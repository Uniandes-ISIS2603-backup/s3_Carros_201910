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
 *DTO del punto donde se venderan los autos
 * @author Daniel Lozano
 */
public class PuntoVentaDTO implements Serializable
{
/**
 * Direccion del punto de venta
 */
 private String direccion; 
 
 /**
  * Telefono del punto de venta
  */
 private String telefono;
 
 /**
  * id con el cual el programa identifica el punto de venta
  */
 private long id;

 
/**
 * Constructor vacio por convencion
 */
 public PuntoVentaDTO()
 {
     
 }
    /**Devuelve la direccion del punto de venta
     * @return the dirreccion del punto de venta
     */
    public String getDireccion() {
        return direccion;
    }

    /**Fija la direccion del punto de venta
     * @param direccion the direccion to set nueva direccion del punto de venta
     */
    public void setDireccion(String dirreccion) {
        this.direccion = dirreccion;
    }

    /**Retorna el telefono del punto de venta
     * @return the telefoo del punto de venta
     */
    public String getTelefono() {
        return telefono;
    }

    /**Fija un nuevo telefono para el punto de venta
     * @param telefoo the telefoo to set nuevo telefono del punto de venta
     */
    public void setTelefono(String telefoo) {
        this.telefono = telefoo;
    }

    /** Retona el id del punto de venta
     * @return the id con el que se reconoce al punto de venta en el programa
     */
    public long getId() {
        return id;
    }

    /** Fija el id del punto de venta con el cual se reconoce en el sistema
     * @param id the id to set el nuevo id del punto de venta
     */
    public void setId(long id) {
        this.id = id;
    }
 
    /**
     * Metodo que convierte el Punto de venta en su calidad de DTO en un PuntoVentaEntity
     * @return nuevo punto de venta entity.
     */
    public PuntoVentaEntity toEntity()
    {
       PuntoVentaEntity entity = new PuntoVentaEntity();
       entity.setDireccion(this.direccion);
       entity.setTelefono(this.telefono);
       entity.setId(this.id);
       return entity;
    }
    /**
     * Contructor del DTO que crea un nuevo punto de venta apartir de un entity
     * @param entity para crear un puntoVentaDTO a parir de este
     */
 public PuntoVentaDTO(PuntoVentaEntity entity)
 {
      this.direccion = entity.getDireccion();
      this.telefono = entity.getTelefono();
      this.id = entity.getId();
 }
}
