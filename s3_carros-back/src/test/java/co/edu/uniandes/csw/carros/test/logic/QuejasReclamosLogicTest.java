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
import java.util.concurrent.ThreadLocalRandom;
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
            Long j = new Long(i);
            queja.setCarroId(j);
            queja.setSolucionado(false);
            int random = ThreadLocalRandom.current().nextInt(0, 6);
            queja.setTipo(random);
            queja.setComentarios(random == 5 && queja.getComentarios().isEmpty()? "sdfghjkl": queja.getComentarios());
            em.persist(queja);
            data.add(queja);
        }
    }
    
    @Test
    public void createQuejasReclamosTest() throws BusinessLogicException 
    {
        QuejasReclamosEntity newEntity;
        newEntity = factory.manufacturePojo(QuejasReclamosEntity.class);
        newEntity.setSolucionado(false);
        int random = ThreadLocalRandom.current().nextInt(0, 6);
        newEntity.setTipo(random);
        newEntity.setComentarios(random == 5 && newEntity.getComentarios().isEmpty()? "sdfghjkl": newEntity.getComentarios());
        QuejasReclamosEntity result = quejasReclamosLogic.createQuejasReclamos(newEntity);
        Assert.assertNotNull(result);
        QuejasReclamosEntity entity = em.find(QuejasReclamosEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCarroId(), entity.getCarroId());
        
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createQuejasReclamosConMismoIdTest() throws BusinessLogicException 
    {
        QuejasReclamosEntity newEntity = factory.manufacturePojo(QuejasReclamosEntity.class);
        newEntity.setSolucionado(false);
        int random = ThreadLocalRandom.current().nextInt(0, 6);
        newEntity.setTipo(random);
        newEntity.setComentarios(random == 5 && newEntity.getComentarios().isEmpty()? "sdfghjkl": newEntity.getComentarios());
        newEntity.setCarroId(data.get(0).getCarroId());
        quejasReclamosLogic.createQuejasReclamos(newEntity);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createQuejasReclamosTipoInvalido() throws BusinessLogicException 
    {
        QuejasReclamosEntity newEntity = factory.manufacturePojo(QuejasReclamosEntity.class);
        newEntity.setSolucionado(true);
        int random = ThreadLocalRandom.current().nextInt(6, 100);
        newEntity.setTipo(random);
        newEntity.setCarroId(data.get(0).getCarroId());
        quejasReclamosLogic.createQuejasReclamos(newEntity);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createQuejasReclamosTipoOtroSinComentarios() throws BusinessLogicException 
    {
        QuejasReclamosEntity newEntity = factory.manufacturePojo(QuejasReclamosEntity.class);
        newEntity.setSolucionado(false);
        newEntity.setTipo(5);
        newEntity.setComentarios("");
        newEntity.setCarroId(data.get(0).getCarroId());
        quejasReclamosLogic.createQuejasReclamos(newEntity);
    }
    
    @Test
    public void getQuejasReclamosTest() {
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
    public void getQuejaTest() throws BusinessLogicException{
        QuejasReclamosEntity entity = data.get(0);
        QuejasReclamosEntity resultEntity = quejasReclamosLogic.getQueja(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getCarroId(), resultEntity.getCarroId());
    }
    
    @Test
    public void updateQuejasReclamosTest()
    {
        QuejasReclamosEntity entity = data.get(0);
        QuejasReclamosEntity pojoEntity = factory.manufacturePojo(QuejasReclamosEntity.class);
        pojoEntity.setId(entity.getId());
        quejasReclamosLogic.updateQuejasReclamos(pojoEntity.getId(), pojoEntity);
        QuejasReclamosEntity resp = em.find(QuejasReclamosEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getCarroId(), resp.getCarroId());
    }
    
     @Test
    public void deleteQuejasReclamosTest() throws BusinessLogicException {
        QuejasReclamosEntity entity = data.get(1);
        quejasReclamosLogic.deleteQuejasReclamos(entity.getId());
        QuejasReclamosEntity deleted = em.find(QuejasReclamosEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    
}
