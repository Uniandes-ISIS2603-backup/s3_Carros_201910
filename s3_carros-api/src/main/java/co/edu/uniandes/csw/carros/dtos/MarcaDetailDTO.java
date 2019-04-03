/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.entities.MarcaEntity;
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
    private List<AutomovilDTO> listaAutomoviles;
    
    
    

    
    public MarcaDetailDTO(MarcaEntity marca){
        super(marca);
        if(marca != null){
            listaAutomoviles = new ArrayList<>();
            for(AutomovilEntity auto : marca.getAutomoviles()){
                listaAutomoviles.add(new AutomovilDTO(auto));
            }           
        }
    }
    
    
    public MarcaEntity toEntity(){
        MarcaEntity marcaEntidad = super.toEntity();
        if(listaAutomoviles != null){
            List<AutomovilEntity> automoviles= new ArrayList<>();
            for(AutomovilDTO dtoAuto : listaAutomoviles){
                automoviles.add(dtoAuto.toEntity());
            }
            marcaEntidad.setAutomoviles(automoviles);
        }       
        return marcaEntidad;
    }
    
    
    /**
     * @return the listaAutomoviles
     */
    public List<AutomovilDTO> getListaAutomoviles() {
        return listaAutomoviles;
    }

    /**
     * @param listaAutomoviles the listaModelo to set
     */
    public void setListaAutomoviles(List<AutomovilDTO> listaAutos) {
        this.listaAutomoviles = listaAutos;
    }

    public void addAutomovil(AutomovilDTO auto){
        this.listaAutomoviles.add(auto);
    }
    
}
