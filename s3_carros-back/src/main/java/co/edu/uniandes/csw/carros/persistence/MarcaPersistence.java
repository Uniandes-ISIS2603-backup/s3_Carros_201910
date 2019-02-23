/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private static final Logger LOGGER = Logger.getLogger(MarcaPersistence.class.getName());
    
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public MarcaEntity create(MarcaEntity marcaEntity){
        LOGGER.log(Level.INFO, "creando una marca nueva");
        em.persist(marcaEntity);        
        LOGGER.log(Level.INFO, "Saliendo de crear una marca nueva ");
        return marcaEntity;
    }
    
    public MarcaEntity find(Long marcaId){
        return em.find(MarcaEntity.class, marcaId);
    }
    
    public List<MarcaEntity> findAll(){
        TypedQuery<MarcaEntity> query = em.createQuery("select u from MarcaEntity u", MarcaEntity.class);
        return query.getResultList();
    }
    
}
