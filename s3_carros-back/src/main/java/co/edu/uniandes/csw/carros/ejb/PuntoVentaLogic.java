/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Lozano
 */
@Stateless
public class PuntoVentaLogic
{
    @Inject
    private PuntoVentaPersistence persistence; 
    
    public PuntoVentaEntity createPuntoVenta(PuntoVentaEntity puntoVenta) throws BusinessLogicException
    {
        if(persistence.findByDireccion(puntoVenta.getDireccion())!= null)
        {
            throw new BusinessLogicException("Ya existe un Punto de venta con la direccion:  "+ puntoVenta.getDireccion());
        }
        puntoVenta = persistence.create(puntoVenta);
        return puntoVenta;
    }
    
}
