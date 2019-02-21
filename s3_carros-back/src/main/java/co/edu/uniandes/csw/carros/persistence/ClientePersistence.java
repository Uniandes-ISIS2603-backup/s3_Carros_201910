/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.persistence;

import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
@Stateless
public class ClientePersistence {
    
    @PersistenceContext(unitName = "carrosPU")
    protected EntityManager em;
    
    public ClienteEntity create(ClienteEntity clienteEntity){
        em.persist(clienteEntity);
        return clienteEntity;
    }
    
    public ClienteEntity findCliente(Long clienteID){
        return em.find(ClienteEntity.class, clienteID);
    }
            
    public List<ClienteEntity> findAllClientes(){
        TypedQuery<ClienteEntity> query = em.createQuery("Select u from ClienteEntity u", ClienteEntity.class);
        return query.getResultList();
    }
    
    public void deleteCliente(Long clienteID){
        ClienteEntity entity = findCliente(clienteID);
        em.remove(entity);
    }
}
