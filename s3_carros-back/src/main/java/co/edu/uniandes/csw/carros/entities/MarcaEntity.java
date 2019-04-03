/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Andres Forero
 */
@Entity     
public class MarcaEntity extends BaseEntity implements Serializable{    
  
    @PodamExclude                                 
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AutomovilEntity> automoviles = new ArrayList<>();
       
    /**
     * nombre de la marca
     */
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

    /**
     * @return the automoviles
     */
    public List<AutomovilEntity> getAutomoviles() {
        return automoviles;
    }

    /**
     * @param automoviles the automoviles to set
     */
    public void setAutomoviles(List<AutomovilEntity> automoviles) {
        this.automoviles = automoviles;
    }
    
    
    
}
