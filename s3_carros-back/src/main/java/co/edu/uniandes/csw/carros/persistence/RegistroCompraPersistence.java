/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Lozano
 */
@Stateless
public class RegistroCompraPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(RegistroCompraPersistence.class.getName());
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;

    /**
     * Método para persisitir el RegistroCompra en la base de datos.
     *
     * @param registroCompraEntity objeto RegistroCompra que se creará en la base de datos.
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public RegistroCompraEntity create(RegistroCompraEntity registroCompraEntity) 
    {
                LOGGER.log(Level.INFO, "Creando un nuevo punto de venta");
        em.persist(registroCompraEntity);
        LOGGER.log(Level.INFO, "Saliendo de  crear un nuevo punto de venta");
        return registroCompraEntity;
    }
    
    /**
     * Devuelve todos los RegistrosCompra de la base de datos.
     *
     * @return una lista con todas los RegistrosCompra que encuentre en la base de datos.
     */
    public List<RegistroCompraEntity> findAll()
    {
        LOGGER.log(Level.INFO, "Consultando todos los registros de compra");
        
        TypedQuery query = em.createQuery("select u from RegistroCompraEntity u", RegistroCompraEntity.class);
        return query.getResultList();
    }
    
    /**
     * Método que devuelve un registroCompra con base en su id
     * @param registroCompraId: id del registro
     * @return 
     */
    public RegistroCompraEntity find(Long registroCompraId)
    {
        LOGGER.log(Level.INFO, "Consultando registro compra con id={0}", registroCompraId);
        
        return em.find(RegistroCompraEntity.class, registroCompraId);
    }
    
    /**
     * Actualiza un RegistroCompra
     *
     * @param registroCompraEntity: la compra que viene con los nuevos cambios.
     * @return una compra con los cambios aplicados.
     */
    public RegistroCompraEntity update(RegistroCompraEntity registroCompraEntity)
    {
         LOGGER.log(Level.INFO, "Actualizando registro compra con id = {0}", registroCompraEntity.getId());
         
         LOGGER.log(Level.INFO, "Saliendo de actualizar el registro de compra  con id = {0}", registroCompraEntity.getId());
         return em.merge(registroCompraEntity);
         
    }
    
    /**
     * Elimina una compra
     * @param registroCompraId: id de la compra 
     */
    public void delete(Long registroCompraId)
    {
         LOGGER.log(Level.INFO, "Borrando registro compra con id = {0}", registroCompraId);
         
         RegistroCompraEntity  entity = em.find(RegistroCompraEntity.class, registroCompraId);
         
         em.remove(entity);
         LOGGER.log(Level.INFO, "Saliendo de borrar el registro compra con id = {0}", registroCompraId);
    }
    
    /**
     * Devuelve un registroCompra por el nombre de un vendedor
     * @param name : nombre del vendedor
     * @return 
     */
    public RegistroCompraEntity findByVendedorName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando registro de compra por nombre ", name);
        // Se crea un query para buscar editoriales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From RegistroCompraEntity e where e.nombreVendedor = :name", RegistroCompraEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<RegistroCompraEntity> sameName = query.getResultList();
        RegistroCompraEntity result;
        if (sameName == null) {
            result = null;
        } else if (sameName.isEmpty()) {
            result = null;
        } else {
            result = sameName.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar registro de compra por nombre ", name);
        return result;
    }
}
