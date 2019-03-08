/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.RegistroCompraDTO;
import co.edu.uniandes.csw.carros.ejb.RegistroCompraLogic;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
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
 * @author Daniel Lozano
 */
@Path("registrosCompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class RegistroCompraResourse 
{
    private static final Logger LOGGER = Logger.getLogger(RegistroCompraResourse.class.getName());
    @Inject
    private RegistroCompraLogic logica;
    
    @POST
    public RegistroCompraDTO createdRegistroCompra(RegistroCompraDTO registroCompra) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "RegistroCompraResourse createRegistroCompra: input: {0}", registroCompra);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        RegistroCompraEntity entity = registroCompra.toEntity();
        // Invoca la lógica para crear la editorial nueva
        RegistroCompraEntity nuevoRegistroCompraEntity = logica.createRegistroCompra(entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        RegistroCompraDTO nuevoRegistroCompraDTO = new RegistroCompraDTO(nuevoRegistroCompraEntity);
        LOGGER.log(Level.INFO, "RegistroCompraResourse createRegistroCompra: output: {0}", nuevoRegistroCompraDTO);
        return nuevoRegistroCompraDTO;
    }
    
    @GET
    public List<RegistroCompraDTO> getRegistrosCompra()
    {
        LOGGER.info("RegistroCompraResourse getRegistroCompra: input: void");
        List<RegistroCompraDTO> listaEditoriales = listEntity2DTO(logica.getRegistrosCompra());
        LOGGER.log(Level.INFO, "RegistroCompraResourse getRegistroCompra: output: {0}", listaEditoriales);
        return listaEditoriales;
    }
    
     private List<RegistroCompraDTO> listEntity2DTO(List<RegistroCompraEntity> entityList) {
        List<RegistroCompraDTO> list = new ArrayList<>();
        for (RegistroCompraEntity entity : entityList) {
            list.add(new RegistroCompraDTO(entity));
        }
        return list;
    }
    
    @GET
    @Path("{compraID: \\d+}")
    public RegistroCompraDTO getCliente(@PathParam("compraID") Long registroCompraID){
          LOGGER.log(Level.INFO, "RegistroCompraResourse getRegistroCompra: input: {0}", registroCompraID);
        RegistroCompraEntity editorialEntity = logica.getRegistroCompra(registroCompraID);
        if (editorialEntity == null) {
            throw new WebApplicationException("El recurso /registroCompra/" + registroCompraID + " no existe.", 404);
        }
        RegistroCompraDTO DTO = new RegistroCompraDTO(editorialEntity);
        LOGGER.log(Level.INFO, "RegistroCompraResourse getRegistroCompra: output: {0}", DTO);
        return DTO;
    }
   
    @PUT
    @Path("{compraID: \\d+}")
    public RegistroCompraDTO updateRegistroCompra(@PathParam("compraID") Long registroCompraID, RegistroCompraDTO registroCompra){
         LOGGER.log(Level.INFO, "RegistroCompraResourse updateRegistroCompra: input: id:{0} , editorial: {1}", new Object[]{registroCompraID, registroCompra});
        registroCompra.setCompraId(registroCompraID);
        if (logica.getRegistroCompra(registroCompraID) == null) {
            throw new WebApplicationException("El recurso /registroCompra/" + registroCompraID + " no existe.", 404);
        }
        RegistroCompraDTO DTO = new RegistroCompraDTO(logica.updateRegistroCompra(registroCompraID, registroCompra.toEntity()));
        LOGGER.log(Level.INFO, "EditorialResource updateEditorial: output: {0}", DTO);
        return DTO;

    }
   
}
