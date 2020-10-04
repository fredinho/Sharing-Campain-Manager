/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.PersonneFacadeLocal;
import JPA.Personne;
import JPA.Profile;
import config.DataModel;
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
public class PersonneBean implements Serializable {
    @EJB
    private PersonneFacadeLocal persLocal;
    private Personne pers;
    private List<Personne> persList;
    private Personne selection;
    private Personne modif;
    private DataModel model;

    public PersonneBean() {
    }

    public PersonneFacadeLocal getPersLocal() {
        return persLocal;
    }

    public void setPersLocal(PersonneFacadeLocal persLocal) {
        this.persLocal = persLocal;
    }

    public Personne getPers() {
        return pers;
    }

    public void setPers(Personne pers) {
        this.pers = pers;
    }

    public List<Personne> getPersList() {
        return persList;
    }

    public void setPersList(List<Personne> persList) {
        this.persList = persList;
    }

    public Personne getSelection() {
        return selection;
    }

    public void setSelection(Personne selection) {
        this.selection = selection;
    }

    public Personne getModif() {
        return modif;
    }

    public void setModif(Personne modif) {
        this.modif = modif;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
    public void allspadmin(){
        List<Personne> listpers = getPersLocal().allbyprofil(new Profile(4));
        persList = new ArrayList<Personne>();
        model = new DataModel(persList);
        for(Personne spa : listpers){
            getPersList().add(spa);
        }
    }
    
    public void allchefprojet(){
        List<Personne> listpers = getPersLocal().allbyprofil(new Profile(2));
        persList = new ArrayList<Personne>();
        model = new DataModel(persList);
        for(Personne cp : listpers){
            getPersList().add(cp);
        }
    }
    
    public void allOS(){
        List<Personne> listpers = getPersLocal().allbyprofil(new Profile(1));
        persList = new ArrayList<Personne>();
        model = new DataModel(persList);
        for(Personne os : listpers){
            getPersList().add(os);
        }
    }
    
    public void alladmin(){
        List<Personne> listpers = getPersLocal().allbyprofil(new Profile(3));
        persList = new ArrayList<Personne>();
        model = new DataModel(persList);
        for(Personne ssa : listpers){
            getPersList().add(ssa);
        }
    }
    
    public void allpersonne(){
        List<Personne> listpers = getPersLocal().findAll();
        persList = new ArrayList<Personne>();
        model = new DataModel(persList);
        for(Personne p : listpers){
            getPersList().add(p);
        }
    }
}
