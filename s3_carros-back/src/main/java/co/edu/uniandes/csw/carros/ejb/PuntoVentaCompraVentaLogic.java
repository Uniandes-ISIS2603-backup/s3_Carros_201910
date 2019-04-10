/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Lozano 
 */
@Stateless
public class PuntoVentaCompraVentaLogic
{
    private static final Logger LOGGER = Logger.getLogger(PuntoVentaEmpleadoLogic.class.getName());
      
    @Inject
    
    private CompraVentaPersistence compraVentaPersistence;

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
    public CompraVentaEntity addVenta(Long clienteId, Long puntoVentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle una venta  a un punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(  puntoVentaId);
        CompraVentaEntity compraVentaEntity = compraVentaPersistence.findByID(clienteId);
        compraVentaEntity.setPuntoVenta(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de roceso de agregarle una venta a un punto de venta con id = {0}", puntoVentaId);
        return compraVentaEntity;
    }

    /**
     * Retorna todos los books asociados a una editorial
     *
     * @param editorialsId El ID de la editorial buscada
     * @return La lista de libros de la editorial
     */
    public List<CompraVentaEntity> getVentas(Long ventaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar las VENTAS s aosicados con el punto de venta con id = {0}", ventaId);
        return puntoVentaPersistence.find(ventaId).getVentas();
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
    public CompraVentaEntity getVenta(Long puntoVentaId, Long ventaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la venta con id = {0} del punto de venta  con id = " + puntoVentaId, ventaId);
        List<CompraVentaEntity> ventas = puntoVentaPersistence.find(puntoVentaId).getVentas();
        CompraVentaEntity compraVENTAEntity = compraVentaPersistence.findByID(ventaId);
        int index = ventas.indexOf(compraVENTAEntity);
        LOGGER.log(Level.INFO, "Termina proceso de  consultar LA VENTA   con id = {0} del punto de venta  con id = " + puntoVentaId, ventaId);
        if (index >= 0) {
            return ventas.get(index);
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

    public List<CompraVentaEntity> replaceVenta(Long puntoVentaId, List<CompraVentaEntity> ventas) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar cliente del punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(puntoVentaId);
        List<CompraVentaEntity> ventasList = compraVentaPersistence.findAll();
        for (CompraVentaEntity venta : ventasList) {
            if (ventas.contains(venta)) {
                //Falta mirar que no se agregue solamente
                //REVISAR
                venta.setPuntoVenta(puntoVentaEntity);
            } else if (venta.getPuntoVenta()!= null && venta.getPuntoVenta().equals(puntoVentaEntity)) {
                venta.setPuntoVenta(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el cliente del punto de venta con id = {0}", puntoVentaId);
        return ventas;
    }
}
