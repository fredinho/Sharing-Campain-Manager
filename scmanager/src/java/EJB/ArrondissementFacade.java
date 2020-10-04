/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Arrondissement;
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
public class ArrondissementFacade extends AbstractFacade<Arrondissement> implements ArrondissementFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArrondissementFacade() {
        super(Arrondissement.class);
    }
    
     @Override
    public List<Arrondissement> allbydepart(Departement iddep){
        return getEntityManager().createNamedQuery("Arrondissement.findByIDDepartement").setParameter("iDDep", iddep).getResultList();
    }
    
    @Override
    public List<Arrondissement> allbyidarron(int idarron){
        return getEntityManager().createNamedQuery("Arrondissement.findByIDArrondissement").setParameter("iDArrondissement", idarron).getResultList();
    }
    
}
