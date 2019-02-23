/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;

import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
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
       
       Assert.assertEquals(newEntity.getDirreccion(), entity.getDirreccion());
       
    }
}
