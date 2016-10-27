package edu.usc.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import edu.usc.rest.messenger.database.DatabaseClass;
import edu.usc.rest.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("AnkitaJain", new Profile(1, "AnkitaJain", "Ankita", "Jain"));
	}
	
	public List<Profile> getAllProfiles(){		
		return new ArrayList(profiles.values());	
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);		
	}

}
