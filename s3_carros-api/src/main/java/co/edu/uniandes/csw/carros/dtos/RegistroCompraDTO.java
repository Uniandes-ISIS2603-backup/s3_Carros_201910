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
 * @author Daniel Lozano
 */
public class RegistroCompraDTO implements Serializable
{
    private double precioAcordado; 
    
    private Date fechaCompra; 
    
    private String nombreVendedor; 
    
    private int autoId; 
    
    private long compraId; 

    /**
     * 
     */
    public RegistroCompraDTO()
    {
        
    }
    /**
     * @return the precioAcordado
     */
    public double getPrecioAcordado() {
        return precioAcordado;
    }

    /**
     * @param precioAcordado the precioAcordado to set
     */
    public void setPrecioAcordado(double precioAcordado) {
        this.precioAcordado = precioAcordado;
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
     * @return the autoId
     */
    public int getAutoId() {
        return autoId;
    }

    /**
     * @param autoId the autoId to set
     */
    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    /**
     * @return the compraId
     */
    public long getCompraId() {
        return compraId;
    }

    /**
     * @param compraId the compraId to set
     */
    public void setCompraId(long compraId) {
        this.compraId = compraId;
    }
    
    
}
