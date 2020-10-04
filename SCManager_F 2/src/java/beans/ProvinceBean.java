/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import JPA.Province;
import EJB.ProvinceFacadeLocal;
import config.DataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
/**
 *
 * @author FREDINHO
 */
@ManagedBean
@SessionScoped
public class ProvinceBean implements Serializable {
    @EJB
    private ProvinceFacadeLocal provL;
    private Province prov;
    private List<Province> provList;
    private Province modified;
    private Province privi;
    
    private String nomProv;
    private Province[] selection;
    private DataModel model;

    public ProvinceBean() {
    }

    public Province getProv() {
        return prov;
    }

    public void setProv(Province prov) {
        this.prov = prov;
    }

    public ProvinceFacadeLocal getProvL() {
        return provL;
    }

    public void setProvL(ProvinceFacadeLocal provL) {
        this.provL = provL;
    }

    public String getNomProv() {
        return nomProv;
    }

    public void setNomProv(String nomProv) {
        this.nomProv = nomProv;
    }

    public List<Province> getProvList() {
        return provList;
    }

    public void setProvList(List<Province> provList) {
        this.provList = provList;
    }

    public Province getModified() {
        return modified;
    }

    public void setModified(Province modified) {
        this.modified = modified;
    }

    public Province getPrivi() {
        return privi;
    }

    public void setPrivi(Province privi) {
        this.privi = privi;
    }

    public Province[] getSelection() {
        return selection;
    }

    public void setSelection(Province[] selection) {
        this.selection = selection;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
    public void allprovince(){
        System.out.println("Start");
        List<Province> listprov = getProvL().findAll();
        provList = new ArrayList<Province>();
        model = new DataModel(provList);
        for(Province p : listprov){
            getProvList().add(p);
            System.out.println(getProvList().iterator().next().getNomProvince().toString());
            
        }
    }
    
    public void addprovince(){
        System.out.println("yep");
        prov = new Province();
        getProv().setNomProvince(getNomProv());
        getProvL().create(prov);
        System.out.println("done");
    }
    
    public void onEditRow(RowEditEvent event) {
        System.out.println("Mod inline");
        modified = (Province) event.getObject();

        try{
        privi = getProvL().find(modified.getIDProvince());

        privi.setNomProvince(modified.getNomProvince());

        getProvL().edit(privi);
        System.out.println("La province = "+modified.getDepartementList().iterator().next().getNomDepartement()+" a ete modifier.");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Valeur Modifier"));
        }catch(Exception ex){
            System.err.println(ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Modification Echec"));
        }
    }
}
