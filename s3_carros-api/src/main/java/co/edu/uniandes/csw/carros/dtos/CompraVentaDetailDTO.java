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
 * * Clase que extiende de {@link CompraVentaDTO} para manejar las relaciones entre las compraVentas JSON y otros DTOs. 
 * Para conocer el contenido de la una CompraVenta vaya a la documentacion de {@link ComraVentaDTO}
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * 
 * <pre>
 * 
 *   {
 *      "ventaID": number,
 *      "calificacionCompra": number,
 *      "fecha": date,
 *      "pagado": boolean,
 *      "factura": {@link FacturaDTO},
      "quejasReclamos": [{@link QuejasReclamosDTO}],
 *      "quejasReclamosEmpleado": [{@link QuejasReclamosDTO}]
 *   }
 * 
 * </pre>
 * 
 * @author Kevin Hernán Castrillón Castañeda
 */
public class CompraVentaDetailDTO extends CompraVentaDTO implements Serializable
{
    /**
     * Lista de quejas y reclamos del cliente.
     */
    private List<QuejasReclamosDTO> quejasReclamos;
    
    /**
     * Lista de quejas y reclamos del empleado.
     */
//    private List<QuejasReclamosDTO> quejasReclamosEmpleado;

    /**
     * Constructor por defecto
     */
    public CompraVentaDetailDTO() 
    {
        super();
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
            if (compraVentaEntity.getQuejasReclamos() != null) 
            {
                quejasReclamos = new ArrayList<>();
                for(QuejasReclamosEntity quejasReclamosEntity : compraVentaEntity.getQuejasReclamos()) 
                {
                    quejasReclamos.add(new QuejasReclamosDTO(quejasReclamosEntity));
                }
            }            
            else
            {
                quejasReclamos = new ArrayList<>();
            }
//            if (compraVentaEntity.getQuejasReclamosEmpleado() != null) 
//            {
//                quejasReclamosEmpleado = new ArrayList<>();
//                for(QuejasReclamosEntity quejasReclamosEntity : compraVentaEntity.getQuejasReclamosEmpleado()) 
//                {
//                    quejasReclamosEmpleado.add(new QuejasReclamosDTO(quejasReclamosEntity));
//                }
//            }
//            else
//            {
//                quejasReclamosEmpleado = new ArrayList<>();
//            }
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
        if (quejasReclamos != null) 
        {
            List<QuejasReclamosEntity> quejasRelamosEntity = new ArrayList<>();
            for (QuejasReclamosDTO quejasReclamosDTO : quejasReclamos) 
            {
                quejasRelamosEntity.add(quejasReclamosDTO.toEntity());
            }
            compraventaEntity.setQuejasReclamos(quejasRelamosEntity);
        }
//        if (quejasReclamosEmpleado != null) 
//        {
//            List<QuejasReclamosEntity> quejasRelamosEmpleadoEntity = new ArrayList<>();
//            for (QuejasReclamosDTO quejasReclamosDTO : quejasReclamosEmpleado) 
//            {
//                quejasRelamosEmpleadoEntity.add(quejasReclamosDTO.toEntity());
//            }
//            compraventaEntity.setQuejasReclamosEmpleado(quejasRelamosEmpleadoEntity);
//        }
        return compraventaEntity;
    }
    
    /**
     * Retorna la lista de quejas del cliente.
     * @return the quejasReclamos
     */
    public List<QuejasReclamosDTO> getQuejasReclamos() 
    {
        return quejasReclamos;
    }

    /**
     * Asigna una lista de quejas del cliente.
     * @param quejasReclamos the quejasReclamos set
     */
    public void setQuejasReclamos(List<QuejasReclamosDTO> quejasReclamos) 
    {
        this.quejasReclamos = quejasReclamos;
    }
    
    /**
     * Agrega una nueva queja a la lista de quejas del cliente
     * @param queja: Es la queja que se va a agregar a la lista de quejas de empleado.
     */
//    public void addQuejaCliente(QuejasReclamosDTO queja)
//    {
//        this.quejasReclamos.add(queja);
//    }
    
    /**
     * Retorna la lista de quejas del empleado.
     * @return the quejasReclamosEmpleado
     */
//    public List<QuejasReclamosDTO> getQuejasReclamosEmpleado() 
//    {
//        return quejasReclamosEmpleado;
//    }

    /**
     * Asigna una lista de quejas del empleado.
     * @param quejasReclamosEmpleado the quejasReclamosEmpleado set
     */
//    public void setQuejasReclamosEmpleado(List<QuejasReclamosDTO> quejasReclamosEmpleado) 
//    {
//        this.quejasReclamosEmpleado = quejasReclamosEmpleado;
//    }
    
    /**
     * Agrega una nueva queja a la lista de quejas del empleado
     * @param queja: Es la queja que se va a agregar a la lista de quejas de empleado.
     */
//    public void addQuejaEmpleado(QuejasReclamosDTO queja)
//    {
//        this.quejasReclamosEmpleado.add(queja);
//    }
}
