/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.AutomovilDTO;
import co.edu.uniandes.csw.carros.ejb.AutomovilLogic;
import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
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

/**
 *
 * @author Andres Forero
 */
@Path("automoviles")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AutomovilResource {
    
    private static final Logger LOGGER = Logger.getLogger(AutomovilResource.class.getName());
    
    
    @Inject
    private AutomovilLogic autoLogic;
    
    
    @POST
    public AutomovilDTO createAutomovil(AutomovilDTO auto) throws BusinessLogicException{
       LOGGER.log(Level.INFO, "AutomovilResource createAutomovil: input: {0}", auto);
        AutomovilDTO nuevoAutomovilDTO = new AutomovilDTO(autoLogic.createAutomovil(auto.toEntity()));
        LOGGER.log(Level.INFO, "FacturaResource createFactura: output: {0}", nuevoAutomovilDTO);
        return nuevoAutomovilDTO; 
        
    }
    
    
    @GET
    public List<AutomovilDTO> getAutomoviles(){
       LOGGER.info("FacturaResource getFacturas: input: void");
        List<AutomovilDTO> listaFacturas = listEntity2DetailDTO(autoLogic.getAutomoviles());
        LOGGER.log(Level.INFO, "FacturaResource getFacturas: output: {0}", listaFacturas);
        return listaFacturas;  
    }
    
    
    
    @GET
    @Path("{autoId: \\d+}")
    public AutomovilDTO getAutomovil(@PathParam("autoId") Long autoId){
        LOGGER.log(Level.INFO, "AutomovilResource getAutomovil: input: {0}", autoId);
        AutomovilEntity autoEntity = autoLogic.getAutomovil(autoId);
        if (autoEntity == null) {
            throw new WebApplicationException("El recurso /automoviles/" + autoId + " no existe.", 404);
        }
        AutomovilDTO autoDTO = new AutomovilDTO(autoEntity);
        LOGGER.log(Level.INFO, "FacturaResource getFactura: output: {0}", autoDTO);
        return autoDTO; 
    }
    
    
    @PUT
    @Path("(autoId: \\d+)")
    public AutomovilDTO updateAutomovil(@PathParam("autoId") Long autoId, AutomovilDTO auto) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Automovilresorice updateAutomovil: input: id:{0} , auto: {1}", new Object[]{autoId, auto});
        auto.setAutoId(autoId);
        if (autoLogic.getAutomovil(autoId) == null) {
            throw new WebApplicationException("El recurso /Automovil/" + autoId + " no existe.", 404);
        }
        AutomovilDTO DTO = new AutomovilDTO(autoLogic.updateAutomovil(auto.toEntity()));
        LOGGER.log(Level.INFO, "Automovilresorice updateAutomovil: output: {0}", DTO);
        return DTO;
    }
    
    //@DELETE
    //@Path("(autoId: \\d+)")
    //public void deleteAutomovil(@PathParam("autoId") Long autoID){
    //    AutomovilEntity entity = autoLogic.getAutomovil(autoID);
    //    if (entity == null) {
    //        throw new WebApplicationException("El recurso /automoviles/" + autoID + " no existe.", 404);
    //    }
    //    autoLogic.deleteAutomovil(autoID);
    //}
    
    private List<AutomovilDTO> listEntity2DetailDTO(List<AutomovilEntity> entityList){
        List<AutomovilDTO> list = new ArrayList<>();
        for (AutomovilEntity entity : entityList) {
            list.add(new AutomovilDTO(entity));
        }
        return list;
    }
     
}
