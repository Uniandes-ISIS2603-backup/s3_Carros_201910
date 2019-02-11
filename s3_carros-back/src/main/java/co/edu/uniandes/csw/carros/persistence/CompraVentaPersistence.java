/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kevin Hernan Castrillon Castañeda
 */

@Stateless
public class CompraVentaPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(CompraVentaPersistence.class.getName());

    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public CompraVentaEntity create(CompraVentaEntity compraVentaEntity)
    {
        em.persist(compraVentaEntity);
        return compraVentaEntity;
    }
}
