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
 *   {
 *      "ventaID": number,
 *      "calificacionCompra": number,
 *      "fecha": date,
 *      "pagado": boolean,
 *      "factura": {@link FacturaDTO}
 *   }
 * </pre> Por ejemplo una compraVenta se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "ventaID": 13579,
 *      "calificacionCompra": "4.5",
 *      "fecha": "2018-08-20T00:00:00-05:00",
 *      "pagado": "true",
 *      "factura": {
 *                     "transaccionId": 13579,
 *                     "cuentaOrigen": 147852369,
 *                     "fecha": "2018-08-20T00:00:00-07:00"
 *                 }
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
     * Indica si la compraVenta ya fue pagada.
     */
    private boolean pagado;
    
    /**
     * Factura asociada a la CompraVenta.
     */
    private FacturaDTO factura;

    /**
     * Constructor por defecto de CompraVentaDTO.
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
    public boolean isPagado() {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
}
