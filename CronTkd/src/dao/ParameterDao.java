/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidades.Parameter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Diego Muniz <diego2605@gmail.com>
 */
public class ParameterDao {
    private static ParameterDao service;
    private static final EntityManagerFactory factory;
    
    static{
        factory = Persistence.createEntityManagerFactory("CronPU");
    }
    
    private EntityManager entityManager;

    private ParameterDao(){
        super();
    }
     public static ParameterDao getInstance(){

        if(service == null){
            service = new ParameterDao();
        }

        return service;
    }
     private EntityManager getEntityManager() {
    	if (entityManager == null) {
    		entityManager = factory.createEntityManager();
    	}
    	
    	return entityManager;
    }
      private void closeEntityManager() {
    	if (entityManager != null) {
    		entityManager.close();
    		entityManager = null;
    	}
    }
      
      public void closeHsqldb(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try{
            em.createNativeQuery("SHUTDOWN").executeUpdate();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            closeEntityManager();
            factory.close();
        }
    }
      
      
      
    @SuppressWarnings("unchecked")
	public List<Parameter> recoverAllParameters() {
        EntityManager em = getEntityManager();
        
        try {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Parameter> criteria = cb.createQuery(Parameter.class);
                Root<Parameter> selector = criteria.from(Parameter.class);
                criteria.select(selector);
	        Query query = em.createQuery(criteria);
	        List<Parameter> result = query.getResultList();
	        return result;
        } finally {
        	closeEntityManager();
        }
    }

    public void saveParameters(List<Parameter> tableData) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try{
            for (Parameter p : tableData) {
                if(p.getID() != null){
                    Parameter e = em.find(Parameter.class, p.getID());
                    em.merge(p);
                }else{
                    em.persist(p);
                }
            }
            boolean teste = em.getTransaction().isActive();
            try{
            em.getTransaction().commit();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception(e);
        }finally{
            closeEntityManager();
        }
    }

    public void exclude(Parameter entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try{
            entity = em.merge(entity);
            em.remove(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            try {
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally{
            closeEntityManager();
        }
    }

   /* public void saveProfileList(List<Profile> profileList) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try{
            for (Profile p : profileList) {
                if(p.getId() == null){
                    em.persist(p);
                }else{
                    em.merge(p);
                }
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            try {
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally{
            closeEntityManager();
        }
    }*/
    
    public void openConnection() {
        this.getEntityManager();
        this.closeEntityManager();
    }    
    
    
}
