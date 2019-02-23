/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.CompraVentaDTO;
import java.util.ArrayList;
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
 * @author Kevin Hernán Castrillón Castañeda
 */
@Path("/compraVentas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraVentaResourse 
{
    private final static Logger LOGGER = Logger.getLogger(CompraVentaResourse.class.getName());
    
     /**
     * Crea una nueva editorial con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param compraVenta {@link CompraVentaDTO} - La compraVenta que se desea
     * guardar.
     * @return JSON {@link CompraVentaDTO} - La compraVenta guardada con el atributo
     * id autogenerado.
     */
    @POST
    public CompraVentaDTO createCompraVenta( CompraVentaDTO compraVenta )
    {
        return compraVenta;
    }
    
    /**
     * Retorna la lista de compraVentas.
     * @return lista de compraVentas.
     */
    @GET
    public ArrayList<CompraVentaDTO> getCompraVentas( )
    {
        return new ArrayList<>();
    }

    /**
     * Retorna la compraVenta asociada al id dado por parametro.
     * @param ventaID: Identificador de la compraVenta.
     * @return compraVenta asociada al id dado por parametro, null de lo contrario.
     */
    @GET
    @Path("{VentaID: \\d+}")
    public CompraVentaDTO getCompraVenta( @PathParam("VentaID") Long ventaID )
    {
        return null;
    }
}
