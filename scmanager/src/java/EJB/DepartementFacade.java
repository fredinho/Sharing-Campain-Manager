/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Departement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FREDINHO
 */
@Stateless
public class DepartementFacade extends AbstractFacade<Departement> implements DepartementFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartementFacade() {
        super(Departement.class);
    }
    
    @Override
    public List<Departement> listref(Object p){
        return getEntityManager().createNamedQuery("Departement.findByIdProvince").setParameter("idProvince", p).getResultList();
    }
    
}
