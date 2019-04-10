/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.CompraVentaDTO;
import co.edu.uniandes.csw.carros.dtos.CompraVentaDetailDTO;
import co.edu.uniandes.csw.carros.ejb.CompraVentaLogic;
import co.edu.uniandes.csw.carros.ejb.PuntoVentaCompraVentaLogic;
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
 * @author Daniel Lozano
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PuntoVentaCompraVentaResource 
{
     private static final Logger LOGGER = Logger.getLogger(PuntoVentaEmpleadoResource.class.getName());    
  @Inject
    private PuntoVentaCompraVentaLogic puntoVentaCompraVentaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private CompraVentaLogic compraVentaLogic;
    
    @POST
    @Path("{puntoVentaID: \\d+}")
    public CompraVentaDTO addVenta(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("ventaID") Long ventaId) {
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource addVenta: input: puntoVentaID: {0} , clienteID: {1}", new Object[]{puntoVentaId, ventaId});
        if (compraVentaLogic.getCompraVenta(ventaId) == null) {
            throw new WebApplicationException("El recurso /venta/" + ventaId + " no existe.", 404);
        }
        CompraVentaDTO compraVentDTO = new CompraVentaDTO(puntoVentaCompraVentaLogic.addVenta(ventaId, puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource addVenta: output: {0}", compraVentDTO);
        return compraVentDTO;
    }
    
    @GET
    public List<CompraVentaDetailDTO> getVentas(@PathParam("puntoVentaID") Long puntoVentaId) {
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource getVentas: input: {0}", puntoVentaId);
        List<CompraVentaDetailDTO> listaDetailDTOs = ventaListEntity2DTO(puntoVentaCompraVentaLogic.getVentas(puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource getVentas: output: {0}", listaDetailDTOs);
        return listaDetailDTOs;
    }

    /**
     * Busca el libro con el id asociado dentro de la editorial con id asociado.
     *
     * @param editorialsId Identificador de la editorial que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param booksId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link BookDetailDTO} - El libro buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro en la
     * editorial.
     */
    @GET
      @Path("{puntoVentaID: \\d+}")
    public CompraVentaDetailDTO getVenta(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("ventaID") Long ventaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource getVenta: input: editorialsID: {0} , booksId: {1}", new Object[]{puntoVentaId, ventaId});
        if (compraVentaLogic.getCompraVenta(ventaId) == null) {
            throw new WebApplicationException("El recurso /PuntoVenta/" + puntoVentaId + "/cliente/" + ventaId + " no existe.", 404);
        }
        CompraVentaDetailDTO ventaDetailDTO = new CompraVentaDetailDTO(puntoVentaCompraVentaLogic.getVenta(puntoVentaId, ventaId));
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource getVenta:  output: {0}", ventaDetailDTO);
        return ventaDetailDTO;
    }

    /**
     * Remplaza las instancias de Book asociadas a una instancia de Editorial
     *
     * @param editorialsId Identificador de la editorial que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param books JSONArray {@link BookDTO} El arreglo de libros nuevo para la
     * editorial.
     * @return JSON {@link BookDTO} - El arreglo de libros guardado en la
     * editorial.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @PUT
    public List<CompraVentaDetailDTO> replaceCompraVenta(@PathParam("puntoVentaID") Long puntoVentaId, List<CompraVentaDetailDTO> ventas) {
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource remplaceVenta: input: editorialsId: {0} , marcas: {1}", new Object[]{puntoVentaId, ventas});
        for (CompraVentaDetailDTO venta : ventas) {
            if (compraVentaLogic.getCompraVenta(venta.getVentaID()) == null) 
                    {
                throw new WebApplicationException("El recurso /ventas/" + venta.getVentaID() + " no existe.", 404);
            }
        }
        List<CompraVentaDetailDTO> listaDetailDTOs = ventaListEntity2DTO(puntoVentaCompraVentaLogic.replaceVenta(puntoVentaId, ventaListDTO2Entity(ventas)));
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource remplaceVenta:output: {0}", listaDetailDTOs);
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de BookEntity a una lista de BookDetailDTO.
     *
     * @param entityList Lista de BookEntity a convertir.
     * @return Lista de BookDTO convertida.
     */
    private List<CompraVentaDetailDTO> ventaListEntity2DTO(List<CompraVentaEntity> entityList) {
        List<CompraVentaDetailDTO> list = new ArrayList<>();
        for (CompraVentaEntity entity : entityList) 
        {
            list.add(new CompraVentaDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de BookDetailDTO a una lista de BookEntity.
     *
     * @param dtos Lista de BookDetailDTO a convertir.
     * @return Lista de BookEntity convertida.
     */
    private List<CompraVentaEntity> ventaListDTO2Entity(List<CompraVentaDetailDTO> dtos) {
        List<CompraVentaEntity> list = new ArrayList<>();
        for (CompraVentaDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
      
}
