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
    
    /**
     * Constructor por defecto
     */
    public EmpleadoDTO(){
    }
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     */
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
    public Integer getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(Integer extension) {
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
    
    /**
     * @return the puntoVenta
     */
    public PuntoVentaDTO getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * @param puntoVenta the puntoVenta to set
     */
    public void setPuntoVenta(PuntoVentaDTO puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
    
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public EmpleadoEntity toEntity(){
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setNombre(this.nombre);
        entity.setCorreo(this.correo);
        entity.setExtension(this.extension);
        entity.setId(this.empleadoID);
        entity.setPuntoVenta(getPuntoVenta().toEntity());
        return entity;
    }   
}
