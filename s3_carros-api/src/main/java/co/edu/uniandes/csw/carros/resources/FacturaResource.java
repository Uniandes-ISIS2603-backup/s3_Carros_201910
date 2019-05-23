/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.FacturaDTO;
import co.edu.uniandes.csw.carros.ejb.FacturaLogic;
import co.edu.uniandes.csw.carros.entities.FacturaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Clase que implementa el recurso "facturas".
 *
 * @author Kevin Hernán Castrillon Castañeda.
 */
@Path("/facturas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class FacturaResource 
{
    private final static Logger LOGGER = Logger.getLogger(FacturaResource.class.getName());
    
    @Inject
    private FacturaLogic facturaLogic;
    
    
     /**
     * Crea una nueva Factura con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param factura {@link FacturaDTO} - La factura que se desea guardar.
     * @return JSON {@link FacturaDTO} - La factura guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la factura o el isbn es
     * inválido o si la CompraVenta ingresada es invalida.
     */
    @POST
    public FacturaDTO createFactura( FacturaDTO factura ) throws BusinessLogicException 
    {
        LOGGER.log(Level.INFO, "FacturaResource createFactura: input: {0}", factura);
        FacturaDTO nuevaFacturaDTO = new FacturaDTO(facturaLogic.createFactura(factura.toEntity()));
        LOGGER.log(Level.INFO, "FacturaResource createFactura: output: {0}", nuevaFacturaDTO);
        return nuevaFacturaDTO;
    }
    
    /**
     * Busca y devuelve todas las facturas que existen en la aplicacion.
     *
     * @return JSONArray {@link FacturaDTO} - Las facturas encontradas en la
     * aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<FacturaDTO> getFacturas( )
    {
        LOGGER.info("FacturaResource getFacturas: input: void");
        List<FacturaDTO> listaFacturas = listEntity2DetailDTO(facturaLogic.getFacturas());
        LOGGER.log(Level.INFO, "FacturaResource getFacturas: output: {0}", listaFacturas);
        return listaFacturas;
    }

    /**
     * Busca la factura con el id asociado recibido en la URL y la devuelve.
     *
     * @param facturaID Identificador de la factura que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link FacturaDTO} - La factura buscada
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la factura.
     */
    @GET
    @Path("{facturaID: \\d+}")
    public FacturaDTO getFactura(@PathParam("facturaID") Long facturaID)
    {
        LOGGER.log(Level.INFO, "FacturaResource getFactura: input: {0}", facturaID);
        FacturaEntity facturaEntity = facturaLogic.getFactura(facturaID);
        if (facturaEntity == null) {
            throw new WebApplicationException("El recurso /facturas/" + facturaID + " no existe.", 404);
        }
        FacturaDTO facturaDTO = new FacturaDTO(facturaEntity);
        LOGGER.log(Level.INFO, "FacturaResource getFactura: output: {0}", facturaDTO);
        return facturaDTO;
    }
    
    /**
     * Convierte una lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos FacturaEntity a una lista de
     * objetos FacturaDTO (json)
     *
     * @param entityList corresponde a la lista de facturas de tipo Entity que
     * vamos a convertir a DTO.
     * @return la lista de facturas en forma DTO (json)
     */
    private List<FacturaDTO> listEntity2DetailDTO(List<FacturaEntity> entityList) {
        List<FacturaDTO> list = new ArrayList<>();
        for (FacturaEntity entity : entityList) {
            list.add(new FacturaDTO(entity));
        }
        return list;
    }
}
