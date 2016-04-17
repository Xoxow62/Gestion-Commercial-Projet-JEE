package dto.lignecommande;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResumeLigneCommande {
    
    private String refProd;   
    private String desigProd;
    private Float  prixProd;
    private Float qteCom;
    private Float montantHT;
    private Float montantTTC;

    public ResumeLigneCommande() {
        
    }

    
    //<editor-fold defaultstate="collapsed" desc="G & S">
    
    public String getRefProd() {
        return refProd;
    }
    
    public void setRefProd(String refProd) {
        this.refProd = refProd;
    }
    
    public String getDesigProd() {
        return desigProd;
    }
    
    public void setDesigProd(String desigProd) {
        this.desigProd = desigProd;
    }
    
    public Float getPrixProd() {
        return prixProd;
    }
    
    public void setPrixProd(Float prixProd) {
        this.prixProd = prixProd;
    }
    
    public Float getQteCom() {
        return qteCom;
    }
    
    public void setQteCom(Float qteCom) {
        this.qteCom = qteCom;
    }
    
    public Float getMontantHT() {
        return montantHT;
    }
    
    public void setMontantHT(Float montantHT) {
        this.montantHT = montantHT;
    }
    
    public Float getMontantTTC() {
        return montantTTC;
    }
    
    public void setMontantTTC(Float montantTTC) {
        this.montantTTC = montantTTC;
    }
    
    
    //</editor-fold>
    
   
}




