/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;
import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import java.io.Serializable;

/**
 *
 * @author Andres Forero
 */
public class AutomovilDTO  implements Serializable{
    
    
    private RegistroCompraDTO registroCompra;
    
    

    
    
    private ModeloDTO modelo;
    
    
    
    private String imagen_auto;
    
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
     * ide del punto de venta donde esta el automovil
     */
    private Integer puntoVentaID;
    
    
    /**
     * constructor vacio
     */
    public AutomovilDTO(){}
    

    public AutomovilDTO(AutomovilEntity autoEntity){
        if(autoEntity != null){
            this.anio = autoEntity.getAnio();
            this.autoId = autoEntity.getId();
            this.imagen_auto = autoEntity.getImagen_auto();
            this.color = autoEntity.getColor();
            this.cuidadMatricula = autoEntity.getCuidadMatricula();
            this.disponible = autoEntity.getDisponible();
            this.idChasis = autoEntity.getIdChasis();
            this.matricula = autoEntity.getMatrcula();
            this.precioVenta = autoEntity.getPrecioVenta();
            this.puntoVentaID = autoEntity.getPuntoVentaID();
            this.recorrido = autoEntity.getRecorrido();
            this.referencia = autoEntity.getReferencia();
            this.tipo = autoEntity.getTipo();
          
            if(autoEntity.getRegistroCompra() != null){
                this.registroCompra = new RegistroCompraDTO(autoEntity.getRegistroCompra());
            }else{
                this.registroCompra = null;
            }
            if(autoEntity.getModelo() != null){
                this.modelo = new ModeloDTO(autoEntity.getModelo());
            }else{
                this.modelo = null;
            }
        }
    }
    
    
    public AutomovilEntity toEntity(){
        AutomovilEntity auto = new AutomovilEntity();
        auto.setAnio(this.anio);
        auto.setId(this.autoId);
        auto.setImagen_auto(this.imagen_auto);
        auto.setColor(this.color);
        auto.setCuidadMatricula(this.cuidadMatricula);
        auto.setDisponible(this.disponible);
        auto.setIdChasis(this.idChasis);
        auto.setMatrcula(this.matricula);
        auto.setPrecioVenta(this.precioVenta);
        auto.setPuntoVentaID(this.puntoVentaID);
        auto.setRecorrido(this.recorrido);
        auto.setReferencia(this.referencia);
        auto.setTipo(this.tipo);
       
        if(this.registroCompra != null){
            auto.setRegistroCompra(this.registroCompra.toEntity());
        }
        
        return auto;
        
    }
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
     * @return the registroCompra
     */
    public RegistroCompraDTO getRegistroCompra() {
        return registroCompra;
    }

    /**
     * @param registroCompra the registroCompra to set
     */
    public void setRegistroCompra(RegistroCompraDTO registroCompra) {
        this.registroCompra = registroCompra;
    }

  

    /**
     * @return the modelo
     */
    public ModeloDTO getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the imagen_auto
     */
    public String getImagen_auto() {
        return imagen_auto;
    }

    /**
     * @param imagen_auto the imagen_auto to set
     */
    public void setImagen_auto(String imagen_auto) {
        this.imagen_auto = imagen_auto;
    }    
    
    
    
}
