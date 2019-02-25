/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;

import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import co.edu.uniandes.csw.carros.persistence.RegistroCompraPersistence;
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
public class RegistroCompraPersistanceTest 
{
 @Inject
 private RegistroCompraPersistence rcp;

@PersistenceContext
private EntityManager em;

private List<RegistroCompraEntity> data = new ArrayList<RegistroCompraEntity>();

@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RegistroCompraEntity.class.getPackage())
                .addPackage(RegistroCompraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
   }

@Test
 public void cratedRegistroCompraTest()
    {
        PodamFactory factory = new PodamFactoryImpl();
        RegistroCompraEntity newEntity = factory.manufacturePojo(RegistroCompraEntity.class);
        
        RegistroCompraEntity rce = rcp.create(newEntity);
        Assert.assertNotNull(rce);
        
        RegistroCompraEntity entity = em.find(RegistroCompraEntity.class, rce.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
 
  /**
     * Prueba para consultar la lista de Editoriales.
     */
    @Test
    public void getEditorialsTest() {
        List<RegistroCompraEntity> list = rcp.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (RegistroCompraEntity ent : list) {
            boolean found = false;
            for (RegistroCompraEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Editorial.
     */
    @Test
    public void getEditorialTest() {
        RegistroCompraEntity entity = data.get(0);
        RegistroCompraEntity newEntity = rcp.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Prueba para eliminar una Editorial.
     */
    @Test
    public void deleteEditorialTest() {
        RegistroCompraEntity entity = data.get(0);
        rcp.delete(entity.getId());
        RegistroCompraEntity deleted = em.find(RegistroCompraEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Editorial.
     */
    @Test
    public void updateEditorialTest() {
        RegistroCompraEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        RegistroCompraEntity newEntity = factory.manufacturePojo(RegistroCompraEntity.class);

        newEntity.setId(entity.getId());

        rcp.update(newEntity);

        RegistroCompraEntity resp = em.find(RegistroCompraEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Prueba para consultar una Editorial por nombre.
     */
    @Test
    public void findRegistroCompraByNombreVendedorTest() {
        RegistroCompraEntity entity = data.get(0);
        RegistroCompraEntity newEntity = rcp.findByVendedorName(entity.getNombreVendedor());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombreVendedor(), newEntity.getNombreVendedor());

        newEntity = rcp.findByVendedorName(null);
        Assert.assertNull(newEntity);
    }
}
