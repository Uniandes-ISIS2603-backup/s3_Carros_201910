/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;


import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.persistence.ModeloPersistence;
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

import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import org.junit.Test;

/**
 *
 * @author Andres Forero
 */
@RunWith(Arquillian.class)
public class ModeloPersistenceTest {
    
    @Inject
    private ModeloPersistence mp;
    
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    
    private List<ModeloEntity> data = new ArrayList<>();
    
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ModeloEntity.class.getPackage())
                .addPackage(ModeloPersistence.class.getPackage())
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
      em.createQuery("delete from MarcaEntity").executeUpdate();
    }
    
    
    public void insertData(){
      PodamFactory factory = new PodamFactoryImpl();
      for(int i=0;i<3; i++){
            ModeloEntity entity = factory.manufacturePojo(ModeloEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test 
    public void createModeloTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ModeloEntity newEntity = factory.manufacturePojo(ModeloEntity.class);
        ModeloEntity result = mp.createModelo(newEntity);
        
        Assert.assertNotNull(result);  
        
        ModeloEntity entity = em.find(ModeloEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        
    }
    
    @Test
    public void findModeloTest(){
        ModeloEntity entity = data.get(0);
        ModeloEntity search = mp.findModelo(entity.getId());
        
        Assert.assertNotNull(search);
        Assert.assertEquals(entity.getId(), search.getId());
    }
    
    
    @Test
    public void findAllModelosTest(){
        TypedQuery<ModeloEntity> query = em.createQuery("Select u from ModeloEntity u", ModeloEntity.class);
        Assert.assertEquals(query.getResultList(), mp.findAllModelos());
    }
    
    
    @Test
    public void deleteModeloTest(){
        ModeloEntity entity = data.get(1);
        mp.deleteModelo(entity.getId());
        ModeloEntity search = em.find(ModeloEntity.class, entity.getId());
        Assert.assertNull(search);
    }
    
    @Test
    public void updateModeloTest(){
        ModeloEntity entity = data.get(0);
        entity.setNombre("spark GT");
        mp.updateMarca(entity);
        ModeloEntity search = em.find(ModeloEntity.class, entity.getId());
        Assert.assertEquals("spark GT", search.getNombre());
               
    }
    
    
    
}
