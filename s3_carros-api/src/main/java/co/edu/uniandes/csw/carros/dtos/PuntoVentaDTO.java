/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class PuntoVentaDTO implements Serializable
{
 private String dirreccion; 
 
 private String telefoo;
 
 private long id;
 
 private List<RegistroCompraDTO> registros; 
 
/**
 * 
 */
 public PuntoVentaDTO()
 {
     
 }
    /**
     * @return the dirreccion
     */
    public String getDirreccion() {
        return dirreccion;
    }

    /**
     * @param dirreccion the dirreccion to set
     */
    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    /**
     * @return the telefoo
     */
    public String getTelefoo() {
        return telefoo;
    }

    /**
     * @param telefoo the telefoo to set
     */
    public void setTelefoo(String telefoo) {
        this.telefoo = telefoo;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the registros
     */
    public List<RegistroCompraDTO> getRegistros() {
        return registros;
    }

    /**
     * @param registros the registros to set
     */
    public void setRegistros(List<RegistroCompraDTO> registros) {
        this.registros = registros;
    }
 
 
 
}
