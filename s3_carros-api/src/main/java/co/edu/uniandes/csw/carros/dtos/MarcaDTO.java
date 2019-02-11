/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class MarcaDTO implements Serializable{
    
    
    /**
     * constrictor vacio
     */
    public MarcaDTO(){}
    
    /**
     * nombre de la marca de carros
     */
    private String nombreMarca;
    
    /**
     * id de la marca dentro del concecionario
     */
    private Integer idMarca;

    /**
     * @return the nombreMarca
     */
    public String getNombreMarca() {
        return nombreMarca;
    }

    /**
     * @param nombreMarca the nombreMarca to set
     */
    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    /**
     * @return the idMarca
     */
    public Integer getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }
    
    
}
