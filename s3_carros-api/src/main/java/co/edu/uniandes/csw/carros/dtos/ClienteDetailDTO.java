/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.io.Serializable;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
public class ClienteDetailDTO extends ClienteDTO implements Serializable{
    private List<CompraVentaDTO> listaCompras;
    private List<PuntoVentaDTO> listaPuntosVentas;
    private static final Logger LOGGER = Logger.getLogger(ClienteDTO.class.getName());
    /**
     * Constructor por defecto
     */
    public ClienteDetailDTO(){  
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     */
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
    
    /**
     * Transformar un DTO a un Entity
     */
    public ClienteEntity toEntity(){
        LOGGER.log(Level.INFO, "To entity ClienteDetail");
        ClienteEntity entity = super.toEntity();
        LOGGER.log(Level.INFO, "To entity Cliente 1 "+entity.getCorreo() + "  " + entity.getNombre() + "  " + entity.getTelefono());
        if(listaCompras != null)
        {
            LOGGER.log(Level.INFO, "To entity Cliente if");
            List<CompraVentaEntity> comprasEntity = new ArrayList<>();
            for(CompraVentaDTO compraDto : listaCompras){
                LOGGER.log(Level.INFO, "To entity Cliente for");
                comprasEntity.add(compraDto.toEntity());
            }
            LOGGER.log(Level.INFO, "To entity Cliente sale for");
            entity.setCompras(comprasEntity);
            LOGGER.log(Level.INFO, "To entity Cliente 2");
        }
        LOGGER.log(Level.INFO, "To entity Cliente sale if else");
        if(listaPuntosVentas != null)
        {
            LOGGER.log(Level.INFO, "To entity Cliente if 2");
            List<PuntoVentaEntity> puntosEntity = new ArrayList<>();
            for(PuntoVentaDTO punto : listaPuntosVentas){
                LOGGER.log(Level.INFO, "To entity Cliente for 2");
                puntosEntity.add(punto.toEntity());
            }
            LOGGER.log(Level.INFO, "To entity Cliente sale for");
            entity.setPuntosVenta(puntosEntity);
        }
        LOGGER.log(Level.INFO, "To entity Cliente sale if else");
        return entity;
    }
    
    /**
     * Devuelve la lista de las compras de un cliente.
     */
    public List<CompraVentaDTO> getListaCompras(){
        return listaCompras;
    }
    
     /**
     * Modifica la lista de las compras de un cliente.
     */
    public void setListaCompras(List<CompraVentaDTO> lista){
        this.listaCompras = lista;
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
    
    public void addPuntoVenta(PuntoVentaDTO pv){
        this.listaPuntosVentas.add(pv);
    }
    
    public void addCompra(CompraVentaDTO c){
        this.listaCompras.add(c);
    }
}
