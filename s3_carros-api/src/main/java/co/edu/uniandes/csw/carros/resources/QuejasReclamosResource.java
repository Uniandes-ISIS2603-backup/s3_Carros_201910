/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.EmpleadoDTO;
import co.edu.uniandes.csw.carros.dtos.EmpleadoDetailDTO;
import co.edu.uniandes.csw.carros.dtos.QuejasReclamosDTO;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Julio Ruiz
 */
@Path("/quejasReclamos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuejasReclamosResource {
    
    private static final Logger LOGGER = Logger.getLogger(QuejasReclamosResource.class.getName());
    
    @POST
    public QuejasReclamosDTO createQuejasReclamos(QuejasReclamosDTO queja){
        return queja;
    }
    
    @GET
    public ArrayList<QuejasReclamosDTO> getQuejasReclamos()
    {
        return new ArrayList<>();
    }
    
    @PUT
    @Path("{casoId: \\d+}")
    public QuejasReclamosDTO updateQuejasReclamos(@PathParam("casoId") Long casoId, QuejasReclamosDTO queja){
        return queja;
    }
    
    @DELETE
    @Path("{casoId: \\d+}")
    public void deleteQuejasReclamos(@PathParam("casoId") Long casoID){     
    }
}
