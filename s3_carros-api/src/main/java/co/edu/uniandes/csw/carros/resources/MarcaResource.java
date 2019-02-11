/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.*;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author estudiante
 */
@Path("marcas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MarcaResource {
    
    private static final Logger LOGGER = Logger.getLogger(MarcaResource.class.getName());
    
    @POST
    public MarcaDTO createMarca(MarcaDTO marca){
        return marca;
    }   
    
    
    @GET
    public MarcaDTO getMarca(){
        MarcaDTO m = new MarcaDTO();
        m.setIdMarca(123);
        m.setNombreMarca("default-name");
        return m;
    }
    
    @PUT
    public MarcaDTO updateMarca(MarcaDTO marca){
        marca.setNombreMarca("updated-name");
        return marca;
    }
    
    @DELETE
    public void deleteMarca(){
       LOGGER.getName();
    }
    
    
    
    
    
    
     
    
    
    
}