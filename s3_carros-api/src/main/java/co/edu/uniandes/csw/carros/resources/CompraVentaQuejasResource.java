package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.QuejasReclamosDTO;
import co.edu.uniandes.csw.carros.ejb.QuejasReclamosLogic;
import co.edu.uniandes.csw.carros.ejb.CompraVentaQuejasLogic;
import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
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
 * Clase que implementa el recurso "compraVentas/{ventaID}/quejasReclamos
 * 
 * @author Kevin Hernán Castrillón Castañeda
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraVentaQuejasResource 
{
    private static final Logger LOGGER = Logger.getLogger(CompraVentaQuejasResource.class.getName());

    @Inject
    private CompraVentaQuejasLogic compraVentaQuejasLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private QuejasReclamosLogic quejasLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Guarda una queja dentro de una compraVenta con la informacion que recibe el
     * la URL. Se devuelve la queja que se guarda en la compraVenta.
     *
     * @param compraVentaId Identificador de la compraVenta que se esta
     * actualizando. Este debe ser una cadena de dígitos.
     * @param quejaId Identificador de la queja que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link QuejasReclamosDTO} - La queja guardada en la compraVenta.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la queja.
     */
    @POST
    @Path("{quejaId: \\d+}")
    public QuejasReclamosDTO addQueja(@PathParam("ventaID") Long compraVentaId, @PathParam("quejaId") Long quejaId) {
        LOGGER.log(Level.INFO, "CompraVentaQuejasResourse addQueja: input: ventaID: {0} , quejaId: {1}", new Object[]{compraVentaId, quejaId});
        if (quejasLogic.getQueja(quejaId) == null) {
            throw new WebApplicationException("El recurso /quejasReclamos/" + quejaId + " no existe.", 404);
        }
        QuejasReclamosDTO quejaDTO = new QuejasReclamosDTO(compraVentaQuejasLogic.addQueja(quejaId, compraVentaId));
        LOGGER.log(Level.INFO, "CompraVentaQuejaResource addQueja: output: {0}", quejaId);
        return quejaDTO;
    }
    
    /**
     * Busca y devuelve todas las quejas que existen en la compraVenta.
     *
     * @param compraVentaId Identificador de la compraVenta que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSONArray {@link QuejasReclamosDTO} - Los libros encontrados en la
     * compraVenta. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<QuejasReclamosDTO> getQuejas(@PathParam("compraVentaId") Long compraVentaId) {
        LOGGER.log(Level.INFO, "CompraVentaQuejasResource getQuejass: input: {0}", compraVentaId);
        List<QuejasReclamosDTO> listaQuejasDTOs = quejasListEntity2DTO(compraVentaQuejasLogic.getQuejas(compraVentaId));
        LOGGER.log(Level.INFO, "CompraVentaQuejasResource getQuejas: output: {0}", listaQuejasDTOs);
        return listaQuejasDTOs;
    }
    
     /**
     * Busca la queja con el id asociado dentro de la compraVenta con id asociado.
     *
     * @param compraVentaId Identificador de la compraVenta que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param quejaId Identificador de la queja que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link QuejasReclamosDTO} - La queja buscada
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la queja.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la queja en la
     * compraVenta.
     */
    @GET
    @Path("{quejaId: \\d+}")
    public QuejasReclamosDTO getQueja(@PathParam("ventaId") Long compraVentaId, @PathParam("quejaId") Long quejaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "CompraVentaQuejasResource getBook: input: editorialsID: {0} , booksId: {1}", new Object[]{compraVentaId, quejaId});
        if (quejasLogic.getQueja(quejaId) == null) {
            throw new WebApplicationException("El recurso /compraVentas/" + compraVentaId + "/quejasReclamos/" + quejaId + " no existe.", 404);
        }
        QuejasReclamosDTO quejaDTO = new QuejasReclamosDTO(compraVentaQuejasLogic.getQueja(compraVentaId, quejaId));
        LOGGER.log(Level.INFO, "CompraVentaQuejasResource getQueja: output: {0}", quejaDTO);
        return quejaDTO;
    }
    
    /**
     * Convierte una lista de QuejasReclamosEntity a una lista de QuejasReclamosDTO.
     *
     * @param entityList Lista de QuejasReclamosEntity a convertir.
     * @return Lista de QuejasReclamosDTO convertida.
     */
    private List<QuejasReclamosDTO> quejasListEntity2DTO(List<QuejasReclamosEntity> entityList) {
        List<QuejasReclamosDTO> list = new ArrayList();
        for (QuejasReclamosEntity entity : entityList) {
            list.add(new QuejasReclamosDTO(entity));
        }
        return list;
    }
    
    /**
     * Convierte una lista de QuejasReclamosDTO a una lista de QuejasReclamosEntity.
     *
     * @param dtos Lista de QuejasReclamosDTO a convertir.
     * @return Lista de QuejasReclamosEntity convertida.
     */
    private List<QuejasReclamosEntity> quejasListDTO2Entity(List<QuejasReclamosDTO> dtos) {
        List<QuejasReclamosEntity> list = new ArrayList<>();
        for (QuejasReclamosDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
