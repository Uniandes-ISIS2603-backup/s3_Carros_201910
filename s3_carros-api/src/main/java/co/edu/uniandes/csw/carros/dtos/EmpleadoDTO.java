/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import java.io.Serializable;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
public class EmpleadoDTO implements Serializable{
    private Long empleadoID;
    private String nombre;
    private Integer extension;
    private String correo;
    private PuntoVentaDTO puntoVenta;
    
    public EmpleadoDTO(){
    }
    
    public EmpleadoDTO(EmpleadoEntity entity){
        if(entity != null){
            this.empleadoID = entity.getId();
            this.nombre = entity.getNombre();
            this.extension = entity.getExtension();
            this.correo = entity.getCorreo();
            this.puntoVenta = new PuntoVentaDTO(entity.getPuntoVenta());
        }
    }
    
    
    /**
     * @return the empleadoID
     */
    public Long getEmpleadoID() {
        return empleadoID;
    }

    /**
     * @param empleadoID the empleadoID to set
     */
    public void setEmpleadoID(Long empleadoID) {
        this.empleadoID = empleadoID;
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
     * @return the extension
     */
    public int getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(int extension) {
        this.extension = extension;
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
    
    public EmpleadoEntity toEntity(){
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setNombre(this.nombre);
        entity.setCorreo(this.correo);
        entity.setExtension(this.extension);
        entity.setId(this.empleadoID);
        entity.setPuntoVenta(puntoVenta.toEntity());
        return entity;
    }
    
    
    
    
}
