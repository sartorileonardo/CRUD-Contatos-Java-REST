package org.arpit.java2blog.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arpit.java2blog.bean.Contato;
import org.arpit.java2blog.service.ContatoService;


@Path("/contatos")
public class ContatoController {
	
	ContatoService contatoService=new ContatoService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Contato> getContatos()
	{
		
		List<Contato> listOfContatos=contatoService.getAllContatos();
		return listOfContatos;
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Contato getContatoById(@PathParam("id") int id)
	{
		return contatoService.getContato(id);
	}
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Contato addContato(Contato contato)
	{
		return contatoService.addContato(contato);
	}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Contato updateContato(Contato contato)
	{
		return contatoService.updateContato(contato);
		
	}
	
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteContato(@PathParam("id") int id)
	{
		 contatoService.deleteContato(id);
		
	}
	
}
