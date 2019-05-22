/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
import java.util.logging.Logger;

import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Logica del recurso punto de venta
 * @author Daniel Lozano
 */
@Stateless
public class PuntoVentaLogic
{
    /**
     * 
     */
     private static final Logger LOGGER = Logger.getLogger(PuntoVentaLogic.class.getName());
   
     /**
      * Persistencia del recurso punto de venta
      */
    @Inject
    private PuntoVentaPersistence persistence; 
    
    /**
     * Metodo para crear un punto de venta segun las reglas de negocio
     * @param puntoVenta entidad de la cual se va a partir para crear la logica
     * @return La entidad de punto de venta creada
     * @throws BusinessLogicException  Si la entidad qure se quiere crear no cunple con las reglas de negocio
     */
    public PuntoVentaEntity createPuntoVenta(PuntoVentaEntity puntoVenta) throws BusinessLogicException
    {
        if(persistence.findByDireccion(puntoVenta.getDireccion())!= null)
        {
            throw new BusinessLogicException("Ya existe un Punto de venta con la direccion: "+ puntoVenta.getDireccion());
        }
        if(puntoVenta == null)
        {
            throw  new BusinessLogicException("EL Entity es error");
        }
        puntoVenta = persistence.create(puntoVenta);
        return puntoVenta;
    }
    
    /**
     * Retorna los puntos de venta
     * @return  puntos de venta del sistema
     */
    public List<PuntoVentaEntity> getPuntosVenta()
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los puntos de venta");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<PuntoVentaEntity> puntosVenta = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los punyos de venta");
        return puntosVenta;
    }
    
    /**
     * Retorna un punto de venta en el sistema por in id dado
     * @param puntoVentaId el id a buscar
     * @return el punto de venta buscado por id
     */
    public PuntoVentaEntity getPuntoVenta(Long puntoVentaId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el punto de venta con id = {0}", puntoVentaId);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        PuntoVentaEntity puntoVentaEntity = persistence.find(puntoVentaId);
        if (puntoVentaId == null) {
            LOGGER.log(Level.SEVERE, "El punto de venta con el id = {0} no existe", puntoVentaId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el punto de ventacon id = {0}", puntoVentaId);
        return puntoVentaEntity;
    }
    
    /**
     * Actualiza el punto de venta del id con el nuevo punto de venta 
     * @param puntoVentaId del punto de venta a actualizar
     * @param puntoVentaEntity punto de venta con la informacion actualizada
     * @return el punto de venta con la infomracion actualizada
     */
    public PuntoVentaEntity updatePuntoVenta(Long puntoVentaId, PuntoVentaEntity puntoVentaEntity)    
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el punto de venta con id = {0}", puntoVentaId);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        PuntoVentaEntity newEntity = persistence.update(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el punto de venta con id = {0}", puntoVentaEntity.getId());
        return newEntity;
    }
    
    /**
     * Elimina el punto de venta con el id dado por parametro
     * @param puntoVentaId del cual se queiere eliminar el punto de venta
     * @throws BusinessLogicException  si no se cumplen con las reglas de negocio 
     */
    public void deletePuntoVenta (Long puntoVentaId) throws BusinessLogicException 
        {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el punto de venta con id = {0}", puntoVentaId);
         
        persistence.delete(puntoVentaId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el punto de venta con id = {0}", puntoVentaId);
    }
}
