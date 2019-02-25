    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.EmpleadoDTO;
import co.edu.uniandes.csw.carros.dtos.EmpleadoDetailDTO;
import co.edu.uniandes.csw.carros.ejb.EmpleadoLogic;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
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
 * @author Juan Pablo Patarroyo Duque
 */
@Path("/empleados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmpleadoResource {
    
    private static final Logger LOGGER = Logger.getLogger(EmpleadoResource.class.getName());
    
    @Inject
    private EmpleadoLogic empleadoLogic;
    
    @POST
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleado) throws BusinessLogicException{
        EmpleadoEntity entity = empleado.toEntity();
        empleadoLogic.createEmpleado(entity);
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(entity);
        return empleadoDTO;
    }
    
    @GET
    public List<EmpleadoDTO> getEmpleados(){
        return new ArrayList<>();
    }
    
    @GET
    @Path("{empleadoID: \\d+}")
    public EmpleadoDetailDTO getEmpleado(@PathParam("empleadoID") Long empleadoID){
        return null;
    }
    
    @PUT
    @Path("{empleadoID: \\d+}")
    public EmpleadoDTO updateEmpleado(@PathParam("empleadoID") Long empleadoID, EmpleadoDTO empleado){
        return empleado;
    }
    
    @DELETE
    @Path("{empleadoID: \\d+}")
    public void deleteEmpleado(@PathParam("empleadoID") Long empleadoID){     
    }
}
