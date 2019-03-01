/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;

import co.edu.uniandes.csw.carros.entities.ClienteEntity;
import co.edu.uniandes.csw.carros.persistence.ClientePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
public class ClientePersistenceTest {
    
    @Inject
    private ClientePersistence cp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<ClienteEntity> data = new ArrayList<ClienteEntity>();
  
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Before
    public void configTest(){
        try{
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch(Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            } catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
   private void clearData(){
       em.createQuery("delete from ClienteEntity").executeUpdate();
   }
    
   private void insertData(){
       PodamFactory factory = new PodamFactoryImpl();
       for(int i=0; i<3; i++){
           ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
           em.persist(entity);
           data.add(entity);
       }
   }
   
   @Test
   public void createClienteTest(){
       PodamFactory factory = new PodamFactoryImpl();
       ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
       
       ClienteEntity ee = cp.create(newEntity);
       Assert.assertNotNull(ee);
        
       ClienteEntity entity = em.find(ClienteEntity.class, newEntity.getId());
       Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
   }
   
   @Test
    public void findClienteTest(){
        
        ClienteEntity entity = data.get(0);
        ClienteEntity search = cp.findCliente(entity.getId());
        
        Assert.assertNotNull(search);
        Assert.assertEquals(entity.getNombre(), search.getNombre());
    }
    
    @Test
    public void findAllClientesTest(){
        TypedQuery<ClienteEntity> query = em.createQuery("Select u from ClienteEntity u", ClienteEntity.class);
        Assert.assertEquals(query.getResultList(), cp.findAllClientes());
    }
    
    @Test
    public void deleteCliente(){
        ClienteEntity entity = data.get(1);
        cp.deleteCliente(entity.getId());
        ClienteEntity search = em.find(ClienteEntity.class, entity.getId());
        Assert.assertNull(search);
    }
    
    @Test
    public void updateClienteTest(){
        ClienteEntity entity = data.get(0);
        entity.setNombre("Juan Osorio");
        cp.updateCliente(entity);
        ClienteEntity search = em.find(ClienteEntity.class, entity.getId());
        Assert.assertEquals(search.getNombre(),"Juan Osorio" );
    }
    
    @Test
    public void finEmpleadoPorCorreoTest(){
        ClienteEntity entity = data.get(0);
        String correo = cp.findClientePorCorreo(entity.getCorreo()).getCorreo();   
        TypedQuery<ClienteEntity> query = em.createQuery("Select u From EmpleadoEntity u where u.correo = :correo", ClienteEntity.class);
        query = query.setParameter("correo", correo);
        Assert.assertEquals(correo, query.getSingleResult().getCorreo());
    }
    
}

