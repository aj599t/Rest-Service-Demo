package edu.usc.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import edu.usc.rest.messenger.model.Profile;
import edu.usc.rest.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService service = new ProfileService();
	
	public ProfileResource(){}
	
	@GET
	public List<Profile> getProfiles(){
		return service.getAllProfiles(); 
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getMessage(@PathParam("profileName") String profileName){
		return service.getProfile(profileName); 
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return service.addProfile(profile);		
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return service.updateProfile(profile);		
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName){
		service.removeProfile(profileName);		
	}
	

}
