/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;
import java.io.Serializable;

/**
 *
 * @author Andres Forero
 */
public class AutomovilDTO  implements Serializable{
    
    /**
     * identificador unico de un automovil dentro del 
     * concesionario
     */
    private Long autoId;
    
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
     * nombre de la marca del vehiculo
     */
    private String marca;
    
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
     * precio de compra por parte del concesionario 
     */
    private Double precioComprado;
    
    /**
     * precio de venta al publico
     */
    private Double precioVenta;

    /**
     * modelo del automovil
     */
    private Modelo modelo;
    
    
    /**
     * constructor vacio
     */
    public AutomovilDTO(){}
    
    
    /**
     * @return the autoId
     */
    public Long getAutoId() {
        return autoId;
    }

    /**
     * @param autoId the autoId to set
     */
    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
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
     * @return the precioComprado
     */
    public Double getPrecioComprado() {
        return precioComprado;
    }

    /**
     * @param precioComprado the precioComprado to set
     */
    public void setPrecioComprado(Double precioComprado) {
        this.precioComprado = precioComprado;
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
