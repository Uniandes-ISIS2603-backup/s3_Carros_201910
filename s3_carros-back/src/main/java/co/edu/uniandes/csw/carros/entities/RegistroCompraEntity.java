/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.Date;
<<<<<<< HEAD
import javax.persistence.Entity;
=======
>>>>>>> parent of 776afaa... Revert "Merge origin/master"
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author estudiante
 */
<<<<<<< HEAD
@Entity
=======
>>>>>>> parent of 776afaa... Revert "Merge origin/master"
public class RegistroCompraEntity extends BaseEntity implements Serializable
{
    private double precioComprado; 
   
    @Temporal(TemporalType.DATE)
    private Date fechaCompra; 
    
<<<<<<< HEAD
    private String nombreVendedor; 
=======
    private String nombreVnededor; 
>>>>>>> parent of 776afaa... Revert "Merge origin/master"

    public RegistroCompraEntity()
    {
        
    }
    /**
     * @return the precioComprado
     */
    public double getPrecioComprado() {
        return precioComprado;
<<<<<<< HEAD
    } 
=======
    }
>>>>>>> parent of 776afaa... Revert "Merge origin/master"
    /**
     * @param precioComprado the precioComprado to set
     */
    public void setPrecioComprado(double precioComprado) {
        this.precioComprado = precioComprado;
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
     * @return the nombreVnededor
     */
<<<<<<< HEAD
    public String getNombreVendedor() {
        return nombreVendedor;
=======
    public String getNombreVnededor() {
        return nombreVnededor;
>>>>>>> parent of 776afaa... Revert "Merge origin/master"
    }

    /**
     * @param nombreVnededor the nombreVnededor to set
     */
<<<<<<< HEAD
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
=======
    public void setNombreVnededor(String nombreVnededor) {
        this.nombreVnededor = nombreVnededor;
>>>>>>> parent of 776afaa... Revert "Merge origin/master"
    }
 
    
    
}
