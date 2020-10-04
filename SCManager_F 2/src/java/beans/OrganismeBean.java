/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.OrganismeFacadeLocal;
import JPA.Organisme;
import config.DataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author FREDINHO
 */
@ManagedBean
@RequestScoped
public class OrganismeBean implements Serializable {
    @EJB
    private OrganismeFacadeLocal orgaLocal;
    private Organisme orga;
    private List<Organisme> orgaList;
    private Organisme modified;
    private String nomOrg;
    private String adr;
    private Organisme[] selection;
    private DataModel model;
    
    public OrganismeBean() {
    }

    public OrganismeFacadeLocal getOrgaLocal() {
        return orgaLocal;
    }

    public Organisme getModified() {
        return modified;
    }

    public void setModified(Organisme modified) {
        this.modified = modified;
    }

    public String getNomOrg() {
        return nomOrg;
    }

    public void setNomOrg(String nomOrg) {
        this.nomOrg = nomOrg;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public Organisme[] getSelection() {
        return selection;
    }

    public void setSelection(Organisme[] selection) {
        this.selection = selection;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public void setOrgaLocal(OrganismeFacadeLocal orgaLocal) {
        this.orgaLocal = orgaLocal;
    }

    public Organisme getOrga() {
        return orga;
    }

    public void setOrga(Organisme orga) {
        this.orga = orga;
    }

    public List<Organisme> getOrgaList() {
        return orgaList;
    }

    public void setOrgaList(List<Organisme> orgaList) {
        this.orgaList = orgaList;
    }

    
    
    public void allorganisme(){
        orgaList = new ArrayList<Organisme>();
        List<Organisme> listorga = getOrgaLocal().findAll();
        for(Organisme org : listorga){
            getOrgaList().add(org);
        }
    }
    
    public void addprovince(){
        System.out.println("yep");
        orga = new Organisme();
        getOrga().setNomOrganisme(getNomOrg());
        getOrga().setResidence(getAdr());
        getOrgaLocal().create(orga);
        System.out.println("done");
    }
    
    
}
