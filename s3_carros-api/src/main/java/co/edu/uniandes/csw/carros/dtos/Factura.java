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
public class Factura 
{
    /**
     * Número de la cuenta bancaria del consecionario.
     */
    public final static int CUENTA_DESTINO = 123456;
    
    /**
     * Identificador único de la factura.
     */
    private Long facturaID;
   
     /**
     * Número de la cuenta bancaria del cliente.
     */
    private Long cuentaOrigen;
    
     /**
     * Fecha de realización de la factura.
     */
    private Date fecha;
    
    /**
     * Transacción asociada a la factura
     */
    private CompraVentaDTO compraVenta;
    
     /**
     * Constructor vacío de Factura.
     */
    public Factura( )
    {
        
    }

    /**
     * @return the facturaID
     */
    public Long getFacturaID() {
        return facturaID;
    }

    /**
     * @param facturaID the facturaID to set
     */
    public void setFacturaID(Long facturaID) {
        this.facturaID = facturaID;
    }

    /**
     * @return the cuentaOrigen
     */
    public Long getCuentaOrigen() {
        return cuentaOrigen;
    }

    /**
     * @param cuentaOrigen the cuentaOrigen to set
     */
    public void setCuentaOrigen(Long cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
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
     * @return the compraVenta
     */
    public CompraVentaDTO getCompraVenta() {
        return compraVenta;
    }

    /**
     * @param compraVenta the compraVenta to set
     */
    public void setCompraVenta(CompraVentaDTO compraVenta) {
        this.compraVenta = compraVenta;
    }
}

