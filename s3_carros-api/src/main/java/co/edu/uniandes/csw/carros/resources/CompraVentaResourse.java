/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.CompraVentaDTO;
import co.edu.uniandes.csw.carros.dtos.CompraVentaDetailDTO;
import co.edu.uniandes.csw.carros.ejb.CompraVentaLogic;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Kevin Hernán Castrillón Castañeda
 */
@Path("/compraVentas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraVentaResourse 
{
    private final static Logger LOGGER = Logger.getLogger(CompraVentaResourse.class.getName());
    
    @Inject
    private CompraVentaLogic compraVentaLogic; 
    
     /**
     * Crea una nueva CompraVenta con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param compraVenta {@link CompraVentaDTO} - La compraVenta que se desea
     * guardar.
     * @return JSON {@link CompraVentaDTO} - La compraVenta guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la compraventa.
     */
    @POST
    public CompraVentaDTO createCompraVenta( CompraVentaDTO compraVenta ) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "ComporaVentaResourse createCompraVenta: imput: {0}", compraVenta);
        //DTO (json) a Entity para ser manejado por la lógica.
        CompraVentaEntity compraVentaEntity = compraVenta.toEntity();
        //Invoca la lógica para crear la compraVenta nueva.
        CompraVentaEntity nuevaCompraVentaEntity = compraVentaLogic.createCompraVenta(compraVentaEntity);
        //Como debe retornar DTO (json) se invoca el constructor del DTO con argumento el entity nuevo.
        CompraVentaDTO nuevaCompraVentaDTO = new CompraVentaDTO(nuevaCompraVentaEntity);
        LOGGER.log(Level.INFO, "CompraVentaResourse createCompraVenta: output: {0}", nuevaCompraVentaDTO);
        return nuevaCompraVentaDTO;
    }
    
    /**
     * Busca y retorna todas las CompraVentas que existen en la aplicación.
     * 
     * @return JSONArray {@link CompraVentaDetailDTO} - Las CompraVentas
     * encontradas en la aplicacion. Si no hay ninguna ratorna una lista vacía..
     */
    @GET
    public List<CompraVentaDetailDTO> getCompraVentas( )
    {
        LOGGER.log(Level.INFO, "ComporaVentaResourse getCompraVentas: imput: void");
        List<CompraVentaDetailDTO> listaCompraVentas = listEntity2DetailDTO(compraVentaLogic.getCompraVentas());
        LOGGER.log(Level.INFO, "ComporaVentaResourse createCompraVenta: output: {0}", listaCompraVentas);
        return listaCompraVentas;
    }

    /**
     * Busca la compraVenta con el id asociado recibido en la URL y la devuelve.
     * 
     * @param ventaID: Identificador de la compraVenta.
     * @return JSON {@link CompraVentaDetailDTO} - La compraVenta buscada. 
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la CompraVenta.
     */
    @GET
    @Path("{ventaID: \\d+}")
    public CompraVentaDetailDTO getCompraVenta( @PathParam("ventaID") Long ventaID ) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "CompraVentaResurse getCompraVenta: imput: {0}", ventaID);
        CompraVentaEntity compraVentaEntity = compraVentaLogic.getCompraVenta(ventaID);
        if(compraVentaEntity == null)
        {
            throw new  WebApplicationException("El recurso /compraVentas/" + ventaID + " no existe.", 404);
        }
        CompraVentaDetailDTO detailDTO = new CompraVentaDetailDTO(compraVentaEntity);
        return detailDTO;
    }
    
    /**
     * Actualiza la compraVenta con el id recibido en la URL con la informacion
     * que se recibe en el cuerpo de la petición.
     *
     * @param ventaID Identificador de la compraVenta que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param compraVenta {@link CompraVentaDTO} La compraVenta que se desea
     * guardar.
     * @return JSON {@link CompraVentaDTO} - La compraVenta guardada.
     //* @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     //* Error de lógica que se genera cuando no se encuentra la editorial a
     //* actualizar.
     */
    @PUT
    @Path("{ventaID: \\d+}")
    public CompraVentaDTO updateCompraVenta(@PathParam("ventaID") Long ventaID, CompraVentaDTO compraVenta) 
    {
        return compraVenta;
    }
    
    /**
     * Convierte una lista de entidades a DTO
     * 
     * Este método convierte una lista de objetos CompraVentaEntity a una lista de 
     * objetos CompraVentaDetailDTO (json).
     * 
     * @param entityList corresponde a una lista de compraventas de tipo Entity.
     * @return la lista de compraVentas en forma DTO (json).
     */
    private List<CompraVentaDetailDTO> listEntity2DetailDTO(List<CompraVentaEntity> entityList)
    {
        List<CompraVentaDetailDTO> list = new ArrayList<>();
        for(CompraVentaEntity entity : entityList)
        {
            list.add(new CompraVentaDetailDTO(entity));
        }
        return list;
    }
}
