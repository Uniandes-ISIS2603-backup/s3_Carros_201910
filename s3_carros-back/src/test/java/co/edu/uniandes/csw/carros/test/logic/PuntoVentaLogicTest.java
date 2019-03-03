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
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import static org.glassfish.pfl.basic.tools.argparser.ElementParser.factory;
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
public class PuntoVentaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private PuntoVentaLogic puntoVentaLogic;
    
    @PersistenceContext
    private EntityManager em; 
    
    @Inject
    private UserTransaction utx;
    
    private List<PuntoVentaEntity> data = new ArrayList<PuntoVentaEntity>();
    
    private List<ClienteEntity> clienteData = new ArrayList();
    
    private List<EmpleadoEntity> empleadoData = new ArrayList(); 
    
    private List<RegistroCompraEntity> registroCompraData = new ArrayList();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoVentaEntity.class.getPackage())
                .addPackage(PuntoVentaLogic.class.getPackage())
                .addPackage(PuntoVentaPersistence.class.getPackage())
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
        em.createQuery("delete from PuntoVentaEntity").executeUpdate();
  
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
     
        for (int i = 0; i < 3; i++) {
            PuntoVentaEntity entity = factory.manufacturePojo(PuntoVentaEntity.class);
            em.persist(entity);
            data.add(entity);
           
        }
    }
    @Test
    public void createPuntoVentaTest() throws BusinessLogicException 
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
    public void createPuntoVentaConMismaDireccionTest() throws BusinessLogicException 
    {
        PuntoVentaEntity newEntity = factory.manufacturePojo(PuntoVentaEntity.class);
        newEntity.setDireccion(data.get(0).getDireccion());
        puntoVentaLogic.createPuntoVenta(newEntity);
    }
    
     
    @Test
    public void getPuntosVentaTest() {
        List<PuntoVentaEntity> list = puntoVentaLogic.getPuntosVenta();
        Assert.assertEquals(data.size(), list.size());
        for(PuntoVentaEntity entity : list) {
            boolean found = false;
            for (PuntoVentaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
        /**
     * Prueba para consultar un punto de venta.
     */
    @Test
    public void getPuntoVentaTest() {
        PuntoVentaEntity entity = data.get(0);
        PuntoVentaEntity resultEntity = puntoVentaLogic.getPuntoVenta(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getDireccion(), resultEntity.getDireccion());
    }

    /**
     * Prueba para actualizar un punto de venta.
     */
    @Test
    public void updatePuntoVentaTest()
    {
        PuntoVentaEntity entity = data.get(0);
        PuntoVentaEntity pojoEntity = factory.manufacturePojo(PuntoVentaEntity.class);
        pojoEntity.setId(entity.getId());
        puntoVentaLogic.updatePuntoVenta(pojoEntity.getId(), pojoEntity);
        PuntoVentaEntity resp = em.find(PuntoVentaEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getDireccion(), resp.getDireccion());
    }
    
     /**
     * Prueba para eliminar un punto de venta.
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
     @Test
    public void deletePuntoVentaTest() throws BusinessLogicException {
        PuntoVentaEntity entity = data.get(1);
        puntoVentaLogic.deletePuntoVenta(entity.getId());
        PuntoVentaEntity deleted = em.find(PuntoVentaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
