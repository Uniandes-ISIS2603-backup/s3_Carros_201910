/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
public class EmpleadoDetailDTO extends EmpleadoDTO implements Serializable{
    
    private List<CompraVentaDTO> listaVentas;
    
    /**
     * Constructor por defecto
     */
    public EmpleadoDetailDTO(){    
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     */
    public EmpleadoDetailDTO(EmpleadoEntity entity){
        super(entity);
        if(entity != null){
            if(entity.getVentas() != null){
                listaVentas = new ArrayList<>();
                for(CompraVentaEntity entityVenta : entity.getVentas()){
                    listaVentas.add(new CompraVentaDTO(entityVenta));
                }
            }
        }
    }
    
     /**
     * Transformar un DTO a un Entity
     */
    public EmpleadoEntity toEntity(){
        EmpleadoEntity empleadoEntity = super.toEntity();
        if(listaVentas != null){
            List<CompraVentaEntity> ventasEntity = new ArrayList<>();
            for(CompraVentaDTO dtoVenta : listaVentas){
                ventasEntity.add(dtoVenta.toEntity());
            }
            empleadoEntity.setVentas(ventasEntity);
        }
        return empleadoEntity;
    }
    
     /**
     * Devuelve la lista de las ventas del empleado.
     */
    public List<CompraVentaDTO> getListaVentas(){
        return listaVentas;
    }
    
     /**
     * Modifica la lista de lasa ventas del empleado.
     */
    public void setListaVentas(List<CompraVentaDTO> lista){
        this.listaVentas = lista;
    }
    
    public void addVenta(CompraVentaDTO venta){
        this.listaVentas.add(venta);
    }
    
    
}
