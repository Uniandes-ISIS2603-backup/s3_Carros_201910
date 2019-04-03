/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andres Forero
 */

@Stateless
public class MarcaPersistence {
    
    
    
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public MarcaEntity create(MarcaEntity marcaEntity){        
        em.persist(marcaEntity);       
        return marcaEntity;
    }
    
    public MarcaEntity findMarca(Long marcaId){
        return em.find(MarcaEntity.class, marcaId);
    }
    
    public List<MarcaEntity> findAllMarcas(){
        TypedQuery<MarcaEntity> query = em.createQuery("select u from MarcaEntity u", MarcaEntity.class);
        return query.getResultList();
    }
    
    public MarcaEntity findByName(String nombreMarca){
        TypedQuery<MarcaEntity> query = em.createQuery("select u from MarcaEntity u where u.nombreMarca = :nombre", MarcaEntity.class);
        query.setParameter("nombre", nombreMarca );
        return query.getSingleResult();
    }
    
    public void deleteMarca(Long marcaID){
        MarcaEntity entity = em.find(MarcaEntity.class, marcaID);
        em.remove(entity);
    }
    
    public MarcaEntity updateMarca(MarcaEntity marca){
        return em.merge(marca);
    }
    
}
