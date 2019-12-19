package test;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class Test2 {

	public void performGetOperation() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpReq = RestAssured.given();
		Response response = httpReq.request(Method.GET, "");
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		for (Header header : response.getHeaders()) {
			
		}
	}

	public static void main(String[] args) {
		Test2 t2 = new Test2();
//		t2.performGetOperation();
		t2.performPostOperation();
	}
	
	public void performPostOperation() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpReq = RestAssured.given();
		JSONObject objJSON = new JSONObject();
		objJSON.put("name", "Vikas");
		objJSON.put("job", "leader");
		httpReq.header("Content-Type","application/json");
		httpReq.body(objJSON.toJSONString());
		Response response = httpReq.request(Method.POST, "");
		System.out.println(response.getBody().asString());
	}
}