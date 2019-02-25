/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.entities;

/**
 *
 * @author estudiante
 */
public class PuntoVentaEntity extends BaseEntity
{
   private String direccion;
   
   private String telefono;

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
