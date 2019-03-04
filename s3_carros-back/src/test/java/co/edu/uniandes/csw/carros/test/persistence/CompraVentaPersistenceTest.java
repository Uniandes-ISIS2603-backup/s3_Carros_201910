/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;

import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
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
 * Pruebas de persistencia de CompraVenta.
 *
 * @author Kevin hernán Castrillón Castañeda
 */
@RunWith(Arquillian.class)
public class CompraVentaPersistenceTest 
{
    @Inject
    private CompraVentaPersistence compraVentaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<CompraVentaEntity> data = new ArrayList<>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CompraVentaEntity.class.getPackage())
                .addPackage(CompraVentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
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
    private void clearData() {
        em.createQuery("delete from CompraVentaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

            CompraVentaEntity entity = factory.manufacturePojo(CompraVentaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una CompraVenta.
     */
    @Test
    public void createCompraVentaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        CompraVentaEntity result = compraVentaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CompraVentaEntity entity = em.find(CompraVentaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getComentarios(), entity.getComentarios());
        Assert.assertEquals(newEntity.isPagado(), entity.isPagado());
    }

    /**
     * Prueba para consultar la lista de CompraVentas.
     */
    @Test
    public void getCompraVentasTest() {
        List<CompraVentaEntity> list = compraVentaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CompraVentaEntity ent : list) {
            boolean found = false;
            for (CompraVentaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una CompraVenta.
     */
    @Test
    public void getCompraVentaTest() {
        CompraVentaEntity entity = data.get(0);
        CompraVentaEntity newEntity = compraVentaPersistence.findByID(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }
    
     /**
     * Prueba para actualizar una CompraVenta.
     */
    @Test
    public void updateCompraVentaTest() {
        CompraVentaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);

        newEntity.setId(entity.getId());

        compraVentaPersistence.update(newEntity);

        CompraVentaEntity resp = em.find(CompraVentaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
}
