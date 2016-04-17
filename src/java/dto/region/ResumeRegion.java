package dto.region;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResumeRegion {
    
    
    private String codeReg;
    private String nomReg;
    private Float caAnnuel;
    private int nbClient;

    public ResumeRegion() {
        
    }

    //<editor-fold defaultstate="collapsed" desc="G & S">
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
    
    
    public Float getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Float caAnnuel) {
        this.caAnnuel = caAnnuel;
    }
    
        public int getNbClient() {
        return nbClient;
    }

    public void setNbClient(int nbClient) {
        this.nbClient = nbClient;
    }
    
    
    //</editor-fold>



    

}




