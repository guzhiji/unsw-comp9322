/**
 * ImportDownloadServicesSkeleton.java
 *
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

    private static Calendar parseDateTime(String date, String time, String offset) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);
        TimeZone tz = TimeZone.getTimeZone("GMT");
//        TimeZone tz = TimeZone.getTimeZone("GMT" + offset);
        df.setTimeZone(tz);
        tf.setTimeZone(tz);
        Calendar d = df.getCalendar();
        Calendar t = tf.getCalendar();
        t.set(d.get(Calendar.YEAR), d.get(Calendar.MONTH), d.get(Calendar.DATE));
        t.add(Calendar.HOUR_OF_DAY, Integer.parseInt(offset));
        return t;
    }

    private static String findRoot() throws URISyntaxException, FileNotFoundException {
        // webapps/axis2/WEB-INF/services/ImportDownloadServices.aar
        MessageContext mc = MessageContext.getCurrentMessageContext();
        File f = new File(mc.getAxisService().getFileName().toURI());
        File[] c = f.getParentFile() // webapps/axis2/WEB-INF/services
                .getParentFile() // webapps/axis2/WEB-INF
                .getParentFile() // webapps/axis2
                .getParentFile(). // webapps
                listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.equalsIgnoreCase("root");
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

    private static String prepareID(String repo) {
        File t;
        String id;
        do {
            id = String.valueOf(System.nanoTime()) + (int) (Math.random() * 10000);
            t = new File(repo + id + ".csv");
        } while (t.exists());
        return id;
    }

    private static String getURL(String id) throws MalformedURLException {
        HttpServletRequest req = (HttpServletRequest) MessageContext.getCurrentMessageContext()
                .getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
        URL url = new URL(req.getRequestURL().toString());

        StringBuilder result = new StringBuilder();
        result.append(url.getProtocol()).append(":");
        if (url.getAuthority() != null && url.getAuthority().length() > 0) {
            result.append("//").append(url.getAuthority());
        }
        result.append('/').append(id).append(".csv");
        return result.toString();
    }

    /**
     * Auto generated method signature
     *
     * @param importMarketData0
     * @return importMarketDataResponse1
     * @throws ImportDownloadFaultException
     */
    public ImportMarketDataResponseDocument importMarketData(ImportMarketDataDocument importMarketData0)
            throws ImportDownloadFaultException {

        try {
            ImportMarketDataDocument.ImportMarketData data = importMarketData0.getImportMarketData();

            String reqSec = data.getSec();
            Calendar reqStartDate = data.getStartDate();// 2001-07-10T08:26:00Z
            Calendar reqEndDate = data.getEndDate();

            String root = findRoot();
            String id = prepareID(root);

            CsvWriter writer = new CsvWriter(root + id + ".csv");
            URL url = new URL(data.getDataSourceURL()); // http://www.cse.unsw.edu.au/~hpaik/9322/assignments/common/files_csv_spec/FinDataSimple.csv
            CsvReader reader = new CsvReader(new InputStreamReader(url.openStream()));
            reader.readRecord();//skip headings
            while (reader.readRecord()) {
                String sec = reader.get(0);
                if (!sec.equals(reqSec)) {
                    continue;
                }
                String date = reader.get(1);
                String time = reader.get(2);
                String offset = reader.get(3);
                Calendar t = parseDateTime(date, time, offset);
                if (t.before(reqStartDate) || t.after(reqEndDate)) {
                    continue;
                }
                writer.writeRecord(new String[]{
                    sec,
                    date,
                    time,
                    offset
                }, true);

            }
            reader.close();
            writer.close();

            ImportMarketDataResponseDocument doc = ImportMarketDataResponseDocument.Factory.newInstance();
            ImportMarketDataResponseDocument.ImportMarketDataResponse resp = doc.addNewImportMarketDataResponse();
            resp.setEventSetId(id);
            return doc;

        } catch (Exception ex) {
            throw new ImportDownloadFaultException(ex);
        }
    }

    /**
     * Auto generated method signature
     *
     * @param downloadFile2
     * @return downloadFileResponse3
     * @throws ImportDownloadFaultException
     */
    public DownloadFileResponseDocument downloadFile(DownloadFileDocument downloadFile2)
            throws ImportDownloadFaultException {

        try {
            DownloadFileDocument.DownloadFile file = downloadFile2.getDownloadFile();

            String root = findRoot();
            String id = file.getEventSetId();
            File t = new File(root + id + ".csv");
            if (!t.exists()) {
                throw new FileNotFoundException("invalid event set id");
            }

            DownloadFileResponseDocument doc = DownloadFileResponseDocument.Factory.newInstance();
            DownloadFileResponseDocument.DownloadFileResponse resp = doc.addNewDownloadFileResponse();
            resp.setDataURL(getURL(id));

            return doc;
        } catch (Exception ex) {
            throw new ImportDownloadFaultException(ex);
        }

    }

}
