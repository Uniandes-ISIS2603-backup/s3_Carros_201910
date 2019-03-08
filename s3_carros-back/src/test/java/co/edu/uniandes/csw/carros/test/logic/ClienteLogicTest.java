/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.ClienteLogic;
import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.entities.PuntoVentaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.ClientePersistence;
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
public class ClienteLogicTest {
    
    @Inject 
    private ClienteLogic clienteLogic;
    
    @Inject
    UserTransaction utx;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    private List<ClienteEntity> data = new ArrayList<ClienteEntity>();
    private List<PuntoVentaEntity> puntosVenta = new ArrayList<>();
    
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
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
    
    private void clearData(){
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
        em.createQuery("delete from PuntoVentaEntity").executeUpdate();
    }
    
    private void insertData(){
        for(int i=0; i<2; i++){
            PuntoVentaEntity entity = factory.manufacturePojo(PuntoVentaEntity.class);
            em.persist(entity);
            puntosVenta.add(entity);
        }
        for(int i=0; i<3; i++){
            ClienteEntity empleado = factory.manufacturePojo(ClienteEntity.class);
            em.persist(empleado);
            data.add(empleado);
        }
    }
    
    @Test
    public void createClienteTest() throws BusinessLogicException{
        ClienteEntity nuevoCliente = factory.manufacturePojo(ClienteEntity.class);
        nuevoCliente.setPuntosVenta(puntosVenta);
        ClienteEntity result = clienteLogic.createCliente(nuevoCliente);
        Assert.assertNotNull(result);
        ClienteEntity entity = em.find(ClienteEntity.class, result.getId());
        Assert.assertEquals(nuevoCliente.getId(), entity.getId());
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createClienteConMismoCorreoTest()throws BusinessLogicException{
        ClienteEntity nuevoCliente = factory.manufacturePojo(ClienteEntity.class);
        nuevoCliente.setPuntosVenta(puntosVenta);
        nuevoCliente.setCorreo(data.get(0).getCorreo());
        clienteLogic.createCliente(nuevoCliente);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createClienteSinPuntoVenta() throws BusinessLogicException{
        ClienteEntity nuevoCliente = factory.manufacturePojo(ClienteEntity.class);
        nuevoCliente.setPuntosVenta(new ArrayList<>());
        clienteLogic.createCliente(nuevoCliente);
    }
    
    @Test
    public void updateClienteTest() throws BusinessLogicException{
        ClienteEntity nuevoCliente = factory.manufacturePojo(ClienteEntity.class);
        ClienteEntity cliente = data.get(0);
        cliente.setCorreo(nuevoCliente.getCorreo());
        clienteLogic.updateCliente(cliente);
        ClienteEntity search = em.find(ClienteEntity.class, cliente.getId());
        Assert.assertEquals(search.getCorreo(), cliente.getCorreo());
    }
    
    @Test(expected = BusinessLogicException.class)
    public void updateClienteConMismoCorreoTest() throws BusinessLogicException{
        ClienteEntity cliente = data.get(0);
        cliente.setCorreo(data.get(1).getCorreo());
        clienteLogic.updateCliente(cliente);
    }
    
    @Test
    public void deleteEmpleadoTest(){
        ClienteEntity cliente = data.get(0);
        clienteLogic.deleteCliente(cliente.getId());
        ClienteEntity deleted = em.find(ClienteEntity.class, cliente.getId());
        Assert.assertNull(deleted);
    }
}
