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
 *Recurso del punto de venta 
 * @author Daniel Lozano
 */
@Path("puntosdeVenta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class PuntoVentaResourse 
{
    /**
     * Constante de logger
     */
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaResourse.class.getName());
    
    /**
     * Asociacion con la logica del punto de venta
     */
    @Inject
    private PuntoVentaLogic logica;
    
    /**
     * Metodo que crea un nuevo punto de venta
     * @param puntoVenta a crear
     * @return el punto de venra creado con su respectiva logica.
     * @throws BusinessLogicException si no cu mple con las reglas de negocio
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
    
    /**
     * Retorna todos los puntos de venta del sistema
     * @return 
     */
    @GET
    public List<PuntoVentaDetailDTO> getPuntosVenta()
    {
        LOGGER.info("PuntoVentaResourse getPuntoVenta: input: void");
        List<PuntoVentaDetailDTO> listaPuntoVenta = listEntity2DetailDTO(logica.getPuntosVenta());
        LOGGER.log(Level.INFO, "PuntoVentaResourse getPuntoVenta: output: {0}", listaPuntoVenta);
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
    
    /**
     * Busca un punto de venta con un id dado
     * @param puntoVentaID de un punto de venta a buscar
     * @return punto de venta con un id que entra como parametro 
     * @throws WebApplicationException  si el punto de venta no exite
     */
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
    
    /**
     * Actualiza la informacion de un punto de venta 
     * @param puntoVentaID al cual se le va a actualizar la informacion
     * @param puntoVenta con la infromacion a actualizar
     * @return punto de venta con la informacion actualizada
     * @throws WebApplicationException  si el punto de venta que se quiere actuaqlizar no existe
     */
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
    
    /**
     * Elimina un punto de venta del sistema al cual corresponde el id
     * @param puntoVentaID del cual se va a borrar el punto de venta
     * @throws BusinessLogicException SU OCURRE un error al borar el punto de venta
     */
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
