/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.EmpleadoDTO;
import co.edu.uniandes.csw.carros.dtos.EmpleadoDetailDTO;
import co.edu.uniandes.csw.carros.dtos.QuejasReclamosDTO;
import co.edu.uniandes.csw.carros.ejb.QuejasReclamosLogic;
import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Julio Ruiz
 */
@Path("/quejasReclamos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class QuejasReclamosResource {
    
    private static final Logger LOGGER = Logger.getLogger(QuejasReclamosResource.class.getName());
    
    @Inject
    private QuejasReclamosLogic quejasReclamosLogic;
    
    /**
     * Crea una nueva Queja con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param queja {@link QuejasReclamosDTO} - La queja que se desea
     * guardar.
     * @return JSON {@link QuejasReclamosDTO} - La queja guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la compraventa.
     */
    @POST
    public QuejasReclamosDTO createQuejasReclamos(QuejasReclamosDTO queja) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "QuejasReclamosResource createQuejasReclamos: input: {0}", queja);
        QuejasReclamosDTO nuevoQuejasReclamosDTO = new QuejasReclamosDTO(quejasReclamosLogic.createQuejasReclamos(queja.toEntity()));
        LOGGER.log(Level.INFO, "QuejasReclamosResource createQuejasReclamos: output: {0}", nuevoQuejasReclamosDTO);
        return nuevoQuejasReclamosDTO;
}
    /**
     * Busca y retorna todas las quejas que existen en la aplicación.
     * 
     * @return JSONArray {@link QuejasReclamosDTO} - Las quejas
     * encontradas en la aplicacion. Si no hay ninguna ratorna una lista vacía..
     */
    @GET
    public List<QuejasReclamosDTO> getQuejasReclamos() {
        LOGGER.info("QuejasReclamosResource QuejasReclamosBooks: input: void");
        List<QuejasReclamosDTO> listaQuejasReclamos = listEntity2DetailDTO(quejasReclamosLogic.getQuejasReclamos());
        LOGGER.log(Level.INFO, "QuejasReclamosResource getBooks: output: {0}", listaQuejasReclamos);
        return listaQuejasReclamos;
}
    /**
     * Busca la queja con el id asociado recibido en la URL y la devuelve.
     * 
     * @param casoID: Identificador de la queja.
     * @return JSON {@link QuejasReclamosDTO} - La queja buscada. 
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la queja.
     */
    @GET
    @Path("{casoId: \\d+}")
    public QuejasReclamosDTO getQueja(@PathParam("casoId") Long casoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "QuejasReclamosResource getQueja: input: {0}", casoId);
        QuejasReclamosEntity quejaEntity = quejasReclamosLogic.getQueja(casoId);
        if (quejaEntity == null) {
            throw new WebApplicationException("El recurso /quejasReclamos/" + casoId + " no existe.", 404);
        }
        QuejasReclamosDTO quejaDTO = new QuejasReclamosDTO(quejaEntity);
        LOGGER.log(Level.INFO, "QuejasReclamosResource getQueja: output: {0}", quejaDTO);
        return quejaDTO;
}
    
    /**
     * Actualiza la queja con el id recibido en la URL con la informacion
     * que se recibe en el cuerpo de la petición.
     *
     * @param casoId Identificador de la queja que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param queja {@link QuejasReclamosDTO} La queja que se desea
     * guardar.
     * @return JSON {@link QuejasReclamosDTO} - La queja guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la queja a
     * actualizar.
     */
    @PUT
    @Path("{casoId: \\d+}")
    public QuejasReclamosDTO updateQuejasReclamos(@PathParam("casoId") Long casoId, QuejasReclamosDTO queja) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "QuejasReclamosResource updateQuejasReclamos: input: casoId: {0} , queja: {1}", new Object[]{casoId, queja});
        queja.setCasoId(casoId);
        if (quejasReclamosLogic.getQueja(casoId) == null) {
            throw new WebApplicationException("El recurso /quejasReclamos/" + casoId + " no existe.", 404);
        }
        QuejasReclamosDTO DTO = new QuejasReclamosDTO(quejasReclamosLogic.updateQuejasReclamos(casoId, queja.toEntity()));
        LOGGER.log(Level.INFO, "QuejasReclamosResource updateQuejasReclamos: output: {0}", DTO);
        return DTO;
    }
    
    
    /**
     * Elimina una queja con el ID recibido en la URL con la información
     * que recibe el cuerpo de petición
     * @param QuejasReclamosId : Identificador de la queja
     * @throws BusinessLogicException si no existe la queja con el Id
     */
    @DELETE
    @Path("{casoId: \\d+}")
    public void deleteQuejasReclamos(@PathParam("casoId") Long QuejasReclamosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "QuejasReclamosResource deleteQuejasReclamos: input: {0}", QuejasReclamosId);
        QuejasReclamosEntity entity = quejasReclamosLogic.getQueja(QuejasReclamosId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /quejasReclamos/" + QuejasReclamosId + " no existe.", 404);
        }
        quejasReclamosLogic.deleteQuejasReclamos(QuejasReclamosId);
        LOGGER.info("BookResource deleteBook: output: void");
}

    /**
     * Convierte una lista de entidades a DTO
     * 
     * Este método convierte una lista de objetos QuejasReclamosEntity a una lista de 
     * objetos QuejasReclamosDTO (json).
     * 
     * @param entityList corresponde a una lista de quejas de tipo Entity.
     * @return la lista de quejas en forma DTO (json).
     */
    private List<QuejasReclamosDTO> listEntity2DetailDTO(List<QuejasReclamosEntity> entityList) {
        List<QuejasReclamosDTO> list = new ArrayList<>();
        for (QuejasReclamosEntity entity : entityList) {
            list.add(new QuejasReclamosDTO(entity));
        }
        return list;
}
}
