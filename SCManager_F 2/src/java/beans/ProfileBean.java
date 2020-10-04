/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import EJB.ProfileFacadeLocal;
import JPA.Profile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author FREDINHO
 */
@ManagedBean
@ViewScoped
public class ProfileBean implements Serializable {
    @EJB
    private ProfileFacadeLocal profLocal;
    
    private Profile prof;
    private List<Profile> listprof;

    public ProfileBean() {
    }

    public ProfileFacadeLocal getProfLocal() {
        return profLocal;
    }

    public void setProfLocal(ProfileFacadeLocal profLocal) {
        this.profLocal = profLocal;
    }

    public Profile getProf() {
        return prof;
    }

    public void setProf(Profile prof) {
        this.prof = prof;
    }

    public List<Profile> getListprof() {
        return listprof;
    }

    public void setListprof(List<Profile> listprof) {
        this.listprof = listprof;
    }
    
    public void allprofile(){
        listprof = new ArrayList<Profile>();
        List<Profile> lprof = getProfLocal().findAll();
        for(Profile profs : lprof){
            getListprof().add(profs);
        }
    }
}
