/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.util.Date;

/**
 *
 * @author Kevin Hernan Castrillon Castañeda
 */
public class CompraVentaDTO extends CascaraDTO
{
    /**
     * Identificador único de la transacción.
     */
    private int ventaID;
    
    /**
     * Calificación de la CompraVenta.
     */
    private double calificacionCompra;
    
    /**
     * Fecha en la que se hizo la CompraVenta.
     */
    private Date fecha;
    
    /**
     * Factura asociada a la CompraVenta.
     */
    private Factura factura;

    /**
     * Constructor vacío de CompraVentaDTO.
     */
    public CompraVentaDTO( )
    {
        
    }
    /**
     * @return the ventaID
     */
    public int getVentaID() {
        return ventaID;
    }

    /**
     * @param ventaID the ventaID to set
     */
    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    /**
     * @return the calificacionCompra
     */
    public double getCalificacionCompra() {
        return calificacionCompra;
    }

    /**
     * @param calificacionCompra the calificacionCompra to set
     */
    public void setCalificacionCompra(double calificacionCompra) {
        this.calificacionCompra = calificacionCompra;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
