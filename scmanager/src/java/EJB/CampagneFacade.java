/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Campagne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FREDINHO
 */
@Stateless
public class CampagneFacade extends AbstractFacade<Campagne> implements CampagneFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CampagneFacade() {
        super(Campagne.class);
    }
    
}
