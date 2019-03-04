/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Julio Ruiz
 */
@Stateless
public class QuejasReclamosPersistence {

    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;

    public QuejasReclamosEntity create(QuejasReclamosEntity quejasReclamosEntity) {
        em.persist(quejasReclamosEntity);
        return quejasReclamosEntity;
    }

    public QuejasReclamosEntity find(Long casoId) {
        return em.find(QuejasReclamosEntity.class, casoId);
    }
    
    public QuejasReclamosEntity findByName(Long casoID){
        TypedQuery<QuejasReclamosEntity> query = em.createQuery("select e From QuejasReclamosEntity e where e.name = :name", QuejasReclamosEntity.class);
        query = query.setParameter("name", casoID);
        List<QuejasReclamosEntity> sameName = query.getResultList();
        QuejasReclamosEntity result;
        if(sameName == null){
            result = null;
        } else if (sameName.isEmpty()){
            result = null;
        } else {
            result = sameName.get(0);
        }
        return result;
    }
    
    public List<QuejasReclamosEntity> findAll(){
        TypedQuery<QuejasReclamosEntity> query = em.createQuery("select u from QuejasReclamosEntity u", QuejasReclamosEntity.class);
        return query.getResultList();
    }
    
    public QuejasReclamosEntity update(QuejasReclamosEntity auto){
        return em.merge(auto);
    }
    
    public void delete(Long casoId){
        QuejasReclamosEntity entity = em.find(QuejasReclamosEntity.class, casoId);
        em.remove(entity);
    }
}
