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
    
    
    
    
    
    
    /*Crear un nuevo automovil
    Regla de negocio: no puede haber dos automoviles con el mismo id en toda la base de datos
    */
    public AutomovilEntity createAutomovil(AutomovilEntity automovil) throws BusinessLogicException{
        
        if(autoPersistece.findByIdChasis(automovil.getIdChasis()) != null){
            throw new BusinessLogicException("Ya existe un automovil con el id: " + automovil.getIdChasis());
        }
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
    
    public AutomovilEntity updateAutomovil(AutomovilEntity auto){
        AutomovilEntity newEntity = autoPersistece.updateAutomovil(auto);
        return newEntity;
    }
    
    
}
