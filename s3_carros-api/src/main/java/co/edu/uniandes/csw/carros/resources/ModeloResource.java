/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.ModeloDTO;
import co.edu.uniandes.csw.carros.dtos.ModeloDetailDTO;
import co.edu.uniandes.csw.carros.ejb.ModeloLogic;
import co.edu.uniandes.csw.carros.entities.ModeloEntity;
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
 * @author Andres Forero
 */
@Path("modelos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ModeloResource {
    
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaResourse.class.getName());
    
    @Inject
    private ModeloLogic logicModelo;
    
    
    @POST
    public ModeloDTO createModelo(ModeloDTO modeloDTO) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "ModeloResource createModelo: input: {0}", modeloDTO);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ModeloEntity modeloEntity = modeloDTO.toEntity();
        // Invoca la lógica para crear la editorial nueva
        ModeloEntity nuevoModeloEntity = logicModelo.createModelo(modeloEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        ModeloDTO nuevoModeloDTO = new ModeloDTO(nuevoModeloEntity);
        LOGGER.log(Level.INFO, "ModeloResource createModelo: output: {0}", nuevoModeloEntity);
        return nuevoModeloDTO; 
    
    }
    
    @GET
    public List<ModeloDTO> getModelos(){
       LOGGER.info("ModeloResource getModelos: input: void");
       List<ModeloDTO> listaModelos = listEntity2DetailDTO(logicModelo.getModelos());
       LOGGER.log(Level.INFO, "modeloresoruce getModelos: output: {0}", listaModelos);
       return listaModelos; 
    }
    
    
    @GET 
    @Path("{modeloID: \\d+}")
    public ModeloDTO getModelo(@PathParam("modeloID") Long modeloID) throws  WebApplicationException{
        LOGGER.log(Level.INFO, "Modeloresorurce getModelo: input: {0}", modeloID);
        ModeloEntity modeloEntity = logicModelo.getModelo(modeloID);
        if (modeloEntity == null) {
            throw new WebApplicationException("El recurso /modelos/" + modeloID + " no existe.", 404);
        }
        ModeloDTO detailDTO = new ModeloDetailDTO(modeloEntity);
        LOGGER.log(Level.INFO, "ModeloResource getModelo: output: {0}", detailDTO);
        return detailDTO;
    }
    
    @PUT
    @Path("{modeloID: \\d+}")
    public ModeloDTO updateModelo(@PathParam("modeloID") Long modeloID, ModeloDTO modelo )throws BusinessLogicException{
        LOGGER.log(Level.INFO, "ModeloResource UpdateModelo: input: id:{0} , modelo: {1}", new Object[]{modeloID, modelo});
        modelo.setModeloID(modeloID);
        if (logicModelo.getModelo(modeloID) == null) {
            throw new WebApplicationException("El recurso /modelos/" + modeloID + " no existe.", 404);
        }
        ModeloDetailDTO detailDTO = new ModeloDetailDTO(logicModelo.updateModelo(modelo.toEntity()));
        LOGGER.log(Level.INFO, "ModeloResource updateModelo: output: {0}", detailDTO);
        return detailDTO;
    }
    
    
    @DELETE
    @Path("{modeloID: \\d+}")
    public void deleteModelo(@PathParam("modeloID") Long modeloID) throws BusinessLogicException
    {
       LOGGER.log(Level.INFO, "ModeloResource deleteModelo: input: {0}", modeloID);
        if (logicModelo.getModelo(modeloID) == null) {
            throw new WebApplicationException("El recurso /modelos/" + modeloID + " no existe.", 404);
        }
        logicModelo.deleteModelo(modeloID);
        LOGGER.info("ModeloResource deleteModelo: output: void"); 
    }
    
    
    
    
    
    private List<ModeloDTO> listEntity2DetailDTO(List<ModeloEntity> entityList){
        List<ModeloDTO> list = new ArrayList<>();
        for (ModeloEntity entity : entityList) {
            list.add(new ModeloDTO(entity));
        }
        return list;
    }
    
    
}
