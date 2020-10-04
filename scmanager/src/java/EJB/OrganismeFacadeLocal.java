/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Organisme;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface OrganismeFacadeLocal {

    void create(Organisme organisme);

    void edit(Organisme organisme);

    void remove(Organisme organisme);

    Organisme find(Object id);

    List<Organisme> findAll();

    List<Organisme> findRange(int[] range);

    int count();
    
}
