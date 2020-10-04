/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

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
public class QuartierFacade extends AbstractFacade<Quartier> implements QuartierFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuartierFacade() {
        super(Quartier.class);
    }
    
    @Override
    public List<Quartier> findbyarron(Object arrond){
        return getEntityManager().createNamedQuery("Quartier.findByIDArron").setParameter("arron", arrond).getResultList();
    }
    
}
