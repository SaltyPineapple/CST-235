package business;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Thing;

@RequestScoped
@Path("/things")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ThingsRestService {
	@Inject
	BusinessServiceInterface bs;
	
	// get all records and display in json
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Thing> getAllThingsAsJSON() {
		return bs.readAll();
	}
	
	// get all records and display in json
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Thing[] getAllThingsAsXML() {
		ArrayList<Thing> things = bs.readAll();
		
		return things.toArray(new Thing[things.size()]);
	}
		
	
}
