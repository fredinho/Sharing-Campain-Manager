/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.QuartierFacadeLocal;
import JPA.Arrondissement;
import JPA.Quartier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FREDINHO
 */
@ManagedBean
@ViewScoped
public class QuartierBean implements Serializable{
    @EJB
    private QuartierFacadeLocal qLocal;
    
    private Quartier quart;
    private List<Quartier> quartList;
    private String nomQ;
    private int idarron;

    public QuartierBean() {
    }

    public QuartierFacadeLocal getqLocal() {
        return qLocal;
    }

    public void setqLocal(QuartierFacadeLocal qLocal) {
        this.qLocal = qLocal;
    }

    public Quartier getQuart() {
        return quart;
    }

    public void setQuart(Quartier quart) {
        this.quart = quart;
    }

    public String getNomQ() {
        return nomQ;
    }

    public void setNomQ(String nomQ) {
        this.nomQ = nomQ;
    }

    public int getIdarron() {
        return idarron;
    }

    public void setIdarron(int idarron) {
        this.idarron = idarron;
    }

    public List<Quartier> getQuartList() {
        return quartList;
    }

    public void setQuartList(List<Quartier> quartList) {
        this.quartList = quartList;
    }
    
    public void creerquartier(){
        System.out.println("start");
        getQuart().setIDArrondissement(new Arrondissement(getIdarron()));
        getQuart().setNomQuartier(getNomQ());
        getqLocal().create(quart);
        System.out.println("end");
    }
    
    public void allquart(){
        quartList = new ArrayList<Quartier>();
        List<Quartier> listquart = getqLocal().findAll();
        for(Quartier q : listquart){
            getQuartList().add(q);
        }
    }
    
    public void findbyarron(){
        quartList = new ArrayList<Quartier>();
        List<Quartier> qlist = getqLocal().findbyarron(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("arron").toString());
        for(Quartier qt : qlist){
            getQuartList().add(qt);
        }
    }
}
