/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.*;
import co.edu.uniandes.csw.carros.ejb.MarcaLogic;
import co.edu.uniandes.csw.carros.entities.MarcaEntity;
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
 * @author estudiante
 */
@Path("marcas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MarcaResource {
    
    private static final Logger LOGGER = Logger.getLogger(MarcaResource.class.getName());
    
    @Inject
    private MarcaLogic logicMarca;
    
    
    @POST
    public MarcaDTO createMarca(MarcaDTO marca) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "MarcaResource createMarca: input: {0}", marca);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        MarcaEntity marcaEntity = marca.toEntity();
        // Invoca la lógica para crear la editorial nueva
        MarcaEntity nuevaMarcaEntity = logicMarca.createMarca(marcaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        MarcaDTO nuevaMarcaoDTO = new MarcaDTO(nuevaMarcaEntity);
        LOGGER.log(Level.INFO, "MarcaResource createMarca: output: {0}", nuevaMarcaEntity);
        return nuevaMarcaoDTO;
    }   
    
    @GET
    public List<MarcaDetailDTO> getMarcas()
    {
        LOGGER.info("MarcaResourse getMarcas: input: void");
        List<MarcaDetailDTO> listaMarcas = listEntity2DetailDTO(logicMarca.getMarcas());
        LOGGER.log(Level.INFO, "MarcaResourse getMarcas: output: {0}", listaMarcas);
        return listaMarcas;
    }
    
   private List<MarcaDetailDTO> listEntity2DetailDTO(List<MarcaEntity> entityList)
   {
        List<MarcaDetailDTO> list = new ArrayList<>();
        for (MarcaEntity entity : entityList) {
            list.add(new MarcaDetailDTO(entity));
        }
        return list;
    }
    
    
    @GET
    @Path("{marcaID: \\d+}")
    public MarcaDetailDTO getMarca(@PathParam("marcaID") Long MarcaId) throws WebApplicationException{
        LOGGER.log(Level.INFO, "Marcaresorurce getMarca: input: {0}", MarcaId);
        MarcaEntity marcaEntity = logicMarca.getMarca(MarcaId);
        if (marcaEntity == null) {
            throw new WebApplicationException("El recurso /marca/" + MarcaId + " no existe.", 404);
        }
        MarcaDetailDTO detailDTO = new MarcaDetailDTO(marcaEntity);
        LOGGER.log(Level.INFO, "MarcaResource getMarca: output: {0}", detailDTO);
        return detailDTO;
    }
    
    
    
    @PUT
    @Path("{marcaID: \\d+}")
    public MarcaDetailDTO updateModelo(@PathParam("marcaID") Long marcaID, MarcaDTO marca )throws BusinessLogicException{
        LOGGER.log(Level.INFO, "MarcaResource UpdateMarca: input: id:{0} , modelo: {1}", new Object[]{marcaID, marca});
        marca.setIdMarca(marcaID);
        if (logicMarca.getMarca(marcaID) == null) {
            throw new WebApplicationException("El recurso /marcas/" + marcaID + " no existe.", 404);
        }
        MarcaDetailDTO detailDTO = new MarcaDetailDTO(logicMarca.updateMarca(marca.toEntity()));
        LOGGER.log(Level.INFO, "MarcaResource updateMarca: output: {0}", detailDTO);
        return detailDTO;
    }
    
    @DELETE
    @Path("{marcaID: \\d+}")
    public void deleteMarca(@PathParam("marcaID") Long marcaID) throws BusinessLogicException
    {
       LOGGER.log(Level.INFO, "MarcaResourse deleteMarca: input: {0}", marcaID);
        if (logicMarca.getMarca(marcaID) == null) {
            throw new WebApplicationException("El recurso /marcas/" + marcaID + " no existe.", 404);
        }
        logicMarca.deleteMarca(marcaID);
        LOGGER.info("MarcaResourse deleteMarca: output: void"); 
    }
    
    @Path("{marcaID: \\d+}/modelos")
    public Class<MarcaModelosResource> getMarcaModelosResource(@PathParam("marcaID") Long marcaID)
    {
        if(logicMarca.getMarca(marcaID) == null)
        {
            throw new WebApplicationException("El recurso /marcas/"+ marcaID+ "no existe", 404);
        }
        return MarcaModelosResource.class;
    }
    
    
    
    
     
    
    
    
}