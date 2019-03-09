/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Julio Ruiz
 */
@Stateless
public class QuejasReclamosPersistence {

    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;

    /**
     * Método para persisitir la queja en la base de datos.
     *
     * @param quejasReclamosEntity objeto queja que se creará en la base de datos.
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public QuejasReclamosEntity create(QuejasReclamosEntity quejasReclamosEntity) {
        em.persist(quejasReclamosEntity);
        return quejasReclamosEntity;
    }

    public QuejasReclamosEntity find(Long casoId) {
        return em.find(QuejasReclamosEntity.class, casoId);
    }
    
    /**
     * Busca si hay alguna queja con el id que se envía de argumento
     *
     * @param id: casoId de la queja que se está buscando.
     * @return queja con el id del argumento, null si no existe ninguna.
     */
    public QuejasReclamosEntity findByName(Long casoId){
        TypedQuery<QuejasReclamosEntity> query = em.createQuery("select e From QuejasReclamosEntity e where e.casoId = :casoId", QuejasReclamosEntity.class);
        query = query.setParameter("casoId", casoId);
        List<QuejasReclamosEntity> sameName = query.getResultList();
        QuejasReclamosEntity result;
        if(sameName == null){
            result = null;
        } else if (sameName.isEmpty()){
            result = null;
        } else {
            result = sameName.get(0);
        }
        return result;
    }
    
    /**
     * Devuelve todas las quejas de la base de datos.
     *
     * @return una lista con todas las quejas que encuentre en la base de datos.
     */
    public List<QuejasReclamosEntity> findAll(){
        TypedQuery<QuejasReclamosEntity> query = em.createQuery("select u from QuejasReclamosEntity u", QuejasReclamosEntity.class);
        return query.getResultList();
    }
    
    /**
     * Actualiza una queja.
     *
     * @param auto: la queja que viene con los nuevos cambios.
     * @return una queja con los cambios aplicados.
     */
    public QuejasReclamosEntity update(QuejasReclamosEntity auto){
        return em.merge(auto);
    }
    
    /**
     * Elimina una queja
     * @param casoId: el id de la queja a eliminar
     */
    public void delete(Long casoId){
        QuejasReclamosEntity entity = em.find(QuejasReclamosEntity.class, casoId);
        em.remove(entity);
    }
}
