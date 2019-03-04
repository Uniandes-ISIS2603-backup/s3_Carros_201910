/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.QuejasReclamosLogic;
import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.QuejasReclamosPersistence;
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
 * @author Julio Ruiz
 */
@RunWith(Arquillian.class)
public class QuejasReclamosLogicTest {
    
    @Inject 
    private QuejasReclamosLogic quejasReclamosLogic;
    
    @Inject
    UserTransaction utx;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    private List<QuejasReclamosEntity> data = new ArrayList<QuejasReclamosEntity>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(QuejasReclamosEntity.class.getPackage())
                .addPackage(QuejasReclamosLogic.class.getPackage())
                .addPackage(QuejasReclamosPersistence.class.getPackage())
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
        em.createQuery("delete from QuejasReclamosEntity").executeUpdate();
    }
    
    private void insertData(){
        for(int i=0; i<3; i++){
            QuejasReclamosEntity queja = factory.manufacturePojo(QuejasReclamosEntity.class);
            em.persist(queja);
            data.add(queja);
        }
    }
    
    @Test
    public void createQuejasReclamosTest() throws BusinessLogicException{
        QuejasReclamosEntity nuevaQueja = factory.manufacturePojo(QuejasReclamosEntity.class);
        QuejasReclamosEntity result = quejasReclamosLogic.createQuejasReclamos(nuevaQueja);
        Assert.assertNotNull(result);
        QuejasReclamosEntity entity = em.find(QuejasReclamosEntity.class, result.getId());
        Assert.assertEquals(nuevaQueja.getCarroId(), entity.getCarroId());
        Assert.assertEquals(nuevaQueja.getCarroId(), entity.getCarroId());
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createQuejasReclamosConMismoId() throws BusinessLogicException 
    {
        QuejasReclamosEntity newEntity = factory.manufacturePojo(QuejasReclamosEntity.class);
        newEntity.setCarroId(data.get(0).getCarroId());
        quejasReclamosLogic.createQuejasReclamos(newEntity);
    }
    
     
    @Test
    public void getPuntosVentaTest() {
        List<QuejasReclamosEntity> list = quejasReclamosLogic.getQuejasReclamos();
        Assert.assertEquals(data.size(), list.size());
        for(QuejasReclamosEntity entity : list) {
            boolean found = false;
            for (QuejasReclamosEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getPuntoVentaTest() throws BusinessLogicException{
        QuejasReclamosEntity entity = data.get(0);
        QuejasReclamosEntity resultEntity = quejasReclamosLogic.getQueja(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getCarroId(), resultEntity.getCarroId());
    }
}
