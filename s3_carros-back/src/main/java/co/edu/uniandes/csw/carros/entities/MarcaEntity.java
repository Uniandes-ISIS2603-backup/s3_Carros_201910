/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import javax.persistence.Entity;

/**
 *
 * @author estudiante
 */
@Entity
public class MarcaEntity extends BaseEntity{
    
    
    
    
    public MarcaEntity(){}
    
    private String nombreMarca;

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
    
}
