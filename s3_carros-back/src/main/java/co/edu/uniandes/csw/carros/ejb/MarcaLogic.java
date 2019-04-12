/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.MarcaPersistence;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
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
public class MarcaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
    
    @Inject
    private PuntoVentaPersistence puntoVentapersistence;
    
    @Inject
    private MarcaPersistence marcaPersistence;
    
    
    public MarcaEntity createMarca(MarcaEntity marcaEntity) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la Marca");
        //TODO: Hacer una regla de negocio que pregunte que no hay una marca con el mismo nombre
        marcaPersistence.create(marcaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la Marca");
        return marcaEntity; 
    }
    
    
    public List<MarcaEntity> getMarcas(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las Marcas");
        List<MarcaEntity> lista = marcaPersistence.findAllMarcas();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos las Marcas");
        return lista;
    }
    
    
    public MarcaEntity getMarca(Long marcaId){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la Marca con id = {0}", marcaId);
        MarcaEntity marcaEntity =marcaPersistence.findMarca(marcaId);
        if (marcaEntity == null) {
            LOGGER.log(Level.SEVERE, "La Factura con el id = {0} no existe", marcaId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la Marca con id = {0}", marcaId);
        return marcaEntity;
    }
    
    
    public void deleteMarca(Long marcaId){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el automovil con id = {0}", marcaId);
        marcaPersistence.deleteMarca(marcaId);
        LOGGER.log(Level.INFO, "termina proceso de borrar el automovil con id = {0}", marcaId);
    }
    
    public MarcaEntity updateMarca(MarcaEntity marca) throws BusinessLogicException{
       LOGGER.log(Level.INFO, "Inicia proceso de actualizar la marca con id = {0}", marca.getId());
        MarcaEntity newEntity = marcaPersistence.updateMarca(marca);
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la marca con id = {0}", marca.getId());
        return newEntity; 
    }   
}
