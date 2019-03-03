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
     * Busca si hay CompraVentas con los ids que se envían de argumento
     *
     * @param ids: Lista de ids de compraVentas que se están buscando.
     * @return Lista de CompraVentas, null si no existe ninguna.
     */
    public List<CompraVentaEntity> findListByIDs(List<Long> ids) {
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
    
    /**
     * Devuelve todas las compraVentas de la base de datos.
     *
     * @return una lista con todas las compraVentas que encuentre en la base de datos.
     */
    public List<CompraVentaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las compraVentas");
        // Se crea un query para buscar todas las compraVentas en la base de datos.
        //"select u from CompraVentaEntity u" es como un "select * from CompraVentaEntity;" - "SELECT * FROM table_name" en SQL        
        TypedQuery query = em.createQuery("select u from CompraVentaEntity u", CompraVentaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de compraVentas.
        return query.getResultList();
    }
    
     /**
     * Actualiza una compraVenta.
     *
     * @param compraVentaEntity: la editorial que viene con los nuevos cambios.
     * Por ejemplo el nombre pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return una editorial con los cambios aplicados.
     */
    public CompraVentaEntity update(CompraVentaEntity compraVentaEntity) {
        LOGGER.log(Level.INFO, "Actualizando compraVenta con id = {0}", compraVentaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la editorial con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar la compraVenta con id = {0}", compraVentaEntity.getId());
        return em.merge(compraVentaEntity);
    }
}
