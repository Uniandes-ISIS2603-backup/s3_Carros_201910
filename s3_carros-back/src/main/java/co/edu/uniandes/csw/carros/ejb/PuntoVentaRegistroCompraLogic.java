/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
import co.edu.uniandes.csw.carros.persistence.RegistroCompraPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel lozano
 */
@Stateless
public class PuntoVentaRegistroCompraLogic 
{
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaEmpleadoLogic.class.getName());
      
    @Inject  
    private RegistroCompraPersistence registroCompraPersistence;

    @Inject
    private PuntoVentaPersistence   puntoVentaPersistence;

    /**
     * Agregar un book a la editorial
     *
     * @param booksId El id libro a guardar
     * @param editorialsId El id de la editorial en la cual se va a guardar el
     * libro.
     * @return El libro creado.
     */
    public RegistroCompraEntity addCompra(Long compraId, Long puntoVentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle una compra  a un punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(  puntoVentaId);
        RegistroCompraEntity registroCompraEntity = registroCompraPersistence.find(compraId);
        registroCompraEntity.setPuntoVenta(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de roceso de agregarle una compra a un punto de venta con id = {0}", puntoVentaId);
        return registroCompraEntity;
    }

    /**
     * Retorna todos los books asociados a una editorial
     *
     * @param editorialsId El ID de la editorial buscada
     * @return La lista de libros de la editorial
     */
    public List<RegistroCompraEntity> getCompras(Long ventaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar las compras s aosicados con el punto de venta con id = {0}", ventaId);
        return puntoVentaPersistence.find(ventaId).getCompras();
    }

    /**
     * Retorna un book asociado a una editorial
     *
     * @param editorialsId El id de la editorial a buscar.
     * @param booksId El id del libro a buscar
     * @return El libro encontrado dentro de la editorial.
     * @throws BusinessLogicException Si el libro no se encuentra en la
     * editorial
     */
    public RegistroCompraEntity getCompra(Long puntoVentaId, Long compraID) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la compra con id = {0} del punto de venta  con id = " + puntoVentaId, compraID);
        List<RegistroCompraEntity> compras = puntoVentaPersistence.find(puntoVentaId).getCompras();
        RegistroCompraEntity registroCompraEntity = registroCompraPersistence.find(compraID);
        int index = compras.indexOf(registroCompraEntity);
        LOGGER.log(Level.INFO, "Termina proceso de  consultar LA compra   con id = {0} del punto de venta  con id = " + puntoVentaId, compraID);
        if (index >= 0) {
            return compras.get(index);
        }
        throw new BusinessLogicException("El empleado no esta asociado con el pto de venta");
    }

    /**
     * Remplazar books de una editorial
     *
     * @param books Lista de libros que serán los de la editorial.
     * @param editorialsId El id de la editorial que se quiere actualizar.
     * @return La lista de libros actualizada.
     */

    public List<RegistroCompraEntity> replaceCompra(Long puntoVentaId, List<RegistroCompraEntity> compras) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una compra del punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(puntoVentaId);
        List<RegistroCompraEntity> comprasList = registroCompraPersistence.findAll();
        for (RegistroCompraEntity compra : comprasList) {
            if (compras.contains(compra)) {
                //Falta mirar que no se agregue solamente
                //REVISAR
                compra.setPuntoVenta(puntoVentaEntity);
            } else if (compra.getPuntoVenta()!= null && compra.getPuntoVenta().equals(puntoVentaEntity)) {
                compra.setPuntoVenta(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la compra del punto de venta con id = {0}", puntoVentaId);
        return compras;
    }
}
