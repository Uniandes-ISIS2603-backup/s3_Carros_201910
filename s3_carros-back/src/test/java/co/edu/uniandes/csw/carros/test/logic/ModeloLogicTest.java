/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.carros.test.logic;

import co.edu.uniandes.csw.carros.ejb.ModeloLogic;
import co.edu.uniandes.csw.carros.entities.ModeloEntity;
import co.edu.uniandes.csw.carros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.carros.persistence.ModeloPersistence;
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
public class ModeloLogicTest {
    @Inject 
    private ModeloLogic modeloLogic;
    
    @Inject
    UserTransaction utx;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    private List<ModeloEntity> data = new ArrayList<ModeloEntity>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ModeloEntity.class.getPackage())
                .addPackage(ModeloLogic.class.getPackage())
                .addPackage(ModeloPersistence.class.getPackage())
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
        em.createQuery("delete from ModeloEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData(){
        for(int i=0; i<3; i++){
            ModeloEntity modelo = factory.manufacturePojo(ModeloEntity.class);
            em.persist(modelo);
            data.add(modelo);
        }
    }
    
    /**
     * Prueba para crear un modelo
     * @throws BusinessLogicException 
     */
    @Test
    public void createModeloTest() throws BusinessLogicException 
    {
        ModeloEntity newEntity;
        newEntity = factory.manufacturePojo(ModeloEntity.class);
        ModeloEntity result = modeloLogic.createModelo(newEntity);
        Assert.assertNotNull(result);
        ModeloEntity entity = em.find(ModeloEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        
    }
    
    /**
     * Prueba para comprobar que no se crea una modelo con nombre repetido
     * @throws BusinessLogicException 
     */
//  @Test(expected = BusinessLogicException.class)
//  public void createModeloConMismoNombreTest() throws BusinessLogicException 
//  {
//      ModeloEntity newEntity = factory.manufacturePojo(ModeloEntity.class);
//      newEntity.setNombre(data.get(0).getNombre());
//      modeloLogic.createModelo(newEntity);
//  }
   
    /**
     * Prueba para consultar la lista de marcas
     */
    @Test
    public void getMarcas() {
        List<ModeloEntity> list = modeloLogic.getModelos();
        Assert.assertEquals(data.size(), list.size());
        for(ModeloEntity entity : list) {
            boolean found = false;
            for (ModeloEntity storedEntity : data) {
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
    public void getModeloTest() throws BusinessLogicException{
        ModeloEntity entity = data.get(0);
        ModeloEntity resultEntity = modeloLogic.getModelo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
    }
    
    /**
     * Prueba para actualizar una marca
     */
    @Test
    public void updateMarcaTest()
    {
        ModeloEntity entity = data.get(0);
        ModeloEntity pojoEntity = factory.manufacturePojo(ModeloEntity.class);
        pojoEntity.setId(entity.getId());
        modeloLogic.updateModelo(pojoEntity);
        ModeloEntity resp = em.find(ModeloEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
    }
    
    /**
     * Prueba para eliminar una queja
     * @throws BusinessLogicException 
     */
    @Test
    public void deleteMarcaTest() throws BusinessLogicException {
        ModeloEntity entity = data.get(1);
        modeloLogic.deleteModelo(entity.getId());
        ModeloEntity deleted = em.find(ModeloEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
