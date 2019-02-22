/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author estudiante
 */
public class RegistroCompraDetailDTO  extends RegistroCompraDTO implements Serializable
{
    private double precioComprado; 
    
    private Long compraID; 
    
    private Date fechaCompra; 
    
    private String nombreVendedor;
    
    private Long autoID;

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
     * @return the compraID
     */
    public Long getCompraID() {
        return compraID;
    }

    /**
     * @param compraID the compraID to set
     */
    public void setCompraID(Long compraID) {
        this.compraID = compraID;
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
     * @return the nombreVendedor
     */
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    /**
     * @param nombreVendedor the nombreVendedor to set
     */
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    /**
     * @return the autoID
     */
    public Long getAutoID() {
        return autoID;
    }

    /**
     * @param autoID the autoID to set
     */
    public void setAutoID(Long autoID) {
        this.autoID = autoID;
    }
    
    
}
