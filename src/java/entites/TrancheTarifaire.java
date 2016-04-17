package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TrancheTarifaire implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTranche;
    private Float prixUnitaireTranche;
    private Float QteDebutTranche;
    private Float QteFinTranche;
    @JoinColumn(name="REFPROD")
    @ManyToOne
    private Produit produit;

    public TrancheTarifaire() {
    }


    public TrancheTarifaire (Long id,Float prixUnitaireTranche, Float QteDebutTranche, Float QteFinTranche, Produit prod) {
        
        this.idTranche = id;
        this.prixUnitaireTranche = prixUnitaireTranche;
        this.QteDebutTranche  = QteDebutTranche;
        this.QteFinTranche = QteFinTranche;
        this.produit = prod;
        
    }
  
    public void afficher(){ System.out.printf("%-10s %20s",prixUnitaireTranche,QteDebutTranche,QteFinTranche);}

    //<editor-fold defaultstate="collapsed" desc="G & S">
    
    public Float getPrixUnitaireTranche() {
        return prixUnitaireTranche;
    }
    
    public void setPrixUnitaireTranche(Float prixUnitaireTranche) {
        this.prixUnitaireTranche = prixUnitaireTranche;
    }
    
    public Float getQteDebutTranche() {
        return QteDebutTranche;
    }
    
    public void setQteDebutTranche(Float QteDebutTranche) {
        this.QteDebutTranche = QteDebutTranche;
    }
    
    public Float getQteFinTranche() {
        return QteFinTranche;
    }
    
    public void setQteFinTranche(Float QteFinTranche) {
        this.QteFinTranche = QteFinTranche;
    }
    
        public Long getIdTranche() {
        return idTranche;
    }

    public void setIdTranche(Long idTranche) {
        this.idTranche = idTranche;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    
    //</editor-fold>


 
    
    
}


