
package dao.region;

import entites.Region;
import java.util.List;

public interface DaoRegion {

    Region getLaRegion(String CodeReg);
    List<Region>  getToutesLesRegions();
}
