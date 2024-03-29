/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *DTO del punto donde se venderan los autos
 * @author Daniel Lozano
 */
public class PuntoVentaDTO implements Serializable
{
 private static final Logger LOGGER = Logger.getLogger(PuntoVentaDTO.class.getName());
 /**
  * id con el cual el programa identifica el punto de venta
  */
 private Long id;
 
 /**
 * Direccion del punto de venta
 */
 private String direccion; 
 
 /**
  * Telefono del punto de venta
  */
 private String telefono;
 
 private String nombre; 
 
 private Double latitud; 
 
 private Double longitud;
 
 private String rutaFotos;
 
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
    public Long getId() {
        return id;
    }

    /** Fija el id del punto de venta con el cual se reconoce en el sistema
     * @param id the id to set el nuevo id del punto de venta
     */
    public void setId(Long id) {
        this.id = id;
    }
 
    /**
     * Metodo que convierte el Punto de venta en su calidad de DTO en un PuntoVentaEntity
     * @return nuevo punto de venta entity.
     */
    public PuntoVentaEntity toEntity()
    {
       LOGGER.log(Level.INFO, "To entity PuntoVenta");
       PuntoVentaEntity entity = new PuntoVentaEntity();
       LOGGER.log(Level.INFO, "To entity PuntoVenta 1");
       entity.setDireccion(this.direccion);
       LOGGER.log(Level.INFO, "To entity PuntoVenta 2");
       entity.setTelefono(this.telefono);
       LOGGER.log(Level.INFO, "To entity PuntoVenta 3");
       entity.setId(this.getId());
       LOGGER.log(Level.INFO, "To entity PuntoVenta 4");
       entity.setNombre(this.nombre);
       LOGGER.log(Level.INFO, "To entity PuntoVenta 5");
       entity.setLatitud(this.latitud);
       LOGGER.log(Level.INFO, "To entity PuntoVenta 6");
       entity.setLongitud(this.longitud);
       LOGGER.log(Level.INFO, "To entity PuntoVenta 7");
       entity.setRutaFotos(this.rutaFotos);
       LOGGER.log(Level.INFO, "To entity PuntoVenta sale");
       return entity;
    }
    
    /**
     * Contructor del DTO que crea un nuevo punto de venta apartir de un entity
     * @param entity para crear un puntoVentaDTO a parir de este
     */
 public PuntoVentaDTO(PuntoVentaEntity entity)
 {
     if(entity != null)
     {
        this.direccion = entity.getDireccion();
        this.telefono = entity.getTelefono();
        this.id = entity.getId();
        this.nombre = entity.getNombre();
        this.latitud = entity.getLatitud();
        this.longitud = entity.getLongitud();
        this.rutaFotos = entity.getRutaFotos();
     }
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
     * @return the latitud
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the rutaFotos
     */
    public String getRutaFotos() {
        return rutaFotos;
    }

    /**
     * @param rutaFotos the rutaFotos to set
     */
    public void setRutaFotos(String rutaFotos) {
        this.rutaFotos = rutaFotos;
    }
    
    
}
