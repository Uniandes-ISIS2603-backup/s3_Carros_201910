/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.AutomovilLogic;
import co.edu.uniandes.csw.carros.entities.AutomovilEntity;
import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.entities.RegistroCompraEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.AutomovilPersistence;
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
 * @author Andres Forero
 */
@RunWith(Arquillian.class)
public class AutomovilLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private AutomovilLogic autoLogic;
    
    @Inject
    UserTransaction utx;
    
    @PersistenceContext
    private EntityManager em;
    

    
    private List<AutomovilEntity> data = new ArrayList<>();
    
    private ModeloEntity modelo;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AutomovilEntity.class.getPackage())
                .addPackage(AutomovilLogic.class.getPackage())
                .addPackage(AutomovilPersistence.class.getPackage())
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
      modelo = factory.manufacturePojo(ModeloEntity.class);
      em.persist(modelo);
      for(int i=0;i<3; i++){
            AutomovilEntity entity = factory.manufacturePojo(AutomovilEntity.class);
            RegistroCompraEntity reg = factory.manufacturePojo(RegistroCompraEntity.class);
            entity.setModelo(modelo);
            entity.setRegistroCompra(reg);
            em.persist(entity);
            data.add(entity);
        }
    }
    @Test
    public void createAutomovilTest() throws BusinessLogicException{
        
        AutomovilEntity newEntity = factory.manufacturePojo(AutomovilEntity.class); 
        AutomovilEntity result = autoLogic.createAutomovil(newEntity);
        Assert.assertNotNull(result);
        AutomovilEntity entity = em.find(AutomovilEntity.class, result.getId());
        Assert.assertEquals(newEntity.getIdChasis(), entity.getIdChasis());
    }
    
    
    @Test(expected = BusinessLogicException.class)
    public void createAutomovilMismoID() throws BusinessLogicException
    {
        AutomovilEntity newEntity = factory.manufacturePojo(AutomovilEntity.class);
        newEntity.setIdChasis(data.get(0).getIdChasis());
        autoLogic.createAutomovil(newEntity);
    }
    
    @Test
    public void getAutomovilesTest() {
        List<AutomovilEntity> list = autoLogic.getAutomoviles();
        for(AutomovilEntity entity : list) {
            boolean found = false;
            for (AutomovilEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void updateAutomovilTest() 
    {
        AutomovilEntity entity = data.get(0);
        AutomovilEntity pojoEntity = factory.manufacturePojo(AutomovilEntity.class);
        pojoEntity.setId(entity.getId());
        autoLogic.updateAutomovil(pojoEntity);
        AutomovilEntity resp = em.find(AutomovilEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getIdChasis(), resp.getIdChasis());
    }
    
    
    
    
    
    
    
    
}
