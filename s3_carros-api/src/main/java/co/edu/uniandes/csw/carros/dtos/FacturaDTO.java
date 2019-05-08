/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.adapters.DateAdapter;
import co.edu.uniandes.csw.carros.entities.FacturaEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
    private Long facturaID;
   
     /**
     * Número de la cuenta bancaria del cliente.
     */
    private Long cuentaOrigen;
    
     /**
     * Fecha de realización de la factura.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fecha;
    


     /**
     * Constructor vacío de Factura.
     */
    public FacturaDTO( )
    {
        
    }
    
    /**
     * Constructor a partir de la entidad
     *
     * @param facturaEntity La entidad de factura.
     */
    public FacturaDTO(FacturaEntity facturaEntity) {
        if (facturaEntity != null) 
        {
            this.facturaID = facturaEntity.getId();
            this.cuentaOrigen = facturaEntity.getCuentaOrigen();
            this.fecha = facturaEntity.getFecha();
            
        }
    }
    
    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad de la factura asociada.
     */
    public FacturaEntity toEntity() 
    {
        FacturaEntity facturaEntity = new FacturaEntity();
        facturaEntity.setId(this.facturaID);
        facturaEntity.setCuentaOrigen(this.cuentaOrigen);
        facturaEntity.setFecha(this.fecha);
       
        return facturaEntity;
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

   
}
