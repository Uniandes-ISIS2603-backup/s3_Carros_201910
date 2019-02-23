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
public class AutomovilEntity extends BaseEntity{
    
    
   public AutomovilEntity(){}
    
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
    private String matrcula;
    
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
    
    
    /**
     * modelo del automovil
     */
    private Modelo modelo;

   
    
    
    
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
        return matrcula;
    }

    /**
     * @param matrcula the matrcula to set
     */
    public void setMatrcula(String matrcula) {
        this.matrcula = matrcula;
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
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    
    
    
    
}
