/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.CompraVentaDTO;
import co.edu.uniandes.csw.carros.dtos.CompraVentaDetailDTO;
import co.edu.uniandes.csw.carros.ejb.CompraVentaLogic;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Clase que implementa el recurso "compraVentas".
 *
 * @author Kevin Hernán Castrillón Castañeda
 */
@Path("/compraVentas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class CompraVentaResource 
{
    private final static Logger LOGGER = Logger.getLogger(CompraVentaResource.class.getName());
    
    @Inject
    private CompraVentaLogic compraVentaLogic; 
    
    /**
     * Crea una nueva CompraVenta con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param compraVenta {@link CompraVentaDTO} - La compraVenta que se desea
     * guardar.
     * @return JSON {@link CompraVentaDTO} - La compraVenta guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la compraventa.
     */
    @POST
    public CompraVentaDTO createCompraVenta( CompraVentaDTO compraVenta ) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "ComporaVentaResourse createCompraVenta: imput: {0}", compraVenta);
        CompraVentaEntity entity = compraVenta.toEntity();
        CompraVentaEntity nuevaCompraVentaEntity = compraVentaLogic.createCompraVenta(entity);
        CompraVentaDTO nuevaCompraVentaDTO = new CompraVentaDTO(nuevaCompraVentaEntity);
        LOGGER.log(Level.INFO, "CompraVentaResourse createCompraVenta: output: {0}", nuevaCompraVentaDTO);
        return nuevaCompraVentaDTO;
    }
    
    /**
     * Busca y retorna todas las CompraVentas que existen en la aplicación.
     * 
     * @return JSONArray {@link CompraVentaDetailDTO} - Las CompraVentas
     * encontradas en la aplicacion. Si no hay ninguna ratorna una lista vacía..
     */
    @GET
    public List<CompraVentaDetailDTO> getCompraVentas( )
    {
        LOGGER.log(Level.INFO, "ComporaVentaResourse getCompraVentas: imput: void");
        List<CompraVentaDetailDTO> listaCompraVentas = listEntity2DetailDTO(compraVentaLogic.getCompraVentas());
        LOGGER.log(Level.INFO, "ComporaVentaResourse createCompraVenta: output: {0}", listaCompraVentas);
        return listaCompraVentas;
    }

    /**
     * Busca la compraVenta con el id asociado recibido en la URL y la devuelve.
     * 
     * @param ventaID: Identificador de la compraVenta.
     * @return JSON {@link CompraVentaDetailDTO} - La compraVenta buscada. 
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la CompraVenta.
     */
    @GET
    @Path("{ventaID: \\d+}")
    public CompraVentaDetailDTO getCompraVenta( @PathParam("ventaID") Long ventaID ) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "CompraVentaResourse getCompraVenta: imput: {0}", ventaID);
        CompraVentaEntity compraVentaEntity = compraVentaLogic.getCompraVenta(ventaID);
        if(compraVentaEntity == null)
        {
            throw new  WebApplicationException("El recurso /compraVentas/" + ventaID + " no existe.", 404);
        }
        CompraVentaDetailDTO detailDTO = new CompraVentaDetailDTO(compraVentaEntity);
        LOGGER.log(Level.INFO, "CompraVentaResourse getCompraVenta: output: {0}", detailDTO);
        return detailDTO;
    }
    
    /**
     * Actualiza la compraVenta con el id recibido en la URL con la informacion
     * que se recibe en el cuerpo de la petición.
     *
     * @param ventaID Identificador de la compraVenta que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param compraVenta {@link CompraVentaDetailDTO} La compraVenta que se desea
     * guardar.
     * @return JSON {@link CompraVentaDetailDTO} - La compraVenta guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la compraVenta a
     * actualizar.
     */
    @PUT
    @Path("{ventaID: \\d+}")
    public CompraVentaDetailDTO updateCompraVenta(@PathParam("ventaID") Long ventaID, CompraVentaDetailDTO compraVenta) 
    {
        LOGGER.log(Level.INFO, "CompraVentaResource updateCompraVenta: input: id:{0} , compraVenta: {1}", new Object[]{ventaID, compraVenta});
        compraVenta.setVentaID(ventaID);
        if (compraVentaLogic.getCompraVenta(ventaID) == null) {
            throw new WebApplicationException("El recurso /compraVentas/" + ventaID + " no existe.", 404);
        }
        CompraVentaDetailDTO detailDTO = new CompraVentaDetailDTO(compraVentaLogic.updateCompraVenta(ventaID, compraVenta.toEntity()));
        LOGGER.log(Level.INFO, "CompraVentaResource updateCompraVenta: output: {0}", detailDTO);
        return detailDTO;
    }
    
    /**
     * Conexión con el servicio de quejas para una compraVenta.
     * {@link CompraVentaQuejasResource}
     *
     * Este método conecta la ruta de /compraVentas con las rutas de /quejasReclamos que
     * dependen de la editorial, es una redirección al servicio que maneja el
     * segmento de la URL que se encarga de los libros de una editorial.
     *
     * @param compraVentaId El ID de la compraVenta con respecto a la cual se
     * accede al servicio.
     * @return El servicio de quejas para esta compraVenta en paricular.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la compraVenta.
     */
    @Path("{ventaID: \\d+}/quejasReclamos")
    public Class<CompraVentaQuejasResource> getCompraVentaQuejasResource(@PathParam("ventaID") Long compraVentaId) {
        if (compraVentaLogic.getCompraVenta(compraVentaId) == null) {
            throw new WebApplicationException("El recurso /compraVentas/" + compraVentaId + " no existe.", 404);
        }
        return CompraVentaQuejasResource.class;
    }
    
    /**
     * Convierte una lista de entidades a DTO
     * 
     * Este método convierte una lista de objetos CompraVentaEntity a una lista de 
     * objetos CompraVentaDetailDTO (json).
     * 
     * @param entityList corresponde a una lista de compraventas de tipo Entity.
     * @return la lista de compraVentas en forma DTO (json).
     */
    private List<CompraVentaDetailDTO> listEntity2DetailDTO(List<CompraVentaEntity> entityList)
    {
        List<CompraVentaDetailDTO> list = new ArrayList<>();
        for(CompraVentaEntity entity : entityList)
        {
            list.add(new CompraVentaDetailDTO(entity));
        }
        return list;
    }
}
