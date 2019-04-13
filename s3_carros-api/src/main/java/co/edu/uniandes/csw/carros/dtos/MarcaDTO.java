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
            this.imagen_marca = marcaEntity.getImagen_marca();
        }
    }
    
    public MarcaEntity toEntity(){
        MarcaEntity marca = new MarcaEntity();
        marca.setId(this.idMarca);
        marca.setNombreMarca(this.nombreMarca);
        marca.setImagen_marca(this.imagen_marca);
        return marca;
    }
    
    
    /**
     * ruta de la imagen de la marca
     */
    private String imagen_marca;
    
    
    /**
     * nombre de la marca de carros
     */
    private String nombreMarca;
    
    /**
     * id de la marca dentro del concecionario
     */
    private Long idMarca;

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
     * @return the imagen_marca
     */
    public String getImagen_marca() {
        return imagen_marca;
    }

    /**
     * @param imagen_marca the imagen_marca to set
     */
    public void setImagen_marca(String imagen_marca) {
        this.imagen_marca = imagen_marca;
    }

    
    
    
}
