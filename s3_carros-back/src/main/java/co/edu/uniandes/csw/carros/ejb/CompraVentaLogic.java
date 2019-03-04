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

/**
 * Clase que implementa la conexion con la persistencia para la entidad de CompraVenta.
 *
 * @author Kevin Hernán Castrillón Castañeda.
 */
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
     * @return La entiddad de la compraVenta luego de persistirla.
     * @throws BusinessLogicException Si la compraVenta a persistir ya existe.
     */
    public CompraVentaEntity createCompraVenta(CompraVentaEntity compraVentaEntity) throws BusinessLogicException 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la compraVenta");
        if (persistence.findByID(compraVentaEntity.getId()) != null) 
        {
            throw new BusinessLogicException("Ya existe una CompraVenta con el ID \"" + compraVentaEntity.getId() + "\"");
        }
        if(compraVentaEntity.getPuntoVenta() == null || puntoVentaPersistence.find(compraVentaEntity.getPuntoVenta().getId()) == null) 
        {
            throw new BusinessLogicException("El puntoVenta es inválido.");
        }
        if(compraVentaEntity.getCliente() == null ||clientePersistence.findCliente(compraVentaEntity.getCliente().getId()) == null) 
        {
            throw new BusinessLogicException("El cliente es inválido.");
        }
        if(compraVentaEntity.getEmpleado() == null || empleadoPersistence.findEmpleado(compraVentaEntity.getEmpleado().getId()) == null) 
        {
            throw new BusinessLogicException("El empleado es inválido.");
        }
        if(compraVentaEntity.getAutomovilFacturado() == null || automovilPersistence.findAutomovil(compraVentaEntity.getAutomovilFacturado().getId()) == null) 
        {
            throw new BusinessLogicException("El automovil es inválido.");
        }
        persistence.create(compraVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la compraVenta");
        return compraVentaEntity;
        
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
