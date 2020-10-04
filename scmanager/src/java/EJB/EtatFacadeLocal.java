/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Etat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface EtatFacadeLocal {

    void create(Etat etat);

    void edit(Etat etat);

    void remove(Etat etat);

    Etat find(Object id);

    List<Etat> findAll();

    List<Etat> findRange(int[] range);

    int count();
    
}
