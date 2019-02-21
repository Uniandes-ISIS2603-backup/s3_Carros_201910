/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
@Stateless
public class EmpleadoPersistence {
    
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public EmpleadoEntity create(EmpleadoEntity empleadoEntity){
        em.persist(empleadoEntity);
        return empleadoEntity;
    }
    
    public EmpleadoEntity findEmpleado(Long empleadoID){
        return em.find(EmpleadoEntity.class, empleadoID);
    }
    
    public List<EmpleadoEntity> findAllEmpleados(){
        TypedQuery<EmpleadoEntity> query = em.createQuery("Select u from EmpleadoEntity u", EmpleadoEntity.class);
        return query.getResultList();
    }
    
    public void deleteEmpleado(Long empleadoID){
        EmpleadoEntity entity = em.find(EmpleadoEntity.class, empleadoID);
        em.remove(entity);
    }
    
}
