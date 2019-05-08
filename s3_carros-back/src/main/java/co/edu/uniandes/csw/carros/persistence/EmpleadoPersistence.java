/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

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
    
    /**
     * Método para persisitir la entidad en la base de datos.
     */
    public EmpleadoEntity create(EmpleadoEntity empleadoEntity){
        em.persist(empleadoEntity);
        return empleadoEntity;
    }
    
       /**
     * Busca si hay algun empleado con el id que se envía de argumento
     */
    public EmpleadoEntity findEmpleado(Long empleadoID){
        return em.find(EmpleadoEntity.class, empleadoID);
    }
    
    /**
     * Devuelve todas las editoriales de la base de datos.
     */
    public List<EmpleadoEntity> findAllEmpleados(){
        TypedQuery<EmpleadoEntity> query = em.createQuery("Select u from EmpleadoEntity u", EmpleadoEntity.class);
        return query.getResultList();
    }
    
    /**
     *
     * Borra un empleado de la base de datos recibiendo como argumento el id del empleado.
     */
    public void deleteEmpleado(Long empleadoID){
        EmpleadoEntity entity = em.find(EmpleadoEntity.class, empleadoID);
        em.remove(entity);
    }
    
    /**
     * Actualiza un empleado.
     */
    public void updateEmpleado(EmpleadoEntity empleado){
        em.merge(empleado);
    }
    
   
    /**
     * Busca si hay algun empleado con el correo que se envía de argumento
     */
    public EmpleadoEntity findEmpleadoPorCorreo(String correo){
        TypedQuery<EmpleadoEntity> query = em.createQuery("Select u From EmpleadoEntity u where u.correo = :correo", EmpleadoEntity.class);
        query = query.setParameter("correo", correo);
        List<EmpleadoEntity> lista = query.getResultList(); 
        EmpleadoEntity empleado;
        if(lista == null){
            empleado = null;
        }
        else if(lista.isEmpty()){
            empleado = null;
        }
        else{
            empleado = lista.get(0);
        }
        return empleado;
    }
}
