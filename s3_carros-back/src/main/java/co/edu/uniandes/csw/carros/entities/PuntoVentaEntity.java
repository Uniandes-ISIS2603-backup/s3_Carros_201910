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
    
   @Id 
   private Long id;
   private String direccion;
   
   private String telefono;
   
   @PodamExclude
   @OneToMany( mappedBy = "puntosVenta", fetch = LAZY)
   private List<EmpleadoEntity> empleados;
   
   @PodamExclude
   @ManyToMany( mappedBy = "puntosVenta", fetch = LAZY)
   private List<ClienteEntity> clientes;
   
   @PodamExclude
   @OneToMany( mappedBy = "puntoVenta", fetch = LAZY)
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
   
}
