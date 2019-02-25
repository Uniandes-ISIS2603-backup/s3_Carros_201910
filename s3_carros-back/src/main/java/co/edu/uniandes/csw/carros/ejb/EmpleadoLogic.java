/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.EmpleadoPersistence;
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
    
    public EmpleadoEntity createEmpleado(EmpleadoEntity nuevoEmpleado) throws BusinessLogicException{
        EmpleadoEntity search = persistence.findEmpleadoPorCorreo(nuevoEmpleado.getCorreo());
        if(search == null){
            persistence.create(nuevoEmpleado);
            return nuevoEmpleado;
        }
        else{
            throw new BusinessLogicException("El empleado con el correo ingresado ya existe");
        }
    }
    
    public void deleteEmpleado(Long empleadoID){
        persistence.deleteEmpleado(empleadoID);
    }
    
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleado)throws BusinessLogicException{
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
        return empleado;
    }
}
