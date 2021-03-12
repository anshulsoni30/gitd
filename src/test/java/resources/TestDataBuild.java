package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Getbody;
import pojo.Location;

public class TestDataBuild {



	public Getbody addPlacePayload(String name, String laungauge,  String address) {
		// TODO Auto-generated method stub
		  
		  Getbody b=new Getbody();
		  b.setAccuracy(50);
		  b.setAddress(address);
		  b.setLanguage(laungauge);
		 b.setName(name);
		  b.setPhone_number("\"(+91) 983 893 3937");
		  b.setWebsite("http://google.com");
		  
		  List<String> mylist=new ArrayList<String>();
		  mylist.add("shoe_park");
		  mylist.add("shoe");
		b.setTypes(mylist);

		  Location l=new Location();
		  l.setLat(-38.383494);
		  l.setLng(33.427362);
		  b.setLocation(l);
		  return b;
		
	}
	public String deletePlacePayload(String placeid) {
		return "{\r\n   \"place_id\": \""+placeid+"\"\r\n}" ;
	
}
}