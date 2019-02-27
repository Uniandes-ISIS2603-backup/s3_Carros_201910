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
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.glassfish.pfl.basic.tools.argparser.ElementParser.factory;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Daniel Lozano
 */
@RunWith(Arquillian.class)
public class PuntoVentaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
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
    
    @Test
    public void createEditorialTest() throws BusinessLogicException 
    {
        PuntoVentaEntity newEntity;
        newEntity = factory.manufacturePojo(PuntoVentaEntity.class);
        PuntoVentaEntity result = puntoVentaLogic.createPuntoVenta(newEntity);
        Assert.assertNotNull(result);
        PuntoVentaEntity entity = em.find(PuntoVentaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getDireccion(), entity.getDireccion());
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createEditorialConMismaDireccionTest() throws BusinessLogicException 
    {
        PuntoVentaEntity newEntity = factory.manufacturePojo(PuntoVentaEntity.class);
        newEntity.setDireccion(data.get(0).getDireccion());
        puntoVentaLogic.createPuntoVenta(newEntity);
    }
    
     
    @Test
    public void getPuntosVentaTest() {
        List<PuntoVentaEntity> list = puntoVentaLogic.getPuntosVenta();
        Assert.assertEquals(data.size(), list.size());
        for (PuntoVentaEntity entity : list) {
            boolean found = false;
            for (PuntoVentaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
