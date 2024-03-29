/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Daniel Lozano
 */
@Entity
public class RegistroCompraEntity extends BaseEntity implements Serializable 
{
    private double precioComprado; 
   
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    
    private String nombreVendedor; 
   

    @PodamExclude
    @ManyToOne()
    private PuntoVentaEntity puntoVenta;
    
    
    @PodamExclude
    @OneToOne
    private AutomovilEntity automovil;
            
    /**
     * Constructor por defecto de la clase
     */ 
    public RegistroCompraEntity()
    {
        
    }
    /**
     * @return the precioComprado
     */
    public double getPrecioComprado() {
        return precioComprado;
    }
    /**
     * @param precioComprado the precioComprado to set
     */
    public void setPrecioComprado(double precioComprado) {
        this.precioComprado = precioComprado;
    }

    /**
     * @return the fechaCompra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * @return the nombreVnededor
     */
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    /**
     * @param nombreVnededor the nombreVnededor to set
     */
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    /**
     * @return the automovil
     */
    public AutomovilEntity getAutomovil() {
        return automovil;
    }

    /**
     * @param automovil the automovil to set
     */
    public void setAutomovil(AutomovilEntity automovil) {
        this.automovil = automovil;
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
