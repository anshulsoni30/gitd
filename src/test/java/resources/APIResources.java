package resources;

public enum   APIResources {
//enum is a special class which has collection of contansts and methods 

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
    
	private String resource;
    
    
	APIResources(String resource)
	{
	
		this.resource=resource;
		
	}
	public String  getResource()
	{
		return resource;
		
	}
	
	
	
	
	
	
	
	
}
