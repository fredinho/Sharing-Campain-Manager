/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Disponibilite;
import JPA.Pointretrait;
import JPA.Quartier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface PointretraitFacadeLocal {

    void create(Pointretrait pointretrait);

    void edit(Pointretrait pointretrait);

    void remove(Pointretrait pointretrait);

    Pointretrait find(Object id);

    List<Pointretrait> findAll();
    
    List<Pointretrait> findbyquart(Quartier qt);
    
    List<Pointretrait> findRange(int[] range);
    
    List<Pointretrait> findbyDisp(Disponibilite disp);

    int count();
    
}
