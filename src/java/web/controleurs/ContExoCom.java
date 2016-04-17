package web.controleurs;

import dao.client.DaoClient;
import dao.commande.DaoCommande;
import bal.commande.BalCommande;
import bal.client.BalClient;
import entites.Client;
import dao.tva.DaoTva;
import entites.Commande;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ContExoCom implements Serializable{
  
    @Inject private DaoClient daoClient;
    @Inject private DaoCommande daoCommande;
    @Inject private BalClient balClient;
    @Inject private BalCommande balCommande;
    @Inject private DaoTva daoTva;
    
  
    private Long      numcomRecherche;
    private Commande    commande;
    private Float       caClient;
    private Float       soldeClient;
    private Float       montantHT;
    private Float       montantTTC;
    private Float       tva;
    public void ecouteurRecherche(){
    
        if(numcomRecherche!=null){ 
            commande=daoCommande.getCommande(numcomRecherche);
            caClient=balClient.caAnneeEnCours(commande.getLeClient());
            calculMontantHT();
            calculMontantTTC();
            soldeClient();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="g & s ">
    
    public void calculMontantHT(){
        montantHT=this.balCommande.montantCommandeHT(commande);
    }
    
    public void calculMontantTTC(){
        montantTTC=this.balCommande.montantCommandeTTC(commande);
    }
    
    public void soldeClient(){
        soldeClient=this.balClient.resteARegler(commande.getLeClient());
    }
    
    
    public DaoClient getDaoClient() {
        return daoClient;
    }
    
    public Float getMontantTTC() {
        return montantTTC;
    }
    
    public void setMontantTTC(Float montantTTC) {
        this.montantTTC = montantTTC;
    }
    
    public void setDaoClient(DaoClient daoClient) {
        this.daoClient = daoClient;
    }
    
    public DaoCommande getDaoCommande() {
        return daoCommande;
    }
    
    public void setDaoCommande(DaoCommande daoCommande) {
        this.daoCommande = daoCommande;
    }
    
    public BalClient getBalClient() {
        return balClient;
    }
    
    public Float getMontantHT() {
        return montantHT;
    }
    
    public void setMontantHT(Float montantHT) {
        this.montantHT = montantHT;
    }
    
    public void setBalClient(BalClient balClient) {
        this.balClient = balClient;
    }
    
    public Long getNumcomRecherche() {
        return numcomRecherche;
    }
    
    public void setNumcomRecherche(Long numcomRecherche) {
        this.numcomRecherche = numcomRecherche;
    }
    
    public Commande getCommande() {
        return commande;
    }
    
    public void setCommande(Commande commande) {
        this.commande = commande;
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
    
    public BalCommande getBalCommande() {
        return balCommande;
    }
    
    public void setBalCommande(BalCommande balCommande) {
        this.balCommande = balCommande;
    }
    
    public DaoTva getDaoTva() {
        return daoTva;
    }
    
    public void setDaoTva(DaoTva daoTva) {
        this.daoTva = daoTva;
    }
    //</editor-fold>
    
    
    
}
