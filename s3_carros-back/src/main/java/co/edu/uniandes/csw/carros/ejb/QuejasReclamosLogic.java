/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.QuejasReclamosPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Julio Ruiz
 */
@Stateless
public class QuejasReclamosLogic {
    
    @Inject
    private QuejasReclamosPersistence persistence;
    
    private static final Logger LOGGER = Logger.getLogger(QuejasReclamosLogic.class.getName());
    
    public QuejasReclamosEntity createQuejasReclamos(QuejasReclamosEntity queja) throws BusinessLogicException{
        
        if(persistence.findByName(queja.getCarroId())!= null)
        {
            throw new BusinessLogicException("Ya existe una queja con el id:  "+ queja.getCarroId());
        }
        queja = persistence.create(queja);
        return queja; 
        
    }
    
    public List<QuejasReclamosEntity> getQuejasReclamos()
    {
        List<QuejasReclamosEntity> quejas = persistence.findAll();
        return quejas;
    }
    
    public QuejasReclamosEntity getQueja(Long casoId) throws BusinessLogicException
    {
        QuejasReclamosEntity entity = persistence.find(casoId);
        if (casoId == null) {
            throw new BusinessLogicException("No se encuentra queja con el Id");
        }
        return entity;
    }
    
    
    public QuejasReclamosEntity updateQuejasReclamos(Long casoId, QuejasReclamosEntity entity)    
    {
        QuejasReclamosEntity newEntity = persistence.update(entity);
        return newEntity;
    }
    
    public void deleteQuejasReclamos (Long casoId) throws BusinessLogicException 
        {
        persistence.delete(casoId);
    }
}
