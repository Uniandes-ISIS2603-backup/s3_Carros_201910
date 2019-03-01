/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.RegistroCompraDTO;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("registrosCompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class RegistroCompraResourse 
{
    private static final Logger LOGGER = Logger.getLogger(RegistroCompraResourse.class.getName());
    
    @POST
    public RegistroCompraDTO createdRegistroCompra(RegistroCompraDTO registroCompra)
    {
        return registroCompra;
    }
    
    @GET
    public ArrayList<RegistroCompraDTO> getRegistrosCompra()
    {
        return new ArrayList<>() ;
    }
    
    @GET
    @Path("{compraID: \\d+}")
    public RegistroCompraDTO getCliente(@PathParam("compraID") Long registroCompraID){
        return null;
    }
   
    @PUT
    @Path("{compraID: \\d+}")
    public RegistroCompraDTO updateEmpleado(@PathParam("compraID") Long empleadoID, RegistroCompraDTO registroCompra){
        return registroCompra;
    }
   
}
