/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.AutomovilPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andres Forero
 */
@Stateless
public class AutomovilLogic {
    
    @Inject
    private AutomovilPersistence persistece;
    
    
    /*
    Regla de negocio: no puede haber dos automoviles con el mismo id en toda la base de datos
    */
    public AutomovilEntity createAutomovil(AutomovilEntity automovil) throws BusinessLogicException{
        
        if(persistece.findById(automovil.getId()) != null){
            throw new BusinessLogicException("Ya existe un automovil con el id: " + automovil.getIdChasis());
        }        
        persistece.create(automovil);
        return automovil;
    }
    
    public void deleteAutomovil(Long autoID){
        persistece.deleteAutomovil(autoID);
    }
    
    public AutomovilEntity updateAutomovil(AutomovilEntity auto)throws BusinessLogicException{
        return null;
    }
}
