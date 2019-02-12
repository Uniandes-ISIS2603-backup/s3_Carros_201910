/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.EmpleadoDTO;
import co.edu.uniandes.csw.carros.dtos.EmpleadoDetailDTO;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author estudiante
 */
@Path("/empleados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmpleadoResource {
    
    private static final Logger LOGGER = Logger.getLogger(EmpleadoResource.class.getName());
    
    @POST
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleado){
        return empleado;
    }
    
    @GET
    @Path("(empleadoID: \\d+")
    public EmpleadoDetailDTO getEmpleado(@PathParam("empleadoID") int empleadoID){
        return null;
    }
    
}
