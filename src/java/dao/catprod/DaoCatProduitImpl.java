package dao.catprod;
import entites.CategorieProduit;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DaoCatProduitImpl implements DaoCatProduit{
    
    @PersistenceContext private EntityManager em;

    @Override
    public CategorieProduit getCatProduit(String pCodeCateg) {
      
        return em.find(CategorieProduit.class, pCodeCateg);
    
    }

    @Override
    public List<CategorieProduit> getTousLesCatProd() {
        return em.createQuery("Select c from CategorieProduit c").getResultList();
    }
    
}
