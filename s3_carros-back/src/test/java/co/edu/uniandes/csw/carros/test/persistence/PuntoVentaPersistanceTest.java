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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
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
public class PuntoVentaPersistanceTest 
{
    @Inject
    private PuntoVentaPersistence pvp;
    
    @PersistenceContext
    private EntityManager em; 
    
    private List<PuntoVentaEntity> data = new ArrayList<PuntoVentaEntity>();
    
@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoVentaEntity.class.getPackage())
                .addPackage(PuntoVentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
   }
    @Test
    public void cratedPuntoVentaTest()
    { 
        PodamFactory factory = new PodamFactoryImpl();
        PuntoVentaEntity newEntity = factory.manufacturePojo(PuntoVentaEntity.class);
        
       PuntoVentaEntity pve = pvp.create(newEntity);
       Assert.assertNotNull(pve);
       
       PuntoVentaEntity entity   =  em.find(PuntoVentaEntity.class, pve.getId());
       
    }
    
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
    
    @Test
    public void getPuntoVentaTest() {
        PuntoVentaEntity entity = data.get(0);
        PuntoVentaEntity newEntity = pvp.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());
    }
    
    @Test
    public void deleteEditorialTest() {
        PuntoVentaEntity entity = data.get(0);
        pvp.delete(entity.getId());
        PuntoVentaEntity deleted = em.find(PuntoVentaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateEditorialTest() {
        PuntoVentaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PuntoVentaEntity newEntity = factory.manufacturePojo(PuntoVentaEntity.class);

        newEntity.setId(entity.getId());

        pvp.update(newEntity);

        PuntoVentaEntity resp = em.find(PuntoVentaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getDireccion(), resp.getDireccion());
    }

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
