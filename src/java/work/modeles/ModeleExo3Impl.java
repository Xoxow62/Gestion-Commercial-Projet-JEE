/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package work.modeles;

import bal.client.BalClient;
import dao.client.DaoClient;
import entites.Client;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author rsmon
 */

@Singleton
public class ModeleExo3Impl implements ModeleExo3, Serializable {
    
    @Inject private DaoClient daoClient; 
    @Inject private BalClient balClient;

    @Override
    public Client getLeClient(Long pNumcli) {
        return daoClient.getLeClient(pNumcli);
    }

    @Override
    public Float caAnneeEnCours(Client pClient) {
        return balClient.caAnneeEnCours(pClient);
    }
       
}
