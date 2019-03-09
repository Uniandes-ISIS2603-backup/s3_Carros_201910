/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;

import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.persistence.AutomovilPersistence;
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
 * @author Andres Forero
 */
@RunWith(Arquillian.class)
public class AutomovilPersistenceTest {
    
    @Inject
    private AutomovilPersistence ap;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<AutomovilEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeplyment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AutomovilEntity.class.getPackage())
                .addPackage(AutomovilPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
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
        em.createQuery("delete from AutomovilEntity").executeUpdate();
    }
    
    
    public void insertData(){
      PodamFactory factory = new PodamFactoryImpl();
      for(int i=0;i<3; i++){
            AutomovilEntity entity = factory.manufacturePojo(AutomovilEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
   
    @Test
    public void createAutomovilTest(){
      PodamFactory factory = new PodamFactoryImpl();
      AutomovilEntity newEntity = factory.manufacturePojo(AutomovilEntity.class);
      AutomovilEntity result = ap.create(newEntity);
      
       Assert.assertNotNull(result);
       
       AutomovilEntity entity = em.find(AutomovilEntity.class, result.getId());
       
       Assert.assertEquals(newEntity.getIdChasis(), entity.getIdChasis());
    }
    
    @Test
    public void findAutomovilTest(){
        AutomovilEntity entity = data.get(0);
        AutomovilEntity search = ap.findAutomovil(entity.getId());
        
        Assert.assertNotNull(search);
        Assert.assertEquals(entity.getId(), search.getId());
    }
    
    @Test
    public void findAllAutomovilesTest(){
        TypedQuery<AutomovilEntity> query = em.createQuery("Select u from AutomovilEntity u", AutomovilEntity.class);
        Assert.assertEquals(query.getResultList(),ap.findAllAutomoviles());
    } 
    
    @Test
    public void deleteAutomovilTest(){
        AutomovilEntity entity = data.get(1);
        ap.deleteAutomovil(entity.getId());
        AutomovilEntity search = em.find(AutomovilEntity.class, entity.getId());
        Assert.assertNull(search);        
    }
    
    @Test
    public void updateAutomovilTest(){
        AutomovilEntity entity = data.get(0);
        entity.setCuidadMatricula("tokio");
        ap.updateAutomovil(entity);
        AutomovilEntity search = em.find(AutomovilEntity.class, entity.getId());
        Assert.assertEquals(search.getCuidadMatricula(), "tokio");
    }
   
    
}
