/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Daniel Lozano
 */
public class PuntoVentaDTO implements Serializable
{
 private String dirreccion; 
 
 private String telefono;
 
 private long id;

 
/**
 * 
 */
 public PuntoVentaDTO()
 {
     
 }
    /**
     * @return the dirreccion
     */
    public String getDirreccion() {
        return dirreccion;
    }

    /**
     * @param dirreccion the dirreccion to set
     */
    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    /**
     * @return the telefoo
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefoo the telefoo to set
     */
    public void setTelefono(String telefoo) {
        this.telefono = telefoo;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
 
    public PuntoVentaEntity toEntity()
    {
       PuntoVentaEntity entity = new PuntoVentaEntity();
       entity.setDireccion(this.dirreccion);
       entity.setTelefono(this.telefono);
       entity.setId(this.id);
       return entity;
    }
 public PuntoVentaDTO(PuntoVentaEntity entity)
 {
      this.dirreccion = entity.getDireccion();
      this.telefono = entity.getTelefono();
      this.id = entity.getId();
 }
}
