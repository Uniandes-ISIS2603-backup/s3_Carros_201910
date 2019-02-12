/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.util.List;

/**
 *
 * @author Juan Pablo Patarroyo Duque
 */
public class ClienteDetailDTO {
    private List<CompraVentaDTO> listaCompras;
    
    public ClienteDetailDTO(){  
    }
    
    public List<CompraVentaDTO> getListaCompras(){
        return listaCompras;
    }
    
    public void setListaCompras(List<CompraVentaDTO> lista){
        this.listaCompras = lista;
    }
   
    public void addCompra(CompraVentaDTO compra){
        listaCompras.add(compra);
    }
}
