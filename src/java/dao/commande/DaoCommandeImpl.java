package dao.commande;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static utilitaire.UtilDate.*;

@Singleton
public class DaoCommandeImpl   implements DaoCommande, Serializable{

    @PersistenceContext private EntityManager em;
    
    @Override
    public Commande getCommande(Long pNumCom) {
        return em.find(Commande.class, pNumCom);
    }

    @Override
    public List<Commande> getToutesLesCommandes() {
        return em.createQuery("Select c from Commande c").getResultList();
    }   

    @Override
    public List<Commande> getLesCommandesduClient(Client client) {
        return client.getLesCommandes();
    }

    @Override
    public List<Commande> getLesCommandesduClient(Client client, int pAnnee) {
        
       List<Commande> lc= new LinkedList<Commande>();
       
       for(Commande c :client.getLesCommandes() ){
       
          if( annee(c.getDateCom())== pAnnee){lc.add(c); }
       
       }
       return lc;
    }

    @Override
    public List<Commande> getLesCommandesduClient(Client client, int pAnnee, int pMois) {
        
       List<Commande> lc= new LinkedList<Commande>();
       
       for(Commande c :client.getLesCommandes() ){
       
          if( annee(c.getDateCom())== pAnnee && mois(c.getDateCom())==pMois ){
          
              lc.add(c);
          }
       
       }
       return lc;
    }
}
