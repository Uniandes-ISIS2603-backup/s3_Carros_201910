/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.PuntoVentaClienteLogic;
import co.edu.uniandes.csw.carros.ejb.ClienteLogic;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.PuntoVentaPersistence;
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
public class PuntoVentaClienteLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private PuntoVentaClienteLogic puntoVentaClienteLogic;
    
    @Inject
    private ClienteLogic clienteLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private PuntoVentaEntity punto = new PuntoVentaEntity();
    private List<PuntoVentaEntity> puntos = new ArrayList<>();
    private List<ClienteEntity> data = new ArrayList<>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoVentaEntity.class.getPackage())
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(PuntoVentaClienteLogic.class.getPackage())
                .addPackage(PuntoVentaPersistence.class.getPackage())
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
        em.createQuery("delete from PuntoVentaEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        punto = factory.manufacturePojo(PuntoVentaEntity.class);
        punto.setId(1L);
        puntos.add(punto);
        punto.setClientes(new ArrayList<>());
        em.persist(punto);

        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
            entity.setPuntosVenta(puntos);
            em.persist(entity);
            data.add(entity);
            punto.getClientes().add(entity);
        }
    }
    
    @Test
    public void getClienteTest() throws BusinessLogicException {
        ClienteEntity clienteEntity = data.get(0);
        ClienteEntity cliente = puntoVentaClienteLogic.getCliente(punto.getId(), clienteEntity.getId());
        Assert.assertNotNull(cliente);

        Assert.assertEquals(clienteEntity.getId(), cliente.getId());
    }
}
