/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.carros.persistence.ClientePersistence;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
import co.edu.uniandes.csw.carros.persistence.EmpleadoPersistence;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.inject.Inject;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de CompraVenta.
 *
 * @author Kevin Hernán Castrillón Castañeda.
 */
@Stateless
public class CompraVentaLogic 
{
    private static final Logger LOGGER = Logger.getLogger(CompraVentaLogic.class.getName());

    @Inject
    private CompraVentaPersistence persistence;
    
    @Inject
    private PuntoVentaPersistence puntoVentaPersistence;
    
    @Inject
    private ClientePersistence clientePersistence;
    
    @Inject
    private EmpleadoPersistence empleadoPersistence;
    
    @Inject
    private AutomovilPersistence automovilPersistence;

    /**
     * Crea una compraVenta en la persistencia.
     *
     * @param compraVentaEntity La entidad que representa la compraVenta a
     * persistir.
     * @return La entidad de la compraVenta luego de persistirla.
     * @throws BusinessLogicException Si la compraVenta a persistir ya existe o si PuntoVenta, Cliente, Empleado o Automovil no existen en la base de datos.
     */
    public CompraVentaEntity createCompraVenta(CompraVentaEntity compraVentaEntity) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la compraVenta");
        if (compraVentaEntity == null) 
        {
            throw new BusinessLogicException("La CompraVenta es null.");
        }
        if(compraVentaEntity.getPuntoVenta() == null) 
        {
            throw new BusinessLogicException("El puntoVenta es null.");
        }
        if(puntoVentaPersistence.find(compraVentaEntity.getPuntoVenta().getId()) == null) 
        {
            throw new BusinessLogicException("El puntoVenta no existe en la base de datos.");
        }
        if(compraVentaEntity.getCliente() == null) 
        {
            throw new BusinessLogicException("El cliente es null.");
        }
        if(clientePersistence.findCliente(compraVentaEntity.getCliente().getId()) == null) 
        {
            throw new BusinessLogicException("El cliente no existe en la base de datos.");
        }
        if(compraVentaEntity.getAutomovilFacturado() == null) 
        {
            throw new BusinessLogicException("El automovil es null.");
        }
        if(automovilPersistence.findAutomovil(compraVentaEntity.getAutomovilFacturado().getId()) == null) 
        {
            throw new BusinessLogicException("El automovil no existe en la base de datos.");
        }
        if(compraVentaEntity.getEmpleado() != null)
        {
            compraVentaEntity.setEmpleado(empleadoPersistence.findEmpleado(compraVentaEntity.getEmpleado().getId()));
        }
        compraVentaEntity.setPuntoVenta(puntoVentaPersistence.find(compraVentaEntity.getPuntoVenta().getId()));
        compraVentaEntity.setCliente(clientePersistence.findCliente(compraVentaEntity.getCliente().getId()));
        compraVentaEntity.setAutomovilFacturado(automovilPersistence.findAutomovil(compraVentaEntity.getAutomovilFacturado().getId()));
        CompraVentaEntity compra = persistence.create(compraVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la compraVenta");
        return compra;
    }

    /**
     * Obtiene todas las CompraVentas existentes en la base de datos.
     *
     * @return una lista de compraVentas.
     */
    public List<CompraVentaEntity> getCompraVentas() 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las compraVentas");
        List<CompraVentaEntity> compraVentas = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos las compraVentas");
        return compraVentas;
    }

    /**
     * Obtiene una CompraVenta a partir de su ID.
     *
     * @param compraVentaId Identificador de la instancia a consultar
     * @return la CompraVenta solicitada por medio de su ID.
     */
    public CompraVentaEntity getCompraVenta(Long compraVentaId) 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la CompraVenta con id = {0}", compraVentaId);
        CompraVentaEntity compraVentaEntity = persistence.findByID(compraVentaId);
        if (compraVentaEntity == null) {
            LOGGER.log(Level.SEVERE, "La CompraVenta con el id = {0} no existe", compraVentaId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la CompraVenta con id = {0}", compraVentaId);
        return compraVentaEntity;
    }

    /**
     * Actualiza la información de una instancia de CompraVenta.
     *
     * @param compraVentaId Identificador de la instancia a actualizar
     * @param compraVentaEntity Instancia de CompraVentaEntity con los nuevos datos.
     * @return Instancia de CompraVentaEntity con los datos actualizados en la base de datos.
     */
    public CompraVentaEntity updateCompraVenta(Long compraVentaId, CompraVentaEntity compraVentaEntity) 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la CompraVenta con id = {0}", compraVentaId);
        CompraVentaEntity newCompraVentaEntity = persistence.update(compraVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la CompraVenta con id = {0}", compraVentaEntity.getId());
        return newCompraVentaEntity;
    }
}
