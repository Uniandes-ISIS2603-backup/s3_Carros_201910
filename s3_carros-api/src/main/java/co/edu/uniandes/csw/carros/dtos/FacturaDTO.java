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
 * @author Kevin Hernan Castrillon Castañeda
 */
public class FacturaDTO extends CascaraDTO implements Serializable
{
    /**
     * Número de la cuenta bancaria del consecionario.
     */
    public final static int CUENTA_DESTINO = 123456;
    
    /**
     * Identificador único de la transacción asociada a la factura.
     */
    private int facturaID;
   
     /**
     * Número de la cuenta bancaria del cliente.
     */
    private int cuentaOrigen;
    
     /**
     * Fecha de realización de la factura.
     */
    private Date fecha;
    
    /**
     * Transacción asociada a la factura.
     */
    private CompraVentaDTO compraventa;
    
     /**
     * Constructor vacío de Factura.
     */
    public FacturaDTO( )
    {
        
    }

    /**
     * @return the facturaID
     */
    public int getFacturaID() {
        return facturaID;
    }

    /**
     * @param facturaID the facturaID to set
     */
    public void setFacturaID(int facturaID) {
        this.facturaID = facturaID;
    }

    /**
     * @return the cuentaOrigen
     */
    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    /**
     * @param cuentaOrigen the cuentaOrigen to set
     */
    public void setCuentaOrigen(int cuentaOrigen) {
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
     * @return the compraventa
     */
    public CompraVentaDTO getCompraventa() {
        return compraventa;
    }

    /**
     * @param compraventa the compraventa to set
     */
    public void setCompraventa(CompraVentaDTO compraventa) {
        this.compraventa = compraventa;
    }
}
