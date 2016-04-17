
package web.controleurs;

import bal.client.BalClient;
import bal.commande.BalCommande;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import web.beans.TableAssocClients;

/**
 *
 * @author rsmon
 */

@ManagedBean
@SessionScoped
public class ControleurExo3 implements Serializable{
    
    @Inject
    private BalCommande balCommande;
    
    @Inject
    private BalClient balClient; 
    
    @Inject
    private TableAssocClients tClients;
     
    private List<Client> lesClients;
    
    private Client client;
    
    private List<Commande> listeCommandes;
    
    private String messageTableau;
   
    public void prevalide(ComponentSystemEvent e){
         
         this.client=new Client();
         this.setListeCommandes(new LinkedList<Commande>()); 
         this.messageTableau=null;
    }
     
    
    @PostConstruct
    public void init(){
    
        tClients.rafraichir();
        lesClients=tClients.getListe();
        if (! lesClients.isEmpty()) {
           client=lesClients.get(0);   
           traiterSelectionCombo();
        }  
    }
    
    
    public Float montantCommandeHt(Commande cmd){
     return balCommande.montantCommandeHT(cmd);
    }
    
    public Float montantCommandeTTC(Commande cmd){
      return balCommande.montantCommandeTTC(cmd);
    }
    
    public void traiterSelectionCombo(){
    
            if (client!=null){
                listeCommandes=client.getLesCommandes();
                messageTableau="Pas de commande pour ce client";
            } 
    }
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
 
    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }
    
    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }
    
    public String getMessageTableau() {
        return messageTableau;
    }

    public void setMessageTableau(String messageTableau) {
        this.messageTableau = messageTableau;
    }
    
    public List<Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }

    public BalCommande getBalCommande() {
        return balCommande;
    }
    //</editor-fold>

    

    

}
