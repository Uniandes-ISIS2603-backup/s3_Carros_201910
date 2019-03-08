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
    
    @POST
    @Path("{casoId: \\d+}")
    public QuejasReclamosDTO createQuejasReclamos(QuejasReclamosDTO queja) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "QuejasReclamosResource createQuejasReclamos: input: {0}", queja);
        QuejasReclamosDTO nuevoQuejasReclamosDTO = new QuejasReclamosDTO(quejasReclamosLogic.createQuejasReclamos(queja.toEntity()));
        LOGGER.log(Level.INFO, "QuejasReclamosResource createQuejasReclamos: output: {0}", nuevoQuejasReclamosDTO);
        return nuevoQuejasReclamosDTO;
}
    
    @GET
    public List<QuejasReclamosDTO> getQuejasReclamos() {
        LOGGER.info("QuejasReclamosResource QuejasReclamosBooks: input: void");
        List<QuejasReclamosDTO> listaQuejasReclamos = listEntity2DetailDTO(quejasReclamosLogic.getQuejasReclamos());
        LOGGER.log(Level.INFO, "QuejasReclamosResource getBooks: output: {0}", listaQuejasReclamos);
        return listaQuejasReclamos;
}
    
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

    private List<QuejasReclamosDTO> listEntity2DetailDTO(List<QuejasReclamosEntity> entityList) {
        List<QuejasReclamosDTO> list = new ArrayList<>();
        for (QuejasReclamosEntity entity : entityList) {
            list.add(new QuejasReclamosDTO(entity));
        }
        return list;
}
}
