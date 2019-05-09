/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;
import co.edu.uniandes.csw.carros.dtos.AutomovilDTO;
import co.edu.uniandes.csw.carros.ejb.AutomovilLogic;
import co.edu.uniandes.csw.carros.ejb.ModeloAutomovilesLogic;
import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.mappers.BusinessLogicExceptionMapper;
import co.edu.uniandes.csw.carros.mappers.WebApplicationExceptionMapper;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author estudiante
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

/**
 *
 * @author estudiante
 */
public class ModeloAutomovilesResource {
    @Inject
    private ModeloAutomovilesLogic ModeloAutomovilesLogic; 

    @Inject
    private AutomovilLogic automovilLogic;
    
    @Path("{autoId: \\d+}")
    public AutomovilDTO addAutomovil(@PathParam("modeloID") Long modeloID, @PathParam("autoId") Long autoId) {
        if (automovilLogic.getAutomovil(autoId) == null) {
            throw new WebApplicationException("El recurso /automoviles/" + autoId + " no existe.", 404);
        }
        AutomovilDTO automovilDTO = new AutomovilDTO(ModeloAutomovilesLogic.addAutomovil(autoId, modeloID));
        return automovilDTO;
    }
    
    @GET
    public List<AutomovilDTO> getAutomoviles(@PathParam("modeloID") Long modeloID) {
        List<AutomovilDTO> listaAutomovilDTOs = automovilesListEntity2DTO(ModeloAutomovilesLogic.getAutomoviles(modeloID));
        return listaAutomovilDTOs;
    }
    
    @GET
    @Path("{autoId: \\d+}")
    public AutomovilDTO getAutomovil(@PathParam("modeloID") Long modeloID, @PathParam("autoId") Long autoId) throws BusinessLogicException {
        if (automovilLogic.getAutomovil(autoId) == null) {
            throw new WebApplicationException("El recurso /modelos/" + modeloID + "/automoviles/" + autoId + " no existe.", 404);
        }
        AutomovilDTO automovilDTO = new AutomovilDTO(ModeloAutomovilesLogic.getAutomovil(modeloID, autoId));
        return automovilDTO;
    }
    
    private List<AutomovilDTO> automovilesListEntity2DTO(List<AutomovilEntity> entityList) {
        List<AutomovilDTO> list = new ArrayList();
        for (AutomovilEntity entity : entityList) {
            list.add(new AutomovilDTO(entity));
        }
        return list;
    }
    
    private List<AutomovilEntity> automovilesListDTO2Entity(List<AutomovilDTO> dtos) {
        List<AutomovilEntity> list = new ArrayList<>();
        for (AutomovilDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    } 
}

