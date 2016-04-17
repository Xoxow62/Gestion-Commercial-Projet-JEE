
package dao.tva;

import java.io.Serializable;

public class DaoTvaImpl implements DaoTva, Serializable{
    
    @Override
    public Float getTauxTVA() {
        return 0.20f;
    }       
}
