/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author estudiante
 */
@Entity
public class PuntoVentaEntity extends BaseEntity implements Serializable
{
    
   private String direccion;
   
   private String telefono;
   
   @PodamExclude
   @OneToMany( mappedBy = "puntoVenta", fetch = LAZY)
   private List<EmpleadoEntity> empleados;
   
   @PodamExclude
   @ManyToMany( mappedBy = "puntosVenta", fetch = LAZY)
   private List<ClienteEntity> clientes;
   
   @PodamExclude
   @ManyToMany( mappedBy = "puntosVenta", fetch = LAZY)
   private List<MarcaEntity> marcas; 
   
   @PodamExclude
   @OneToMany( mappedBy = "puntoVenta", fetch = LAZY)
   private List<RegistroCompraEntity> compras;
   
   @PodamExclude
   @OneToMany( mappedBy = "puntoVenta", fetch = LAZY)
   private List<CompraVentaEntity> ventas;      
   
   public PuntoVentaEntity()
   {
       
   }
    /**
     * @return the dirreccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param dirreccion the dirreccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
     * @return the empleados
     */
    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }

    /**
     * @return the clientes
     */
    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<ClienteEntity> clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the marcas
     */
    public List<MarcaEntity> getMarcas() {
        return marcas;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(List<MarcaEntity> marcas) {
        this.marcas = marcas;
    }

    /**
     * @return the compras
     */
    public List<RegistroCompraEntity> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<RegistroCompraEntity> compras) {
        this.compras = compras;
    }

    /**
     * @return the ventas
     */
    public List<CompraVentaEntity> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<CompraVentaEntity> ventas) {
        this.ventas = ventas;
    }
   
}
