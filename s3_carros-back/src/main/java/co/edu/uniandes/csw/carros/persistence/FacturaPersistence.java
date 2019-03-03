/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.FacturaEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Kevin Hernán Castrillón Castañeda
 */
public class FacturaPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(FacturaPersistence.class.getName());

    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    /**
     * Método para persisitir la Factura en la base de datos.
     *
     * @param facturaEntity objeto Factura que se creará en la base de datos.
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public FacturaEntity create(FacturaEntity facturaEntity)
    {
        LOGGER.log(Level.INFO, "Creando una Factura nueva");
        em.persist(facturaEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear una Factura nueva");
        return facturaEntity;
    }
    
    /**
     * Busca si hay alguna factura con el id que se envía de argumento
     *
     * @param id: id de la Factura que se está buscando.
     * @return Factura con el id del argumento, null si no existe ninguna.
     */
    public FacturaEntity findByID(Long id) {
        LOGGER.log(Level.INFO, "Consultando Factura por id", id);
        // Se crea un query para buscar una Factura con el id que recibe el método como argumento. ":id" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From FacturaEntity e where e.id = :id", FacturaEntity.class);
        // Se remplaza el placeholder ":id" con el valor del argumento 
        query = query.setParameter("id", id);
        // Se invoca el query se obtiene el resultado
        FacturaEntity result = (FacturaEntity) query.getSingleResult();
        
        LOGGER.log(Level.INFO, "Saliendo de consultar Factura por id", id);
        return result;
    }
    
    /**
     * Busca si hay Facturas con los ids que se envían de argumento
     *
     * @param ids: Lista de ids de factura que se están buscando.
     * @return Lista de Facturas, null si no existe ninguna.
     */
    public List<FacturaEntity> findListByIDs(List<Long> ids) {
        LOGGER.log(Level.INFO, "Consultando lista Factura por ids", ids);
        // Se crea un query para buscar una Factura con el id que recibe el método como argumento. ":id" es un placeholder que debe ser remplazado
        List<FacturaEntity> result = new ArrayList<>();        
        Iterator iterador = ids.iterator();
        while(iterador.hasNext())
        {
            FacturaEntity busqueda = findByID((Long) iterador.next());
            if(busqueda != null)
            {
                result.add(busqueda);
            }
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar lista Factura por id", ids);
        if(result.isEmpty())
        {
            return null;
        }
        return result;
    }
    
    /**
     * Devuelve todas las facturas de la base de datos.
     *
     * @return una lista con todas las facturas que encuentre en la base de datos.
     */
    public List<FacturaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las compraVentas");
        // Se crea un query para buscar todas las facturas en la base de datos.
        //"select u from FacturaEntity u" es como un "select * from CompraVentaEntity;" - "SELECT * FROM table_name" en SQL        
        TypedQuery query = em.createQuery("select u from FacturaEntity u", FacturaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de compraVentas.
        return query.getResultList();
    }
}
