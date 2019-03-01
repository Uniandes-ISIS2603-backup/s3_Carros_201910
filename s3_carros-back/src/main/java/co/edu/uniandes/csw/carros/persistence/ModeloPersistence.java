/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.ModeloEntity;
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
public class ModeloPersistence{
 
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public ModeloEntity createModelo(ModeloEntity modelo){
        em.persist(modelo);
        return modelo;
    }
    
    public ModeloEntity findModelo(Long modeloID){
        return em.find(ModeloEntity.class, modeloID);
    }
    
    public List<ModeloEntity> findAllModelos(){
        TypedQuery<ModeloEntity> query = em.createQuery("select u from ModeloEntity u", ModeloEntity.class);
        return query.getResultList();
    }
    
    public void deleteModelo(Long modeloID){
        ModeloEntity entity = em.find(ModeloEntity.class, modeloID);
        em.remove(entity);
    }
    
    public void updateMarca(ModeloEntity modelo){
        em.merge(modelo);
    }
    
}
