/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.EmpleadoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
@Stateless
public class EmpleadoLogic {
    
    @Inject
    private EmpleadoPersistence persistence;
    
    private static final Logger LOGGER = Logger.getLogger(EmpleadoLogic.class.getName());
    
    public EmpleadoEntity createEmpleado(EmpleadoEntity nuevoEmpleado) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de creación del empleado");
        EmpleadoEntity search = persistence.findEmpleadoPorCorreo(nuevoEmpleado.getCorreo());
        if(search == null){
            
            persistence.create(nuevoEmpleado);
            LOGGER.log(Level.INFO, "Inicia proceso de creación del empleado");
            return nuevoEmpleado;
        }
        else{
            throw new BusinessLogicException("El empleado con el correo ingresado ya existe");
        }
        
    }
    
    public void deleteEmpleado(Long empleadoID){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el empleado con id = {0}", empleadoID);
        persistence.deleteEmpleado(empleadoID);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el empleado con id = {0}", empleadoID);
    }
    
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleado)throws BusinessLogicException{
         LOGGER.log(Level.INFO, "Inicia proceso de actualizar el empleado con id = {0}", empleado.getId());
        String correo = empleado.getCorreo();
        EmpleadoEntity ee = persistence.findEmpleado(empleado.getId());
        if(ee.getCorreo().equals(correo)){
            persistence.updateEmpleado(empleado);
        }
        else{
            EmpleadoEntity search = persistence.findEmpleadoPorCorreo(correo);
            if(search == null){
                persistence.updateEmpleado(empleado);
            }
            else{
                throw new BusinessLogicException("Ya existe un empleado con el correo ingresado");
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el empleado con id = {0}", empleado);
        return empleado;
    }
    
    public EmpleadoEntity getEmpleado(Long empleadoID){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el empleado con id = {0}", empleadoID);
        EmpleadoEntity empleado = persistence.findEmpleado(empleadoID);
        if(empleado == null){
            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", empleadoID);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el empleado con id = {0}", empleadoID);
        return empleado;
    }
    
    public List<EmpleadoEntity> getAllEmpleados(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los empleados");
        List<EmpleadoEntity> lista = persistence.findAllEmpleados();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los empleados");
        return lista;     
    }
}
