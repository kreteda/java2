package com.example.restservicedemo.rest;

import com.example.restservicedemo.domain.Chair;
import com.example.restservicedemo.service.ChairManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("chair")
public class ChairRESTService {

    private ChairManager cm = new ChairManager();

    @GET
    @Path("/{chairId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chair getChair(@PathParam("chairId") int id){
        Chair c = cm.getChair(id);
        return c;
    }

    @GET
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chair> getAllChairs() {
        return cm.getAllChairs();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewChair(Chair chair) {
        Chair chairToAdd = new Chair(chair.getModel(), chair.getYop());
        cm.addChair(chairToAdd);
        return Response.status(201).entity("success").build();
    }

    @POST
    @Path("/remove")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeChair(Chair chair) {
        Chair chairToRemove = cm.getChair(chair.getId());
        cm.removeChair(chairToRemove);
        return Response.status(201).entity("success").build();
    }
    
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST API /chair is running";
	}
	
    @DELETE
    public Response clearChairs(){
        cm.clearChairs();
        return Response.status(200).build();
    }
}