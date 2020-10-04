/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Disponibilite;
import JPA.Pointretrait;
import JPA.Quartier;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FREDINHO
 */
@Stateless
public class PointretraitFacade extends AbstractFacade<Pointretrait> implements PointretraitFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PointretraitFacade() {
        super(Pointretrait.class);
    }
    
    @Override
    public List<Pointretrait> findbyquart(Quartier qt){
        return getEntityManager().createNamedQuery("Pointretrait.findByIDQuartier").setParameter("iDQuart", qt).getResultList();
    }
    
    @Override
    public List<Pointretrait> findbyDisp(Disponibilite disp){
        return getEntityManager().createNamedQuery("Pointretrait.findByIDDisponibilite").setParameter("iDDisponibilite", disp).getResultList();
    }
    
}
