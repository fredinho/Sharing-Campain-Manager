/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.ArrondissementFacadeLocal;
import JPA.Arrondissement;
import JPA.Departement;
import config.DataModel;
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
public class ArrondissementBean implements Serializable {
    
    @EJB
    private ArrondissementFacadeLocal arronLocal;
    private Arrondissement arron;
    
    private String arrond;
    private int iddep;
    private List<Arrondissement> arronList;
    private DataModel model;
    /**
     * Constructors
     */
    public ArrondissementBean() {
    }
    
    /**
     * Getters and Setters
     */
    public ArrondissementFacadeLocal getArronLocal() {
        return arronLocal;
    }

    public void setArronLocal(ArrondissementFacadeLocal arronLocal) {
        this.arronLocal = arronLocal;
    }

    public Arrondissement getArron() {
        return arron;
    }

    public void setArron(Arrondissement arron) {
        this.arron = arron;
    }

    public String getArrond() {
        return arrond;
    }

    public void setArrond(String arrond) {
        this.arrond = arrond;
    }

    public int getIddep() {
        return iddep;
    }

    public void setIddep(int iddep) {
        this.iddep = iddep;
    }

    public List<Arrondissement> getArronList() {
        return arronList;
    }

    public void setArronList(List<Arrondissement> arronList) {
        this.arronList = arronList;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    /**
     * Methods
     */
    
    public void creerarrondissement(){
        System.out.println("Start");
        getArron().setNomArrondissement(getArrond());
        getArron().setIDDepartement(new Departement(getIddep()));
        getArronLocal().create(arron);
    }
    
    public void allarron(){
        List<Arrondissement> listarron = getArronLocal().findAll();
        arronList = new ArrayList<Arrondissement>();
        model = new DataModel(arronList);
        for(Arrondissement a : listarron){
            getArronList().add(a);
        }
    }
    
    public void findbyidarron(){
        int ar = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idarron").toString());
        List<Arrondissement> listarron = getArronLocal().allbyidarron(ar);
        arronList = new ArrayList<Arrondissement>();
        model = new DataModel(arronList);
        for(Arrondissement a : listarron){
            getArronList().add(a);
        }
    }
}
