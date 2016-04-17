package dto.commande;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResumeCommande {
    
  private Long    numcom;
  private Date    datecom;
  private String  etatcom;
  private Float   montantHT;
  private Float   montantTTC;  
  private Float   tauxTVA; 
  private Long    numCli;
  private String  nomCli;
  private String  adrCli;
  private String  codeReg;
  private String  nomReg;

    public ResumeCommande() {
        
    }

    public ResumeCommande(Long numCom, Date dateCom, String etatCom, Float montantCommandeHT, Float montantCommandeTTC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //<editor-fold defaultstate="collapsed" desc="G & S ">
    public Long getNumcom() {
        return numcom;
    }
    
    public void setNumcom(Long numcom) {
        this.numcom = numcom;
    }
    
    public Date getDatecom() {
        return datecom;
    }
    
    public void setDatecom(Date datecom) {
        this.datecom = datecom;
    }
    
    public String getEtatcom() {
        return etatcom;
    }
    
    public void setEtatcom(String etatcom) {
        this.etatcom = etatcom;
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
    
    public Float getTauxTVA() {
        return tauxTVA;
    }
    
    public void setTauxTVA(Float tauxTVA) {
        this.tauxTVA = tauxTVA;
    }
    
    public Long getNumCli() {
        return numCli;
    }
    
    public void setNumCli(Long numCli) {
        this.numCli = numCli;
    }
    
    public String getNomCli() {
        return nomCli;
    }
    
    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }
    
    public String getAdrCli() {
        return adrCli;
    }
    
    public void setAdrCli(String adrCli) {
        this.adrCli = adrCli;
    }
    
    public String getCodeReg() {
        return codeReg;
    }
    
    public void setCodeReg(String codeReg) {
        this.codeReg = codeReg;
    }
    
    public String getNomReg() {
        return nomReg;
    }
    
    public void setNomReg(String nomReg) {
        this.nomReg = nomReg;
    }
    
    //</editor-fold>
  
}




