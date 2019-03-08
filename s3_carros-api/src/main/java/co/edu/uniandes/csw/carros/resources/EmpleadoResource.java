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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
public class EmpleadoResource {
    
    private static final Logger LOGGER = Logger.getLogger(EmpleadoResource.class.getName());
    
    @Inject
    private EmpleadoLogic empleadoLogic;
    
    @POST
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleado) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "EmpleadoResource createEmpleado: input: {0}", empleado);
        EmpleadoEntity entity = empleado.toEntity();
        EmpleadoEntity empleadoEntity = empleadoLogic.createEmpleado(entity);
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleadoEntity);
        LOGGER.log(Level.INFO, "EmpleadoResource createEmleado: output: {0}", empleadoDTO);
        return empleadoDTO;
    }
    
    @GET
    public List<EmpleadoDetailDTO> getEmpleados(){ 
        LOGGER.info("EmpleadoResource getEmpleados: input: void");
        List<EmpleadoDetailDTO> listDTO = new ArrayList<>();
        List<EmpleadoEntity> listEntity = empleadoLogic.getAllEmpleados();
        for(int i=0; i<listEntity.size(); i++){
            listDTO.add(new EmpleadoDetailDTO(listEntity.get(i)));
        }
        LOGGER.log(Level.INFO, "EmpleadoResource getEmpleados: output: {0}", listDTO);
        return listDTO;
    }
    
    @GET
    @Path("{empleadoID: \\d+}")
    public EmpleadoDetailDTO getEmpleado(@PathParam("empleadoID") Long empleadoID){
        LOGGER.log(Level.INFO, "EmpleadoResource getEmpleado: input: {0}", empleadoID);
        EmpleadoEntity empleadoEntity = empleadoLogic.getEmpleado(empleadoID);
        EmpleadoDetailDTO empleadoDTO = new EmpleadoDetailDTO(empleadoEntity);
         LOGGER.log(Level.INFO, "EmpleadoResource getEmpleado: output: {0}", empleadoDTO);
        return empleadoDTO;
    }
    
    @PUT
    @Path("{empleadoID: \\d+}")
    public EmpleadoDetailDTO updateEmpleado(@PathParam("empleadoID") Long empleadoID, EmpleadoDetailDTO empleado)throws BusinessLogicException{
        LOGGER.log(Level.INFO, "EmpleadoResource updateEmpleado: input: id:{0} , empleado: {1}", new Object[]{empleadoID, empleado});
        empleado.setEmpleadoID(empleadoID);
        EmpleadoDetailDTO empleadoDto = new EmpleadoDetailDTO(empleadoLogic.updateEmpleado(empleado.toEntity()));
        LOGGER.log(Level.INFO, "EmpleadoResource updateEmpleado: output: {0}", empleadoDto);
        return empleadoDto;
    }
    
    @DELETE
    @Path("{empleadoID: \\d+}")
    public void deleteEmpleado(@PathParam("empleadoID") Long empleadoID){   
        LOGGER.log(Level.INFO, "EmpleadoResource deleteEmpleado: input: {0}", empleadoID);
        empleadoLogic.deleteEmpleado(empleadoID);
        LOGGER.info("EmpleadoResource deleteEmpleado: output: void");
    }
}
