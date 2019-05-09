/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.ModeloPersistence;
import co.edu.uniandes.csw.carros.persistence.MarcaPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class MarcaModelosLogic {
    @Inject
    private ModeloPersistence modeloPersistence;

    @Inject
    private MarcaPersistence marcaPersistence;
    
    public ModeloEntity addModelo(Long modeloID, Long marcaID) {
        MarcaEntity marcaEntity = marcaPersistence.findMarca(marcaID);
        ModeloEntity modeloEntity = modeloPersistence.findModelo(modeloID);
        modeloEntity.setMarca(marcaEntity);
        return modeloEntity;
    }
    
    public List<ModeloEntity> getModelos(Long marcaID) {
        return marcaPersistence.findMarca(marcaID).getModelos();
    }
    
    public ModeloEntity getModelo(Long marcaID, Long modeloID) throws BusinessLogicException {
        List<ModeloEntity> modelos = marcaPersistence.findMarca(marcaID).getModelos();
        ModeloEntity modeloEntity = modeloPersistence.findModelo(modeloID);
        int index = modelos.indexOf(modeloEntity);
        if (index >= 0) {
            return modelos.get(index);
        }
        throw new BusinessLogicException("El modelo no esta asociado con la marca");
    }
    
    public List<ModeloEntity> replaceModelo(Long marcaID, List<ModeloEntity> modelos) {
        MarcaEntity marcaEntity = marcaPersistence.findMarca(marcaID);
        List<ModeloEntity> modeloList = modeloPersistence.findAllModelos();
        for (ModeloEntity modelo : modeloList) {
            if (modelos.contains(modelo)) {
                //Falta mirar que no se agregue solamente
                //REVISAR
                modelo.setMarca(marcaEntity);
            } else if (modelo.getMarca()!= null && modelo.getMarca().equals(marcaEntity)) {
                modelo.setMarca(null);
            }
        }
        return modelos;
    }
}
