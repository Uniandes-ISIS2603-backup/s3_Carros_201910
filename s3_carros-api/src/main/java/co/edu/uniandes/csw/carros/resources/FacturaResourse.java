/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.FacturaDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Kevin Hernán Castrillon Castañeda.
 */
@Path("/compraVentas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FacturaResourse 
{
    private final static Logger LOGGER = Logger.getLogger(FacturaResourse.class.getName());
    
     /**
     * Crea una nueva Factura con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param factura {@link FacturaDTO} - La factura que se desea
     * guardar.
     * @return JSON {@link FacturaDTO} - La factura guardada con el atributo
     * id autogenerado.
     */
    @POST
    public FacturaDTO createFactura( FacturaDTO factura )
    {
        return factura;
    }
    
    /**
     * Retorna la lista de facturas.
     * @return lista de facturas.
     */
    @GET
    public List<FacturaDTO> getFacturas( )
    {
        return new ArrayList<>();
    }

    /**
     * Retorna la factura asociada al id dado por parametro.
     * @param facturaID: Identificador de la factura.
     * @return factura asociada al id dado por parametro, null de lo contrario.
     */
    @GET
    @Path("{facturaID: \\d+}")
    public FacturaDTO getFactura( @PathParam("facturaID") Long facturaID )
    {
        return null;
    }
}
