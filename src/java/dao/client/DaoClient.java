package dao.client;
import entites.Client;
import java.util.List;

public interface DaoClient {

    Client             getLeClient(Long pNumcli);
    List<Client>       getTousLesClients();   
}



