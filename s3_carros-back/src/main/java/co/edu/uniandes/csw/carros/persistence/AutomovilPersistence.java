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
    
    public List<AutomovilEntity> finfAllAutomoviles(){
        TypedQuery<AutomovilEntity> query = em.createQuery("select u from AutomovilEntity u", AutomovilEntity.class);
        return query.getResultList();
    }
    
    public void deleteAutomovil(Long autoId){
        AutomovilEntity entity = em.find(AutomovilEntity.class, autoId);
        em.remove(entity);
    }
    
    public void updateMarca(AutomovilEntity auto){
        em.merge(auto);
    }
    
    
}