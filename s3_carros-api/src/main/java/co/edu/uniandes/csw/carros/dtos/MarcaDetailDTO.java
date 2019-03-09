/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Forero
 */
public class MarcaDetailDTO extends MarcaDTO implements Serializable{
    
    
    /**
     * constructor vacio
     */
    public MarcaDetailDTO(){
        super();
    }
    
    /**
     * lista de modelos  asociados a esta marca
     */
    private List<ModeloDTO> listaModelo;
    
    
    private List<PuntoVentaDTO> listaPuntosVenta;

    
    public MarcaDetailDTO(MarcaEntity marca){
        super(marca);
        if(marca != null){
            listaModelo = new ArrayList<>();
            for(ModeloEntity modelo : marca.getModelos()){
                listaModelo.add(new ModeloDTO(modelo));
            }
            listaPuntosVenta = new ArrayList<>();
            for(PuntoVentaEntity punto : marca.getPuntosVenta()){
                listaPuntosVenta.add(new PuntoVentaDTO(punto));
            }
        }
    }
    
    
    public MarcaEntity toEntity(){
        MarcaEntity marcaEntidad = super.toEntity();
        if(listaModelo != null){
            List<ModeloEntity> modelosEntidad = new ArrayList<>();
            for(ModeloDTO dtoModelo : listaModelo){
                modelosEntidad.add(dtoModelo.toEntity());
            }
            marcaEntidad.setModelos(modelosEntidad);
        }
        
        if(listaPuntosVenta != null){
            List<PuntoVentaEntity> puntosEntidad = new ArrayList<>();
            for(PuntoVentaDTO dtoPunto: listaPuntosVenta){
                puntosEntidad.add(dtoPunto.toEntity());
            }
            marcaEntidad.setPuntosVenta(puntosEntidad);
        }
        
        return marcaEntidad;
    }
    
    
    /**
     * @return the listaModelo
     */
    public List<ModeloDTO> getListaModelo() {
        return listaModelo;
    }

    /**
     * @param listaModelo the listaModelo to set
     */
    public void setListaModelo(List<ModeloDTO> listaModelo) {
        this.listaModelo = listaModelo;
    }

    public void addModelo(ModeloDTO modelo){
        this.getListaModelo().add(modelo);
    }    

    /**
     * @return the listaPuntosVenta
     */
    public List<PuntoVentaDTO> getListaPuntosVenta() {
        return listaPuntosVenta;
    }

    /**
     * @param listaPuntosVenta the listaPuntosVenta to set
     */
    public void setListaPuntosVenta(List<PuntoVentaDTO> listaPuntosVenta) {
        this.listaPuntosVenta = listaPuntosVenta;
    }
}
