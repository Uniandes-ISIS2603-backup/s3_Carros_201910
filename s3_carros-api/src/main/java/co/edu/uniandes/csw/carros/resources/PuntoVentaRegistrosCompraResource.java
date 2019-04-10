/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.CompraVentaDTO;
import co.edu.uniandes.csw.carros.dtos.RegistroCompraDTO;
import co.edu.uniandes.csw.carros.ejb.PuntoVentaRegistroCompraLogic;
import co.edu.uniandes.csw.carros.ejb.RegistroCompraLogic;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
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
public class PuntoVentaRegistrosCompraResource 
{
    
  private static final Logger LOGGER = Logger.getLogger(PuntoVentaEmpleadoResource.class.getName());    
  
  
  @Inject
   private PuntoVentaRegistroCompraLogic puntoVentaRegistroCompraLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private RegistroCompraLogic registroCompraLogic;
    
    @POST
    @Path("{puntoVentaID: \\d+}")
    public RegistroCompraDTO addCompra(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("compraID") Long compraId) {
        LOGGER.log(Level.INFO, "PuntoVentaRegistroCompraResource addCompra: input: puntoVentaID: {0} , clienteID: {1}", new Object[]{puntoVentaId, compraId});
        if (registroCompraLogic.getRegistroCompra(compraId) == null) {
            throw new WebApplicationException("El recurso /compra/" + compraId + " no existe.", 404);
        }
        RegistroCompraDTO compraDTO = new RegistroCompraDTO(puntoVentaRegistroCompraLogic.addCompra(compraId, puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaRegistroCompraResource addCompra: output: {0}", compraDTO);
        return compraDTO;
    }
    
    @GET
    public List<RegistroCompraDTO> getCompras(@PathParam("puntoVentaID") Long puntoVentaId) {
        LOGGER.log(Level.INFO, "PuntoVentaRegistroCompraResource getCompras: input: {0}", puntoVentaId);
        List<RegistroCompraDTO> listaDetailDTOs = compraListEntity2DTO(puntoVentaRegistroCompraLogic.getCompras(puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaRegistroCompraResource getCompras: output: {0}", listaDetailDTOs);
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
    public RegistroCompraDTO getCompra(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("compraID") Long compraID) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "PuntoVentaRegistroCompraResource getCompra: input: editorialsID: {0} , booksId: {1}", new Object[]{puntoVentaId, compraID});
        if (registroCompraLogic.getRegistroCompra(compraID) == null) {
            throw new WebApplicationException("El recurso /PuntoVenta/" + puntoVentaId + "/compra/" + compraID + " no existe.", 404);
        }
        RegistroCompraDTO compraDTO = new RegistroCompraDTO(puntoVentaRegistroCompraLogic.getCompra(puntoVentaId, compraID));
        LOGGER.log(Level.INFO, "PuntoVentaRegistroCompraResource getCompra:  output: {0}", compraDTO);
        return compraDTO;
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
    
    public List<RegistroCompraDTO> replaceRegistroCompra(@PathParam("puntoVentaID") Long puntoVentaId, List<RegistroCompraDTO> compras) {
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource remplaceVenta: input: editorialsId: {0} , marcas: {1}", new Object[]{puntoVentaId, compras});
        for (RegistroCompraDTO compra : compras) {
            if (registroCompraLogic.getRegistroCompra(compra.getCompraId()) == null) 
                    {
                throw new WebApplicationException("El recurso /compras/" + compra.getCompraId() + " no existe.", 404);
            }
        }
        List<RegistroCompraDTO> listaDetailDTOs = compraListEntity2DTO(puntoVentaRegistroCompraLogic.replaceCompra(puntoVentaId, compraListDTO2Entity(compras)));
        LOGGER.log(Level.INFO, "PuntoVentaCompraVentaResource remplaceVenta:output: {0}", listaDetailDTOs);
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de BookEntity a una lista de BookDetailDTO.
     *
     * @param entityList Lista de BookEntity a convertir.
     * @return Lista de BookDTO convertida.
     */
    private List<RegistroCompraDTO> compraListEntity2DTO(List<RegistroCompraEntity> entityList) {
        List<RegistroCompraDTO> list = new ArrayList<>();
        for (RegistroCompraEntity entity : entityList) 
        {
            list.add(new RegistroCompraDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de BookDetailDTO a una lista de BookEntity.
     *
     * @param dtos Lista de BookDetailDTO a convertir.
     * @return Lista de BookEntity convertida.
     */
    private List<RegistroCompraEntity> compraListDTO2Entity(List<RegistroCompraDTO> dtos) {
        List<RegistroCompraEntity> list = new ArrayList<>();
        for (RegistroCompraDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
      
}
