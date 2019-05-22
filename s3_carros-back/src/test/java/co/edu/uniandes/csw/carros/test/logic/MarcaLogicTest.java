/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.MarcaLogic;
import co.edu.uniandes.csw.carros.entities.MarcaEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.MarcaPersistence;
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
 * @author Andres Forero
 */
@RunWith(Arquillian.class)
public class MarcaLogicTest {
    @Inject 
    private MarcaLogic marcaLogic;
    
    @Inject
    UserTransaction utx;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    private List<MarcaEntity> data = new ArrayList<MarcaEntity>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MarcaEntity.class.getPackage())
                .addPackage(MarcaLogic.class.getPackage())
                .addPackage(MarcaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest(){
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData(){
        em.createQuery("delete from MarcaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData(){
        for(int i=0; i<3; i++){
            MarcaEntity marca = factory.manufacturePojo(MarcaEntity.class);
            em.persist(marca);
            data.add(marca);
        }
    }
    
    /**
     * Prueba para crear una marca
     * @throws BusinessLogicException 
     */
    @Test
    public void createMarcaTest() throws BusinessLogicException 
    {
        MarcaEntity newEntity;
        newEntity = factory.manufacturePojo(MarcaEntity.class);
        MarcaEntity result = marcaLogic.createMarca(newEntity);
        Assert.assertNotNull(result);
        MarcaEntity entity = em.find(MarcaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombreMarca(), entity.getNombreMarca());
        
    }
    
    /**
     * Prueba para comprobar que no se crea una marca con nombre repetido
     * @throws BusinessLogicException 
     */
//  @Test(expected = BusinessLogicException.class)
//  public void createMarcaConMismoNombreTest() throws BusinessLogicException 
//  {
//      MarcaEntity newEntity = factory.manufacturePojo(MarcaEntity.class);
//      newEntity.setNombreMarca(data.get(0).getNombreMarca());
//      marcaLogic.createMarca(newEntity);
//  }
 
    /**
     * Prueba para consultar la lista de marcas
     */
    @Test
    public void getMarcas() {
        List<MarcaEntity> list = marcaLogic.getMarcas();
        Assert.assertEquals(data.size(), list.size());
        for(MarcaEntity entity : list) {
            boolean found = false;
            for (MarcaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar una marca con base en su id
     * @throws BusinessLogicException 
     */
    @Test
    public void getMarcaTest() throws BusinessLogicException{
        MarcaEntity entity = data.get(0);
        MarcaEntity resultEntity = marcaLogic.getMarca(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombreMarca(), resultEntity.getNombreMarca());
    }
    
    /**
     * Prueba para actualizar una marca
     */
    @Test
    public void updateMarcaTest()
    {
        MarcaEntity entity = data.get(0);
        MarcaEntity pojoEntity = factory.manufacturePojo(MarcaEntity.class);
        pojoEntity.setId(entity.getId());
        marcaLogic.updateMarca(pojoEntity);
        MarcaEntity resp = em.find(MarcaEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombreMarca(), resp.getNombreMarca());
    }
    
    /**
     * Prueba para eliminar una queja
     * @throws BusinessLogicException 
     */
    @Test
    public void deleteMarcaTest() throws BusinessLogicException {
        MarcaEntity entity = data.get(1);
        marcaLogic.deleteMarca(entity.getId());
        MarcaEntity deleted = em.find(MarcaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
