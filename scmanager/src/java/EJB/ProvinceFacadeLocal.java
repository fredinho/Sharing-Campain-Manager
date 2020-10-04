/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Province;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FREDINHO
 */
@Local
public interface ProvinceFacadeLocal {

    void create(Province province);

    void edit(Province province);

    void remove(Province province);

    Province find(Object id);

    List<Province> findAll();

    List<Province> findRange(int[] range);

    int count();
    
}
