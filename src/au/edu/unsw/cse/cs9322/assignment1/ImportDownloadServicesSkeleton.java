
/**
 * ImportDownloadServicesSkeleton.java
 *
 */
package au.edu.unsw.cse.cs9322.assignment1;

import au.edu.unsw.sltf.services.ImportMarketDataResponseDocument;
import au.edu.unsw.sltf.services.ImportMarketDataDocument;
import au.edu.unsw.sltf.services.DownloadFileResponseDocument;
import au.edu.unsw.sltf.services.DownloadFileDocument;
 
/**
 *  ImportDownloadServicesSkeleton java skeleton for the axisService
 */
public class ImportDownloadServicesSkeleton implements ImportDownloadServicesSkeletonInterface{


    /**
     * Auto generated method signature
     * 
     * @param importMarketData0 
     * @return importMarketDataResponse1 
     * @throws ImportDownloadFaultException 
     */
    public ImportMarketDataResponseDocument importMarketData (ImportMarketDataDocument importMarketData0)
        throws ImportDownloadFaultException {

        //TODO : fill this with the necessary business logic

        ImportMarketDataDocument.ImportMartketData data = importMarketData0.getImportMarketData();

        throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#importMarketData");

        ImportMarketDataResponseDocument doc = ImportMarketDataResponseDocument.Factory.newInstance();
        ImportMarketDataResponseDocument.ImportMarketDataResponse resp = doc.addNewImportMarketDataResponse();
        resp.setReturn("");

        return doc;

    }


    /**
     * Auto generated method signature
     * 
     * @param downloadFile2 
     * @return downloadFileResponse3 
     * @throws ImportDownloadFaultException 
     */
    public DownloadFileResponseDocument downloadFile (DownloadFileDocument downloadFile2)
        throws ImportDownloadFaultException {

        DownloadFileDocument.DownloadFile file = downloadFile2.getDownloadFile();

        //TODO : fill this with the necessary business logic
        throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#downloadFile");

        DownloadFileResponseDocument doc = DownloadFileResponseDocument.Factory.newInstance();
        DownloadFileResponseDocument.DownloadFileResponse resp = doc.addNewDownloadFileResponse();
        resp.setReturn("");

        return doc;


    }

}

