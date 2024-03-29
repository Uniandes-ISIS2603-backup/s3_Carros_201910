/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author estudiante
 */
@Stateless
public class AutomovilPersistence {
    
    
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public AutomovilEntity create(AutomovilEntity automovilEntity){
        em.persist(automovilEntity);
        return automovilEntity;
    }
    
    public AutomovilEntity findAutomovil(Long autoId){
        return em.find(AutomovilEntity.class, autoId);
    }
    
    public AutomovilEntity findByIdChasis(Integer idChasis){
        TypedQuery<AutomovilEntity> query = em.createQuery("Select e From AutomovilEntity e where e.idChasis = :idChasis", AutomovilEntity.class);
        query= query.setParameter("idChasis", idChasis);
        List<AutomovilEntity> mismoId = query.getResultList();
        
        AutomovilEntity result;
        if(mismoId == null){
            result = null;
        } else if (mismoId.isEmpty()) {
            result = null;
        }else {
            result = mismoId.get(0);
        }
        return result;
    }
    
    public List<AutomovilEntity> findAllAutomoviles(){
        TypedQuery<AutomovilEntity> query = em.createQuery("select u from AutomovilEntity u", AutomovilEntity.class);
        return query.getResultList();
    }
    
    public void deleteAutomovil(Long autoId){
        AutomovilEntity entity = em.find(AutomovilEntity.class, autoId);
        em.remove(entity);
    }
    
    public AutomovilEntity updateAutomovil(AutomovilEntity auto){
        return em.merge(auto);
    }
    
    
}
