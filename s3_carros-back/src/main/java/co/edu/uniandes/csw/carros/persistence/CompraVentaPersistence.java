/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
    /**
     * Método para persisitir la CompraVenta en la base de datos.
     *
     * @param compraVentaEntity objeto CompraVenta que se creará en la base de datos.
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CompraVentaEntity create(CompraVentaEntity compraVentaEntity)
    {
        LOGGER.log(Level.INFO, "Creando una Compra-Venta nueva");
        em.persist(compraVentaEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear una Compra-Venta nueva");
        return compraVentaEntity;
    }
    
    /**
     * Busca si hay alguna CompraVenta con el id que se envía de argumento
     *
     * @param id: id de la CompraVenta que se está buscando.
     * @return CompraVenta con el id del argumento, null si no existe ninguna.
     */
    public CompraVentaEntity findByID(Long id) {
        LOGGER.log(Level.INFO, "Consultando CompraVenta por id", id);
        // Se crea un query para buscar una CompraVenta con el id que recibe el método como argumento. ":id" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From CompraVentaEntity e where e.id = :id", CompraVentaEntity.class);
        // Se remplaza el placeholder ":id" con el valor del argumento 
        query = query.setParameter("id", id);
        // Se invoca el query se obtiene el resultado
        CompraVentaEntity result = (CompraVentaEntity) query.getSingleResult();
        
        LOGGER.log(Level.INFO, "Saliendo de consultar CompraVenta por id", id);
        return result;
    }
    
    /**
     * Busca si hay alguna CompraVenta con el id que se envía de argumento
     *
     * @param ids: Lista de ids de la CompraVenta que se está buscando.
     * @return Lista de CompraVentas, null si no existe ninguna.
     */
    public List<CompraVentaEntity> findListByID(List<Long> ids) {
        LOGGER.log(Level.INFO, "Consultando lista CompraVenta por ids", ids);
        // Se crea un query para buscar una CompraVenta con el id que recibe el método como argumento. ":id" es un placeholder que debe ser remplazado
        List<CompraVentaEntity> result = new ArrayList<>();        
        Iterator iterador = ids.iterator();
        while(iterador.hasNext())
        {
            CompraVentaEntity busqueda = findByID((Long) iterador.next());
            if(busqueda != null)
            {
                result.add(busqueda);
            }
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar lista CompraVenta por id", ids);
        if(result.isEmpty())
        {
            return null;
        }
        return result;
    }
}
