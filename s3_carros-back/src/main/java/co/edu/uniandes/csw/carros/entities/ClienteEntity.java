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
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
@Entity
public class ClienteEntity extends BaseEntity implements Serializable{
    
    private String nombre;
    private String correo;
    private String telefono;
    
    //@PodamExclude
    //@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    //private List<CompraVentaEntity> compras = new ArrayList<CompraVentaEntity>();
    
    //@PodamExclude
    //@ManyToMany(mappedBy = "clientes", cascade = CascadeType.PERSIST, orphanRemoval = true)
    //private List<PuntoVentaEntity> puntos = new ArrayList<PuntoVentaEntity>();
    
    
    public ClienteEntity(){
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the compras
     */
    //public List<CompraVentaEntity> getCompras() {
    //    return compras;
    //}

    /**
     * @param compras the compras to set
     */
    //public void setCompras(List<CompraVentaEntity> compras) {
    //    this.compras = compras;
    //}
    
    //public void addCompra(CompraVentaEntity compra){
    //    compras.add(compra);
    //}
}
