/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
@Entity
public class EmpleadoEntity extends BaseEntity implements Serializable  {
    
    private String nombre;
    private Integer extension;
    private String telefono;
    
    //@PodamExclude
    //@OneToMany(mappedBy = "empleado", cascade = CascadeType.PERSIST, orphanRemoval = true)
    //private List<CompraVentaEntity> ventas = new ArrayList<CompraVentaEntity>();
    
    //@ManyToOne
    //private PuntoVentaEntity puntoVenta;

    public EmpleadoEntity(){
        
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

    /**
     * @return the ventas
     */
    //public List<CompraVentaEntity> getVentas() {
    //    return ventas;
    //}

    /**
     * @param ventas the ventas to set
     */
    //public void setVentas(List<CompraVentaEntity> ventas) {
    //    this.ventas = ventas;
    //}

    /**
     * @return the puntoVenta
     */
    //public PuntoVentaEntity getPuntoVenta() {
    //    return puntoVenta;
    //}

    /**
     * @param puntoVenta the puntoVenta to set
     */
    //public void setPuntoVenta(PuntoVentaEntity puntoVenta) {
    //    this.puntoVenta = puntoVenta;
    //}
    
    
}
