package entites;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
public class Produit implements Serializable {
    
    @Id
    private String refProd;   
    private String desigProd;
    private Float  prixProd;
   
    @PrivateOwned
    @OneToMany(mappedBy = "leProduit", cascade=CascadeType.ALL)
    private List<LigneDeCommande>lesLignesDeCommande=new LinkedList<LigneDeCommande>();
    @OneToMany(mappedBy = "produit")
    private List<TrancheTarifaire>TrancheTarifaire=new LinkedList<TrancheTarifaire>();
   
    
    @JoinColumn(name="CODECATEG")
    @ManyToOne
    private CategorieProduit laCategorie;
     
    public Produit (){
    }

    public Produit(String refProd,String desigProd, Float prixProd, CategorieProduit categProd) {
       
        this.refProd   = refProd;
        this.desigProd = desigProd;
        this.prixProd  = prixProd;
        this.laCategorie = categProd;
    }
    
    public void afficher(){
    
        System.out.printf("%-10s  %-20s  %5.2f",refProd,desigProd,prixProd);
    }
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public List<TrancheTarifaire> getTrancheTarifaire() {
        return TrancheTarifaire;
    }

    public void setTrancheTarifaire(List<TrancheTarifaire> TrancheTarifaire) {
        this.TrancheTarifaire = TrancheTarifaire;
    }
    
    public String getRefProd() {
        return refProd;
    }
    public void   setRefProd(String refProd) {
        this.refProd = refProd;
    }
    public String getDesigProd() {
        return desigProd;
    }
    public void   setDesigProd(String desigProd) {
        this.desigProd = desigProd;
    }
    public List<LigneDeCommande> getLesLignesDeCommande() {
        return lesLignesDeCommande;
    }
    public void   setLesLignesDeCommande(List<LigneDeCommande> lesLignesDeCommande) {
        this.lesLignesDeCommande = lesLignesDeCommande;
    }
    public Float  getPrixProd() {
        return prixProd;
    }
    public void   setPrixProd(Float prixProd) {
        this.prixProd = prixProd;
    }
    public CategorieProduit getLaCategorie() {
        return laCategorie;
    }
    public void setLaCategorie(CategorieProduit laCategorie) {
        this.laCategorie = laCategorie;
    }
    
    //</editor-fold>

    
}
    
