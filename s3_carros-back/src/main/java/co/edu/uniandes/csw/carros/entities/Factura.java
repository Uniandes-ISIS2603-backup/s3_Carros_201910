/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;
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
     * Identificador único de la transacción asociada a la factura.
     */
    private int transaccionID;
   
     /**
     * Número de la cuenta bancaria del cliente.
     */
    private int cuentaOrigen;
    
     /**
     * Fecha de realización de la factura.
     */
    private Date fecha;
    
     /**
     * Constructor vacío de Factura.
     */
    public Factura( )
    {
        
    }

    /**
     * @return the transaccionID
     */
    public int getTransaccionID() {
        return transaccionID;
    }

    /**
     * @param transaccionID the transaccionID to set
     */
    public void setTransaccionID(int transaccionID) {
        this.transaccionID = transaccionID;
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
}

