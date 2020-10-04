/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Statut;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface StatutFacadeLocal {

    void create(Statut statut);

    void edit(Statut statut);

    void remove(Statut statut);

    Statut find(Object id);

    List<Statut> findAll();

    List<Statut> findRange(int[] range);

    int count();
    
}
