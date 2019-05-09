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
    
    /**
     * Método para persisitir la entidad en la base de datos.
     */
    public ClienteEntity create(ClienteEntity clienteEntity){
        em.persist(clienteEntity);
        return clienteEntity;
    }
    
    /**
     * Busca si hay algun cliente con el id que se envía de argumento
     */
    public ClienteEntity findCliente(Long clienteID){
        return em.find(ClienteEntity.class, clienteID);
    }
    
    /**
     * Devuelve todas las editoriales de la base de datos.
     */
    public List<ClienteEntity> findAllClientes(){
        TypedQuery<ClienteEntity> query = em.createQuery("Select u from ClienteEntity u", ClienteEntity.class);
        return query.getResultList();
    }
    
    	
    /**
     *
     * Borra un cliente de la base de datos recibiendo como argumento el id del cliente.
     */
    public void deleteCliente(Long clienteID){
        ClienteEntity entity = findCliente(clienteID);
        em.remove(entity);
    }
    
    /**
     * Actualiza un cliente.
     */
    public void updateCliente(ClienteEntity cliente){
        em.merge(cliente);
    }
    
    /**
     * Busca si hay algun cliente con el correo que se envía de argumento
     */
    public ClienteEntity findClientePorCorreo(String correo){
        TypedQuery<ClienteEntity> query = em.createQuery("Select u From ClienteEntity u where u.correo = :correo", ClienteEntity.class);
        query = query.setParameter("correo", correo);
        List<ClienteEntity> mismoCorreo = query.getResultList();
        ClienteEntity cliente;
        if(mismoCorreo == null){
            cliente = null;
        }
        else if(mismoCorreo.isEmpty()){
            cliente = null;
        }
        else{
            cliente = mismoCorreo.get(0);
        }
        return cliente;
    }
}
