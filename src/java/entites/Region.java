package entites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
public class Region implements Serializable {
    
    @Id
    private String codeReg;
    private String nomReg;
    
    @PrivateOwned
    @OneToMany(mappedBy = "laRegion", cascade=CascadeType.ALL)
    private List<Client> lesClients=new LinkedList<Client>();

    public Region() {}

    public Region(String codeRegion, String nomRegion) {
       
        this.codeReg = codeRegion;
        this.nomReg  = nomRegion;
    }
  
    public void afficher(){ System.out.printf("%-10s %20s",codeReg,nomReg);}
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public String getCodeRegion() {
        return codeReg;
    }
    public void   setCodeRegion(String codeRegion) {
        this.codeReg = codeRegion;
    }
    public String getNomRegion() {
        return nomReg;
    }
    public void   setNomRegion(String nomRegion) {
        this.nomReg = nomRegion;
    }
    
    public List<Client> getLesClients() {
        return lesClients;
    }
    public void         setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }
    //</editor-fold>
}


