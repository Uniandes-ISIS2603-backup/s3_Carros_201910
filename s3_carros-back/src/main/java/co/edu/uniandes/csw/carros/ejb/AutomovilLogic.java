/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.carros.persistence.ModeloPersistence;
import co.edu.uniandes.csw.carros.persistence.RegistroCompraPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andres Forero
 */
@Stateless
public class AutomovilLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaLogic.class.getName());
    
    @Inject
    private AutomovilPersistence autoPersistece;
    
    
    @Inject
    private RegistroCompraPersistence registroPesistence;
    
    
    @Inject
    private ModeloPersistence modeloPersistence;
    
    
    
    /*Crear un nuevo automovil
    Regla de negocio: no puede haber dos automoviles con el mismo id en toda la base de datos
    */
    public AutomovilEntity createAutomovil(AutomovilEntity automovil) throws BusinessLogicException{
        
        if(autoPersistece.findById(automovil.getId()) != null){
            throw new BusinessLogicException("Ya existe un automovil con el id: " + automovil.getIdChasis());
        }
        if(automovil.getModelo() == null){
            throw new BusinessLogicException("el modelo es null");
        }        
        if(modeloPersistence.findModelo(automovil.getModelo().getId())== null){
              throw new BusinessLogicException("El modelo no existe en la base de datos");           
        }
        if(automovil.getRegistroCompra() == null){
            throw new BusinessLogicException("el registro compra es null");
        }
        if(registroPesistence.find(automovil.getRegistroCompra().getId()) == null ){
            throw new BusinessLogicException("el registro no existe en la base de datos");
        }
        LOGGER.log(Level.INFO, "Termina proceso de creación del automovil");
        autoPersistece.create(automovil);
        return automovil;
    }
    
    /**
     * 
     * @return lista de todos los autos en la compañia
     */
    public List<AutomovilEntity> getAutomoviles(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los automoviles de la compañia");        
        List<AutomovilEntity> autos = autoPersistece.findAllAutomoviles();
        LOGGER.log(Level.INFO, "Finlaliza proceso de consultar todos los automoviles de la compañia");
        return autos;
    }
    
    public AutomovilEntity getAutomovil(Long autoID){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el  con el id = {0}", autoID);
        AutomovilEntity entity = autoPersistece.findAutomovil(autoID);
        if(entity == null){
            LOGGER.log(Level.SEVERE, "El automovil con el id = {0} no existe", autoID);
        }
         LOGGER.log(Level.INFO, "Termina proceso de consultar el modelo con  id = {0}", autoID);
        return entity;     
    }
    
    public void deleteAutomovil(Long autoID){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el automovil con id = {0}", autoID);
        autoPersistece.deleteAutomovil(autoID);
        LOGGER.log(Level.INFO, "termina proceso de borrar el automovil con id = {0}", autoID);
    }
    
    public AutomovilEntity updateAutomovil(AutomovilEntity auto)throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el auto con id = {0}", auto.getId());
        AutomovilEntity newEntity = autoPersistece.updateAutomovil(auto);
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el auto con id = {0}", auto.getId());
        return newEntity;
    }
}
