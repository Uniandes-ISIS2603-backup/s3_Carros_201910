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
 * @author Daniel Lozano
 */
public class PuntoVentaDetailDTO extends PuntoVentaDTO implements Serializable
{
   private List<EmpleadoDTO> emplados;
   
   private List<ClienteDTO> clientes; 
   
   private List<MarcaDTO> marcas;
   
   private List<RegistroCompraDTO> registrosCompra;
   
   private List<CompraVentaDTO> compraVentas;

    /**
     * @return the emplados
     */
    public List<EmpleadoDTO> getEmplados() {
        return emplados;
    }

    /**
     * @param emplados the emplados to set
     */
    public void setEmplados(List<EmpleadoDTO> emplados) {
        this.emplados = emplados;
    }

    /**
     * Añade un empleado
     * @param empleado 
     */
    public void addEmpleado(EmpleadoDTO empleado)
    {
       this.emplados.add(empleado);
    }
    /**
     * @return the clientes
     */
    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }

    /**
     * 
     * @param clienteNuevo 
     */
    public void addCliente(ClienteDTO clienteNuevo)
    {
        this.clientes.add(clienteNuevo);
    }
    /**
     * @return the marcas
     */
    public List<MarcaDTO> getMarcas() {
        return marcas;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(List<MarcaDTO> marcas) {
        this.marcas = marcas;
    }

    /**
     * 
     * @param marcaNueva 
     */
    public void addMarca(MarcaDTO marcaNueva)
    {
        this.marcas.add(marcaNueva);
    }
    /**
     * @return the registrosCompra
     */
    public List<RegistroCompraDTO> getRegistrosCompra() {
        return registrosCompra;
    }

    /**
     * @param registrosCompra the registrosCompra to set
     */
    public void setRegistrosCompra(List<RegistroCompraDTO> registrosCompra) {
        this.registrosCompra = registrosCompra;
    }
    
    /**
     *  
     * @param nuevaCompra 
     */
    public void addRegistroCompra(RegistroCompraDTO nuevaCompra)
    {
        this.registrosCompra.add(nuevaCompra);
    }
    /**
     * @return the compraVentas
     */
    public List<CompraVentaDTO> getCompraVentas() {
        return compraVentas;
    }

    /**
     * @param compraVentas the compraVentas to set
     */
    public void setCompraVentas(List<CompraVentaDTO> compraVentas) {
        this.compraVentas = compraVentas;
    }
   /**
    * 
    * @param nuevaVenta 
    */
    public void adsCompraVenta(CompraVentaDTO nuevaVenta)
    {
        this.compraVentas.add(nuevaVenta);
    }
   
   
}
