package business;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Verse;

@RequestScoped
@Path("/verse")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class VerseRestService {
	
	@Inject
	BusinessServiceInterface bs;
	
	// gets verses specified by word
	@GET
	@Path("/getverse/{word}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Verse> getverse(@PathParam("word") String word) {
		return bs.returnSelected(word);
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Verse> getAll() {
		return bs.returnAll();
	}
}
