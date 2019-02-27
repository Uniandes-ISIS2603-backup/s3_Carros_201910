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
    private ClienteEntity cliente;

    @PodamExclude
    @OneToMany(mappedBy = "compraVenta")
    private List<QuejasReclamosEntity> quejasReclamosEmpleado = new ArrayList<QuejasReclamosEntity>();
    
    @PodamExclude
    @OneToMany(mappedBy = "compraVenta")
    private List<QuejasReclamosEntity> quejasReclamosCliente = new ArrayList<QuejasReclamosEntity>();
    
    @PodamExclude
    @OneToOne
    private AutomovilEntity automovilFacturado;
    
    @PodamExclude
    @ManyToOne
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

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the quejasReclamosEmpleado
     */
    public List<QuejasReclamosEntity> getQuejasReclamosEmpleado() {
        return quejasReclamosEmpleado;
    }

    /**
     * @param quejasReclamosEmpleado the quejasReclamosEmpleado to set
     */
    public void setQuejasReclamosEmpleado(List<QuejasReclamosEntity> quejasReclamosEmpleado) {
        this.quejasReclamosEmpleado = quejasReclamosEmpleado;
    }

    /**
     * @return the quejasReclamosCliente
     */
    public List<QuejasReclamosEntity> getQuejasReclamosCliente() {
        return quejasReclamosCliente;
    }

    /**
     * @param quejasReclamosCliente the quejasReclamosCliente to set
     */
    public void setQuejasReclamosCliente(List<QuejasReclamosEntity> quejasReclamosCliente) {
        this.quejasReclamosCliente = quejasReclamosCliente;
    }

    /**
     * @return the automovilFacturado
     */
    public AutomovilEntity getAutomovilFacturado() {
        return automovilFacturado;
    }

    /**
     * @param automovilFacturado the automovilFacturado to set
     */
    public void setAutomovilFacturado(AutomovilEntity automovilFacturado) {
        this.automovilFacturado = automovilFacturado;
    }

    /**
     * @return the puntoVenta
     */
    public PuntoVentaEntity getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * @param puntoVenta the puntoVenta to set
     */
    public void setPuntoVenta(PuntoVentaEntity puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the pagado
     */
    public boolean isPagado() {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    /**
     * @return the factura
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * @return the empleado
     */
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
    
}
