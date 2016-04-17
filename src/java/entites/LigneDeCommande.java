package entites;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneDeCommande implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private Float qteCom;
    
    @JoinColumn(name="NUMCOM")
    @ManyToOne
    private Commande laCommande;
    
    @JoinColumn(name="REFPROD")
    @ManyToOne
    private Produit leProduit;
    
    public LigneDeCommande(){}

    public LigneDeCommande(Commande laCommande, Produit leProduit, Float qteCom ) {
       
        this.qteCom = qteCom;
        this.laCommande = laCommande;
        this.leProduit = leProduit;
    }

    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Float getQteCom() {
        return qteCom;
    }
    public void setQteCom(Float qteCom) {
        this.qteCom = qteCom;
    }
    public Commande getLaCommande() {
        return laCommande;
    }
    public void setLaCommande(Commande laCommande) {
        this.laCommande = laCommande;
    }
    public Produit getLeProduit() {
        return leProduit;
    }
    public void setLeProduit(Produit leProduit) {
        this.leProduit = leProduit;
    }
    //</editor-fold>
}
