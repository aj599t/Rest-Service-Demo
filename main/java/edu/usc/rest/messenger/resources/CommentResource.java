package edu.usc.rest.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {

	@GET
	public String test(){
		return "test";
	}
}
