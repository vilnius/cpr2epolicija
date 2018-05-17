package lt.insoft.cpr2epolicija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.insoft.cpr2epolicija.helper.S2SHelper;
import lt.insoft.cpr2epolicija.model.ws.Report;
import lt.insoft.cpr2epolicija.model.ws.S2SServiceException_Exception;
import lt.insoft.cpr2epolicija.model.ws.StatusRequest;
import lt.insoft.cpr2epolicija.model.ws.StatusResponse;

@RequestMapping("/epolicija")
@RestController
public class S2SServiceController {

    @Autowired
    private S2SHelper s2SHelper;

    @RequestMapping(path = "/getReportStatus")
    public List<StatusResponse> getReportStatus(@RequestParam(value = "senderCode", required = false) String senderCode, @RequestBody StatusRequest statusRequest) throws S2SServiceException_Exception {
        return s2SHelper.getReportStatus(senderCode, statusRequest);
    }

    @RequestMapping(path = "/sendReport")
    public String sendReport(@RequestParam(value = "senderCode", required = false) String senderCode, @RequestBody Report report) throws S2SServiceException_Exception {
        return s2SHelper.sendReport(senderCode, report);
    }
}
