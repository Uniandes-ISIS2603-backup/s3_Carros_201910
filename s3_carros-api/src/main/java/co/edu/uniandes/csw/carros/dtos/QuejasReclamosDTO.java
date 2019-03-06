/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.dtos;

import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import java.io.Serializable;

/**
 *
 * @author Julio Ruiz
 */
public class QuejasReclamosDTO implements Serializable{
    
    
    /**
     * identificador unico de un caso de queja o reclamo dentro del 
     * concesionario
     */
    private Long casoId;
    
    /**
     * indica si el caso ha sido solucionado
     */
    private Boolean solucionado;
    
    /**
     * tipo "ESTADO_AUTOMOVIL"|"PROBLEMA_PAGO"|"DEMORA_ENTREGA"|"MALA ATENCION"|
     * "REEMBOLSO"
     */
    private Integer tipoQueja;
    
    /**
     * comentarios que el usuario que ponga la queja tiene de la situacion
     * opcional
     */
    private String comentarios;
    
    /**
     * los diferentes tipos de queja
     */
    private final static int ESTADO_AUTOMOVIL = 0;
    private final static int PROBLEMA_PAGO = 1;
    private final static int DEMORA_ENTREGA = 2;
    private final static int MALA_ATENCION = 3;
    private final static int REEMBOLSO = 4;
    private final static int OTRO = 5;

    public QuejasReclamosDTO(){
        
    }
    
    /**
     * @return the casoId
     */
    public Long getCasoId() {
        return casoId;
    }

    /**
     * @param casoId the casoId to set
     */
    public void setCasoId(Long casoId) {
        this.casoId = casoId;
    }

    /**
     * @return the solucionado
     */
    public Boolean getSolucionado() {
        return solucionado;
    }

    /**
     * @param solucionado the solucionado to set
     */
    public void setSolucionado(Boolean solucionado) {
        this.solucionado = solucionado;
    }

    /**
     * @return the tipoQueja
     */
    public Integer getTipoQueja() {
        return tipoQueja;
    }

    /**
     * @param tipoQueja the tipoQueja to set
     */
    public void setTipoQueja(Integer tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    public QuejasReclamosEntity toEntity()
    {
       QuejasReclamosEntity entity = new QuejasReclamosEntity();
       entity.setCarroId(this.casoId);
       entity.setComentarios(this.comentarios);
       entity.setTipo(this.tipoQueja);
       entity.setSolucionado(this.solucionado);
       return entity;
    }
    public QuejasReclamosDTO(QuejasReclamosEntity entity)
 {
       this.casoId = entity.getCarroId();
       this.comentarios = entity.getComentarios();
       this.tipoQueja = entity.getTipo();
       this.solucionado = entity.isSolucionado();
 }
            
}
