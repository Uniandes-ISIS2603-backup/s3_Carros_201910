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
 *Persistencia de un recurso punto de venta
 * @author Daniel Lozano
 */
@Stateless
public class PuntoVentaPersistence {
    
    /**
     * 
     */
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaPersistence.class.getName());
    
    /**
     * Entity manager
     */
    @PersistenceContext(unitName = "carrosPU")     
    protected EntityManager em;  
    
    /**
     * Crea un nuevo punto de venta a persistir en la base de datos
     * @param puntoVentaEntity el punto de venta a crear
     * @return  el nuevo punto de c¿venta creado en la BD
     */
    public PuntoVentaEntity create(PuntoVentaEntity puntoVentaEntity)
    {
        LOGGER.log(Level.INFO, "Creando un nuevo punto de venta ");
        em.persist(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Saliendo de  crear un nuevo punto de venta");
        return puntoVentaEntity;
    }
    
    /**
     * Retorna una lista con todos los puntos de venta de la base de datos
     * @return 
     */
    public List<PuntoVentaEntity> findAll()
    {
        LOGGER.log(Level.INFO, "Consultando todos los puntos de venta persistencia");
        TypedQuery<PuntoVentaEntity> query = em.createQuery("select u from PuntoVentaEntity u", PuntoVentaEntity.class);
        return  query.getResultList();
    }
    
    
    /**
     * Retorna un punto de venta en la vase de datos con un id que entra por parametros
     * @param puntoVentaID del punto de venta a buscar
     * @return el punto de venta requerido
     */
    public PuntoVentaEntity find(Long puntoVentaID)
    {
        LOGGER.log(Level.INFO, "Consultando punto de venta  con id={0}", puntoVentaID);
        return em.find(PuntoVentaEntity.class, puntoVentaID);
    }
    
    /**
     * Actualiza el punto de venta que entra por parametro 
     * @param puntoVentaEntity a actializar
     * @return el punto de venta actualizado
     */
    public PuntoVentaEntity update(PuntoVentaEntity puntoVentaEntity)
    {
         LOGGER.log(Level.INFO, "Actualizando punto de venta con id = {0}", puntoVentaEntity.getId());
         
         LOGGER.log(Level.INFO, "Saliendo de actualizar el punto de venta  con id = {0}", puntoVentaEntity.getId());
        return em.merge(puntoVentaEntity); 
    }
    
    /**
     * Elimina un punto de venta de la BD
     * @param puntoVentaId del punto de venta a eliminar
     */
    public void delete(Long puntoVentaId)
    {
        LOGGER.log(Level.INFO, "Borrando de punto de venta con id = {0}", puntoVentaId);
        
        PuntoVentaEntity entity = em.find(PuntoVentaEntity.class, puntoVentaId);
        em.remove(entity);
        
        LOGGER.log(Level.INFO, "Saliendo de borrar el punto de venta con id = {0}", puntoVentaId);
    }
    
    /**
     * Busca un punto de venta por medio de la direccion
     * @param direccion del punto de venta abuscar 
     * @return el punto de venta encontrado
     */
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
    }
    
    
    
    
    
    
}
