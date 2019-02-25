/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.PuntoVentaLogic;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

/**
 *
 * @author Daniel Lozano
 */
@RunWith(Arquillian.class)
public class PuntoVentaLogicTest {
    
    @Inject
    private PuntoVentaLogic puntoVentaLogic;
    
    @PersistenceContext
    private EntityManager em; 
    
    //@Inject
    //private UserTransaction utx;
    
    private List<PuntoVentaEntity> data = new ArrayList<PuntoVentaEntity>();
    
    private List<ClienteEntity> clienteData = new ArrayList();
    
    private List<EmpleadoEntity> empleadoData = new ArrayList(); 
    
    private List<RegistroCompraEntity> registroCompraData = new ArrayList();
    
    
    
    
}
