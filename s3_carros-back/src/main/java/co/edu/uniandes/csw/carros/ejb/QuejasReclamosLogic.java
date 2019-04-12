/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.ejb;

import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.QuejasReclamosPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Julio Ruiz
 */
@Stateless
public class QuejasReclamosLogic {
    
    @Inject
    private QuejasReclamosPersistence persistence;
    
    private static final Logger LOGGER = Logger.getLogger(QuejasReclamosLogic.class.getName());
    
    /**
     * Crea una queja en la persistencia.
     *
     * @param QuejasReclamosEntity La entidad que representa la queja a
     * persistir.
     * @return La entiddad de la queja luego de persistirla.
     * @throws BusinessLogicException Si la queja a persistir ya existe o si se crea solucionada, o si el tipo no es el correspondiente, o si el tipo es OTRO y comentarios es vacio.
     */
    public QuejasReclamosEntity createQuejasReclamos(QuejasReclamosEntity queja) throws BusinessLogicException{
        
        if(persistence.findByName(queja.getCarroId())!= null)
        {
            throw new BusinessLogicException("Ya existe una queja con el id:  "+ queja.getCarroId());
        }
        if(queja.isSolucionado())
        {
            throw new BusinessLogicException("La queja no puede crearse ya solucionada");
        }
        if(queja.getTipo() < 0 || queja.getTipo() > 5)
        {
            throw new BusinessLogicException("EL tipo de la queja " + queja.getTipo()+ " no es valido");
        }
        if(queja.getTipo() == 5 && queja.getComentarios().isEmpty())
        {
            throw new BusinessLogicException("Si la queja es de tipo OTRO los comentarios no pueden ser vacio");
        }
       
        queja = persistence.create(queja);
        return queja; 
        
        
        //reglas de negocio
        
    }
    
    /**
     * Obtiene todas las quejas existentes en la base de datos.
     *
     * @return una lista de quejas.
     */
    public List<QuejasReclamosEntity> getQuejasReclamos()
    {
        List<QuejasReclamosEntity> quejas = persistence.findAll();
        return quejas;
    }
    
    /**
     * Obtiene una queja a partir de su ID.
     *
     * @param casoId Identificador de la instancia a consultar
     * @return la queja solicitada por medio de su ID.
     */
    public QuejasReclamosEntity getQueja(Long casoId)
    {
        QuejasReclamosEntity entity = persistence.find(casoId);
        if (casoId == null) {
//            throw new BusinessLogicException("No se encuentra queja con el Id");
        }
        return entity;
    }
    
    /**
     * Actualiza la información de una instancia de QuejasReclamos.
     *
     * @param casoId Identificador de la instancia a actualizar
     * @param entity Instancia de QuejasReclamosEntity con los nuevos datos.
     * @return Instancia de QuejasReclamosEntity con los datos actualizados en la base de datos.
     */
    public QuejasReclamosEntity updateQuejasReclamos(Long casoId, QuejasReclamosEntity entity)    
    {
        QuejasReclamosEntity newEntity = persistence.update(entity);
        return newEntity;
    }
    
    /**
     * Elimina una instancia de QuejasReclamos
     * 
     * @param casoId Identificador de la instancia a eliminar
     * @throws BusinessLogicException si no existe la instancia a eliminar
     */
    public void deleteQuejasReclamos (Long casoId) throws BusinessLogicException 
        {
        persistence.delete(casoId);
    }
}
