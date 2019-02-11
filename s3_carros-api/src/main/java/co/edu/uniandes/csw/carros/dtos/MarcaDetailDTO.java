/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class MarcaDetailDTO extends MarcaDTO implements Serializable{
    
    
    /**
     * constructor vacio
     */
    public MarcaDetailDTO(){}
    
    /**
     * lista de autos asociados a esta marca
     */
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
    
    public void addAutomovil(AutomovilDTO auto){
        this.listaAutos.add(auto);
    }
    
    
    
    
}
