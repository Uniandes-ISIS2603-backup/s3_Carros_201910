/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Forero
 */
public class ModeloDetailDTO extends ModeloDTO{
    
    
    
    
    public ModeloDetailDTO(){
        super();
    }
    
    private List<AutomovilDTO> listaAutos;
    
    
    
    
    
    
    
    public ModeloDetailDTO(ModeloEntity modelo){
        super(modelo);
        if(modelo != null){
            listaAutos = new ArrayList<>();
            for(AutomovilEntity autoEntity : modelo.getAutomoviles()){
                listaAutos.add(new AutomovilDTO(autoEntity));
            }           
        }
    }
    
    
    public ModeloEntity toEntity(){
        ModeloEntity modelo = super.toEntity();
        if(listaAutos != null){
            List<AutomovilEntity> automoviles = new ArrayList<>();
            for(AutomovilDTO dtoAuto : listaAutos){
                automoviles.add(dtoAuto.toEntity());
            }
            modelo.setAutomoviles(automoviles);
        }
        
        return modelo;
    }

    /**
     * @return the listaAutos
     */
    public List<AutomovilDTO> getListaAutos() {
        return listaAutos;
    }

    /**
     * @param listaAutos the listaAutos to set
     */
    public void setListaAutos(List<AutomovilDTO> listaAutos) {
        this.listaAutos = listaAutos;
    }
    
    /*
    * agrega un auto a la lista de autos
    */
    public void addAuto(AutomovilDTO auto){
        this.getListaAutos().add(auto);
    }

    
    
    
    
}
