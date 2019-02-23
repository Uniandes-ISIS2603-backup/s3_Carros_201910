/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author estudiante
 */
public class AutomovilPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(MarcaPersistence.class.getName());
    
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public AutomovilEntity create(AutomovilEntity automovilEntity){
        em.persist(automovilEntity);
        return automovilEntity;
    }
    
    
}
