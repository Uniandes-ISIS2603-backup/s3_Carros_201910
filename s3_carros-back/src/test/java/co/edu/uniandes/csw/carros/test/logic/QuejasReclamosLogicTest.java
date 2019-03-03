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
            QuejasReclamosEntity empleado = factory.manufacturePojo(QuejasReclamosEntity.class);
            em.persist(empleado);
            data.add(empleado);
        }
    }
    
    @Test
    public void createQuejasReclamosTest() throws BusinessLogicException{
        QuejasReclamosEntity nuevaQueja = factory.manufacturePojo(QuejasReclamosEntity.class);
        QuejasReclamosEntity result = quejasReclamosLogic.createQuejasReclamos(nuevaQueja);
        Assert.assertNotNull(result);
        QuejasReclamosEntity entity = em.find(QuejasReclamosEntity.class, result.getId());
        Assert.assertEquals(nuevaQueja.getCarroId(), entity.getCarroId());
    }
    
    
}
