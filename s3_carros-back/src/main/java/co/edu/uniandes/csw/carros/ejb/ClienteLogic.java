/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.ClientePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Juan Pablo Patarroyo Duque 
 */
public class ClienteLogic {
    
    private static final Logger LOGGER = java.util.logging.Logger.getLogger(ClienteLogic.class.getName());
    
    @Inject
    private ClientePersistence persistence;
    
    public ClienteEntity createCliente(ClienteEntity nuevoCliente)throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de creación del cliente");
        ClienteEntity search = persistence.findClientePorCorreo(nuevoCliente.getCorreo());
        if(search == null){
            persistence.create(nuevoCliente);
            LOGGER.log(Level.INFO, "Termina proceso de creación del cliente");
            return nuevoCliente;
        }
        else{
            throw new BusinessLogicException("Ya hay un cliente con el mismo correo, por favor utilice otro");
        }
    }
    
    public void deleteCliente(Long clienteID){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el cliente con id = {0}", clienteID);
        persistence.deleteCliente(clienteID);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el empleado con id = {0}", clienteID);
    }
    
    public ClienteEntity updateCliente(ClienteEntity cliente)throws BusinessLogicException{
         LOGGER.log(Level.INFO, "Inicia proceso de actualizar el cliente con id = {0}", cliente.getId());
        String correo = cliente.getCorreo();
        ClienteEntity ee = persistence.findCliente(cliente.getId());
        if(ee.getCorreo().equals(correo)){
            persistence.updateCliente(cliente);
        }
        else{
            ClienteEntity search = persistence.findClientePorCorreo(correo);
            if(search == null){
                persistence.updateCliente(cliente);
            }
            else{
                throw new BusinessLogicException("Ya existe un empleado con el correo ingresado");
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el empleado con id = {0}", cliente.getId());
        return cliente;
    }
     
    public ClienteEntity getCliente(Long clienteID){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el empleado con id = {0}", clienteID);
        ClienteEntity cliente = persistence.findCliente(clienteID);
        if(cliente == null){
            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", clienteID);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el empleado con id = {0}", clienteID);
        return cliente;
    }
    
      
    public List<ClienteEntity> getAllCliente(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los clientes");
        List<ClienteEntity> lista = persistence.findAllClientes();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los clientes");
        return lista;     
    }
     
}
