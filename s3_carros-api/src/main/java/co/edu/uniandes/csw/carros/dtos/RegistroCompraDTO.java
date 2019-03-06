/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Daniel Lozano
 */
public class RegistroCompraDTO implements Serializable
{
    private double precioAcordado; 
    
    private Date fechaCompra; 
    
    private String nombreVendedor; 
    
    private AutomovilDTO auto; 
    
    private long compraId; 

    /**
     * 
     */
    public RegistroCompraDTO()
    {
        
    }
    
    public RegistroCompraEntity toEntity()
    {
       RegistroCompraEntity entity = new RegistroCompraEntity();
       entity.setFechaCompra(this.getFechaCompra());
       entity.setNombreVendedor(this.getNombreVendedor());
       entity.setPrecioComprado(this.getPrecioAcordado());
       entity.setId(this.getCompraId());
       //AutomovilEntity nuevAuto = auto.toEntity();
       //entity.setAutomovil(nuevAuto);
       
       return entity;
    }
    public RegistroCompraDTO(RegistroCompraEntity entity)
 {
      this.fechaCompra = entity.getFechaCompra();
      this.nombreVendedor = entity.getNombreVendedor();
      this.precioAcordado = entity.getPrecioComprado();
      this.compraId = entity.getId();
     //this.auto = new AutomovilDTO(entity.getAutomovil());
      this.compraId = entity.getId();
 }
    /**
     * @return the precioAcordado
     */
    public double getPrecioAcordado() {
        return precioAcordado;
    }

    /**
     * @param precioAcordado the precioAcordado to set
     */
    public void setPrecioAcordado(double precioAcordado) {
        this.precioAcordado = precioAcordado;
    }

    /**
     * @return the fechaCompra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * @return the nombreVendedor
     */
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    /**
     * @param nombreVendedor the nombreVendedor to set
     */
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }


    /**
     * @return the compraId
     */
    public long getCompraId() {
        return compraId;
    }

    /**
     * @param compraId the compraId to set
     */
    public void setCompraId(long compraId) {
        this.compraId = compraId;
    }

    /**
     * @return the auto
     */
    public AutomovilDTO getAuto() {
        return auto;
    }

    /**
     * @param auto the auto to set
     */
    public void setAuto(AutomovilDTO auto) {
        this.auto = auto;
    }
    
    
}
