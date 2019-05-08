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
    
    public ModeloEntity updateMarca(ModeloEntity modelo){
        return em.merge(modelo);
    }
    
    public ModeloEntity findByNombre(String nombre)
    {
        TypedQuery query = em.createQuery("Select e From ModeloEntity e where e.nombre = :nombre", ModeloEntity.class);
        
        query = query.setParameter("nombre", nombre);
        
        List<ModeloEntity> sameNombre = query.getResultList();
        ModeloEntity result;
        
        if (sameNombre == null) {
            result = null;
        } else if (sameNombre.isEmpty()) {
            result = null;
        } else {
            result = sameNombre.get(0);
        }
        return result;
    }
    
}
