package work.controleurs;

import bal.client.BalClient;
import bal.commande.BalCommande;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import web.beans.TableAssocClients;

/**
 *
 * @author rsmon
 */
@Named
@RequestScoped
public class ContExo4 implements Serializable{
  
    
    @Inject  private TableAssocClients tClients;
    
    @Inject
    private BalCommande balCommande;
    
    @Inject
    private BalClient   balClient; 
    
     
    private List<Client>   lesClients;
    private Client         client;
    
    private Float          caClient;
    private Float          soldeClient;
    
    private List<Commande> listeCommandes;
    private Commande       commandeSel;
    
    private String         messageTableau;
     
    public void prevalide(ComponentSystemEvent e){
         
         this.client=new Client();
        
         this.messageTableau=null;
    }
     
    
    @PostConstruct
    public void init(){
     
        lesClients=tClients.getListe();
        System.out.println(lesClients);
        if (! lesClients.isEmpty()) {
           client=lesClients.get(0);   
           traiterSelectionCombo();
        }
        
    }
    
    
     public void traiterSelectionCombo(){
    
        if (client!=null){
         
           messageTableau="Pas de commande pour ce client";
           
           this.listeCommandes=client.getLesCommandes();           
        }    
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

    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public List<Client> getLesClients() {
        return lesClients;
    }
    
    public void setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Float getCaClient() {
        return caClient;
    }
    
    public void setCaClient(Float caClient) {
        this.caClient = caClient;
    }
    
    public Float getSoldeClient() {
        return soldeClient;
    }
    
    public void setSoldeClient(Float soldeClient) {
        this.soldeClient = soldeClient;
    }
    
    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }
    
    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }
    
    public Commande getCommandeSel() {
        return commandeSel;
    }
    
    public void setCommandeSel(Commande commandeSel) {
        this.commandeSel = commandeSel;
    }
    
    public String getMessageTableau() {
        return messageTableau;
    }
    
    public void setMessageTableau(String messageTableau) {
        this.messageTableau = messageTableau;
    }
    //</editor-fold>
    
    
}
