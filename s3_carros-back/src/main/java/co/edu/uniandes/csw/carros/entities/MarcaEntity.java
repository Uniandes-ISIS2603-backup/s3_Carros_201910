/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
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
public class MarcaEntity extends BaseEntity implements Serializable{    

/**
     * nombre de la marca
     */
    private String nombreMarca;
    
    private String imagen;
    
    private String descripcion;
    
    
    @PodamExclude                                 
    @ManyToMany
    private List<PuntoVentaEntity> puntosVenta = new ArrayList<>();
    
    
    @PodamExclude
    @OneToMany(mappedBy = "marca", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ModeloEntity> modelos = new ArrayList<>();
       

    
    

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
     * @return the puntosVenta
     */
    public List<PuntoVentaEntity> getPuntosVenta() {
        return puntosVenta;
    }

    /**
     * @param puntosVenta the puntosVenta to set
     */
    public void setPuntosVenta(List<PuntoVentaEntity> puntosVenta) {
        this.puntosVenta = puntosVenta;
    }
       
    public void addPuntoVenta(PuntoVentaEntity nuevoPuntoVenta)
    {
        this.puntosVenta.add(nuevoPuntoVenta);
    }
    /**
     * @return the modelos
     */
    public List<ModeloEntity> getModelos() {
        return modelos;
    }

    /**
     * @param modelos the modelos to set
     */
    public void setModelos(List<ModeloEntity> modelos) {
        this.modelos = modelos;
    }
    
    public void addModelo(ModeloEntity modelo)
    {
        this.modelos.add(modelo);
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
