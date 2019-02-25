/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Kevin Hernan Castrillon Castañeda
 */

@Entity
public class CompraVentaEntity extends BaseEntity implements Serializable
{
    private double calificacionCompra;
    
    private String comentarios;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    private boolean pagado;
    
    @PodamExclude
    @OneToOne(mappedBy = "compraVenta")
    private FacturaEntity factura;

    @PodamExclude
    @ManyToOne
    private EmpleadoEntity empleado;
    
    @PodamExclude
    @ManyToOne
    private clienteEntity cliente;

    @PodamExclude
    @OneToMany(mappedBy = "venta")
    private List<QuejasReclamosEntity> quejasReclamosEmpleado = new ArrayList<QuejasReclamosEntity>();
    
    @PodamExclude
    @OneToMany(mappedBy = "compra")
    private List<QuejasReclamosEntity> quejasReclamosCliente = new ArrayList<QuejasReclamosEntity>();
    
    @PodamExclude
    @OneToOne
    private AutomovilEntity automovilFacturado;
    
    @PodamExclude
    @OneToOne
    private PuntoVentaEntity puntoVenta;
    
    public CompraVentaEntity( )
    {
        
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
    
}
