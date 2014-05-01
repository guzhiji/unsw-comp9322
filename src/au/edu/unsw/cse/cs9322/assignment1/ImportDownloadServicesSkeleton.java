/*
 * ImportDownloadServicesSkeleton.java
 *
 * Author: Zhiji Gu <zhiji.gu@student.unsw.edu.au>
 * UNSW Student ID: 3471410
 * Version: 2014s1.comp9322.a1.p1.0501
 */

package au.edu.unsw.cse.cs9322.assignment1;

import au.edu.unsw.sltf.services.ImportMarketDataResponseDocument;
import au.edu.unsw.sltf.services.ImportMarketDataDocument;
import au.edu.unsw.sltf.services.DownloadFileResponseDocument;
import au.edu.unsw.sltf.services.DownloadFileDocument;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.http.HTTPConstants;
import javax.servlet.http.HttpServletRequest;

/**
 * ImportDownloadServicesSkeleton java skeleton for the axisService
 */
public class ImportDownloadServicesSkeleton implements ImportDownloadServicesSkeletonInterface {

    /**
     * parse string datetime information to a {@link java.util.Calendar} object.
     *
     * @param date      dd-MMM-yyyy
     * @param time      HH:mm:ss.SSS
     * @param offset    time zone offset
     * @return
     * @throws ParseException
     */
    private static Calendar parseDateTime(String date, String time, String offset) throws ParseException {

        //System.out.println("==parseDateTime()==");
        //System.out.printf("date=%s, time=%s, offset=%s\n", date, time, offset);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);

        // set timezone
        TimeZone tz = TimeZone.getTimeZone("GMT");
//        TimeZone tz = TimeZone.getTimeZone("GMT" + offset);
        df.setTimeZone(tz);
        tf.setTimeZone(tz);

        // parse date and time
        df.parse(date);
        tf.parse(time);

        // add together
        Calendar d = df.getCalendar();
        Calendar t = tf.getCalendar();
        t.set(d.get(Calendar.YEAR), d.get(Calendar.MONTH), d.get(Calendar.DATE));
        t.add(Calendar.HOUR_OF_DAY, Integer.parseInt(offset));

        //System.out.println(t.getTime().toString());

        return t;
    }

    /**
     * find web root and return it as a string.
     *
     * @return
     * @throws URISyntaxException
     * @throws FileNotFoundException
     */
    private static String findRoot() throws URISyntaxException, FileNotFoundException {
        // webapps/axis2/WEB-INF/services/ImportDownloadServices.aar
        MessageContext mc = MessageContext.getCurrentMessageContext();
        File f = new File(mc.getAxisService().getFileName().toURI());
        File[] c = f.getParentFile() // webapps/axis2/WEB-INF/services
                .getParentFile() // webapps/axis2/WEB-INF
                .getParentFile() // webapps/axis2
                .getParentFile() // webapps
                .listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.equalsIgnoreCase("root"); // webapps/ROOT
            }
        });
        if (c.length > 0) {
            String r = c[0].getAbsolutePath();
            if (!r.endsWith(File.separator)) {
                r += File.separator;
            }
            return r;
        }
        throw new FileNotFoundException("web root is not found");
    }

    /**
     * prepare a valid id string for creating the csv file.
     *
     * @param repo      the directory where the csv file locates
     * @return
     */
    private static String prepareID(String repo) {
        File t;
        String id;
        do {
            id = String.valueOf(System.nanoTime()) + (int) (Math.random() * 10000);
            t = new File(repo + id + ".csv");
        } while (t.exists());
        return id;
    }

    /**
     * generate an open URL to the csv file with a given id.
     *
     * @param id
     * @return
     * @throws MalformedURLException
     */
    private static String getURL(String id) throws MalformedURLException {

        HttpServletRequest req = (HttpServletRequest) MessageContext.getCurrentMessageContext()
                .getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
        URL url = new URL(req.getRequestURL().toString());

        StringBuilder result = new StringBuilder();
        result.append(url.getProtocol()).append(":");

        String authority = url.getAuthority();
        if (authority != null && authority.length() > 0) {
            result.append("//").append(authority);
        }

        result.append('/').append(id).append(".csv");
        return result.toString();

    }

    /**
     * Service Method: import data from the given csv file, filter data against the criteria, 
     * them into an open csv file repository, and return a generated unique id for the file.
     *
     * @param importMarketData0
     * @return importMarketDataResponse1
     * @throws ImportDownloadFaultException
     */
    public ImportMarketDataResponseDocument importMarketData(ImportMarketDataDocument importMarketData0)
            throws ImportDownloadFaultException {

        try {

            // read request
            ImportMarketDataDocument.ImportMarketData data = importMarketData0.getImportMarketData();
            String reqSec = data.getSec();
            Calendar reqStartDate = data.getStartDate();// 2001-07-10T08:26:00Z
            Calendar reqEndDate = data.getEndDate();

            // prepare CSV reader
            URL url = new URL(data.getDataSourceURL());
            CsvReader reader = new CsvReader(new InputStreamReader(url.openStream()));

            // prepare CSV writer
            String root = findRoot();
            String id = prepareID(root);
            CsvWriter writer = new CsvWriter(root + id + ".csv");

            // import data
            try {

                try {

                    boolean firstLine = true;
                    boolean empty = true;
                    while (reader.readRecord()) {

                        // match security code
                        String sec = reader.get(0);
                        if (firstLine) {
                            firstLine = false;
                            if (sec.equals("#RIC")) {
                                continue; // skip headings
                            }
                        }
                        if (!sec.equals(reqSec)) {
                            continue;
                        }

                        // within the requested period
                        String date = reader.get(1);
                        String time = reader.get(2);
                        String offset = reader.get(3);
                        Calendar t = parseDateTime(date, time, offset);
                        if (t.before(reqStartDate) || t.after(reqEndDate)) {
                            continue;
                        }

                        // write to file
                        empty = false;
                        writer.writeRecord(new String[]{
                            sec,
                            date,
                            time,
                            offset,
                            reader.get(4), // type
                            reader.get(5), // price
                            reader.get(6), // volume
                            reader.get(7), // bid price
                            reader.get(8), // bid size
                            reader.get(9), // ask price
                            reader.get(10) // ask size
                        }, true);

                    }

                    if (empty) {
                        throw new ImportDownloadFaultException("no records found");
                    }

                } finally {

                    try {
                        writer.close();
                    } catch (Exception ex) {
                    }
                    try {
                        reader.close();
                    } catch (Exception ex) {
                    }

                }

            } catch (Exception ex) {

                // delete corrupted file
                File t = new File(root + id + ".csv");
                if (t.exists()) {
                    t.delete();
                }

                throw ex;
            }

            // return id
            ImportMarketDataResponseDocument doc = ImportMarketDataResponseDocument.Factory.newInstance();
            ImportMarketDataResponseDocument.ImportMarketDataResponse resp = doc.addNewImportMarketDataResponse();
            resp.setEventSetId(id);
            return doc;

        } catch (ImportDownloadFaultException ex) {
            throw ex;
        } catch (Exception ex) {
            // convert exception
            throw new ImportDownloadFaultException(ex);
        }

    }

    /**
     * Service Method: convert a valid id to an URL to its csv file for download.
     *
     * @param downloadFile2
     * @return downloadFileResponse3
     * @throws ImportDownloadFaultException
     */
    public DownloadFileResponseDocument downloadFile(DownloadFileDocument downloadFile2)
            throws ImportDownloadFaultException {

        try {

            // read request
            DownloadFileDocument.DownloadFile file = downloadFile2.getDownloadFile();

            String id = file.getEventSetId();

            // validate id
            String root = findRoot();
            File t = new File(root + id + ".csv");
            if (!t.exists()) {
                throw new FileNotFoundException("invalid event set id");
            }

            // return url
            DownloadFileResponseDocument doc = DownloadFileResponseDocument.Factory.newInstance();
            DownloadFileResponseDocument.DownloadFileResponse resp = doc.addNewDownloadFileResponse();
            resp.setDataURL(getURL(id));
            return doc;

        } catch (Exception ex) {
            throw new ImportDownloadFaultException(ex);
        }

    }
}
