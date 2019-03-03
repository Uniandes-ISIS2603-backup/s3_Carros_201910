/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.FacturaEntity;
import co.edu.uniandes.csw.carros.persistence.FacturaPersistence;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.inject.Inject;

/**
 *
 * @author Kevin Hernán Castrillón Castañeda.
 */
public class FacturaLogic 
{
    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());

    @Inject
    private  FacturaPersistence persistence;

    /**
     * Se encarga de crear una Factura en la base de datos.
     *
     * @param facturaEntity Objeto de FacturaEntity con los datos nuevos
     * @return Objeto de FacturaEntity con los datos nuevos y su ID.
     */
    public FacturaEntity createFactura(FacturaEntity facturaEntity) 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la Factura");
        FacturaEntity newFacturaEntity = persistence.create(facturaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la Factura");
        return newFacturaEntity;
    }

    /**
     * Obtiene la lista de los registros de Factura.
     *
     * @return Colección de objetos de FacturaEntity.
     */
    public List<FacturaEntity> getFacturas() 
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las Factura");
        List<FacturaEntity> lista = persistence.findAll();
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
        FacturaEntity facturaEntity = persistence.findByID(facturaId);
        if (facturaEntity == null) {
            LOGGER.log(Level.SEVERE, "La Factura con el id = {0} no existe", facturaId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la Factura con id = {0}", facturaId);
        return facturaEntity;
    }
}
