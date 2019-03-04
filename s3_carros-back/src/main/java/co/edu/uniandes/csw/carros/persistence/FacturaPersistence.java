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
 * Clase que maneja la persistencia para Factura. 
 * Se conecta a través Entity Manager de javax.persistance con la base de datos SQL.
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
        FacturaEntity result = em.find(FacturaEntity.class, id);        
        LOGGER.log(Level.INFO, "Saliendo de consultar Factura por id", id);
        return result;
    }
    
    /**
     * Busca si hay Facturas con los ids que se envían de argumento
     *
     * @param ids: Lista de ids de factura que se están buscando.
     * @return Lista de Facturas, lista vacía si no existe ninguna.
     */
    public List<FacturaEntity> findListByIDs(List<Long> ids) {
        LOGGER.log(Level.INFO, "Consultando lista Factura por ids", ids);
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
        return result;
    }
    
    /**
     * Devuelve todas las facturas de la base de datos.
     *
     * @return una lista con todas las facturas que encuentre en la base de datos.
     */
    public List<FacturaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las compraVentas");       
        TypedQuery query = em.createQuery("select u from FacturaEntity u", FacturaEntity.class);
        return query.getResultList();
    }
}
