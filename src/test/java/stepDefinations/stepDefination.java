package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
public class stepDefination extends Utils{
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	static String place_id;
	 JsonPath js;
	TestDataBuild data= new TestDataBuild() ;
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException{
		    // Write code here that turns the phrase above into concrete actions
		
			  
			   res =given().spec(requestSpecification()).
			  body(data.addPlacePayload(name,language,address));
		}


		@When("user calls {string} with {string} http request")
		public void user_calls_with_http_request(String resource, String method) {
		    // Write code here that turns the phrase above into concrete actions
			//constructor will be called with value of resource  which you pass
			APIResources resourceapi=APIResources.valueOf(resource);
			System.out.println(resourceapi.getResource());
			
			resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
             
			if(method.equalsIgnoreCase("POST"))
					{
			 response= res.when().post(resourceapi.getResource());
					}
			else if(method.equalsIgnoreCase("GET")) {
				 response= res.when().get(resourceapi.getResource());
			}
		}
		@Then("the api call is success with status code {int}")
		public void the_api_call_is_success_with_status_code(Integer int1) {
		    // Write code here that turns the phrase above into concrete actions
			assertEquals(response.getStatusCode(),200);
			
		}
		@Then("{string} in response body is {string}")
		public void in_response_body_is(String key , String value) {
		    // Write code here that turns the phrase above into concrete actions

			assertEquals(getJsonPath(response,key),value);
		}
		
		@Then("verify place_id created maps to {string} using {string}")
		public void verify_place_id_created_maps_to_using(String exname,String resource) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
		    //prepare request spec 
			 place_id =getJsonPath(response,"place_id");
			res =given().spec(requestSpecification()).queryParam("place_id",place_id);
			user_calls_with_http_request( resource, "GET");
			String acname =getJsonPath(response,"name");
			assertEquals(acname,exname);
			
		}

		
		@Given("deletePlace Payload")
		public void delete_place_payload() throws IOException {
		    // Write code here that turns the phrase above into concrete actions
		    
			res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
			
			
			
			
		}
		






}



