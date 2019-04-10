/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.resources;

import co.edu.uniandes.csw.carros.dtos.ClienteDTO;
import co.edu.uniandes.csw.carros.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.carros.ejb.ClienteLogic;
import co.edu.uniandes.csw.carros.ejb.PuntoVentaClienteLogic;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 *
 * @author Daniel Lozano
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PuntoVentaClienteResource {
 private static final Logger LOGGER = Logger.getLogger(PuntoVentaEmpleadoResource.class.getName());    
 
    @Inject
    private PuntoVentaClienteLogic puntoVentaClienteLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private ClienteLogic clienteLogic;
    
    @POST
    @Path("{puntoVentaID: \\d+}")
    public ClienteDTO addCliente(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("clienteID") Long clienteId) {
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource addCliente: input: puntoVentaID: {0} , clienteID: {1}", new Object[]{puntoVentaId, clienteId});
        if (clienteLogic.getCliente(clienteId) == null) {
            throw new WebApplicationException("El recurso /cliente/" + clienteId + " no existe.", 404);
        }
        ClienteDTO clienteDTO = new ClienteDTO(puntoVentaClienteLogic.addCliente(clienteId, puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource addCliente: output: {0}", clienteDTO);
        return clienteDTO;
    }
    
    @GET
    public List<ClienteDetailDTO> getEmpleados(@PathParam("puntoVentaID") Long puntoVentaId) {
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource getClientes: input: {0}", puntoVentaId);
        List<ClienteDetailDTO> listaDetailDTOs = clienteListEntity2DTO(puntoVentaClienteLogic.getClientes(puntoVentaId));
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource getClientes: output: {0}", listaDetailDTOs);
        return listaDetailDTOs;
    }

    /**
     * Busca el libro con el id asociado dentro de la editorial con id asociado.
     *
     * @param editorialsId Identificador de la editorial que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param booksId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link BookDetailDTO} - El libro buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro en la
     * editorial.
     */
    @GET
      @Path("{puntoVentaID: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("puntoVentaID") Long puntoVentaId, @PathParam("clienteID") Long clienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource getCliente: input: editorialsID: {0} , booksId: {1}", new Object[]{puntoVentaId, clienteId});
        if (clienteLogic.getCliente(clienteId) == null) {
            throw new WebApplicationException("El recurso /PuntoVenta/" + puntoVentaId + "/cliente/" + clienteId + " no existe.", 404);
        }
        ClienteDetailDTO clienteDetailDTO = new ClienteDetailDTO(puntoVentaClienteLogic.getCliente(puntoVentaId, clienteId));
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource getCliente:  output: {0}", clienteDetailDTO);
        return clienteDetailDTO;
    }

    /**
     * Remplaza las instancias de Book asociadas a una instancia de Editorial
     *
     * @param editorialsId Identificador de la editorial que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param books JSONArray {@link BookDTO} El arreglo de libros nuevo para la
     * editorial.
     * @return JSON {@link BookDTO} - El arreglo de libros guardado en la
     * editorial.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @PUT
    public List<ClienteDetailDTO> replaceCliente(@PathParam("puntoVentaID") Long puntoVentaId, List<ClienteDetailDTO> clientes) {
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource replaceCliente: input: editorialsId: {0} , marcas: {1}", new Object[]{puntoVentaId, clientes});
        for (ClienteDetailDTO cliente : clientes) {
            if (clienteLogic.getCliente(cliente.getClienteID()) == null) 
                    {
                throw new WebApplicationException("El recurso /cliente/" + cliente.getClienteID() + " no existe.", 404);
            }
        }
        List<ClienteDetailDTO> listaDetailDTOs = clienteListEntity2DTO(puntoVentaClienteLogic.replaceCliente(puntoVentaId, clienteListDTO2Entity(clientes)));
        LOGGER.log(Level.INFO, "PuntoVentaClienteResource replaceCliente: output: {0}", listaDetailDTOs);
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de BookEntity a una lista de BookDetailDTO.
     *
     * @param entityList Lista de BookEntity a convertir.
     * @return Lista de BookDTO convertida.
     */
    private List<ClienteDetailDTO> clienteListEntity2DTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> list = new ArrayList();
        for (ClienteEntity entity : entityList) 
        {
            list.add(new ClienteDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de BookDetailDTO a una lista de BookEntity.
     *
     * @param dtos Lista de BookDetailDTO a convertir.
     * @return Lista de BookEntity convertida.
     */
    private List<ClienteEntity> clienteListDTO2Entity(List<ClienteDetailDTO> dtos) {
        List<ClienteEntity> list = new ArrayList<>();
        for (ClienteDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
   
}
