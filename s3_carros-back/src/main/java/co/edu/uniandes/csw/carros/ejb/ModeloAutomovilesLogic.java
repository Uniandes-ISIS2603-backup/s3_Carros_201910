/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.carros.persistence.ModeloPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class ModeloAutomovilesLogic {
    @Inject
    private ModeloPersistence modeloPersistence;

    @Inject
    private AutomovilPersistence automovilPersistence;
    
    public AutomovilEntity addAutomovil(Long modeloID, Long autoId) {
        ModeloEntity modeloEntity = modeloPersistence.findModelo(modeloID);
        AutomovilEntity automovilEntity = automovilPersistence.findAutomovil(autoId);
        automovilEntity.setModelo(modeloEntity);
        return automovilEntity;
    }
    
    public List<AutomovilEntity> getAutomoviles(Long modeloID) {
        return modeloPersistence.findModelo(modeloID).getAutomoviles();
    }
    
    public AutomovilEntity getAutomovil(Long modeloID, Long autoId) throws BusinessLogicException {
        List<AutomovilEntity> autos = modeloPersistence.findModelo(modeloID).getAutomoviles();
        AutomovilEntity automovilEntity = automovilPersistence.findAutomovil(autoId);
        int index = autos.indexOf(automovilEntity);
        if (index >= 0) {
            return autos.get(index);
        }
        throw new BusinessLogicException("El auto no esta asociado con el modelo");
    }
    
    public List<AutomovilEntity> replaceAutomovil(Long modeloID, List<AutomovilEntity> autos) {
        ModeloEntity modeloEntity = modeloPersistence.findModelo(modeloID);
        List<AutomovilEntity> autoList = automovilPersistence.findAllAutomoviles();
        for (AutomovilEntity auto : autoList) {
            if (autos.contains(auto)) {
                //Falta mirar que no se agregue solamente
                //REVISAR
                auto.setModelo(modeloEntity);
            } else if (auto.getModelo()!= null && auto.getModelo().equals(modeloEntity)) {
                auto.setModelo(null);
            }
        }
        return autos;
    }
}
