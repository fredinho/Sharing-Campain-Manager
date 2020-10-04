/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Menage;
import JPA.Province;
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
public class MenageFacade extends AbstractFacade<Menage> implements MenageFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenageFacade() {
        super(Menage.class);
    }
    @Override
    public List<Menage> findrec(Recenseur idrec){
        return getEntityManager().createNamedQuery("Menage.findByRecenseur").setParameter("idrec", idrec).getResultList();
    }
    
    @Override
    public List<Menage> findByProvince(Province p){
        return getEntityManager().createNamedQuery("Menage.findByProvince").setParameter("iDProvince", p).getResultList();
    }
   
 }
