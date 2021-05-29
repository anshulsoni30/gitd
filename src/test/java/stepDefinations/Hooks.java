package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
 
	@Before("@deleteplace")
	
	public void BeforeScenario() throws IOException {
		
		
		
		stepDefination sd=new stepDefination();
		if(stepDefination.place_id==null) {
		sd.add_place_payload_with("anshul", "french", "india");
		sd.user_calls_with_http_request("AddPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("anshul", "getPlaceAPI");
		
		}
		
		
	}
	
}
