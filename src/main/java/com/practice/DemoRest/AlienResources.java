package com.practice.DemoRest;
//D:\Executables\apache-tomcat-6.0.53\bin
import java.util.ArrayList;
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

@Path("/aliens")
public class AlienResources 
{
	AlienRepository repo = new AlienRepository();
@GET
@Produces(MediaType.APPLICATION_XML) //  Server is sending data and Client is accepting it
public List<Alien> getAlians()
{
	System.out.println("getAlian is called !! ");
	return repo.getAllAlians();
	
}
@GET
@Path("/alien/{id}")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Alien getAlian(@PathParam("id") int identity )
{
	return repo.getAlian(identity);
	
	}

@POST
@Path("/alien")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) // Client is sending  data and server is accepting it
public Alien createAlien(Alien a1)
{
	repo.create(a1);
	System.out.println("***** Creating new Alien ******" );
	return a1;
}

@PUT
@Path("/alien")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) // Client is sending  data and server is accepting it
public Alien updateAlien(Alien a1)
{
	if(repo.getAlian(a1.getId()).getId()==0)
	{
		repo.create(a1);
		System.out.println("Alien does not exist in DB hence We will Create !!!");
		System.out.println(a1);
	}
	else
	{
		System.out.println(a1);
		repo.updateDB(a1);
		System.out.println("***** Updating Existing Alien ******" );	
	}
	return a1;
}

@DELETE
@Path("/alien/{id}")

public Alien killAlian(@PathParam("id") int identity )
{

	Alien a= repo.getAlian(identity);
	
	if(a.getId()!=0)
	{
		repo.delete(identity);
	}
	
	return a;

	
}

}
