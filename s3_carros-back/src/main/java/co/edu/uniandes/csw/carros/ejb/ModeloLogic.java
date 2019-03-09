/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.MarcaPersistence;
import co.edu.uniandes.csw.carros.persistence.ModeloPersistence;
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
public class ModeloLogic {
    
    
    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
    
    
    @Inject
    private MarcaPersistence marcaPersistence;
    
    
    @Inject
    private ModeloPersistence modeloPeristence;
    
    public ModeloEntity createModelo(ModeloEntity modelo) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de creación del Modelo");
        if(modelo.getMarca() == null){
            throw new NullPointerException("La Marca es null");
        }
        if(marcaPersistence.findMarca(modelo.getMarca().getId()) == null){
            throw new BusinessLogicException("La marca no existe en la base de datos");
        }
        if(modeloPeristence.findModelo(modelo.getId()) != null){
            throw new BusinessLogicException("ya existe un modelo con el id: " + modelo.getId());
        }
        modeloPeristence.createModelo(modelo);
        LOGGER.log(Level.INFO, "Termina proceso de creación del Modelo");
        return modelo;
    }
    
    public List<ModeloEntity> getModelos(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los modelos de la compañia");
        List<ModeloEntity> modelos = modeloPeristence.findAllModelos();
        LOGGER.log(Level.INFO, "finlaiza proceso de consultar todos los modelos de la compañia");
        return modelos;
    }
    
    public ModeloEntity getModelo(Long modeloId){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el modelo  con el id }", modeloId);
        ModeloEntity entity = modeloPeristence.findModelo(modeloId);
        if(entity == null){
            LOGGER.log(Level.SEVERE, "El modelo con el id = {0} no existe", modeloId);
        }
         LOGGER.log(Level.INFO, "Termina proceso de consultar el modelo con  id }", modeloId);
        return entity;  
    }
    
    public void deleteModelo(Long modeloID){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el automovil con id ", modeloID);
        modeloPeristence.deleteModelo(modeloID);
        LOGGER.log(Level.INFO, "termina proceso de borrar el automovil con id ", modeloID);
    }
    
    public ModeloEntity updateModelo(ModeloEntity modelo) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el mdoelo con id ", modelo.getId());
        ModeloEntity newEntity = modeloPeristence.updateMarca(modelo);
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el modelo con id", modelo.getId());
        return newEntity;
    }
    
}
