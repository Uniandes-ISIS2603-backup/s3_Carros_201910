/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.QuejasReclamosPersistence;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la relación entre
 * la entidad de CompraVenta y QuejasReclamos.
 * @author Kevin Hernán Castrillón Castañeda
 */
@Stateless
public class CompraVentaQuejasLogic 
{
    private static final Logger LOGGER = Logger.getLogger(CompraVentaQuejasLogic.class.getName());

    @Inject
    private QuejasReclamosPersistence quejaPersistence;

    @Inject
    private CompraVentaPersistence compraVentaPersistence;
    
    /**
     * Agregar una queja a la compraVenta
     *
     * @param quejaId El id queja a guardar
     * @param compraVentaId El id de la compraVenta en la cual se va a guardar la
     * queja.
     * @return La queja creada.
     */
    public QuejasReclamosEntity addQueja(Long quejaId, Long compraVentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle una queja a la compraVenta con id = {0}", compraVentaId);
        CompraVentaEntity compraVentaEntity = compraVentaPersistence.findByID(compraVentaId);
        QuejasReclamosEntity quejaEntity = quejaPersistence.find(quejaId);
        quejaEntity.setCompraVenta(compraVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle una queja a la compraVenta con id = {0}", compraVentaId);
        return quejaEntity;
    }
    
    /**
     * Retorna todas las quejas asociadas a una compraVenta
     *
     * @param compraVentaId El ID de la compraVenta buscada
     * @return La lista de quejas de cliente de la compraVenta
     */
    public List<QuejasReclamosEntity> getQuejas(Long compraVentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar las quejas de cliente asociadas a la compraVenta con id = {0}", compraVentaId);
        return compraVentaPersistence.findByID(compraVentaId).getQuejasReclamos();
    }
    
    /**
     * Retorna todas las quejas de un empleado asociadas a una compraVenta
     *
     * @param compraVentaId El ID de la compraVenta buscada
     * @return La lista de quejas de empleado de la compraVenta
     */
//    public List<QuejasReclamosEntity> getQuejasEmpleado(Long compraVentaId) {
//        LOGGER.log(Level.INFO, "Inicia proceso de consultar las quejas de empleado asociadas a la compraVenta con id = {0}", compraVentaId);
//        return compraVentaPersistence.findByID(compraVentaId).getQuejasReclamos();
//    }
    
    /**
     * Retorna una queja asociada a una compraVenta
     *
     * @param compraVentaId El id de la compraVenta a buscar.
     * @param quejaId El id de la queja a buscar
     * @return La queja encontrada dentro de la compraVenta.
     * @throws BusinessLogicException Si la queja no se encuentra en la
     * compraVenta
     */
    public QuejasReclamosEntity getQueja(Long compraVentaId, Long quejaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la queja con id = {0} de la compraVenta con id = " + compraVentaId, quejaId);
        List<QuejasReclamosEntity> quejas = compraVentaPersistence.findByID(compraVentaId).getQuejasReclamos();
        QuejasReclamosEntity quejaEntity = quejaPersistence.find(quejaId);
        int index = quejas.indexOf(quejaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar la queja con id = {0} de la compraVenta con id = " + compraVentaId, quejaId);
        if (index >= 0) {
            return quejas.get(index);
        }
        throw new BusinessLogicException("La queja no está asociada a la cmpraVenta");
    }
    
    /**
     * Retorna una queja de un empleado asociada a una compraVenta
     *
     * @param compraVentaId El id de la compraVenta a buscar.
     * @param quejaId El id de la queja a buscar
     * @return La queja encontrada dentro de la compraVenta.
     * @throws BusinessLogicException Si la queja no se encuentra en la
     * compraVenta
     */
//    public QuejasReclamosEntity getQuejaEmpleado(Long compraVentaId, Long quejaId) throws BusinessLogicException {
//        LOGGER.log(Level.INFO, "Inicia proceso de consultar la queja con id = {0} de la compraVenta con id = " + compraVentaId, quejaId);
//        List<QuejasReclamosEntity> quejas = compraVentaPersistence.findByID(compraVentaId).getQuejasReclamos();
//        QuejasReclamosEntity quejaEntity = quejaPersistence.find(quejaId);
//        int index = quejas.indexOf(quejaEntity);
//        LOGGER.log(Level.INFO, "Termina proceso de consultar la queja con id = {0} de la compraVenta con id = " + compraVentaId, quejaId);
//        if (index >= 0) {
//            return quejas.get(index);
//        }
//        throw new BusinessLogicException("La queja no está asociada a la cmpraVenta");
//    }
}
