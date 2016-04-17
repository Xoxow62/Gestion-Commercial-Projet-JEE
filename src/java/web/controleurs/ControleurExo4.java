
package web.controleurs;

import bal.client.BalClient;
import bal.commande.BalCommande;
import dao.Dao;
import entites.Client;
import entites.Commande;
import entites.Region;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import web.beans.TableAssocClients;
import web.beans.TableAssocRegions;

/**
 *
 * @author rsmon
 */

@Named
@SessionScoped
public class ControleurExo4 implements Serializable{
     
    
    @Inject Dao dao;
    
    @Inject
    private BalCommande balCommande;
    
    @Inject
    private BalClient balClient; 
    
   
    @Inject
    private TableAssocClients tClients;
     
    @Inject
    private TableAssocRegions tRegions;
    
    @Inject
    private ControleurExo2 contExo2;
    
    private List<Client> lesClients;
    
    private Client client;
    
    private Float caClient;
    private Float soldeClient;
    
    private List<Commande> listeCommandes;
    
    private Commande commandeSel;
    
    private String messageTableau;
    
    private List<Region> lesRegions;
    private Region       regionSel;
   
    
    SelectOneMenu      choixRegion;
    
    
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
        lesRegions=tRegions.getListe();
        
        
    }
    
    
     public void traiterSelectionCombo(){
    
        if (client!=null){
           
            client.setLaRegion(tRegions.getObjet(client.getLaRegion().getCodeRegion()));
         
           messageTableau="Pas de commande pour ce client";
        } 
        
         System.out.println("Selection Combo");
        
    }
    
     
    public void traiterChangementRegion(){
    
        System.out.println("changement region");
      
       
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
      
      FacesMessage msg = new FacesMessage("Commande Sélectionnée",commandeSel.getNumCom().toString());
      FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void enregisterModifications(){
        
        System.out.println("Modification enregistée");
        
        System.out.println(client.getNumCli());
        System.out.println(client.getNomCli());
        System.out.println(client.getAdrCli());
        System.out.println(client.getLaRegion());
        dao.repercuterMAJ(client);
    
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

    public List<Region> getLesRegions() {
        return lesRegions;
    }

    public void setLesRegions(List<Region> lesRegions) {
        this.lesRegions = lesRegions;
    }

    public Region getRegionSel() {
        return regionSel;
    }

    public void setRegionSel(Region regionSel) {
        this.regionSel = regionSel;
    }

    
    
}
