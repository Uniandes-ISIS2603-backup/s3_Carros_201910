<<<<<<< HEAD:s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistance.java
<<<<<<< HEAD:s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistence.java
=======
>>>>>>> parent of 776afaa... Revert "Merge origin/master":s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistence.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel Lozano
 */
@Stateless
public class PuntoVentaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaPersistence.class.getName());
    @PersistenceContext(unitName = "carrosPU")
    
    protected EntityManager em;  
    
    public PuntoVentaEntity create(PuntoVentaEntity puntoVentaEntity)
    {
        LOGGER.log(Level.INFO, "Creando un nuevo punto de venta");
<<<<<<< HEAD:s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistance.java
        
        
=======
>>>>>>> parent of 776afaa... Revert "Merge origin/master":s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistence.java
        em.persist(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Saliendo de  crear un nuevo punto de venta");
        return puntoVentaEntity;
    }
    
<<<<<<< HEAD:s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistance.java
    public List<PuntoVentaEntity> findAll()
    {
        LOGGER.log(Level.INFO, "Consultando toos los puntos de venta");
        TypedQuery query = em.createQuery("select u from PuntoVentaEntity u", PuntoVentaEntity.class);
        return  query.getResultList();
    }
    
    public PuntoVentaEntity find(Long puntoVentaID)
    {
        LOGGER.log(Level.INFO, "Consultando punto de venta  con id={0}", puntoVentaID);
        return em.find(PuntoVentaEntity.class, puntoVentaID);
    }
    
    public PuntoVentaEntity update(PuntoVentaEntity puntoVentaEntity)
    {
         LOGGER.log(Level.INFO, "Actualizando punto de venta con id = {0}", puntoVentaEntity.getId());
         
         LOGGER.log(Level.INFO, "Saliendo de actualizar el punto de venta  con id = {0}", puntoVentaEntity.getId());
        return em.merge(puntoVentaEntity); 
    }
    
    public void delete(Long puntoVentaId)
    {
        LOGGER.log(Level.INFO, "Borrando de punto de venta con id = {0}", puntoVentaId);
        
        PuntoVentaEntity entity = em.find(PuntoVentaEntity.class, puntoVentaId);
        em.remove(entity);
        
        LOGGER.log(Level.INFO, "Saliendo de borrar el punto de venta con id = {0}", puntoVentaId);
    }
    
    public PuntoVentaEntity findByDireccion(String direccion)
    {
        LOGGER.log(Level.INFO, "Consultando punto de venta por direccion ", direccion);
        
        TypedQuery query = em.createQuery("Select e From PuntoVentaEntity e where e.direccion = :direccion", PuntoVentaEntity.class);
        
        query = query.setParameter("direccion", direccion);
        
        List<PuntoVentaEntity> sameDireccion = query.getResultList();
        PuntoVentaEntity result;
        
        if (sameDireccion == null) {
            result = null;
        } else if (sameDireccion.isEmpty()) {
            result = null;
        } else {
            result = sameDireccion.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar punto de venta por direccion ", direccion);
        return result;
=======
    public PuntoVentaEntity find(Long puntoVentaID)
    {
        return em.find(PuntoVentaEntity.class, puntoVentaID);
    }
    
    public List<PuntoVentaEntity> findAll()
    {
        TypedQuery query = em.createQuery("select u from PuntoVentaEntity u", PuntoVentaEntity.class);
        return  query.getResultList();
>>>>>>> parent of 776afaa... Revert "Merge origin/master":s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistence.java
    }
    
    
    
<<<<<<< HEAD:s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistance.java
    
    
    
}
=======
=======
}
>>>>>>> parent of 776afaa... Revert "Merge origin/master":s3_carros-back/src/main/java/co/edu/uniandes/csw/carros/persistence/PuntoVentaPersistence.java
