/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.util.List;

/**
 *
 * @author Andres Forero
 */
public class ModeloDetailDTO extends ModeloDTO{
    
    public ModeloDetailDTO(){}
    
    private List<AutomovilDTO> listaAutos;

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
        this.listaAutos.add(auto);
    }
    
    
    
}
