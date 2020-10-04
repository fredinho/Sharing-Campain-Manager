/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Campagne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface CampagneFacadeLocal {

    void create(Campagne campagne);

    void edit(Campagne campagne);

    void remove(Campagne campagne);

    Campagne find(Object id);

    List<Campagne> findAll();

    List<Campagne> findRange(int[] range);

    int count();
    
}
