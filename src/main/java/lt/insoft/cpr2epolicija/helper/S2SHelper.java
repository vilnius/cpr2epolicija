package lt.insoft.cpr2epolicija.helper;

import java.util.List;

import lt.insoft.cpr2epolicija.model.ws.Report;
import lt.insoft.cpr2epolicija.model.ws.S2SServiceException_Exception;
import lt.insoft.cpr2epolicija.model.ws.StatusRequest;
import lt.insoft.cpr2epolicija.model.ws.StatusResponse;

public interface S2SHelper {

    List<StatusResponse> getReportStatus(String senderCode, StatusRequest request) throws S2SServiceException_Exception;

    String sendReport(String senderCode, Report report) throws S2SServiceException_Exception;
}
