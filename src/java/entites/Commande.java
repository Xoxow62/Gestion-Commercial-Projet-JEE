package entites;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
public class Commande implements Serializable {
    
    @Id
    private Long numCom;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCom;
   
    private String etatCom;
    
    @PrivateOwned
    @OneToMany(mappedBy = "laCommande", cascade=CascadeType.ALL)
    private List<LigneDeCommande>lesLignesDeCommande=new LinkedList<LigneDeCommande>();
    
    @JoinColumn(name="NUMCLI")
    @ManyToOne
    private Client leClient;
    
    public Commande(){        
    }

    public Commande(Long numCom,Date dateCom, String etatCom, Client leClient) {
        
        this.numCom   = numCom;
        this.dateCom  = dateCom;
        this.etatCom  = etatCom;
        this.leClient = leClient;
    }
    
    public void afficher(){
    
        System.out.printf("%6d %-10s %2s", numCom,dateCom,etatCom);
    
    }
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public Long getNumCom() {
        return numCom;
    }
    public void setNumCom(Long numCom) {
        this.numCom = numCom;
    }
    public Date getDateCom() {
        return dateCom;
    }
    public void setDateCom(Date dateCom) {
        this.dateCom = dateCom;
    }
    public String getEtatCom() {
        return etatCom;
    }
    public void setEtatCom(String etatCom) {
        this.etatCom = etatCom;
    }
    public List<LigneDeCommande> getLesLignesDeCommande() {
        return lesLignesDeCommande;
    }
    public void setLesLignesDeCommande(List<LigneDeCommande> lesLignesDeCommande) {
        this.lesLignesDeCommande = lesLignesDeCommande;
    }
    public Client getLeClient() {
        return leClient;
    }
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }
    //</editor-fold>
}




