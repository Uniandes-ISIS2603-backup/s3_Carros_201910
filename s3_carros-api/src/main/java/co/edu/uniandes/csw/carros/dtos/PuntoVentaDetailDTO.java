/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que maneja las listas de recursos relacionados con un punto de venta
 * @author Daniel Lozano
 */
public class PuntoVentaDetailDTO extends PuntoVentaDTO implements Serializable
{
    /**
     * Lista de empleados de un punto de venta
     */
   private List<EmpleadoDTO> empleados;
   
   /**
    * lista de clientes de un punto de venta
    */
   private List<ClienteDTO> clientes; 
   
   /**
    * Lista de marcas de auto de un punto de venta
    */
   private List<MarcaDTO> marcas;
   
   /**
    * Lista de comptas de autos realizadas por un punto de venta
    */
   private List<RegistroCompraDTO> registrosCompra;
   
   /**
    * Lista de vents de autos realizadas por un punto de venta
    */
   private List<CompraVentaDTO> compraVentas;

   /**
    * Constructor vacio por defecto de un DetailDTO
    */
   public PuntoVentaDetailDTO()
   {
       
   }
   /**
    * Constructor de un detail DTO aparir de una entidad
    * @param puntoVentaEntity  entidad base para construtir el detailDTO
    */
   public PuntoVentaDetailDTO(PuntoVentaEntity puntoVentaEntity)
   {
       super(puntoVentaEntity);
       if(puntoVentaEntity != null)
       {
           if(puntoVentaEntity.getEmpleados()!=null)
           {
               empleados = new ArrayList<>();
               for (EmpleadoEntity empleado : puntoVentaEntity.getEmpleados()) 
               {
                   empleados.add(new EmpleadoDTO(empleado));
               }
           }
           if(puntoVentaEntity.getCompras() != null)
           {
               registrosCompra = new ArrayList<>();
               for(RegistroCompraEntity compras : puntoVentaEntity.getCompras())
               {
                   registrosCompra.add(new RegistroCompraDTO(compras));
               }
           }
           if(puntoVentaEntity.getMarcas() != null)
           {
               marcas = new ArrayList<>();
               for (MarcaEntity marca : puntoVentaEntity.getMarcas())
               {
                marcas.add(new MarcaDTO(marca));
               }
           }
           if(puntoVentaEntity.getClientes() != null)
           {
               clientes = new ArrayList<>();
               for (ClienteEntity cliente : puntoVentaEntity.getClientes())
               {
                   clientes.add(new ClienteDTO(cliente));
               }
           }
           if(puntoVentaEntity.getVentas() != null)
           {
              compraVentas = new ArrayList<>();           
              for (CompraVentaEntity compraVenta : puntoVentaEntity.getVentas()) 
               {
                    compraVentas.add(new CompraVentaDTO(compraVenta));  
               }
           }
       }
   }
   
   /**
    * Metodo de convierte el objeto en una entidad
    * @return entidad con las caracterisiticas ibtenidad aparit del detailDto
    */
   @Override
   public PuntoVentaEntity toEntity()
   {
       PuntoVentaEntity entity = super.toEntity();
       if(clientes != null)
       {
            List<ClienteEntity> clienteEntity = new ArrayList<>();
            for(ClienteDTO dtoCliente : clientes)
            {
                clienteEntity.add(dtoCliente.toEntity());
            }
            entity.setClientes(clienteEntity);
       }
       if(compraVentas != null)
       {
           List<CompraVentaEntity> compraVentaEntity = new ArrayList<>();
           for(CompraVentaDTO dtoCompraVenta: compraVentas)
           {
               compraVentaEntity.add(dtoCompraVenta.toEntity());
           }
           entity.setVentas(compraVentaEntity);

       }
       if(empleados != null)
       {
           List<EmpleadoEntity> empleadoEntity = new ArrayList<>();
           for(EmpleadoDTO dtoEmpleado : empleados)
           {
               empleadoEntity.add(dtoEmpleado.toEntity());
           }
           entity.setEmpleados(empleadoEntity);
       }
       if(marcas != null)
       {
           List<MarcaEntity> marcasEntity = new ArrayList<>();
           for (MarcaDTO marca : marcas) 
           {
               marcasEntity.add(marca.toEntity());
           }
           entity.setMarcas(marcasEntity);
      }
       if(registrosCompra != null)
       {
           List<RegistroCompraEntity> registroEntity = new ArrayList<>();
           for(RegistroCompraDTO dtoRegistroCompra: registrosCompra)
           {
               registroEntity.add(dtoRegistroCompra.toEntity());
           }
           entity.setCompras(registroEntity);
       }
       return entity;
        
   }
    /**Devuleve la lista de empleados del punto de venta
     * @return the emplados pertenecientes al punto de venta
     */
    public List<EmpleadoDTO> getEmplados() {
        return empleados;
    }

    /**Asgina los empleados al punto de venta.
     * @param emplados the emplados to set del punto de venta
     */
    public void setEmplados(List<EmpleadoDTO> emplados) {
        this.empleados = emplados;
    }

    /**
     * Añade un empleado
     * @param empleado 
     */
    public void addEmpleado(EmpleadoDTO empleado)
    {
       this.empleados.add(empleado);
    }
    /**Devuleve la lista de clienetes del punto de venta
     * @return the clientes
     */
    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    /**Asgina los clientes al punto de venta.
     * @param clientes the clientes to set
     */
    public void setClientes(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }

    /**
     * Añade un cliente
     * @param clienteNuevo 
     */
    public void addCliente(ClienteDTO clienteNuevo)
    {
        this.clientes.add(clienteNuevo);
    }
    /**Devuleve la lista de marcas del punto de venta
     * @return the marcas
     */
    public List<MarcaDTO> getMarcas() {
        return marcas;
    }

    /**Asgina las marcas al punto de venta.
     * @param marcas the marcas to set
     */
    public void setMarcas(List<MarcaDTO> marcas) {
        this.marcas = marcas;
    }

    /**
     * Añade una marca
     * @param marcaNueva 
     */
    public void addMarca(MarcaDTO marcaNueva)
    {
        this.marcas.add(marcaNueva);
    }
    /**Devuleve la lista de registros compra del punto de venta
     * @return the registrosCompra
     */
    public List<RegistroCompraDTO> getRegistrosCompra() {
        return registrosCompra;
    }

    /**Asgina las compras al punto de venta.
     * @param registrosCompra the registrosCompra to set
     */
    public void setRegistrosCompra(List<RegistroCompraDTO> registrosCompra) {
        this.registrosCompra = registrosCompra;
    }
    
    /**
     *  Añade una compra
     * @param nuevaCompra 
     */
    public void addRegistroCompra(RegistroCompraDTO nuevaCompra)
    {
        this.registrosCompra.add(nuevaCompra);
    }
    /**Devuleve la lista de compras del punto de venta
     * @return the compraVentas
     */
    public List<CompraVentaDTO> getCompraVentas() {
        return compraVentas;
    }

    /**Asgina las ventas al punto de venta.
     * @param compraVentas the compraVentas to set
     */
    public void setCompraVentas(List<CompraVentaDTO> compraVentas) {
        this.compraVentas = compraVentas;
    }
   /**
    * Añade una venta
    * @param nuevaVenta 
    */
    public void adsCompraVenta(CompraVentaDTO nuevaVenta)
    {
        this.compraVentas.add(nuevaVenta);
    }
   
   
}
