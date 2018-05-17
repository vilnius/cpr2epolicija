
package lt.insoft.cpr2epolicija.model.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the lt.insoft.cpr2epolicija.model.ws package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetIvykisClassifier_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "getIvykisClassifier");
    private final static QName _GetIvykisClassifierResponse_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "getIvykisClassifierResponse");
    private final static QName _GetReportStatus_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "getReportStatus");
    private final static QName _GetReportStatusResponse_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "getReportStatusResponse");
    private final static QName _Report_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "report");
    private final static QName _SendReport_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "sendReport");
    private final static QName _SendReportResponse_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "sendReportResponse");
    private final static QName _StatusRequest_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "statusRequest");
    private final static QName _Test_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "test");
    private final static QName _TestResponse_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "testResponse");
    private final static QName _S2SServiceException_QNAME = new QName("http://ws.s2s.eservices.insoft.lt/", "S2sServiceException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lt.insoft.cpr2epolicija.model.ws
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIvykisClassifier }
     *
     */
    public GetIvykisClassifier createGetIvykisClassifier() {
        return new GetIvykisClassifier();
    }

    /**
     * Create an instance of {@link GetIvykisClassifierResponse }
     *
     */
    public GetIvykisClassifierResponse createGetIvykisClassifierResponse() {
        return new GetIvykisClassifierResponse();
    }

    /**
     * Create an instance of {@link GetReportStatus }
     *
     */
    public GetReportStatus createGetReportStatus() {
        return new GetReportStatus();
    }

    /**
     * Create an instance of {@link GetReportStatusResponse }
     *
     */
    public GetReportStatusResponse createGetReportStatusResponse() {
        return new GetReportStatusResponse();
    }

    /**
     * Create an instance of {@link Report }
     *
     */
    public Report createReport() {
        return new Report();
    }

    /**
     * Create an instance of {@link SendReport }
     *
     */
    public SendReport createSendReport() {
        return new SendReport();
    }

    /**
     * Create an instance of {@link SendReportResponse }
     *
     */
    public SendReportResponse createSendReportResponse() {
        return new SendReportResponse();
    }

    /**
     * Create an instance of {@link StatusRequest }
     *
     */
    public StatusRequest createStatusRequest() {
        return new StatusRequest();
    }

    /**
     * Create an instance of {@link Test }
     *
     */
    public Test createTest() {
        return new Test();
    }

    /**
     * Create an instance of {@link TestResponse }
     *
     */
    public TestResponse createTestResponse() {
        return new TestResponse();
    }

    /**
     * Create an instance of {@link S2SServiceException }
     *
     */
    public S2SServiceException createS2SServiceException() {
        return new S2SServiceException();
    }

    /**
     * Create an instance of {@link StatusResponse }
     *
     */
    public StatusResponse createStatusResponse() {
        return new StatusResponse();
    }

    /**
     * Create an instance of {@link StatusField }
     *
     */
    public StatusField createStatusField() {
        return new StatusField();
    }

    /**
     * Create an instance of {@link File }
     *
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link KeyValuePair }
     *
     */
    public KeyValuePair createKeyValuePair() {
        return new KeyValuePair();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIvykisClassifier }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "getIvykisClassifier")
    public JAXBElement<GetIvykisClassifier> createGetIvykisClassifier(GetIvykisClassifier value) {
        return new JAXBElement<GetIvykisClassifier>(_GetIvykisClassifier_QNAME, GetIvykisClassifier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIvykisClassifierResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "getIvykisClassifierResponse")
    public JAXBElement<GetIvykisClassifierResponse> createGetIvykisClassifierResponse(GetIvykisClassifierResponse value) {
        return new JAXBElement<GetIvykisClassifierResponse>(_GetIvykisClassifierResponse_QNAME, GetIvykisClassifierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReportStatus }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "getReportStatus")
    public JAXBElement<GetReportStatus> createGetReportStatus(GetReportStatus value) {
        return new JAXBElement<GetReportStatus>(_GetReportStatus_QNAME, GetReportStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReportStatusResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "getReportStatusResponse")
    public JAXBElement<GetReportStatusResponse> createGetReportStatusResponse(GetReportStatusResponse value) {
        return new JAXBElement<GetReportStatusResponse>(_GetReportStatusResponse_QNAME, GetReportStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Report }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "report")
    public JAXBElement<Report> createReport(Report value) {
        return new JAXBElement<Report>(_Report_QNAME, Report.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendReport }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "sendReport")
    public JAXBElement<SendReport> createSendReport(SendReport value) {
        return new JAXBElement<SendReport>(_SendReport_QNAME, SendReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendReportResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "sendReportResponse")
    public JAXBElement<SendReportResponse> createSendReportResponse(SendReportResponse value) {
        return new JAXBElement<SendReportResponse>(_SendReportResponse_QNAME, SendReportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "statusRequest")
    public JAXBElement<StatusRequest> createStatusRequest(StatusRequest value) {
        return new JAXBElement<StatusRequest>(_StatusRequest_QNAME, StatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Test }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "test")
    public JAXBElement<Test> createTest(Test value) {
        return new JAXBElement<Test>(_Test_QNAME, Test.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "testResponse")
    public JAXBElement<TestResponse> createTestResponse(TestResponse value) {
        return new JAXBElement<TestResponse>(_TestResponse_QNAME, TestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link S2SServiceException }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.s2s.eservices.insoft.lt/", name = "S2sServiceException")
    public JAXBElement<S2SServiceException> createS2SServiceException(S2SServiceException value) {
        return new JAXBElement<S2SServiceException>(_S2SServiceException_QNAME, S2SServiceException.class, null, value);
    }

}
