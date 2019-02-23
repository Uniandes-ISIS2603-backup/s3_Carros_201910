/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.io.Serializable;
import java.util.Date;

/**CompraVentaDTO Objeto de transferencia de datos de CompraVentas. Los DTO
 * contienen las representaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *"
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
   {
      "compraVentaID": number,
      "calificacionCompra": number,
      "fecha": date,
      "factura": {
                     "facturaID": number,
                     "cuentaOrigen": number,
                     "fecha": date
                 }
   }
 </pre> Por ejemplo una compraVenta se representa asi:<br>
 *
 * <pre>

   {
      "compraVentaID": 13579,
      "calificacionCompra": "4.5",
      "fecha": "23-02-2018",
      "factura": {
                     "facturaID": 13579,
                     "cuentaOrigen": 147852369,
                     "fecha": "23-02-2018"
                 }
   }

 </pre>
 *
 * @author Kevin Hernan Castrillon Castañeda
 */
public class CompraVentaDTO extends CascaraDTO implements Serializable
{
    /**
     * Identificador único de la transacción.
     */
    private Long compraVentaID;
    
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
     * Automovil asociado a la transacción.
     */
    private AutomovilDTO automovil;
    
    /**
     * Cliente asociado a la transacción.
     */
    private ClienteDTO cliente;
    
    /**
     * Empleado asociado a la transacción.
     */
    private EmpleadoDTO empleado;
    
    /**
     * Punto de venta asociado a la transacción.
     */
    private PuntoVentaDTO puntoVenta;

    /**
     * Constructor por defecto de CompraVentaDTO.
     */
    public CompraVentaDTO( )
    {
        
    }
    /**
     * @return the compraVentaID
     */
    public Long getCompraVentaID() {
        return compraVentaID;
    }

    /**
     * @param compraVentaID the compraVentaID to set
     */
    public void setCompraVentaID(Long compraVentaID) {
        this.compraVentaID = compraVentaID;
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

    /**
     * @return the automovil
     */
    public AutomovilDTO getAutomovil() {
        return automovil;
    }

    /**
     * @param automovil the automovil to set
     */
    public void setAutomovil(AutomovilDTO automovil) {
        this.automovil = automovil;
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
