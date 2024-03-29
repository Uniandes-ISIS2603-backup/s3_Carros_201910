/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;

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
 *Prueba si las entidades de persisten efectivamente
 * @author Daniel Lozano
 */
@RunWith(Arquillian.class)    
public class PuntoVentaPersistanceTest 
{
    /**
     * 
     */
    @Inject
    private PuntoVentaPersistence pvp;
    
    /**
     * 
     */
    @PersistenceContext  
    private EntityManager em;  
    
    /**
     * 
     */
    @Inject
    UserTransaction utx;
    
    /**
     * Lista con entidades de punto de venta
     */
    private List<PuntoVentaEntity> data = new ArrayList<PuntoVentaEntity>();
   

    
@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoVentaEntity.class.getPackage())
                .addPackage(PuntoVentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
   }
    
    /**
     * Meotdo a ejecutar antes de los test
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
    private void clearData() 
    {
        em.createQuery("delete from PuntoVentaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) 
        {
            PuntoVentaEntity entity = factory.manufacturePojo(PuntoVentaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
  
    /**
     * Prueba que se cree efectivamente un punto de venta
     */
    @Test
    public void cratedPuntoVentaTest()
    {
 
    PodamFactory factory = new PodamFactoryImpl();
    PuntoVentaEntity newEntity = factory.manufacturePojo(PuntoVentaEntity.class);                
    PuntoVentaEntity pve = pvp.create(newEntity);
    
    Assert.assertNotNull(pve);
      
    PuntoVentaEntity entity   =  em.find(PuntoVentaEntity.class, pve.getId());
       
    Assert.assertEquals(newEntity.getDireccion(), entity.getDireccion());
       
    }
    
    /**
     * Prueba que se cogan todos los puntos de venta 
     */
    @Test
    public void getPuntosVentaTest()
    {
        List<PuntoVentaEntity> list = pvp.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(PuntoVentaEntity ent : list)
        {
            boolean found = false; 
            for(PuntoVentaEntity entity : data)
            {
                if(ent.getId().equals(entity.getId()))
                {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Purba de que se encuentre efectivemtne un punto de venta
     */
    @Test
    public void getPuntoVentaTest() {
        PuntoVentaEntity entity = data.get(0);
        PuntoVentaEntity newEntity = pvp.find(entity.getId());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }
    
    /**
     * Prueba que se elimene efectivamente un punto de venta
     */
    @Test
    public void deletePuntosTest() {
        PuntoVentaEntity entity = data.get(0);
        pvp.delete(entity.getId());
        PuntoVentaEntity deleted = em.find(PuntoVentaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba de que se actualice efectivmetne el punto de venta
     */
    @Test
    public void updatePuntoVentaTest() {
        PuntoVentaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PuntoVentaEntity newEntity = factory.manufacturePojo(PuntoVentaEntity.class);

        newEntity.setId(entity.getId());

        pvp.update(newEntity);

        PuntoVentaEntity resp = em.find(PuntoVentaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getDireccion(), resp.getDireccion());
    }

    /**
     * Prueba de que se ecuentre efectiavemte un punto de venta por su direccion
     */
    @Test
    public void findPuntoVentaByDireccionTest() {
        PuntoVentaEntity entity = data.get(0);
        PuntoVentaEntity newEntity = pvp.findByDireccion(entity.getDireccion());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());

        newEntity = pvp.findByDireccion(null);
        Assert.assertNull(newEntity);
    }
}
