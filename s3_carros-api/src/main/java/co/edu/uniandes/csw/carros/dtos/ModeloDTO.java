/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import java.io.Serializable;

/**
 *
 * @author Andres Forero
 */
public class ModeloDTO implements Serializable{
    
    //TODO para que esta declarando este atributo
    private MarcaDTO marca;

    /**
     * id del modelo
     */
    private Long modeloID;

    /**
     * nombre del modelo
     */
    private String nombre;
    
    /**
     * Imagen del modelo
     */
    private String imagen;
    
    /**
     * numerop puertas del automovil con este modelo
     */
    private int numeroPuertas;
    
    /**
     * mecanica, electrica, etc
     */
    private String transmision;
    
    /**
     * centimetros cubicos
     */
    private Double cilindraje;
    
    /**
     * tipo de combustibel: gasolina, acpm, gas, diesel, electrico 
     */
    private String combustible;
    
    /**
     * tipo traccion: 4x4, delantera, trasera..etc
     */
    private String traccion;
    
    /**
     * tipo de direccion: mecanica, hidraulica, asistida etc
     */
    private String direccion;
    
    /**
     * tiene frenos ABS
     */
    private boolean frenosABS;
    
    /**
     * tiene airbag
     */
    private boolean airBag;
    
    /**
     * tiene aire acondicionado
     */
    private boolean aireAc;
    
    /**
     * tipo de asientos: cuero, tela, sintetico
     */
    private String asientos;
        
    /**
     * tipo de vidrios: electricos, manuales
     */
    private String vidrios;

    /**
     * constructor vacio
     */
    public ModeloDTO(){}
    
    
    public ModeloDTO(ModeloEntity modelo){
        if(modelo != null){
            this.airBag = modelo.isAirBag();
            this.aireAc = modelo.isAireAc();
            this.asientos = modelo.getAsientos();
            this.cilindraje = modelo.getCilindraje();
            this.combustible = modelo.getCombustible();
            this.direccion = modelo.getDireccion();
            this.frenosABS = modelo.isFrenosABS();
            this.modeloID = modelo.getId();
            this.numeroPuertas = modelo.getNumeroPuertas();
            this.traccion = modelo.getTraccion();
            this.transmision = modelo.getTransmision();
            this.vidrios = modelo.getVidrios();
            this.nombre = modelo.getNombre();
            this.imagen = modelo.getImagen();
            if(modelo.getMarca() != null){
                this.marca = new MarcaDTO(modelo.getMarca());
            }else{
                this.marca = null;
            }            
        }        
    }
    
    public ModeloEntity toEntity(){
        ModeloEntity modelo = new ModeloEntity();
        modelo.setAirBag(this.airBag);
        modelo.setAireAc(this.aireAc);
        modelo.setAsientos(this.asientos);
        modelo.setCilindraje(this.cilindraje);
        modelo.setCombustible(this.combustible);
        modelo.setDireccion(this.direccion);
        modelo.setFrenosABS(this.frenosABS);
        modelo.setId(this.modeloID);        
        modelo.setNombre(this.nombre);
        modelo.setNumeroPuertas(this.numeroPuertas);
        modelo.setTraccion(this.traccion);
        modelo.setTransmision(this.transmision);
        modelo.setVidrios(this.vidrios);
        modelo.setImagen(this.imagen);
        if(this.marca != null){
            modelo.setMarca(this.marca.toEntity());
        }
        return modelo;        
    }
    
    
    /**
     * @return the numeroPuertas
     */
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    /**
     * @param numeroPuertas the numeroPuertas to set
     */
    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * @return the transmision
     */
    public String getTransmision() {
        return transmision;
    }

    /**
     * @param transmision the transmision to set
     */
    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    /**
     * @return the cilindraje
     */
    public Double getCilindraje() {
        return cilindraje;
    }

    /**
     * @param cilindraje the cilindraje to set
     */
    public void setCilindraje(Double cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * @return the combustible
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * @param combustible the combustible to set
     */
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    /**
     * @return the traccion
     */
    public String getTraccion() {
        return traccion;
    }

    /**
     * @param traccion the traccion to set
     */
    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the frenosABS
     */
    public boolean isFrenosABS() {
        return frenosABS;
    }

    /**
     * @param frenosABS the frenosABS to set
     */
    public void setFrenosABS(boolean frenosABS) {
        this.frenosABS = frenosABS;
    }

    /**
     * @return the airBag
     */
    public boolean isAirBag() {
        return airBag;
    }

    /**
     * @param airBag the airBag to set
     */
    public void setAirBag(boolean airBag) {
        this.airBag = airBag;
    }

    /**
     * @return the aireAc
     */
    public boolean isAireAc() {
        return aireAc;
    }

    /**
     * @param aireAc the aireAc to set
     */
    public void setAireAc(boolean aireAc) {
        this.aireAc = aireAc;
    }

    /**
     * @return the asientos
     */
    public String getAsientos() {
        return asientos;
    }

    /**
     * @param asientos the asientos to set
     */
    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    /**
     * @return the vidrios
     */
    public String getVidrios() {
        return vidrios;
    }

    /**
     * @param vidrios the vidrios to set
     */
    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    /**
     * @return the modeloID
     */
    public Long getModeloID() {
        return modeloID;
    }

    /**
     * @param modeloID the modeloID to set
     */
    public void setModeloID(Long modeloID) {
        this.modeloID = modeloID;
    }

    /**
     * @return the marca
     */
    public MarcaDTO getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
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
