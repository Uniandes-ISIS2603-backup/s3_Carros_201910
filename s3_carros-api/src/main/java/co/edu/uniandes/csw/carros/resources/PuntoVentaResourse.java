/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.PuntoVentaDTO;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author estudiante
 */
@Path("puntosdeVenta")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PuntoVentaResourse 
{
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaResourse.class.getName());
    
    @POST
    public PuntoVentaDTO createdRegistroCompra(PuntoVentaDTO puntoVenta)
    {
        return puntoVenta;
    }
}
