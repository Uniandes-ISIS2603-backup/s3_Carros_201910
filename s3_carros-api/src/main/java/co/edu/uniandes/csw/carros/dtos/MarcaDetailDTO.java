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
 * @author Andres Forero
 */
public class MarcaDetailDTO extends MarcaDTO implements Serializable{
    
    
    /**
     * constructor vacio
     */
    public MarcaDetailDTO(){}
    
    /**
     * lista de modelos  asociados a esta marca
     */
    private List<ModeloDTO> listaModelo;

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
        this.listaModelo.add(modelo);
    }    
}
