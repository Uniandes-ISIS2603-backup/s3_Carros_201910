/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.io.Serializable;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import java.io.Serializable;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
public class ClienteDTO implements Serializable{
    
    private Long clienteID;
    private String nombre;
    private String correo;
    private String telefono;
    
    /**
     * Constructor por defecto
     */
    public ClienteDTO(){
    }
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     */
    public ClienteDTO(ClienteEntity entity){
        if(entity != null){
            this.clienteID = entity.getId();
            this.nombre = entity.getNombre();
            this.correo = entity.getCorreo();
            this.telefono = entity.getTelefono();
        }
    }
    
     /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public ClienteEntity toEntity(){
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.clienteID);
        entity.setNombre(this.nombre);
        entity.setCorreo(this.correo);
        entity.setTelefono(this.telefono);
        
        return entity;
    }

    /**
     * @return the clienteID
     */
    public Long getClienteID() {
        return clienteID;
    }

    /**
     * @param clienteID the clienteID to set
     */
    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
