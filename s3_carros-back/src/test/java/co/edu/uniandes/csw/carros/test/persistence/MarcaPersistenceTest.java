/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;


import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import co.edu.uniandes.csw.carros.persistence.MarcaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
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
public class MarcaPersistenceTest {
    
    @Inject    
    private MarcaPersistence mp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<MarcaEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeplyment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MarcaEntity.class.getPackage())
                .addPackage(MarcaPersistence.class.getPackage())
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
            MarcaEntity entity = factory.manufacturePojo(MarcaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test    
    public void createMarcaTest(){
        PodamFactory factory = new PodamFactoryImpl();
        MarcaEntity newEntity = factory.manufacturePojo(MarcaEntity.class);
        MarcaEntity result = mp.create(newEntity);       
        
        Assert.assertNotNull(result);   
        
        MarcaEntity entity = em.find(MarcaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNombreMarca(), entity.getNombreMarca());
        
    }
    
    @Test
    public void findMarcaTest(){
        MarcaEntity entity = data.get(0);
        MarcaEntity search = mp.findMarca(entity.getId());
        
        Assert.assertNotNull(search);
        Assert.assertEquals(entity.getId(), search.getId());
    }
    @Test
    public void findALLMarcasTest(){
        TypedQuery<MarcaEntity> query = em.createQuery("Select u from MarcaEntity u",MarcaEntity.class);
        Assert.assertEquals(query.getResultList(), mp.findAllMarcas());
    }
    
    @Test
    public void deleteMarcaTest(){
        MarcaEntity entity = data.get(1);
        mp.deleteMarca(entity.getId());
        MarcaEntity search = em.find(MarcaEntity.class, entity.getId());
        Assert.assertNull(search);
    }
    
    @Test
    public void updateMarcaTest(){
        MarcaEntity entity = data.get(0);
        entity.setNombreMarca("concord");
        mp.updateMarca(entity);
        MarcaEntity search = em.find(MarcaEntity.class, entity.getId());
        Assert.assertEquals("concord", search.getNombreMarca());
    }
    
    
    
    
    
}
