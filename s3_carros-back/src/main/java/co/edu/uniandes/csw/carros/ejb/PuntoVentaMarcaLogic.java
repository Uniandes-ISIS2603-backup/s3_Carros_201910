/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.MarcaPersistence;
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
public class PuntoVentaMarcaLogic
{
     private static final Logger LOGGER = Logger.getLogger(PuntoVentaMarcaLogic.class.getName());

    @Inject
    private MarcaPersistence marcaPersistence;

    @Inject
    private PuntoVentaPersistence puntoVentaPersistence;

    /**
     * Agregar un book a la editorial
     *
     * @param booksId El id libro a guardar
     * @param editorialsId El id de la editorial en la cual se va a guardar el
     * libro.
     * @return El libro creado.
     */
    public MarcaEntity addMarca(Long marcasId, Long puntoVentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle una marca a un punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(  puntoVentaId);
        MarcaEntity marcaEntity = marcaPersistence.findMarca(marcasId);
        marcaEntity.addPuntoVenta(puntoVentaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de roceso de agregarle una marca a un punto de vental con id = {0}", puntoVentaId);
        return marcaEntity;
    }

    /**
     * Retorna todos los books asociados a una editorial
     *
     * @param editorialsId El ID de la editorial buscada
     * @return La lista de libros de la editorial
     */
    public List<MarcaEntity> getMarcas(Long marcasId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar las marcas aosicadas con el punto de venta con id = {0}", marcasId);
        return puntoVentaPersistence.find(marcasId).getMarcas();
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
    public MarcaEntity getMarca(Long puntoVentaId, Long marcaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la marca con id = {0} del punto de venta  con id = " + puntoVentaId, marcaId);
        List<MarcaEntity> marcas = puntoVentaPersistence.find(puntoVentaId).getMarcas();
        MarcaEntity marcaEntity = marcaPersistence.findMarca(marcaId);
        int index = marcas.indexOf(marcaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de  consultar la marca con id = {0} del punto de venta  con id = " + puntoVentaId, marcaId);
        if (index >= 0) {
            return marcas.get(index);
        }
        throw new BusinessLogicException("El marca no esta asociada con el pto de venta");
    }

    /**
     * Remplazar books de una editorial
     *
     * @param books Lista de libros que serán los de la editorial.
     * @param editorialsId El id de la editorial que se quiere actualizar.
     * @return La lista de libros actualizada.
     */

    public List<MarcaEntity> replaceMarcas(Long puntoVentaId, List<MarcaEntity> marcas) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el punto de venta con id = {0}", puntoVentaId);
        PuntoVentaEntity puntoVentaEntity = puntoVentaPersistence.find(puntoVentaId);
        List<MarcaEntity> marcasList = marcaPersistence.findAllMarcas();
        for (MarcaEntity marca : marcasList) {
            if (marcas.contains(marca)) {
                //Falta mirar que no se agregue solamente
                //REVISAR
                marca.addPuntoVenta(puntoVentaEntity);
            } else if (marca.getPuntosVenta()!= null && marca.getPuntosVenta().equals(puntoVentaEntity)) {
                marca.setPuntosVenta(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la editorial con id = {0}", puntoVentaId);
        return marcas;
    }
}
