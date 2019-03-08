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
 *
 * @author Daniel Lozano
 */
public class PuntoVentaDetailDTO extends PuntoVentaDTO implements Serializable
{
   private List<EmpleadoDTO> empleados;
   
   private List<ClienteDTO> clientes; 
   
   private List<MarcaDTO> marcas;
   
   private List<RegistroCompraDTO> registrosCompra;
   
   private List<CompraVentaDTO> compraVentas;

   public PuntoVentaDetailDTO()
   {
       
   }
   
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
                //marcas.add(new MarcaDTO);
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
               for (CompraVentaEntity compraVenta : puntoVentaEntity.getVentas()) 
               {
                 compraVentas.add(new CompraVentaDTO(compraVenta));  
               }
               
           }
           
           
       }
   }
   public PuntoVentaEntity toEntity()
   {
       PuntoVentaEntity entity = new PuntoVentaEntity();
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
               //(marcasEntity.add(marca.toEntity());
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
    /**
     * @return the emplados
     */
    public List<EmpleadoDTO> getEmplados() {
        return empleados;
    }

    /**
     * @param emplados the emplados to set
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
