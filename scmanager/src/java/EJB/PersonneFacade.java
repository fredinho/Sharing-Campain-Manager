/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Personne;
import JPA.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FREDINHO
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {
    @PersistenceContext(unitName = "scmanagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
     @Override
    public List<Personne> connexion(Object login, Object pass){
        return getEntityManager().createNamedQuery("Personne.findByConnection").setParameter("pseudo",login).setParameter("pass", pass).getResultList();
    }
    
    @Override
    public List<Personne> allbyprofil(Profile prof){
        return getEntityManager().createNamedQuery("Personne.findByIDProfile").setParameter("idprofile", prof).getResultList();
    } 
}
