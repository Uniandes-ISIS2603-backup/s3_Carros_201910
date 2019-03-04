/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.RegistroCompraPersistence;
import java.util.Date;
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
public class RegistroCompraLogic
{
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaLogic.class.getName());
    
    @Inject
    private RegistroCompraPersistence persistence; 
    
    
    public RegistroCompraEntity createRegistroCompra(RegistroCompraEntity compra)  throws BusinessLogicException 
    {
        Date fecha = new Date();
        
        if(compra.getFechaCompra().after(fecha))
        {
            throw new BusinessLogicException("La fecha de registrar la compra esta despues de la fecha actual");
         }
        compra = persistence.create(compra);
        return compra;
    }
    
    public List<RegistroCompraEntity> getRegistrosCompra()
    {
       LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las compras realizadas por la compañia");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<RegistroCompraEntity> compras = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todas las compras realizadas por la compañia");
        return compras;
    }
    
    public RegistroCompraEntity getRegistroCompra(Long registroCompraId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultarla compra con el id = {0}", registroCompraId);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        RegistroCompraEntity entity = persistence.find(registroCompraId);
        if (registroCompraId == null) {
            LOGGER.log(Level.SEVERE, "La compra con el id = {0} no existe", registroCompraId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la compra con  id = {0}", registroCompraId);
        return entity;
    }
    
     public RegistroCompraEntity updateRegistroCompra(Long registroCompraId, RegistroCompraEntity registroCompraEntity)    
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la compra con id = {0}", registroCompraId);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        RegistroCompraEntity newEntity = persistence.update(registroCompraEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la compra con id = {0}", registroCompraEntity.getId());
        return newEntity;
    }
     
    public void deleteRegistroCompra(Long registroCompraId) 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la compra con id = {0}", registroCompraId);
         
        persistence.delete(registroCompraId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la compra con id = {0}", registroCompraId);
    }
}
