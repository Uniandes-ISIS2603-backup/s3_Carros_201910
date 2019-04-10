/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.EmpleadoPersistence;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
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
    private EmpleadoPersistence persistence; //atributo para acceder a la persistencia empleado
    
    @Inject 
    private PuntoVentaPersistence persPuntoVenta; //atributo para acceder a la persistencia punto de venta
    
    private static final Logger LOGGER = Logger.getLogger(EmpleadoLogic.class.getName());
    
    /**
     * Crea un empleado en la persistencia.
     */
    public EmpleadoEntity createEmpleado(EmpleadoEntity nuevoEmpleado) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de creación del empleado");
        List<EmpleadoEntity> search = persistence.findEmpleadoPorCorreo(nuevoEmpleado.getCorreo());
        if(search.isEmpty()){
            if(nuevoEmpleado.getPuntoVenta() == null){
                throw new BusinessLogicException("¡El empleado no tiene ningún punto de venta asociado!");
            }
            else{
                PuntoVentaEntity pVenta = persPuntoVenta.find(nuevoEmpleado.getPuntoVenta().getId());
                if(pVenta == null){
                    throw new BusinessLogicException("¡El punto de venta asignado al empleado no existe!");
                }
                nuevoEmpleado.setPuntoVenta(pVenta);
                persistence.create(nuevoEmpleado);
                LOGGER.log(Level.INFO, "Inicia proceso de creación del empleado");
                return nuevoEmpleado;
            }           
        }
        else{
            throw new BusinessLogicException("El empleado con el correo ingresado ya existe");
        }      
    }
    
    /**
     * Borrar un empleado
     */
    public void deleteEmpleado(Long empleadoID){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el empleado con id = {0}", empleadoID);
        persistence.deleteEmpleado(empleadoID);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el empleado con id = {0}", empleadoID);
    }
    
    /**
     *
     * Actualizar un empleado.
     */
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleado)throws BusinessLogicException{
         LOGGER.log(Level.INFO, "Inicia proceso de actualizar el empleado con id = {0}", empleado.getId());
        String correo = empleado.getCorreo();
        List<EmpleadoEntity> search = persistence.findEmpleadoPorCorreo(correo);
        if(search.isEmpty() || search.get(0).getId() == empleado.getId()){
            PuntoVentaEntity pVenta = persPuntoVenta.find(empleado.getPuntoVenta().getId());
            if(pVenta != null){
                persistence.updateEmpleado(empleado);
            }
            else{
                throw new BusinessLogicException("El punto de venta asignado no existe");
            }              
        }
        else{
            throw new BusinessLogicException("Ya existe un empleado con el correo ingresado");
        }
        
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el empleado con id = {0}", empleado);
        return empleado;
    }
    
    /**
     *
     * Obtener un empleado por medio de su id.
     */
    public EmpleadoEntity getEmpleado(Long empleadoID){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el empleado con id = {0}", empleadoID);
        EmpleadoEntity empleado = persistence.findEmpleado(empleadoID);
        if(empleado == null){
            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", empleadoID);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el empleado con id = {0}", empleadoID);
        return empleado;
    }
    
     /**
     * Obtener todas los empleados existentes en la base de datos.
     */
    public List<EmpleadoEntity> getAllEmpleados(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los empleados");
        List<EmpleadoEntity> lista = persistence.findAllEmpleados();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los empleados");
        return lista;     
    }
}
