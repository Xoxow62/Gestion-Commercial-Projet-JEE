
package web.controleurs;

import bal.client.BalClient;
import bal.commande.BalCommande;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import web.beans.TableAssocClients;

/**
 *
 * @author rsmon
 */

@Named
@SessionScoped
public class CtlCommandesParClientTabSel implements Serializable{
     
    @Inject
    private BalCommande balCommande;
    
    @Inject
    private BalClient balClient; 
    
    @Inject
    private TableAssocClients tClients;
         
    private List<Client> lesClients;
    
    private Client client;
    
    private Float caClient;
    private Float soldeClient;
    
    private List<Commande> listeCommandes;
    
    private Commande commandeSel;
    
    private String messageTableau;
   
    public void prevalide(ComponentSystemEvent e){
         
         this.client=new Client();
        
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
    
    
     public void traiterSelectionCombo(){
    
        if (client!=null){
         
           messageTableau="Pas de commande pour ce client";
                
        } 
    }
    
    public String rafraichir(){
        this.tClients.rafraichir();return null;
    }
    public Float montantCommandeHt(Commande cmd){
     return balCommande.montantCommandeHT(cmd);
    }
    
    public Float montantCommandeTTC(Commande cmd){
      return balCommande.montantCommandeTTC(cmd);
    }
    
    public Float calculCaClient(){

       return balClient.caAnneeEnCours(client);
    }
    
    public Float calculSoldeClient(){
      return -balClient.resteARegler(client);
    }
    
    public void afficherCommande(){
    
        System.out.println(commandeSel.getNumCom());
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
    
    public BalClient getBalClient() {
        return balClient;
    }

    public Float getCaClient() {
        return caClient;
    }

    public Float getSoldeClient() {
        return soldeClient;
    }
    
     public Commande getCommandeSel() {
        return commandeSel;
    }

    public void setCommandeSel(Commande commandeSel) {
        this.commandeSel = commandeSel;
    }
    
    //</editor-fold>
}
