/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene una colección de representaciones básicas de QuejasReclamosDTO
 * @author Kevin Hernán Castrillón Castañeda
 */
public class CompraVentaDetailDTO extends CompraVentaDTO implements Serializable
{
    /**
     * Lista de quejas y reclamos del cliente.
     */
    private List<QuejasReclamosDTO> quejasReclamosCliente;
    
    /**
     * Lista de quejas y reclamos del empleado.
     */
    private List<QuejasReclamosDTO> quejasReclamosEmpleado;

    /**
     * Constructor por defecto
     */
    public CompraVentaDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param compraVentaEntity La entidad de la compraVenta para transformar a DTO.
     */
    public CompraVentaDetailDTO(CompraVentaEntity compraVentaEntity) 
    {
        super(compraVentaEntity);
        if (compraVentaEntity != null) 
        {
            if (compraVentaEntity.getQuejasReclamosCliente() != null) 
            {
                quejasReclamosCliente = new ArrayList<>();
                for(QuejasReclamosEntity quejasReclamosEntity : compraVentaEntity.getQuejasReclamosCliente()) 
                {
//                    quejasReclamosCliente.add(new QuejasReclamosDTO(quejasReclamosEntity));
                }
            }            
            else
            {
                quejasReclamosCliente = new ArrayList<>();
            }
            if (compraVentaEntity.getQuejasReclamosEmpleado() != null) 
            {
                quejasReclamosEmpleado = new ArrayList<>();
                for(QuejasReclamosEntity quejasReclamosEntity : compraVentaEntity.getQuejasReclamosEmpleado()) 
                {
//                    quejasReclamosEmpleado.add(new QuejasReclamosDTO(quejasReclamosEntity));
                }
            }
            else
            {
                quejasReclamosEmpleado = new ArrayList<>();
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return El DTO de la compraVenta para transformar a Entity
     */
    @Override
    public CompraVentaEntity toEntity() 
    {
        CompraVentaEntity compraventaEntity = super.toEntity();
        if (quejasReclamosCliente != null) 
        {
            List<QuejasReclamosEntity> quejasRelamosClienteEntity = new ArrayList<>();
            for (QuejasReclamosDTO quejasReclamosDTO : quejasReclamosCliente) 
            {
//                quejasRelamosClienteEntity.add(quejasReclamosDTO.toEntity());
            }
            compraventaEntity.setQuejasReclamosCliente(quejasRelamosClienteEntity);
        }
        if (quejasReclamosEmpleado != null) 
        {
            List<QuejasReclamosEntity> quejasRelamosEmpleadoEntity = new ArrayList<>();
            for (QuejasReclamosDTO quejasReclamosDTO : quejasReclamosEmpleado) 
            {
//                quejasRelamosEmpleadoEntity.add(quejasReclamosDTO.toEntity());
            }
            compraventaEntity.setQuejasReclamosEmpleado(quejasRelamosEmpleadoEntity);
        }
        return compraventaEntity;
    }
    
    /**
     * Retorna la lista de quejas del cliente.
     * @return the quejasReclamosCliente
     */
    public List<QuejasReclamosDTO> getQuejasReclamosCliente() 
    {
        return quejasReclamosCliente;
    }

    /**
     * Asigna una lista de quejas del cliente.
     * @param quejasReclamosCliente the quejasReclamosCliente set
     */
    public void setQuejasReclamosCliente(List<QuejasReclamosDTO> quejasReclamosCliente) 
    {
        this.quejasReclamosCliente = quejasReclamosCliente;
    }
    
    /**
     * Agrega una nueva queja a la lista de quejas del cliente
     * @param queja: Es la queja que se va a agregar a la lista de quejas de empleado.
     */
    public void addQuejaCliente(QuejasReclamosDTO queja)
    {
        this.quejasReclamosCliente.add(queja);
    }
    
    /**
     * Retorna la lista de quejas del empleado.
     * @return the quejasReclamosEmpleado
     */
    public List<QuejasReclamosDTO> getQuejasReclamosEmpleado() 
    {
        return quejasReclamosEmpleado;
    }

    /**
     * Asigna una lista de quejas del empleado.
     * @param quejasReclamosEmpleado the quejasReclamosEmpleado set
     */
    public void setQuejasReclamosEmpleado(List<QuejasReclamosDTO> quejasReclamosEmpleado) 
    {
        this.quejasReclamosEmpleado = quejasReclamosEmpleado;
    }
    
    /**
     * Agrega una nueva queja a la lista de quejas del empleado
     * @param queja: Es la queja que se va a agregar a la lista de quejas de empleado.
     */
    public void addQuejaEmpleado(QuejasReclamosDTO queja)
    {
        this.quejasReclamosEmpleado.add(queja);
    }
}
