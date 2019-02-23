/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author estudiante
 */
public class RegistroCompraEntity extends BaseEntity implements Serializable
{
    private double precioComprado; 
   
    @Temporal(TemporalType.DATE)
    private Date fechaCompra; 
    
    private String nombreVnededor; 

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
    public String getNombreVnededor() {
        return nombreVnededor;
    }

    /**
     * @param nombreVnededor the nombreVnededor to set
     */
    public void setNombreVnededor(String nombreVnededor) {
        this.nombreVnededor = nombreVnededor;
    }
 
    
    
}
