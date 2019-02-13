/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.ClienteDTO;
import co.edu.uniandes.csw.carros.dtos.ClienteDetailDTO;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {
    private static final Logger LOGGER= Logger.getLogger(ClienteResource.class.getName());
    
    
    @POST
    public ClienteDTO createCliente(ClienteDTO cliente){
        return cliente;
    }
    
    @GET
    public ArrayList<ClienteDTO> getClientes(){
        return new ArrayList<>();
    }
    
    @GET
    @Path("{clienteID: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("clienteID") Long clienteID){
        return null;
    }
    
    @PUT
    @Path("{clienteID: \\d+}")
    public ClienteDTO updateCliente(@PathParam("clienteID") Long clienteID, ClienteDTO cliente){
        return cliente;
    }
    
    @DELETE
    @Path("{clienteID: \\d+}")
    public void deleteCliente(@PathParam("clienteID") Long clienteID){      
    }
}
