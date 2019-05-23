/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.FacturaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
import co.edu.uniandes.csw.carros.persistence.FacturaPersistence;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de Factura.
 *
 * @author Kevin Hernán Castrillón Castañeda.
 */
public class FacturaLogic 
{
    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());

    @Inject
    private  FacturaPersistence facturaPersistence;
    
    @Inject
    private CompraVentaPersistence compraVentaPersistence;

    /**
     * Guardar una nueva factura
     *
     * @param facturaEntity La entidad de tipo factura de la nueva factura a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si la factura ya existe en la persistencia 
     *         si no existe la CompraVenta asociada en la presiistencia.
     *         NullPointerException si la CompraVenta es null.
     */
    public FacturaEntity createFactura(FacturaEntity facturaEntity) throws BusinessLogicException, NullPointerException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la Factura");
        if (facturaEntity.getCompraVenta() == null) {
            throw new NullPointerException("La compraVenta es null.");
        }
        if (compraVentaPersistence.findByID(facturaEntity.getCompraVenta().getId()) == null) {
            throw new BusinessLogicException("La compraVenta no existe en la base de datos.");
        }
        facturaPersistence.create(facturaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la Factura");
        return facturaEntity;
    }

    /**
     * Devuelve todas las facturas que hay en la base de datos.
     *
     * @return Lista de entidades de tipo factura.
     */
    public List<FacturaEntity> getFacturas() 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las Factura");
        List<FacturaEntity> lista = facturaPersistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos las Factura");
        return lista;
    }

    /**
     * Obtiene los datos de una instancia de Factura a partir de su ID.
     *
     * @param facturaId Identificador de la instancia a consultar
     * @return Instancia de FacturaEntity con los datos de la Factura consultada.
     */
    public FacturaEntity getFactura(Long facturaId) 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la Factura con id = {0}", facturaId);
        FacturaEntity facturaEntity = facturaPersistence.findByID(facturaId);
        if (facturaEntity == null) {
            LOGGER.log(Level.SEVERE, "La Factura con el id = {0} no existe", facturaId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la Factura con id = {0}", facturaId);
        return facturaEntity;
    }
}
