/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Andres Forero
 */
@Entity
public class AutomovilEntity extends BaseEntity implements Serializable{
    
    
    @PodamExclude
    @ManyToOne
    private ModeloEntity modelo;
   
    
    @PodamExclude
    @OneToOne(mappedBy = "automovil", fetch = LAZY, cascade = CascadeType.ALL)
    private RegistroCompraEntity registroCompra;
    
    
    @PodamExclude
    @OneToOne(mappedBy = "automovilFacturado", fetch = LAZY)
    private CompraVentaEntity compraVenta;
           
    
  
    
    /**
     * disponibilidad del vehiculo dentro del 
     * punto de venta
     */
    private Boolean disponible;
    
    /**
     * tipo "Sedan"|"Campero"|"QP"|"camioneta"...etc
     */
    private String tipo;    
    
    
    /**
     * referencia del vehiculo seguida de la marca
     */
    private String referencia;
    
    /**
     * anio del vehiculo
     */
    private Integer anio;
    
    /**
     * kilometraje(km) del vehiculo
     */
    private Double recorrido;
    
    /**
     * color del vehiculo
     */
    private String color;
    
    /**
     * numero de chasis del vehiculo
     */
    private Integer idChasis;
    
    /**
     * matricula del vehiculo
     * solo placas nacionales
     * "AAA-000"
     */
    private String matricula;
    
    /**
     * cuidad de registro de la matricula
     */
    private String cuidadMatricula;
    
        
    /**
     * precio de venta al publico
     */
    private Double precioVenta;

    
    /**
     * de del punto de venta donde esta el automovil
     */
    private Integer puntoVentaID;
    
    private String imagen;
    
    
    

   
    
    
    
    /**
     * @return the disponible
     */
    public Boolean getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the anio
     */ 
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    /**
     * @return the recorrido
     */
    public Double getRecorrido() {
        return recorrido;
    }

    /**
     * @param recorrido the recorrido to set
     */
    public void setRecorrido(Double recorrido) {
        this.recorrido = recorrido;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the idChasis
     */
    public Integer getIdChasis() {
        return idChasis;
    }

    /**
     * @param idChasis the idChasis to set
     */
    public void setIdChasis(Integer idChasis) {
        this.idChasis = idChasis;
    }

    /**
     * @return the matrcula
     */
    public String getMatrcula() {
        return matricula;
    }

    /**
     * @param matrcula the matrcula to set
     */
    public void setMatrcula(String matrcula) {
        this.matricula = matrcula;
    }

    /**
     * @return the cuidadMatricula
     */
    public String getCuidadMatricula() {
        return cuidadMatricula;
    }

    /**
     * @param cuidadMatricula the cuidadMatricula to set
     */
    public void setCuidadMatricula(String cuidadMatricula) {
        this.cuidadMatricula = cuidadMatricula;
    }

    /**
     * @return the precioVenta
     */
    public Double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the puntoVentaID
     */
    public Integer getPuntoVentaID() {
        return puntoVentaID;
    }

    /**
     * @param puntoVentaID the puntoVentaID to set
     */
    public void setPuntoVentaID(Integer puntoVentaID) {
        this.puntoVentaID = puntoVentaID;
    }

    /**
     * @return the modelo
     */
    public ModeloEntity getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloEntity modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the registroCompra
     */
    public RegistroCompraEntity getRegistroCompra() {
        return registroCompra;
    }

    /**
     * @param registroCompra the registroCompra to set
     */
    public void setRegistroCompra(RegistroCompraEntity registroCompra) {
        this.registroCompra = registroCompra;
    }

    /**
     * @return the compraVenta
     */
    public CompraVentaEntity getCompraVenta() {
        return compraVenta;
    }

    /**
     * @param compraVenta the compraVenta to set
     */
    public void setCompraVenta(CompraVentaEntity compraVenta) {
        this.compraVenta = compraVenta;
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

   
    
    
    
    
    
}
