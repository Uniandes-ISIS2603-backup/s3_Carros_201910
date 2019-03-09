/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.EmpleadoLogic;
import co.edu.uniandes.csw.carros.entities.EmpleadoEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.EmpleadoPersistence;
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
 *
 * @author Juan Pablo Patarroyo Duque
 */
@RunWith(Arquillian.class)
public class EmpleadoLogicTest {
    
    @Inject 
    private EmpleadoLogic empleadoLogic;
    
    @Inject
    UserTransaction utx;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext 
    private EntityManager em;
    
    private List<EmpleadoEntity> data = new ArrayList<EmpleadoEntity>();
    
    private PuntoVentaEntity puntoVenta;
    
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EmpleadoEntity.class.getPackage())
                .addPackage(EmpleadoLogic.class.getPackage())
                .addPackage(EmpleadoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
        /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest(){
        try{
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        }catch(Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            } catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
        /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData(){
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
        em.createQuery("delete from PuntoVentaEntity").executeUpdate();
    }
    
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData(){
        puntoVenta = factory.manufacturePojo(PuntoVentaEntity.class);
        em.persist(puntoVenta);
        
        for(int i=0; i<3; i++){
            EmpleadoEntity empleado = factory.manufacturePojo(EmpleadoEntity.class);
            empleado.setPuntoVenta(puntoVenta);
            em.persist(empleado);
            data.add(empleado);
        }
    }
    
        /**
     * Prueba para crear un Empleado.
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void createEmpleadoTest() throws BusinessLogicException{
        EmpleadoEntity nuevoEmpleado = factory.manufacturePojo(EmpleadoEntity.class);
        nuevoEmpleado.setPuntoVenta(puntoVenta);
        EmpleadoEntity result = empleadoLogic.createEmpleado(nuevoEmpleado);
        Assert.assertNotNull(result);
        EmpleadoEntity entity = em.find(EmpleadoEntity.class, result.getId());
        Assert.assertEquals(nuevoEmpleado.getId(), entity.getId());
    }
    

    @Test(expected = BusinessLogicException.class)
    public void createEmpleadoConMismoCorreoTest()throws BusinessLogicException{
        EmpleadoEntity nuevoEmpleado = factory.manufacturePojo(EmpleadoEntity.class);
        nuevoEmpleado.setPuntoVenta(puntoVenta);
        nuevoEmpleado.setCorreo(data.get(0).getCorreo());
        empleadoLogic.createEmpleado(nuevoEmpleado);
    }
    
     /**
     * Prueba para crear un Empleado sin un punto de venta.
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createEmpleadoSinPuntoDeVenta() throws NullPointerException, BusinessLogicException{
        EmpleadoEntity nuevoEmpleado = factory.manufacturePojo(EmpleadoEntity.class);
        nuevoEmpleado.setPuntoVenta(null);
        empleadoLogic.createEmpleado(nuevoEmpleado);
    }
    
    
    /**
     * Prueba para actualizar un Empleado.
     */
    @Test
    public void updateEmpleadoTest() throws BusinessLogicException{
        EmpleadoEntity empleado = data.get(0);
        empleado.setCorreo("aaaaa");
        empleadoLogic.updateEmpleado(empleado);
        EmpleadoEntity search = em.find(EmpleadoEntity.class, empleado.getId());
        Assert.assertEquals(search.getCorreo(), empleado.getCorreo());
    }
    
     /**
     * Prueba para actualizar un Empleado con un correo que ya aparece en la base de datos.
     */
    @Test(expected = BusinessLogicException.class)
    public void updateEmpleadoConMismoCorreoTest() throws BusinessLogicException{
        EmpleadoEntity empleado = data.get(0);
        empleado.setCorreo(data.get(1).getCorreo());
        empleadoLogic.updateEmpleado(empleado);
    }
       
    /**
     * Prueba para eliminar un Empleado.
     */
    @Test
    public void deleteEmpleadoTest(){
        EmpleadoEntity empleado = data.get(0);
        empleadoLogic.deleteEmpleado(empleado.getId());
        EmpleadoEntity deleted = em.find(EmpleadoEntity.class, empleado.getId());
        Assert.assertNull(deleted);
    }
    
    
    
}

