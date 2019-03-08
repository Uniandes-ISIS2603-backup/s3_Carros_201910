/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.PuntoVentaDTO;
import co.edu.uniandes.csw.carros.dtos.PuntoVentaDetailDTO;
import co.edu.uniandes.csw.carros.ejb.PuntoVentaLogic;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
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
 * @author estudiante
 */
@Path("puntosdeVenta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class PuntoVentaResourse 
{
    
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaResourse.class.getName());
    
    @Inject
    private PuntoVentaLogic logica;
    
    /**
     * 
     * @param puntoVenta
     * @return
     * @throws BusinessLogicException 
     */
    @POST
    public PuntoVentaDTO createdPuntoVenta(PuntoVentaDTO puntoVenta) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "PuntoVentaResourse createPuntoVenta: input: {0}", puntoVenta);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        PuntoVentaEntity  puntoVentaEntity = puntoVenta.toEntity();
        // Invoca la lógica para crear la editorial nueva
        PuntoVentaEntity nuevoEditorialEntity = logica.createPuntoVenta(puntoVentaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        PuntoVentaDTO nuevoPuntoVentaDTO = new PuntoVentaDTO(nuevoEditorialEntity);
        LOGGER.log(Level.INFO, "PuntoVentaResourse createPuntoVenta: output: {0}", nuevoPuntoVentaDTO);
        return nuevoPuntoVentaDTO; 
    }
    
    @GET
    public List<PuntoVentaDetailDTO> getPuntosVenta()
    {
        LOGGER.info("PuntoVentaResourse getPuntoVenta: input: void");
        List<PuntoVentaDetailDTO> listaPuntoVenta = listEntity2DetailDTO(logica.getPuntosVenta());
        LOGGER.log(Level.INFO, "EditorialResource getEditorials: output: {0}", listaPuntoVenta);
        return listaPuntoVenta;
    }
    /**
     * Convierte una lista de entidades a DTO.
     */
    private List<PuntoVentaDetailDTO> listEntity2DetailDTO(List<PuntoVentaEntity> entityList) {
        List<PuntoVentaDetailDTO> list = new ArrayList<>();
        for (PuntoVentaEntity entity : entityList) {
            list.add(new PuntoVentaDetailDTO(entity));
        }
        return list;
    }
    @GET
    @Path("{puntoVentaID: \\d+}")
    public PuntoVentaDTO getPuntoVenta(@PathParam("puntoVentaID") Long puntoVentaID) throws WebApplicationException 
    {
        LOGGER.log(Level.INFO, "PuntoVentaResourse getPuntoVenta: input: {0}", puntoVentaID);
        PuntoVentaEntity puntoVentaEntity = logica.getPuntoVenta(puntoVentaID);
        if (puntoVentaEntity == null) {
            throw new WebApplicationException("El recurso /puntoVenta/" + puntoVentaID + " no existe.", 404);
        }
        PuntoVentaDetailDTO detailDTO = new PuntoVentaDetailDTO(puntoVentaEntity);
        LOGGER.log(Level.INFO, "PuntoVentaResourse getPuntoVenta: output: {0}", detailDTO);
        return detailDTO;
    }
    
    @PUT
    @Path("{puntoVentaID: \\d+}")
    public PuntoVentaDTO updatePuntoVenta(@PathParam("puntoVentaID") Long puntoVentaID, PuntoVentaDTO puntoVenta) throws WebApplicationException 
    {
        LOGGER.log(Level.INFO, "PuntoVentaResourse updatePuntoVenta: input: id:{0} , puntoVenta: {1}", new Object[]{puntoVentaID, puntoVenta});
        puntoVenta.setId(puntoVentaID);
        if (logica.getPuntoVenta(puntoVentaID) == null) {
            throw new WebApplicationException("El recurso /puntoVenta/" + puntoVentaID + " no existe.", 404);
        }
        PuntoVentaDetailDTO detailDTO = new PuntoVentaDetailDTO(logica.updatePuntoVenta(puntoVentaID, puntoVenta.toEntity()));
        LOGGER.log(Level.INFO, "PuntoVentaResourse updatePuntoVenta: output: {0}", detailDTO);
        return detailDTO;
       
    }
    
    @DELETE
    @Path("{puntoVentaID: \\d+}")
    public void deleteúntoVenta(@PathParam("puntoVentaID") Long puntoVentaID) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "PuntoVentaResourse deletePuntoVenta: input: {0}", puntoVentaID);
        if (logica.getPuntoVenta(puntoVentaID) == null) {
            throw new WebApplicationException("El recurso /puntoVenta/" + puntoVentaID + " no existe.", 404);
        }
        logica.deletePuntoVenta(puntoVentaID);
        LOGGER.info("PuntoVentaResourse deletePuntoVenta: output: void");
    }
}
