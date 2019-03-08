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
    
    public EmpleadoDetailDTO(){    
    }
    
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
    
    public List<CompraVentaDTO> getListaVentas(){
        return listaVentas;
    }
    
    public void setListaVentas(List<CompraVentaDTO> lista){
        this.listaVentas = lista;
    }
    
    public void addVenta(CompraVentaDTO venta){
        listaVentas.add(venta);
    }
    
    
}
