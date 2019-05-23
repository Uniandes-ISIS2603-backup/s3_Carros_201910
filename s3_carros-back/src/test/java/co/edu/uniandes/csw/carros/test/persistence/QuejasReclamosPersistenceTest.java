/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.persistence;

import co.edu.uniandes.csw.carros.entities.QuejasReclamosEntity;
import co.edu.uniandes.csw.carros.persistence.QuejasReclamosPersistence;
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
 * @author Julio Ruiz
 */
@RunWith(Arquillian.class)
public class QuejasReclamosPersistenceTest {

    @Inject
    private QuejasReclamosPersistence qrp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<QuejasReclamosEntity> data = new ArrayList<>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(QuejasReclamosEntity.class.getPackage())
                .addPackage(QuejasReclamosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     */
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
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    public void clearData(){
      em.createQuery("delete from QuejasReclamosEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData(){
      PodamFactory factory = new PodamFactoryImpl();
      for(int i=0;i<3; i++){
            QuejasReclamosEntity entity = factory.manufacturePojo(QuejasReclamosEntity.class);
            Long j = new Long(i);
            entity.setCasoId(j);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una instancia de unaqueja
     */
    @Test
    public void createQuejasReclamosTest() {
        
        PodamFactory factory = new PodamFactoryImpl();
        QuejasReclamosEntity newEntity = factory.manufacturePojo(QuejasReclamosEntity.class);
        
        QuejasReclamosEntity qre = qrp.create(newEntity);
        
        Assert.assertNotNull(qre);
        
        QuejasReclamosEntity entity = em.find(QuejasReclamosEntity.class, qre.getId());
        
        Assert.assertEquals(newEntity.getCasoId(), entity.getCasoId());
        
    }
    
    /**
     * Prueba para consultar una instancia de una queja
     */
    @Test
    public void findQuejasReclamosTest(){
        QuejasReclamosEntity entity = data.get(0);
        QuejasReclamosEntity search = qrp.find(entity.getId());
        
        Assert.assertNotNull(search);
        Assert.assertEquals(entity.getCasoId(), search.getCasoId());
    }
    
    /**
     * Prueba para consultar todas las instancias de quejas
     */
    @Test
    public void findALLQuejasReclamosTest(){
        TypedQuery<QuejasReclamosEntity> query = em.createQuery("Select u from QuejasReclamosEntity u",QuejasReclamosEntity.class);
        Assert.assertEquals(query.getResultList(), qrp.findAll());
    }
    
    /**
     * Prueba para eliminar una instancia de una queja
     */
    @Test
    public void deleteQuejasReclamosTest(){
        QuejasReclamosEntity entity = data.get(1);
        qrp.delete(entity.getId());
        QuejasReclamosEntity search = em.find(QuejasReclamosEntity.class, entity.getId());
        Assert.assertNull(search);
    }
    
    /**
     * Prueba para actualizar una instancia de una queja
     */
    @Test
    public void updateQuejasReclamosTest(){
        QuejasReclamosEntity entity = data.get(0);
        entity.setSolucionado(true);
        qrp.update(entity);
        QuejasReclamosEntity search = em.find(QuejasReclamosEntity.class, entity.getId());
        Assert.assertEquals(true, search.isSolucionado());
    }
    
    /**
     * Prueba para encontrar una instancia de una queja con su casoId
     */
    @Test
    public void findQuejasReclamosByIdTest() {
        QuejasReclamosEntity entity = data.get(0);
        Long id = qrp.findByName(entity.getCasoId()).getCasoId();   
        TypedQuery<QuejasReclamosEntity> query = em.createQuery("Select u From QuejasReclamosEntity u where u.casoId = :casoId", QuejasReclamosEntity.class);
        query = query.setParameter("casoId", id);
        Assert.assertEquals(id, query.getSingleResult().getCasoId());
    }
}
