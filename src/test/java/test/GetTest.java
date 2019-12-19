package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.BaseTest;
import view.GetView;

public class GetTest extends BaseTest {

	GetView objGetView;

	@BeforeClass
	public void setUpEnvironment() {
		this.setUpEnvironment("Vikas");
		objGetView = new GetView(this);
	}

	@BeforeMethod
	public void beforeMethod() {
		setBaseURI();
		getRequestObject();
	}

	@Test
	public void getUserDetails() {
		loadTestData("100");
		objGetView.performSpecificHttpRequest();
		objGetView.verifyResponseCode();
	}

	@Test
	@Parameters({"browser","abcd"})
	public void postUserDetails(String browser) {
		loadTestData("101");
		getJSONObject();
		objGetView.setJsonBody();
		objGetView.addHeaders();
		objGetView.convertJsonObectToJsonString();
		objGetView.performSpecificHttpRequest();
		System.out.println(objGetView.getResponseBody_1());
		objGetView.verifyResponseCode();
	}

	@AfterClass
	public void afterClass() {
		objGetView = null;
	}

}
