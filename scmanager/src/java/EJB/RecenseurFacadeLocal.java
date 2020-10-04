/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Quartier;
import JPA.Recenseur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface RecenseurFacadeLocal {

    void create(Recenseur recenseur);

    void edit(Recenseur recenseur);

    void remove(Recenseur recenseur);

    Recenseur find(Object id);

    List<Recenseur> findAll();
    
    List<Recenseur> allbyquart(Quartier idq);

    List<Recenseur> findRange(int[] range);

    int count();
    
}
