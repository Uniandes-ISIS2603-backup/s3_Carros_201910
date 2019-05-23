/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.adapters.DateAdapter;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**CompraVentaDTO Objeto de transferencia de datos de CompraVentas. Los DTO
 * contienen las representaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *"
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * 
 * <pre>
 * 
 *   {
 *      "ventaID": number,
 *      "calificacionCompra": number,
 *      "fecha": date,
 *      "pagado": boolean,
 *      "factura": {@link FacturaDTO}
 *      "automovilFacturado": {@link AutomovilFacturadoDTO}
 *      "cliente": {@link ClienteDTO}
 *      "empleado": {@link EmpleadoDTO}
 *      "puntoVenta": {@link PuntoVentaDTO}
 *   }
 * 
 * </pre>
 *
 * @author Kevin Hernan Castrillon Castañeda
 */
public class CompraVentaDTO extends CascaraDTO implements Serializable
{ 
    /**
     * Identificador único de la transacción.
     */
    private Long ventaID;
    
    /**
     * Calificación de la CompraVenta.
     */
    private Double calificacionCompra;
    
    /**
     * Fecha en la que se hizo la CompraVenta.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fecha;
    
    /**
     * Indica si la compraVenta ya fue pagada.
     */
    private Boolean pagado;
    
    /**
     * Factura asociada a la CompraVenta.
     */
    private FacturaDTO factura;
    
    /**
     * Automovil asociado a la CompraVenta.
     */
    private AutomovilDTO automovilFacturado;
    
    /**
     * Cliente asociado a la CompraVenta.
     */
    private ClienteDTO cliente;
    
    /**
     * Empleado asociado a la CompraVenta.
     */
    private EmpleadoDTO empleado;
    
    /**
     * PuntoVenta asociado a la CompraVenta.
     */
    private PuntoVentaDTO puntoVenta;

    /**
     * Constructor por defecto de CompraVentaDTO.
     */
    public CompraVentaDTO( )
    {
        
    }
    
     /**
     * Constructor a partir de la entidad
     *
     * @param compraVentaEntity La entidad de compraVenta
     */
    public CompraVentaDTO(CompraVentaEntity compraVentaEntity) {
        if (compraVentaEntity != null) 
        {
            this.ventaID = compraVentaEntity.getId();
            this.calificacionCompra = compraVentaEntity.getCalificacionCompra();
            this.pagado = compraVentaEntity.isPagado();
            this.fecha = compraVentaEntity.getFecha();
            if (compraVentaEntity.getFactura() != null) 
            {
                this.factura = new FacturaDTO(compraVentaEntity.getFactura());
            } 
            else 
            {
                this.factura = null;
            }
            if (compraVentaEntity.getEmpleado() != null)
            {
                this.empleado = new EmpleadoDTO(compraVentaEntity.getEmpleado());
            }
            else 
            {
                this.empleado = null;
            }
            if (compraVentaEntity.getCliente() != null)
            {
                this.cliente = new ClienteDTO(compraVentaEntity.getCliente());
            }
            else 
            {
                this.cliente = null;
            }
            if (compraVentaEntity.getAutomovilFacturado() != null)
            {
                this.automovilFacturado = new AutomovilDTO(compraVentaEntity.getAutomovilFacturado());
            }
            else 
            {
                this.automovilFacturado = null;
            }
            if (compraVentaEntity.getPuntoVenta() != null)
            {
                this.puntoVenta = new PuntoVentaDTO(compraVentaEntity.getPuntoVenta());
            }
            else 
            {
                this.puntoVenta = null;
            }
        }
    }
    
    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad de la compraVenta asociada.
     */
    public CompraVentaEntity toEntity() 
    {
        CompraVentaEntity compraVentaEntity = new CompraVentaEntity();
        compraVentaEntity.setId(this.ventaID);
        compraVentaEntity.setCalificacionCompra(this.calificacionCompra);
        compraVentaEntity.setFecha(this.fecha);
        compraVentaEntity.setPagado(this.pagado);
        if(this.cliente != null)
        {
            compraVentaEntity.setCliente(this.cliente.toEntity());
        }
        if(this.empleado != null)
        {
            compraVentaEntity.setEmpleado(this.empleado.toEntity());
        }
        if(this.factura != null)
        {
            compraVentaEntity.setFactura(this.factura.toEntity());
        }
        if(this.puntoVenta != null)
        {
            compraVentaEntity.setPuntoVenta(this.puntoVenta.toEntity());
        }
        if (this.automovilFacturado != null) 
        {
            compraVentaEntity.setAutomovilFacturado(this.automovilFacturado.toEntity());
        }
        return compraVentaEntity;
    }
    
    /**
     * @return the ventaID
     */
    public Long getVentaID() {
        return ventaID;
    }

    /**
     * @param ventaID the ventaID to set
     */
    public void setVentaID(Long ventaID) {
        this.ventaID = ventaID;
    }

    /**
     * @return the calificacionCompra
     */
    public Double getCalificacionCompra() {
        return calificacionCompra;
    }

    /**
     * @param calificacionCompra the calificacionCompra to set
     */
    public void setCalificacionCompra(Double calificacionCompra) {
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
    public FacturaDTO getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    /**
     * @return the pagado
     */
    public Boolean isPagado() {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    /**
     * @return the automovilFacturado
     */
    public AutomovilDTO getAutomovilFacturado() {
        return automovilFacturado;
    }

    /**
     * @param automovilFacturado the automovilFacturado to set
     */
    public void setAutomovilFacturado(AutomovilDTO automovilFacturado) {
        this.automovilFacturado = automovilFacturado;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the empleado
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the puntoVenta
     */
    public PuntoVentaDTO getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * @param puntoVenta the puntoVenta to set
     */
    public void setPuntoVenta(PuntoVentaDTO puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
}
