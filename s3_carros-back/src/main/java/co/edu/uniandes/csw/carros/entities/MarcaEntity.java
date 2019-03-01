/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Andres Forero
 */
@Entity     
public class MarcaEntity extends BaseEntity{    
    
    @PodamExclude                                 
    @ManyToMany
    private List<PuntoVentaEntity> puntosVenta = new ArrayList<>();
    
    
    @PodamExclude
    @OneToMany(mappedBy = "marca", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ModeloEntity> modelos = new ArrayList<>();
    
    
    
    
    public MarcaEntity(){}
    
    
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
    
    
    
}
