/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Disponibilite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface DisponibiliteFacadeLocal {

    void create(Disponibilite disponibilite);

    void edit(Disponibilite disponibilite);

    void remove(Disponibilite disponibilite);

    Disponibilite find(Object id);

    List<Disponibilite> findAll();

    List<Disponibilite> findRange(int[] range);

    int count();
    
}
