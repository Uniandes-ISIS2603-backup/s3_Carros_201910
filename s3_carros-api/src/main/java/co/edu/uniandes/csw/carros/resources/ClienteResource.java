/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.ClienteDTO;
import co.edu.uniandes.csw.carros.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.carros.ejb.ClienteLogic;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ClienteResource {
    
    private static final Logger LOGGER= Logger.getLogger(ClienteResource.class.getName());
    
    @Inject
    private ClienteLogic clienteLogic;
    
    @POST
    public ClienteDTO createCliente(ClienteDTO cliente) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "ClienteResource createCliente: input: {0}", cliente);
        ClienteEntity clienteEntity = clienteLogic.createCliente(cliente.toEntity());
        ClienteDTO clienteDto = new ClienteDTO(clienteEntity);
        LOGGER.log(Level.INFO, "ClienteResource createCliente: output: {0}", clienteDto);
        return clienteDto;
    }
    
    @GET
    public List<ClienteDetailDTO> getClientes(){
        LOGGER.info("ClienteResource getClientes: input: void");
        List<ClienteDetailDTO> listaDTO = new ArrayList<>();
        List<ClienteEntity> clientesEntity = clienteLogic.getAllCliente();
        for(ClienteEntity entity : clientesEntity){
            listaDTO.add(new ClienteDetailDTO(entity));
        }
         LOGGER.log(Level.INFO, "ClienteResource getClientes: output: {0}", listaDTO);
        return listaDTO;
    }
    
    @GET
    @Path("{clienteID: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("clienteID") Long clienteID) throws WebApplicationException{
        LOGGER.log(Level.INFO, "ClienteResource getCliente: input: {0}", clienteID);
        ClienteEntity entity = clienteLogic.getCliente(clienteID);
        if(entity == null){
            throw new WebApplicationException("El recurso /clientes/" + clienteID + " no existe.", 404);
        }
        ClienteDetailDTO clienteDto = new ClienteDetailDTO(entity);
        LOGGER.log(Level.INFO, "ClienteResource getCliente: output: {0}", clienteDto);
        return clienteDto;
    }
    
    @PUT
    @Path("{clienteID: \\d+}")
    public ClienteDetailDTO updateCliente(@PathParam("clienteID") Long clienteID, ClienteDetailDTO cliente) throws BusinessLogicException{
       LOGGER.log(Level.INFO, "ClienteResource updateCliente: input: id:{0} , cliente: {1}", new Object[]{clienteID, cliente});
       cliente.setClienteID(clienteID);
       if(clienteLogic.getCliente(clienteID) == null){
           throw new WebApplicationException("El recurso /clientes/" + clienteID + " no existe.", 404);
       }
       ClienteEntity entity = clienteLogic.updateCliente(cliente.toEntity());
       ClienteDetailDTO clienteDto = new ClienteDetailDTO(entity);
       LOGGER.log(Level.INFO, "ClienteResource updateCliente: output: {0}", clienteDto);     
        return clienteDto;
    }
    
    @DELETE
    @Path("{clienteID: \\d+}")
    public void deleteCliente(@PathParam("clienteID") Long clienteID){  
       LOGGER.log(Level.INFO, "ClienteResource deleteCliente: input: {0}", clienteID);
        if(clienteLogic.getCliente(clienteID) == null){
           throw new WebApplicationException("El recurso /clientes/" + clienteID + " no existe.", 404);
       }
       clienteLogic.deleteCliente(clienteID);
       LOGGER.info("ClienteResource deleteCliente: output: void");      
    }
}
