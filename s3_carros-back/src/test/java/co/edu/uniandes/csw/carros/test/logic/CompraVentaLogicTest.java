/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.CompraVentaLogic;
import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.entities.FacturaEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.CompraVentaPersistence;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de lógica de CompraVenta.
 *
 * @author Kevin Hernán Castrillón Castañeda.
 */
@RunWith(Arquillian.class)
public class CompraVentaLogicTest 
{
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private CompraVentaLogic compraVentaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<CompraVentaEntity> data = new ArrayList<>();
    
    private List<AutomovilEntity> automovilData = new ArrayList();
    
    private List<PuntoVentaEntity> puntoVentaData = new ArrayList();
    
    private List<EmpleadoEntity> empleadoData = new ArrayList();
    
    private List<ClienteEntity> clienteData = new ArrayList();

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CompraVentaEntity.class.getPackage())
                .addPackage(CompraVentaLogic.class.getPackage())
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
        em.createQuery("delete from AutomovilEntity").executeUpdate();
        em.createQuery("delete from PuntoVentaEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PuntoVentaEntity puntoVenta = factory.manufacturePojo(PuntoVentaEntity.class);
            em.persist(puntoVenta);
            puntoVentaData.add(puntoVenta);
        }
        for (int i = 0; i < 3; i++) {
            EmpleadoEntity empleado = factory.manufacturePojo(EmpleadoEntity.class);
            ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
            AutomovilEntity automovil = factory.manufacturePojo(AutomovilEntity.class);
            empleado.setPuntoVenta(puntoVentaData.get(i));
            cliente.setPuntosVenta(new ArrayList<>());
            em.persist(empleado);
            empleadoData.add(empleado);
            em.persist(cliente);
            clienteData.add(cliente);
            em.persist(automovil);
            automovilData.add(automovil);
        }
        for (int i = 0; i < 3; i++) {
            CompraVentaEntity entity = factory.manufacturePojo(CompraVentaEntity.class);
            entity.setPuntoVenta(puntoVentaData.get(i));
            entity.setEmpleado(empleadoData.get(i));
            entity.setCliente(clienteData.get(i));
            entity.setAutomovilFacturado(automovilData.get(i));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una CompraVenta.
     *
     * @throws BusinessLogicException
     */
    @Test
    public void createCompraVentaTest() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        newEntity.setPuntoVenta(puntoVentaData.get(0));
        newEntity.setEmpleado(empleadoData.get(0));
        newEntity.setCliente(clienteData.get(0));
        newEntity.setAutomovilFacturado(automovilData.get(0));
        CompraVentaEntity result = compraVentaLogic.createCompraVenta(newEntity);
        Assert.assertNotNull(result);
        CompraVentaEntity entity = em.find(CompraVentaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCalificacionCompra(), entity.getCalificacionCompra());
        Assert.assertEquals(newEntity.getComentarios(), entity.getComentarios());
    }

    /**
     * Prueba para crear una CompraVenta con un PuntoVenta que no existe.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConPuntoVentaInexistente() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        PuntoVentaEntity puntoVentaEntity = new PuntoVentaEntity();
        puntoVentaEntity.setId(Long.MIN_VALUE);
        newEntity.setPuntoVenta(puntoVentaEntity);
        newEntity.setEmpleado(empleadoData.get(0));
        newEntity.setCliente(clienteData.get(0));
        newEntity.setAutomovilFacturado(automovilData.get(0));
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
    /**
     * Prueba para crear una CompraVenta con un Cliente que no existe.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConClienteInexistente() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(Long.MIN_VALUE);
        newEntity.setCliente(clienteEntity);
        newEntity.setEmpleado(empleadoData.get(0));
        newEntity.setPuntoVenta(puntoVentaData.get(0));
        newEntity.setAutomovilFacturado(automovilData.get(0));
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
    /**
     * Prueba para crear una CompraVenta con un Empleado que no existe.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConEmpleadoInexistente() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setId(Long.MIN_VALUE);
        newEntity.setEmpleado(empleadoEntity);
        newEntity.setPuntoVenta(puntoVentaData.get(0));
        newEntity.setCliente(clienteData.get(0));
        newEntity.setAutomovilFacturado(automovilData.get(0));
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
    /**
     * Prueba para crear una CompraVenta con un Automovil que no existe.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConAutomovilInexistente() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        AutomovilEntity automovilEntity = new AutomovilEntity();
        automovilEntity.setId(Long.MIN_VALUE);
        newEntity.setAutomovilFacturado(automovilEntity);
        newEntity.setEmpleado(empleadoData.get(0));
        newEntity.setCliente(clienteData.get(0));
        newEntity.setPuntoVenta(puntoVentaData.get(0));
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
    /**
     * Prueba para crear una CompraVenta con PuntoVenta en null.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConNullPuntoVenta() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        newEntity.setAutomovilFacturado(automovilData.get(0));
        newEntity.setEmpleado(empleadoData.get(0));
        newEntity.setCliente(clienteData.get(0));
        newEntity.setPuntoVenta(null);
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
    /**
     * Prueba para crear una CompraVenta con Empleado en null.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConNullEmpleado() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        newEntity.setAutomovilFacturado(automovilData.get(0));
        newEntity.setEmpleado(null);
        newEntity.setCliente(clienteData.get(0));
        newEntity.setPuntoVenta(puntoVentaData.get(0));
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
    /**
     * Prueba para crear una CompraVenta con Cliente en null.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConNullCliente() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        newEntity.setAutomovilFacturado(automovilData.get(0));
        newEntity.setEmpleado(empleadoData.get(0));
        newEntity.setCliente(null);
        newEntity.setPuntoVenta(puntoVentaData.get(0));
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
    /**
     * Prueba para crear una CompraVenta con Automovil en null.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createCompraVentaTestConNullAutomovil() throws BusinessLogicException 
    {
        CompraVentaEntity newEntity = factory.manufacturePojo(CompraVentaEntity.class);
        newEntity.setAutomovilFacturado(null);
        newEntity.setEmpleado(empleadoData.get(0));
        newEntity.setCliente(clienteData.get(0));
        newEntity.setPuntoVenta(puntoVentaData.get(0));
        compraVentaLogic.createCompraVenta(newEntity);
    }
    
     /**
     * Prueba para consultar la lista de CompraVentas.
     */
    @Test
    public void getCompraVentasTest() {
        List<CompraVentaEntity> list = compraVentaLogic.getCompraVentas();
        Assert.assertEquals(data.size(), list.size());
        for (CompraVentaEntity entity : list) {
            boolean found = false;
            for (CompraVentaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
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
        CompraVentaEntity resultEntity = compraVentaLogic.getCompraVenta(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getCalificacionCompra(), resultEntity.getCalificacionCompra());
        Assert.assertEquals(entity.getComentarios(), resultEntity.getComentarios());
    }

    

    /**
     * Prueba para actualizar una CompraVenta
     */
    @Test
    public void updateCompraVentaTest() {
        CompraVentaEntity entity = data.get(0);
        CompraVentaEntity pojoEntity = factory.manufacturePojo(CompraVentaEntity.class);

        pojoEntity.setId(entity.getId());

        compraVentaLogic.updateCompraVenta(pojoEntity.getId(), pojoEntity);

        CompraVentaEntity resp = em.find(CompraVentaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getCalificacionCompra(), resp.getCalificacionCompra());
        Assert.assertEquals(pojoEntity.getComentarios(), resp.getComentarios());
    }
}
