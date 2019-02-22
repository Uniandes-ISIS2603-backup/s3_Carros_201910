/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.PuntoVentaDTO;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("puntosdeVenta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class PuntoVentaResourse 
{
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaResourse.class.getName());
    
    @POST
    public PuntoVentaDTO createdRegistroCompra(PuntoVentaDTO puntoVenta)
    {
        return puntoVenta;
    }
    
    @GET
    public ArrayList<PuntoVentaDTO> getPuntosVenta(ArrayList<PuntoVentaDTO> puntoVenta)
    {
        return puntoVenta;
    }
    
    @GET
    @Path("{puntoVentaID: \\d+}")
    public PuntoVentaDTO getCliente(@PathParam("puntoVentaID") Long puntoVentaID){
        return null;
    }
    
    @PUT
    @Path("{puntoVentaID: \\d+}")
    public PuntoVentaDTO updatePuntoVenta(@PathParam("puntoVentaID") Long puntoVentaID, PuntoVentaDTO empleado){
        return empleado;
    }
    
    @DELETE
    @Path("{puntoVentaID: \\d+}")
    public void deleteúntoVenta(@PathParam("puntoVentaID") Long puntoVentaID){     
    }
}
