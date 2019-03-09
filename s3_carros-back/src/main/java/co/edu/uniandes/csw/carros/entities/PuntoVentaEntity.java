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
 *Entidad del punto de venta
 * @author Daniel Lozano
 */
@Entity
public class PuntoVentaEntity extends BaseEntity implements Serializable
{
    /**
     * Direccion del punto de venta
     */
   private String direccion;
   
   /**
    * Telefono del punto de venta
    */
   private String telefono;
   
   /**
    * LISTA DE EMPLEADOS DE UN PUNTO DE VENTA 
    */
   @PodamExclude
   @OneToMany( mappedBy = "puntoVenta", fetch = LAZY)
   private List<EmpleadoEntity> empleados;
   
   /**
    * Lista de clientes de un punto de venta
    */
   @PodamExclude
   @ManyToMany( mappedBy = "puntosVenta", fetch = LAZY)
   private List<ClienteEntity> clientes;
   
   /**
    * Lista de marcas de un punto de venta
    */
   @PodamExclude
   @ManyToMany( mappedBy = "puntosVenta", fetch = LAZY)
   private List<MarcaEntity> marcas; 
   
   /**
    * Lista de compras de un punto de venta
    */
   @PodamExclude
   @OneToMany( mappedBy = "puntoVenta", fetch = LAZY)
   private List<RegistroCompraEntity> compras;
   
   
   /**
    * Lista de ventas de un punto de venta
    */
   @PodamExclude
   @OneToMany( mappedBy = "puntoVenta", fetch = LAZY)
   private List<CompraVentaEntity> ventas;      
   
   /**
    * Contrsuctor de un punto de venta, vacio por convencion.
    */
   public PuntoVentaEntity()
   {
       
   }
    /**Retorna la direccion del punto de venta
     * @return the dirreccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**Asigna la direccion de un punto de venta
     * @param dirreccion the dirreccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**Retorna el telefono de un punto de venta
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**Asigna un nuemero del telefono al punto de venta
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**La lista de empleados de un punto de venta 
     * @return the empleados
     */
    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    /**Asigna la lista de empleados de un punto de venta 
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }

    /**La lista de clientes de un punto de venta 
     * @return the clientes
     */
    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    /**Asigna la lista de clientes de un punto de venta 
     * @param clientes the clientes to set
     */
    public void setClientes(List<ClienteEntity> clientes) {
        this.clientes = clientes;
    }

    /**La lista de marcas e un punto de venta 
     * @return the marcas
     */
    public List<MarcaEntity> getMarcas() {
        return marcas;
    }

    /**Asigna la lista de marcas de un punto de venta 
     * @param marcas the marcas to set
     */
    public void setMarcas(List<MarcaEntity> marcas) {
        this.marcas = marcas;
    }

    /**La lista de compras de un punto de venta 
     * @return the compras
     */
    public List<RegistroCompraEntity> getCompras() {
        return compras;
    }

    /**Asigna la lista de compras de un punto de venta 
     * @param compras the compras to set
     */
    public void setCompras(List<RegistroCompraEntity> compras) {
        this.compras = compras;
    }

    /**La lista de ventas de un punto de venta 
     * @return the ventas
     */
    public List<CompraVentaEntity> getVentas() {
        return ventas;
    }

    /**Asigna la lista de ventas de un punto de venta 
     * @param ventas the ventas to set
     */
    public void setVentas(List<CompraVentaEntity> ventas) {
        this.ventas = ventas;
    }
   
}
