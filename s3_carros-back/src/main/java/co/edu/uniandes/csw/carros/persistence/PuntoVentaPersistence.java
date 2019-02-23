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
        em.persist(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Saliendo de  crear un nuevo punto de venta");
        return puntoVentaEntity;
    }
    
    public PuntoVentaEntity find(Long puntoVentaID)
    {
        return em.find(PuntoVentaEntity.class, puntoVentaID);
    }
    
    public List<PuntoVentaEntity> findAll()
    {
        TypedQuery query = em.createQuery("select u from PuntoVentaEntity u", PuntoVentaEntity.class);
        return  query.getResultList();
    }
    
    
    
}
