/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.RegistroCompraLogic;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.RegistroCompraPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Daniel Lozano
 */
@RunWith(Arquillian.class)
public class RegistroCompraLogicTest 
{
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private RegistroCompraLogic registroCompraLogic; 
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    UserTransaction utx;
    
    private List<RegistroCompraEntity> data = new ArrayList<RegistroCompraEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RegistroCompraEntity.class.getPackage())
                .addPackage(RegistroCompraLogic.class.getPackage())
                .addPackage(RegistroCompraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from RegistroCompraEntity").executeUpdate();
  
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
     
        for (int i = 0; i < 3; i++) {
            RegistroCompraEntity entity = factory.manufacturePojo(RegistroCompraEntity.class);
            em.persist(entity);
            data.add(entity);
           
        }
    }
    
    @Test
    public void createRegistroCompraTest() throws BusinessLogicException 
    {
        RegistroCompraEntity newEntity;
        newEntity = factory.manufacturePojo(RegistroCompraEntity.class);
        RegistroCompraEntity result = registroCompraLogic.createRegistroCompra(newEntity);
        Assert.assertNotNull(result);
        RegistroCompraEntity entity = em.find(RegistroCompraEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombreVendedor(), entity.getNombreVendedor());
    }
   
    
   @Test
    public void getRegistrosCompraTest() {
        List<RegistroCompraEntity> list = registroCompraLogic.getRegistrosCompra();
        Assert.assertEquals(data.size(), list.size());
        for(RegistroCompraEntity entity : list) {
            boolean found = false;
            for (RegistroCompraEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar una compra.
     */
    @Test
    public void getRegistroCompraTest() {
        RegistroCompraEntity entity = data.get(0);
        RegistroCompraEntity resultEntity = registroCompraLogic.getRegistroCompra(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombreVendedor(), resultEntity.getNombreVendedor());
    } 
    
         /**
     * Prueba para actualizar un punto de venta.
     */
    @Test
    public void updatePuntoVentaTest()
    {
        RegistroCompraEntity entity = data.get(0);
        RegistroCompraEntity pojoEntity = factory.manufacturePojo(RegistroCompraEntity.class);
        pojoEntity.setId(entity.getId());
        registroCompraLogic.updateRegistroCompra(pojoEntity.getId(), pojoEntity);
        RegistroCompraEntity resp = em.find(RegistroCompraEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombreVendedor(), resp.getNombreVendedor());
    }
    
     /**
     * Prueba para eliminar un registro de compra.
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void deleteRegistroCompraTest() throws BusinessLogicException {
        RegistroCompraEntity entity = data.get(1);
        registroCompraLogic.deleteRegistroCompra( entity.getId());
        RegistroCompraEntity deleted = em.find(RegistroCompraEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
