/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import java.util.List;

/**
 * Clase que contiene una colección de representaciones básicas de QuejasReclamosDTO
 * @author Kevin Hernán Castrillón Castañeda
 */
public class CompraVentaDetailDTO 
{
    private List<QuejasReclamosDTO> listaQuejas;

    /**
     * Retorna la lista de quejas.
     * @return the listaQuejas
     */
    public List<QuejasReclamosDTO> getListaQuejas() 
    {
        return listaQuejas;
    }

    /**
     * Asigna una lista de quejas.
     * @param listaQuejas the listaQuejas set
     */
    public void setListaQuejas(List<QuejasReclamosDTO> listaQuejas) 
    {
        this.listaQuejas = listaQuejas;
    }
    
    /**
     * Agrega una nueva queja a la lista de quejas
     * @param queja: Es la queja que se va a agregar a la lista de quejas.
     */
    public void addQueja(QuejasReclamosDTO queja)
    {
        this.listaQuejas.add(queja);
    }
}
