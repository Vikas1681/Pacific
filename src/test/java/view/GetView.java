package view;

import generic.BaseTest;
import io.restassured.response.Response;

public class GetView {

	BaseTest objBaseTest;
	String strTestData;
	String strTestData1;
	Response objResponse;
	String strResponseBody = "";
	int intTestData;

	public GetView(BaseTest objBaseTest) {
		this.objBaseTest = objBaseTest;
	}

	public Response performSpecificHttpRequest() {
		strTestData = objBaseTest.getObjExcelHelperClass().dpString("requestType");
		strTestData1 = objBaseTest.getObjExcelHelperClass().dpString("strURI");
		if (!strTestData.equals("")) {
			objResponse = objBaseTest.performSpecificHttpRequest(strTestData, strTestData1);
		}
		return objResponse;

	}

	public String getResponseBody_1() {

		return objResponse.getBody().asString();
	}

	public int getResponseStatusCode() {
		return objResponse.statusCode();
	}

	public void verifyResponseCode() {
		strTestData = objBaseTest.getObjExcelHelperClass().dpString("expectedResponseCode");
		intTestData = Integer.parseInt(strTestData);
		if (!strTestData.equals("")) {
			objBaseTest.verifyResponseCode(objResponse.getStatusCode(), intTestData);
		}
	}

	public void setJsonBody() {
		strTestData=objBaseTest.getObjExcelHelperClass().dpString("noOfParametersToAdd");
		intTestData = Integer.parseInt(strTestData);
		for (int i = 1; i <= intTestData; i++) {
			strTestData = objBaseTest.getObjExcelHelperClass().dpString("jsonkey" + i);
			strTestData1 = objBaseTest.getObjExcelHelperClass().dpString("jsonValue" + i);
			objBaseTest.setJsonBody(strTestData, strTestData1);
		}
	}
	
	public void addHeaders() {
		strTestData=objBaseTest.getObjExcelHelperClass().dpString("noOfHeadersToAdd");
		intTestData = Integer.parseInt(strTestData);
		for(int i=1; i<=intTestData;i++) {
			strTestData = objBaseTest.getObjExcelHelperClass().dpString("headerKey" + i);
			strTestData1 = objBaseTest.getObjExcelHelperClass().dpString("headerValue" + i);
			objBaseTest.addHeaders(strTestData, strTestData1);
		}
	}
	
	public void convertJsonObectToJsonString() {
		objBaseTest.convertJsonObectToJsonString();
	}
	
	public void setJsonComplexBody() {
		
	}

}
