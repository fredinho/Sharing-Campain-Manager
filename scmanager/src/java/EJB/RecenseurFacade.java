/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Quartier;
import JPA.Recenseur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FREDINHO
 */
@Stateless
public class RecenseurFacade extends AbstractFacade<Recenseur> implements RecenseurFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecenseurFacade() {
        super(Recenseur.class);
    }
    
    @Override
    public List<Recenseur> allbyquart(Quartier idq){
        return getEntityManager().createNamedQuery("Recenseur.findquart").setParameter("quart", idq).getResultList();
    }
    
}
