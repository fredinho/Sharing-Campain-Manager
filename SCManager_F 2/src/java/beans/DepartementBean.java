/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.DepartementFacadeLocal;
import JPA.Departement;
import JPA.Province;
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
public class DepartementBean implements Serializable {
    /**
     * Declaration des variable
     */
    
    @EJB
    private DepartementFacadeLocal depLocal;
    private Departement dep;
    
    private String nomdep;
    private int idprov;
    private List<Departement> depList;
    /**
     * constructor
     */
    public DepartementBean() {
    }
    
    /**
     * Getters et Setters
     */
    public DepartementFacadeLocal getDepLocal() {
        return depLocal;
    }

    public void setDepLocal(DepartementFacadeLocal depLocal) {
        this.depLocal = depLocal;
    }

    public Departement getDep() {
        return dep;
    }

    public void setDep(Departement dep) {
        this.dep = dep;
    }

    public String getNomdep() {
        return nomdep;
    }

    public void setNomdep(String nomdep) {
        this.nomdep = nomdep;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }

    public List<Departement> getDepList() {
        return depList;
    }

    public void setDepList(List<Departement> depList) {
        this.depList = depList;
    }

    /**
     * Methods
     */
    public void creerdepartement(){
        System.out.println("yep");
        dep = new Departement();
        getDep().setIDProvince(new Province(getIdprov()));
        getDep().setNomDepartement(getNomdep());
        getDepLocal().create(dep);
        System.out.println("done");
    }
    
    public void alldep(){
        depList = new ArrayList<Departement>();
        List<Departement> listdep = getDepLocal().findAll();
        for(Departement d : listdep){
            getDepList().add(d);
        }
    }
}
