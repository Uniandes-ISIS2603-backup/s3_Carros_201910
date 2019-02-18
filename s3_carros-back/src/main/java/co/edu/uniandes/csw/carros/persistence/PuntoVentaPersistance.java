/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author estudiante
 */
public class PuntoVentaPersistance {
    
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaPersistance.class.getName());
    @PersistenceContext(unitName = "carrosPU")
 protected EntityManager em; 
    
    public PuntoVentaEntity create(PuntoVentaEntity puntoVentaEntity)
    {
        LOGGER.log(Level.INFO, "Creando un nuevo punto de venta");
        em.persist(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Saliendo de  crear un nuevo punto de venta");
        return puntoVentaEntity;
    }
    
    
}
