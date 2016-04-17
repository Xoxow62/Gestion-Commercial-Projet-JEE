package dao;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;


@Singleton
public class DaoOrmImpl  implements Dao, Serializable{
   
    @PersistenceContext
    private EntityManager em; 
 
    @Resource private UserTransaction utx; 
    
    
    @Override
    public void enregistrerEntite(Object entite) {
        
        try {utx.begin();} catch (Exception ex) {}
        em.persist(entite);
        try { utx.commit();} catch (Exception ex) {}
    }
    
    @Override
    public void supprimerEntite(Object entite) {
        
        try {utx.begin();} catch (Exception ex) {}
        Object asupp=em.merge(entite);
        em.remove(asupp);
        try { utx.commit();} catch (Exception ex) {}
    }
   
    @Override
 
    public void repercuterMAJ(Object entite) {
        
        try {utx.begin();} catch (Exception ex) {}
        Object o=em.merge(entite); 
        try { utx.commit();} catch (Exception ex) {}
    }
    

     @Override
    public void detache(Object entite) {
       try {utx.begin();} catch (Exception ex) {}    
       em.detach(entite);
       try { utx.commit();} catch (Exception ex) {}
    }
     
      @Override
    public void rafraichir(Object entite) {
        try {utx.begin();} catch (Exception ex) {}  
        em.refresh(entite);
        try { utx.commit();} catch (Exception ex) {}
    }

}


