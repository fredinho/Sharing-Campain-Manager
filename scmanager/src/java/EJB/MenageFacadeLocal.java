/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Menage;
import JPA.Province;
import JPA.Recenseur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface MenageFacadeLocal {

    void create(Menage menage);

    void edit(Menage menage);

    void remove(Menage menage);

    Menage find(Object id);

    List<Menage> findAll();
    
    List<Menage> findrec(Recenseur idrec);
      
    List<Menage> findRange(int[] range);
    
    List<Menage> findByProvince(Province p);

    int count();
    
}
