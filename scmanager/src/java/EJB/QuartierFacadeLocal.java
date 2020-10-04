/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Quartier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface QuartierFacadeLocal {

    void create(Quartier quartier);

    void edit(Quartier quartier);

    void remove(Quartier quartier);

    Quartier find(Object id);

    List<Quartier> findAll();
    
    List<Quartier> findbyarron(Object arrond);

    List<Quartier> findRange(int[] range);

    int count();
    
}
