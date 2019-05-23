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
import java.util.ArrayList;
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
public class ClienteLogic {
    
    private static final Logger LOGGER = java.util.logging.Logger.getLogger(ClienteLogic.class.getName());
    
    @Inject
    private ClientePersistence persistence; //atributo para acceder a la persistencia de cliente
    
    @Inject
    private PuntoVentaPersistence persPuntoVenta; //atributo para acceder a la persistencia de punto venta
    
    /**
     * Crea un cliente en la persistencia.
     */
    public ClienteEntity createCliente(ClienteEntity nuevoCliente)throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de creación del cliente");
        ClienteEntity search = persistence.findClientePorCorreo(nuevoCliente.getCorreo());
        if(search == null){
            ClienteEntity cliente = persistence.create(nuevoCliente);
            LOGGER.log(Level.INFO, "Termina proceso de creación del cliente");
            return cliente;            
        }
        else{
            throw new BusinessLogicException("Ya hay un cliente con el mismo correo, por favor utilice otro");
        }
    }
    
    /**
     * Borrar un cliente
     */
    public void deleteCliente(Long clienteID){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el cliente con id = {0}", clienteID);
        persistence.deleteCliente(clienteID);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el empleado con id = {0}", clienteID);
    }
    
    /**
     *
     * Actualizar un cliente.
     */
    public ClienteEntity updateCliente(ClienteEntity cliente)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el cliente con id = {0}", cliente.getId());
        ClienteEntity search = persistence.findClientePorCorreo(cliente.getCorreo());
        if(search == null || search.getId() == cliente.getId()){
            List<PuntoVentaEntity> puntos = cliente.getPuntosVenta();
            if(puntos != null || !puntos.isEmpty()){
                for(int i=0; i<puntos.size(); i++){
                    PuntoVentaEntity pVenta = persPuntoVenta.find(puntos.get(i).getId());
                    if(pVenta == null){
                        throw new BusinessLogicException("El punto de venta con id " + puntos.get(i).getId() + " no existe.");
                    }
                }
            }
            persistence.updateCliente(cliente);
        }
        else{
           throw new BusinessLogicException("Ya hay un cliente con el mismo correo");
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el empleado con id = {0}", cliente.getId());
        return new ClienteEntity();
    }
    
    /**
     *
     * Obtener un cliente por medio de su id.
     */
    public ClienteEntity getCliente(Long clienteID){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el cliente con id = {0}", clienteID);
        ClienteEntity cliente = persistence.findCliente(clienteID);
        if(cliente == null){
            LOGGER.log(Level.SEVERE, "El cliente con el id = {0} no existe", clienteID);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el cliente con id = {0}", clienteID);
        return cliente;
    }
    
    /**
     * Obtener todos los clientes existentes en la base de datos.
     */
    public List<ClienteEntity> getAllCliente(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los clientes");
        List<ClienteEntity> lista = persistence.findAllClientes();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los clientes");
        return lista;     
    }
     
}
