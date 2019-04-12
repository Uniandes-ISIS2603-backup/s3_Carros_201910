/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.MarcaEntity;
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
    
    
    public MarcaDTO(MarcaEntity marcaEntity){
        if(marcaEntity != null){
            this.idMarca = marcaEntity.getId();
            this.nombreMarca = marcaEntity.getNombreMarca();        
            this.imagen = marcaEntity.getImagen();
            this.descripcion= marcaEntity.getDescripcion();
        }
    }
    
    public MarcaEntity toEntity(){
        MarcaEntity marca = new MarcaEntity();
        marca.setId(this.idMarca);
        marca.setNombreMarca(this.nombreMarca);  
        marca.setImagen(this.imagen);
        marca.setDescripcion(this.descripcion);
        return marca;
    }
    
    
    
    /**
     * nombre de la marca de carros
     */
    private String nombreMarca;
    
    /**
     * id de la marca dentro del concecionario
     */
    private Long idMarca;
    
    private String imagen;
    
    private String descripcion; 
    
    

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
    public Long getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
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
