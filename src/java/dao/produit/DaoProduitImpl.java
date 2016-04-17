package dao.produit;
import entites.Produit;
import java.io.Serializable;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DaoProduitImpl  implements DaoProduit, Serializable{

    @PersistenceContext private EntityManager em;
    
    @Override
    public Produit getProduit(String pRefProd) {
        return em.find(Produit.class, pRefProd);
    }    
}
