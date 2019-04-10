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
 * @author Daniel Lozano
 */
@Stateless
public class PuntoVentaEmpleadoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaEmpleadoLogic.class.getName());

    @Inject
    private EmpleadoPersistence empleadoPersistence;

    @Inject
    private PuntoVentaPersistence puntoVentaPersistence;

    /**
     * Agregar un book a la editorial
     *
     * @param booksId El id libro a guardar
     * @param editorialsId El id de la editorial en la cual se va a guardar el
     * libro.
     * @return El libro creado.
     */
    public EmpleadoEntity addEmpleado(Long empleadoId, Long puntoVentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un empleadp  a un punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(  puntoVentaId);
        EmpleadoEntity empleadoEntity = empleadoPersistence.findEmpleado(empleadoId);
        empleadoEntity.setPuntoVenta(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de roceso de agregarle un empleado a un punto de vental con id = {0}", puntoVentaId);
        return empleadoEntity;
    }

    /**
     * Retorna todos los books asociados a una editorial
     *
     * @param editorialsId El ID de la editorial buscada
     * @return La lista de libros de la editorial
     */
    public List<EmpleadoEntity> getEmpleado(Long empleadoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los empleado aosicados con el punto de venta con id = {0}", empleadoId);
        return puntoVentaPersistence.find(empleadoId).getEmpleados();
    }

    /**
     * Retorna un book asociado a una editorial
     *
     * @param editorialsId El id de la editorial a buscar.
     * @param booksId El id del libro a buscar
     * @return El libro encontrado dentro de la editorial.
     * @throws BusinessLogicException Si el libro no se encuentra en la
     * editorial
     */
    public EmpleadoEntity getEmpleado(Long puntoVentaId, Long empleadoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el empleado con id = {0} del punto de venta  con id = " + puntoVentaId, empleadoId);
        List<EmpleadoEntity> empleados = puntoVentaPersistence.find(puntoVentaId).getEmpleados();
        EmpleadoEntity empleadoEntity = empleadoPersistence.findEmpleado(empleadoId);
        int index = empleados.indexOf(empleadoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de  consultar el empleado  con id = {0} del punto de venta  con id = " + puntoVentaId, empleadoId);
        if (index >= 0) {
            return empleados.get(index);
        }
        throw new BusinessLogicException("El empleado no esta asociado con el pto de venta");
    }

    /**
     * Remplazar books de una editorial
     *
     * @param books Lista de libros que serán los de la editorial.
     * @param editorialsId El id de la editorial que se quiere actualizar.
     * @return La lista de libros actualizada.
     */

    public List<EmpleadoEntity> replaceEmpleado(Long puntoVentaId, List<EmpleadoEntity> empleados) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(puntoVentaId);
        List<EmpleadoEntity> empleadosList = empleadoPersistence.findAllEmpleados();
        for (EmpleadoEntity empleado : empleadosList) {
            if (empleados.contains(empleado)) {
                //Falta mirar que no se agregue solamente
                //REVISAR
                empleado.setPuntoVenta(puntoVentaEntity);
            } else if (empleado.getPuntoVenta()!= null && empleado.getPuntoVenta().equals(puntoVentaEntity)) {
                empleado.setPuntoVenta(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la editorial con id = {0}", puntoVentaId);
        return empleados;
    }
    
}
