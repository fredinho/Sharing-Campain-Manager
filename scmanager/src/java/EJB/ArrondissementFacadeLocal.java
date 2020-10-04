/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Arrondissement;
import JPA.Departement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface ArrondissementFacadeLocal {

    void create(Arrondissement arrondissement);

    void edit(Arrondissement arrondissement);

    void remove(Arrondissement arrondissement);

    Arrondissement find(Object id);

    List<Arrondissement> findAll();

    List<Arrondissement> findRange(int[] range);

    int count();
    
    List<Arrondissement> allbydepart(Departement iddep);
    
    List<Arrondissement> allbyidarron(int idarron);
    
}
