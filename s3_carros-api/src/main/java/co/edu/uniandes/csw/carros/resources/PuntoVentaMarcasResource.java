/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.MarcaDTO;
import co.edu.uniandes.csw.carros.dtos.MarcaDetailDTO;
import co.edu.uniandes.csw.carros.ejb.MarcaLogic;
import co.edu.uniandes.csw.carros.ejb.PuntoVentaMarcaLogic;
import co.edu.uniandes.csw.carros.entities.MarcaEntity;
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
public class PuntoVentaMarcasResource 
{
 private static final Logger LOGGER = Logger.getLogger(PuntoVentaMarcasResource.class.getName());    
 
    @Inject
    private PuntoVentaMarcaLogic puntoVentaMarcaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private MarcaLogic marcaLogic;
    
    @POST
    @Path("{puntoVentaID: \\d+}")
    public MarcaDTO addMarca(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("marcaID") Long marcaId) {
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource addmARCA: input: puntoVentaID: {0} , marcaID: {1}", new Object[]{puntoVentaId, marcaId});
        if (marcaLogic.getMarca(marcaId) == null) {
            throw new WebApplicationException("El recurso /marca/" + marcaId + " no existe.", 404);
        }
        MarcaDTO marcaDTO = new MarcaDTO(puntoVentaMarcaLogic.addMarca(marcaId, puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource addmARCA: output: {0}", marcaDTO);
        return marcaDTO;
    }
    
     @GET
    public List<MarcaDetailDTO> getMarcas(@PathParam("puntoVentaID") Long puntoVentaId) {
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource getMarcas: input: {0}", puntoVentaId);
        List<MarcaDetailDTO> listaDetailDTOs = marcasListEntity2DTO(puntoVentaMarcaLogic.getMarcas(puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource getMarcas: output: {0}", listaDetailDTOs);
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
    public MarcaDetailDTO getMarca(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("marcaID") Long marcaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource getMarcas: input: editorialsID: {0} , booksId: {1}", new Object[]{puntoVentaId, marcaId});
        if (marcaLogic.getMarca(marcaId) == null) {
            throw new WebApplicationException("El recurso /PuntoVenta/" + puntoVentaId + "/marca/" + marcaId + " no existe.", 404);
        }
        MarcaDetailDTO marcaDetailDTO = new MarcaDetailDTO(puntoVentaMarcaLogic.getMarca(puntoVentaId, marcaId));
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource getMarcas: output: {0}", marcaDetailDTO);
        return marcaDetailDTO;
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
    public List<MarcaDetailDTO> replacemARCAS(@PathParam("puntoVentaID") Long puntoVentaId, List<MarcaDetailDTO> marcas) {
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource replaceMarcas: input: editorialsId: {0} , marcas: {1}", new Object[]{puntoVentaId, marcas});
        for (MarcaDetailDTO marca : marcas) {
            if (marcaLogic.getMarca(marca.getIdMarca()) == null) 
                    {
                throw new WebApplicationException("El recurso /marcas/" + marca.getIdMarca() + " no existe.", 404);
            }
        }
        List<MarcaDetailDTO> listaDetailDTOs = marcasListEntity2DTO(puntoVentaMarcaLogic.replaceMarcas(puntoVentaId, marcaListDTO2Entity(marcas)));
        LOGGER.log(Level.INFO, "PuntoVentaMarcasResource replaceMarcas: output: {0}", listaDetailDTOs);
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de BookEntity a una lista de BookDetailDTO.
     *
     * @param entityList Lista de BookEntity a convertir.
     * @return Lista de BookDTO convertida.
     */
    private List<MarcaDetailDTO> marcasListEntity2DTO(List<MarcaEntity> entityList) {
        List<MarcaDetailDTO> list = new ArrayList();
        for (MarcaEntity entity : entityList) {
            list.add(new MarcaDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de BookDetailDTO a una lista de BookEntity.
     *
     * @param dtos Lista de BookDetailDTO a convertir.
     * @return Lista de BookEntity convertida.
     */
    private List<MarcaEntity> marcaListDTO2Entity(List<MarcaDetailDTO> dtos) {
        List<MarcaEntity> list = new ArrayList<>();
        for (MarcaDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    
}
