/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.CompraVentaLogic;
import co.edu.uniandes.csw.carros.ejb.CompraVentaQuejasLogic;
import co.edu.uniandes.csw.carros.ejb.QuejasReclamosLogic;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
import javax.inject.Inject;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class CompraVentaQuejasLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private CompraVentaQuejasLogic compraVentaQuejasLogic;
    
    @Inject
    private QuejasReclamosLogic quejasLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private CompraVentaEntity compra = new CompraVentaEntity();
    private List<QuejasReclamosEntity> data = new ArrayList<>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CompraVentaEntity.class.getPackage())
                .addPackage(QuejasReclamosEntity.class.getPackage())
                .addPackage(CompraVentaQuejasLogic.class.getPackage())
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
        em.createQuery("delete from QuejasReclamosEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        compra = factory.manufacturePojo(CompraVentaEntity.class);
        compra.setId(1L);
        compra.setQuejasReclamos(new ArrayList<>());
        em.persist(compra);

        for (int i = 0; i < 3; i++) {
            QuejasReclamosEntity entity = factory.manufacturePojo(QuejasReclamosEntity.class);
            entity.setCompraVenta(compra);
            em.persist(entity);
            data.add(entity);
            compra.getQuejasReclamos().add(entity);
        }
    }
    
    
    @Test
    public void getQuejasTest() throws BusinessLogicException {
        QuejasReclamosEntity quejasEntity = data.get(0);
        QuejasReclamosEntity quejas = compraVentaQuejasLogic.getQueja(compra.getId(), quejasEntity.getId());
        Assert.assertNotNull(quejas);

        Assert.assertEquals(quejas.getId(), quejasEntity.getId());
    }
    
}
