/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Departement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface DepartementFacadeLocal {

    void create(Departement departement);

    void edit(Departement departement);

    void remove(Departement departement);

    Departement find(Object id);

    List<Departement> findAll();
    
    List<Departement> listref(Object p);

    List<Departement> findRange(int[] range);

    int count();
    
}
