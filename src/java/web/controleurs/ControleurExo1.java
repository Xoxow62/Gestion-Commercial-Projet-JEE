
package web.controleurs;

import dao.client.DaoClient;
import entites.Client;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rsmon
 */
@Named(value = "controleurExo1")
@RequestScoped
public class ControleurExo1 {

    
    @Inject
    private DaoClient daoClient;
    
  
    private Long numcliRecherche;
    
    private Client client= new Client();
    
    public ControleurExo1() {
    }
    
    @PostConstruct
    public void init(){
          
        System.out.println("OK");
    }

    
    public void ecouteurRecherche(){
    
        if(numcliRecherche!=null){
            client=this.daoClient.getLeClient(numcliRecherche);
            System.out.println(client.getNomCli());
        }
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getNumcliRecherche() {
        return numcliRecherche;
    }

    public void setNumcliRecherche(Long numcliRecherche) {
        this.numcliRecherche = numcliRecherche;
    }
    
    
    
}
