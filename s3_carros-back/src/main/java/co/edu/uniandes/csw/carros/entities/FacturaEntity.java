/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una factura en la persistencia y permite su serialización
 * 
 * @author Kevin Hernán Castrillón Castañeda
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable
{
    private Long cuentaOrigen;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @PodamExclude
    @OneToOne(fetch = LAZY)
    private CompraVentaEntity compraVenta;

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
    public CompraVentaEntity getCompraVenta() {
        return compraVenta;
    }

    /**
     * @param compraVenta the compraVenta to set
     */
    public void setCompraVenta(CompraVentaEntity compraVenta) {
        this.compraVenta = compraVenta;
    }
            
}
