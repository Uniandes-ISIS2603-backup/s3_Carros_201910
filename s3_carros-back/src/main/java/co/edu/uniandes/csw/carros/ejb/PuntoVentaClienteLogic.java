/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.ClientePersistence;
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
public class PuntoVentaClienteLogic 
{
    
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaEmpleadoLogic.class.getName());

    @Inject
    private ClientePersistence clientePersistence;

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
    public ClienteEntity addCliente(Long clienteId, Long puntoVentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un cliente  a un punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(  puntoVentaId);
        ClienteEntity clienteEntity = clientePersistence.findCliente(clienteId);
        clienteEntity.addPuntoVenta(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de roceso de agregarle un cliente a un punto de venta con id = {0}", puntoVentaId);
        return clienteEntity;
    }

    /**
     * Retorna todos los books asociados a una editorial
     *
     * @param editorialsId El ID de la editorial buscada
     * @return La lista de libros de la editorial
     */
    public List<ClienteEntity> getClientes(Long clienteId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los clientes aosicados con el punto de venta con id = {0}", clienteId);
        return puntoVentaPersistence.find(clienteId).getClientes();
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
    public ClienteEntity getCliente(Long puntoVentaId, Long clienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el cliente con id = {0} del punto de venta  con id = " + puntoVentaId, clienteId);
        List<ClienteEntity> clientes = puntoVentaPersistence.find(puntoVentaId).getClientes();
        ClienteEntity clienteEntity = clientePersistence.findCliente(clienteId);
        int index = clientes.indexOf(clienteEntity);
        LOGGER.log(Level.INFO, "Termina proceso de  consultar el cliente  con id = {0} del punto de venta  con id = " + puntoVentaId, clienteId);
        if (index >= 0) {
            return clientes.get(index);
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

    public List<ClienteEntity> replaceCliente(Long puntoVentaId, List<ClienteEntity> empleados) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar cliente del punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(puntoVentaId);
        List<ClienteEntity> clienteList = clientePersistence.findAllClientes();
        for (ClienteEntity cliente : clienteList) {
            if (empleados.contains(cliente)) {
                cliente.addPuntoVenta(puntoVentaEntity);
            } else if (cliente.getPuntosVenta()!= null && cliente.getPuntosVenta().equals(puntoVentaEntity)) {
                cliente.setPuntosVenta(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el cliente del punto de venta con id = {0}", puntoVentaId);
        return empleados;
    }
}
