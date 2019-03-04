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
import java.util.logging.Level;

/**
 *
 * @author Julio Ruiz
 */
@Stateless
public class QuejasReclamosLogic {
    
    @Inject
    private QuejasReclamosPersistence persistence;
    
    public QuejasReclamosEntity createQuejasReclamos(QuejasReclamosEntity queja) throws BusinessLogicException{
        
        //validar regla de negocio
        if (persistence.findByName(queja.getId()) != null){
            throw new BusinessLogicException("Ya existe una queja/reclamo con ese id");
        }
        if (queja.isSolucionado()){
            throw new BusinessLogicException("No se puede crear una queja con estado solucionado");
        }
        if (queja.getTipo() > 5 || queja.getTipo() < 0){
            throw new BusinessLogicException("El tipo de queja en invalido");
        }
        if (queja.getTipo() == 5 && queja.getComentarios().isEmpty()){
            throw new BusinessLogicException("Si la queja es de tipo OTRO el comentario no puede ser vacio");
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
