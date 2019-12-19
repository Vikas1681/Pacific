package generic;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	private RequestSpecification httpRequest;
	private Response objResponse;
	private HashMap<String, String> rowData;
	private ExcelHelperClass objExcelHelperClass;
	private JSONObject objJsonObject;
	private HashMap objHashMap;

	public void setBaseURI() {
		RestAssured.baseURI = "https://reqres.in/api/users/";
	}

	public RequestSpecification getRequestObject() {
		this.httpRequest = RestAssured.given();
		return this.httpRequest;
	}

	public void setRowData(HashMap rowData) {
		this.rowData = rowData;
	}

	public HashMap<String, String> getRowData() {
		return rowData;
	}

	public void setUpEnvironment(String excelFileName) {
		objExcelHelperClass = new ExcelHelperClass(this);
		objExcelHelperClass.loadExcelFile(excelFileName);
		this.initialiseHashmap();
	}

	public ExcelHelperClass getObjExcelHelperClass() {
		return this.objExcelHelperClass;
	}

	public void loadTestData(String tc_Id_no) {
		objExcelHelperClass.loadTestData(tc_Id_no);
	}

	public void verifyResponseCode(int actualResponseCode, int expectedResponseCode) {
		Assert.assertEquals(actualResponseCode, expectedResponseCode);
	}

	public Response performSpecificHttpRequest(String requestType, String strUri) {
		if (requestType.equalsIgnoreCase("get")) {
			objResponse = httpRequest.request(Method.GET, strUri);
			return objResponse;
		} else if (requestType.equalsIgnoreCase("post")) {
			httpRequest.body(convertJsonObectToJsonString());
			objResponse = httpRequest.request(Method.POST, strUri);
			return objResponse;
		} else {
			return null;
		}
	}

	public JSONObject getJSONObject() {
		objJsonObject = new JSONObject();
		return objJsonObject;
	}

	public void setJsonBody(String key, String value) {
		this.objJsonObject.put(key, value);
	}

	public void addHeaders(String headerName, String headerValue) {
		this.httpRequest.header(headerName, headerValue);
	}

	public String convertJsonObectToJsonString() {
		return this.objJsonObject.toJSONString();
	}

	public void initialiseHashmap() {
		this.objHashMap = new HashMap<>();
	}

	public HashMap getObjHashmap() {
		return objHashMap;
	}

}
