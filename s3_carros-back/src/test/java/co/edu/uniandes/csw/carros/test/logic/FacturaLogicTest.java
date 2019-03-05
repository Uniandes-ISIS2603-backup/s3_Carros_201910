/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.FacturaLogic;
import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.CompraVentaEntity;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.entities.FacturaEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.FacturaPersistence;
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
 * Pruebas de lógica de Factura.
 *
 * @author Kevin Hernán Castrillón Castañeda.
 */
@RunWith(Arquillian.class)
public class FacturaLogicTest 
{
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private FacturaLogic facturaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<FacturaEntity> data = new ArrayList<>();

    private CompraVentaEntity compraVenta;

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaLogic.class.getPackage())
                .addPackage(FacturaPersistence.class.getPackage())
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
        em.createQuery("delete from FacturaEntity").executeUpdate();
        em.createQuery("delete from CompraVentaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() 
    {
        compraVenta = factory.manufacturePojo(CompraVentaEntity.class);
        em.persist(compraVenta);
        CompraVentaEntity compraVenta2 = factory.manufacturePojo(CompraVentaEntity.class);
        em.persist(compraVenta2);
        for (int i = 0; i < 3; i++) 
        {
            FacturaEntity entity = factory.manufacturePojo(FacturaEntity.class);
            entity.setCompraVenta(compraVenta2);
            em.persist(entity);
            data.add(entity);
        }
    }
    
     /**
     * Prueba para crear una Factura
     *
     * @throws BusinessLogicException
     */
    @Test
    public void createFacturaTest() throws BusinessLogicException 
    {
        FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
        newEntity.setCompraVenta(compraVenta);
        FacturaEntity result = facturaLogic.createFactura(newEntity);
        Assert.assertNotNull(result);
        FacturaEntity entity = em.find(FacturaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCuentaOrigen(), entity.getCuentaOrigen());
    }
    
    /**
     * Prueba para crear una Factura con una CompraVenta que no existe.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createFacturaTestConCompraVentaInexistente() throws BusinessLogicException, NullPointerException
    {
        FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
        CompraVentaEntity compraVentaEntity = new CompraVentaEntity();
        compraVentaEntity.setId(Long.MIN_VALUE);
        newEntity.setCompraVenta(compraVentaEntity);
        facturaLogic.createFactura(newEntity);
    }
    
     /**
     * Prueba para crear una Factura con CompraVenta en null.
     *
     * @throws BusinessLogicException
     */
    @Test(expected = NullPointerException.class)
    public void createFacturaTestConNullCompraVenta() throws BusinessLogicException, NullPointerException
    {
        FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
        newEntity.setCompraVenta(null);
        facturaLogic.createFactura(newEntity);
    }
    
     /**
     * Prueba para consultar la lista de Facturas.
     */
    @Test
    public void getFacturasTest() {
        List<FacturaEntity> list = facturaLogic.getFacturas();
        Assert.assertEquals(data.size(), list.size());
        for (FacturaEntity entity : list) {
            boolean found = false;
            for (FacturaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Factura.
     */
    @Test
    public void getFacturaTest() {
        FacturaEntity entity = data.get(0);
        FacturaEntity resultEntity = facturaLogic.getFactura(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getCuentaOrigen(), resultEntity.getCuentaOrigen());
    }
}
