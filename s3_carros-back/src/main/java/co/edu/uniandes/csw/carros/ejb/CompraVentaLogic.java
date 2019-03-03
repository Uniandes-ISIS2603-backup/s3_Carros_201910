/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Hernán Castrillón Castañeda.
 */
public class CompraVentaLogic 
{
    private static final Logger LOGGER = Logger.getLogger(CompraVentaLogic.class.getName());

    @Inject
    private  CompraVentaPersistence persistence;

    /**
     * Se encarga de crear una CompraVenta en la base de datos.
     *
     * @param compraVentaEntity Objeto de CompraVentaEntity con los datos nuevos
     * @return Objeto de CompraVentaEntity con los datos nuevos y su ID.
     */
    public CompraVentaEntity createCompraVenta(CompraVentaEntity compraVentaEntity) 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la compraVenta");
        CompraVentaEntity newCompraVentaEntity = persistence.create(compraVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la compraVenta");
        return newCompraVentaEntity;
    }

    /**
     * Obtiene la lista de los registros de CompraVenta.
     *
     * @return Colección de objetos de CompraVentaEntity.
     */
    public List<CompraVentaEntity> getCompraVentas() 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las compraVentas");
        List<CompraVentaEntity> lista = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos las compraVentas");
        return lista;
    }

    /**
     * Obtiene los datos de una instancia de CompraVenta a partir de su ID.
     *
     * @param compraVentaId Identificador de la instancia a consultar
     * @return Instancia de CompraVentaEntity con los datos de la CompraVenta consultada.
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
     * @return Instancia de CompraVentaEntity con los datos actualizados.
     */
    public CompraVentaEntity updateCompraVenta(Long compraVentaId, CompraVentaEntity compraVentaEntity) 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la CompraVenta con id = {0}", compraVentaId);
        CompraVentaEntity newCompraVentaEntity = persistence.update(compraVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la CompraVenta con id = {0}", compraVentaId);
        return newCompraVentaEntity;
    }
}
