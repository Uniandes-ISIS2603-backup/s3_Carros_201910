/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
public class ClienteDetailDTO extends ClienteDTO implements Serializable{
    private List<CompraVentaDTO> listaCompras;
    private List<PuntoVentaDTO> listaPuntosVentas;
    
    public ClienteDetailDTO()
    {  
    }
    
    public ClienteDetailDTO(ClienteEntity entity){
        super(entity);
        if(entity != null){
            if(entity.getCompras() != null){
                listaCompras = new ArrayList<>();
                for(CompraVentaEntity compra : entity.getCompras()){
                    listaCompras.add(new CompraVentaDTO(compra));
                }
            }
            if(entity.getPuntosVenta() != null){
                listaPuntosVentas = new ArrayList<>();
                for(PuntoVentaEntity punto : entity.getPuntosVenta()){
                    listaPuntosVentas.add(new PuntoVentaDTO(punto));
                }
            }
        }
    }
    
    public ClienteEntity toEntity(){
        ClienteEntity entity = super.toEntity();
        if(listaCompras != null){
            List<CompraVentaEntity> comprasEntity = new ArrayList<>();
            for(CompraVentaDTO compraDto : listaCompras){
                comprasEntity.add(compraDto.toEntity());
            }
            entity.setCompras(comprasEntity);
        }
        if(listaPuntosVentas != null){
            List<PuntoVentaEntity> puntosEntity = new ArrayList<>();
            for(PuntoVentaDTO punto : listaPuntosVentas){
                puntosEntity.add(punto.toEntity());
            }
            entity.setPuntosVenta(puntosEntity);
        }
        return entity;
    }
    
    public List<CompraVentaDTO> getListaCompras(){
        return listaCompras;
    }
    
    public void setListaCompras(List<CompraVentaDTO> lista){
        this.listaCompras = lista;
    }
   
    public void addCompra(CompraVentaDTO compra){
        listaCompras.add(compra);
    }

    /**
     * @return the listaPuntosVentas
     */
    public List<PuntoVentaDTO> getListaPuntosVentas() {
        return listaPuntosVentas;
    }

    /**
     * @param listaPuntosVentas the listaPuntosVentas to set
     */
    public void setListaPuntosVentas(List<PuntoVentaDTO> listaPuntosVentas) {
        this.listaPuntosVentas = listaPuntosVentas;
    }
}
