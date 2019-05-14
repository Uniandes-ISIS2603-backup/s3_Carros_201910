/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;
import co.edu.uniandes.csw.carros.dtos.ModeloDTO;
import co.edu.uniandes.csw.carros.dtos.ModeloDetailDTO;
import co.edu.uniandes.csw.carros.ejb.ModeloLogic;
import co.edu.uniandes.csw.carros.ejb.MarcaModelosLogic;
import co.edu.uniandes.csw.carros.entities.ModeloEntity;
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
public class MarcaModelosResource {
    private static final Logger LOGGER = Logger.getLogger(MarcaModelosResource.class.getName());

    @Inject
    private MarcaModelosLogic MarcaModelosLogic; 

    @Inject
    private ModeloLogic modeloLogic;
    
    @Path("{modeloID: \\d+}")
    public ModeloDTO addModelo(@PathParam("marcaID") Long marcaID, @PathParam("modeloID") Long modeloID) {
        if (modeloLogic.getModelo(modeloID) == null) {
            throw new WebApplicationException("El recurso /modelos/" + modeloID + " no existe.", 404);
        }
        ModeloDTO modeloDTO = new ModeloDTO(MarcaModelosLogic.addModelo(modeloID, marcaID));
        return modeloDTO;
    }
    
    @GET
    public List<ModeloDetailDTO> getModelos(@PathParam("marcaID") Long marcaID) {
        List<ModeloDetailDTO> listaModeloDTOs = modelosListEntity2DTO(MarcaModelosLogic.getModelos(marcaID));
        return listaModeloDTOs;
    }
    
    @GET
    @Path("{modeloID: \\d+}")
    public ModeloDetailDTO getModelo(@PathParam("marcaID") Long marcaID, @PathParam("modeloId") Long modeloID) throws BusinessLogicException {
        if (modeloLogic.getModelo(modeloID) == null) {
            throw new WebApplicationException("El recurso /marcas/" + marcaID + "/modelos/" + modeloID + " no existe.", 404);
        }
        ModeloDetailDTO modeloDTO = new ModeloDetailDTO(MarcaModelosLogic.getModelo(marcaID, modeloID));
        return modeloDTO;
    }
    
    private List<ModeloDetailDTO> modelosListEntity2DTO(List<ModeloEntity> entityList) {
        List<ModeloDetailDTO> list = new ArrayList();
        for (ModeloEntity entity : entityList) {
            list.add(new ModeloDetailDTO(entity));
        }
        return list;
    }
    
    private List<ModeloEntity> modelosListDTO2Entity(List<ModeloDTO> dtos) {
        List<ModeloEntity> list = new ArrayList<>();
        for (ModeloDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    } 
}
