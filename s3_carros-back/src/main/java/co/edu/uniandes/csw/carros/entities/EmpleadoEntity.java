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
    private String correo;
    
    @PodamExclude
    @OneToMany(mappedBy = "empleado")
    private List<CompraVentaEntity> ventas = new ArrayList<CompraVentaEntity>();
    
    @PodamExclude
    @ManyToOne
    private PuntoVentaEntity puntoVenta;

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
    public String getCorreo() {
        return correo;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the ventas
     */
    public List<CompraVentaEntity> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<CompraVentaEntity> ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the puntoVenta
     */
    public PuntoVentaEntity getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * @param puntoVenta the puntoVenta to set
     */
    public void setPuntoVenta(PuntoVentaEntity puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
    
    
}
