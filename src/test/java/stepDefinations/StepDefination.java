package stepDefinations;

import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.UpdateQRCode;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {

	RequestSpecification 	  requestspecification; 
	ResponseSpecification 	  responsespecification;
	Response 		  response;
	TestDataBuild data 	= new TestDataBuild();
	APIResources 		  resourceAPI
	String	      		  testId;
		

	@Given("Update_QR_Code Payload with {string}  {string} {string}{string}")
	public void update_qr_code_Payload_with(String name, String language, String address,String qr-code_id) throws IOException {
	    		 
		testId = qr-code_id;
		requestspecification = given().spec(requestSpecification_Update(qr-code_id))
			     		      .body(data.updateQrCodePayLoad(description,callback_url,amount));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	
		resourceAPI 		  = APIResources.valueOf(resource);
		responsespecification     = new ResponseSpecBuilder()
					        //.expectStatusCode(200)
						.expectContentType(ContentType.JSON)
						.build();
		
		if(method.equalsIgnoreCase("PATCH"))
		 	response =res.when().patch(resourceAPI.getResource());

		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
		
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	  
		assertEquals(response.getStatusCode(),200);
	}
	
	// This is for Not knowing the status code exactly, Just capturing the status Code
	@Then("the API call should return the status code")
	public void the_API_call_got_success_with_status_code() {
	  
		System.out.println(response.getStatusCode());
		//assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void verify_status_in_response_body_is(String keyValue, String Expectedvalue) {
	     
	 	assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Then("verify the Qr_Code_Id {string}")
	public void verify_the_the Qr_Code_Id(String keyValue) throws IOException {
	
	  assertEquals(getJsonPath(response,keyValue),testId);		 
	    
	}
	
	@And("validate the {string},{string} in response body")
	public void validate_status_Error_Message_in_response_body(String status, String errorMessage)
	{
		System.out.println(getJsonPath(response,status));
		System.out.println(getJsonPath(response,errorMessage));
		System.out.println(getJsonPath(response,"error_code"));
	}


}
