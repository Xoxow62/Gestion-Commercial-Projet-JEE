package dao.region;

import entites.Region;
import java.io.Serializable;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rsmon
 */

@Singleton
public class DaoRegionImpl  implements DaoRegion,Serializable {

    @PersistenceContext private EntityManager em;
    
    @Override
    public List<Region> getToutesLesRegions() {
     
        return em.createQuery("Select r from Region r").getResultList();
    }
    
    public Region getLaRegion(String CodeReg){
    
    return em.find(Region.class, CodeReg);
    
    }
}
