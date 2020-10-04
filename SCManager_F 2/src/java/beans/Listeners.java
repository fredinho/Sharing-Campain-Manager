/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.ArrondissementFacadeLocal;
import EJB.DepartementFacadeLocal;
import EJB.PointretraitFacadeLocal;
import EJB.ProvinceFacadeLocal;
import EJB.QuartierFacadeLocal;
import JPA.Arrondissement;
import JPA.Departement;
import JPA.Pointretrait;
import JPA.Province;
import JPA.Quartier;
import config.DataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Tambia Egbebot
 */
@ManagedBean
@SessionScoped
public class Listeners implements Serializable {
    @EJB
    private ProvinceFacadeLocal pvLocal;
    @EJB
    private DepartementFacadeLocal dpLocal;
    @EJB
    private ArrondissementFacadeLocal arLocal;
    @EJB
    private QuartierFacadeLocal qtLocal;
    @EJB
    private PointretraitFacadeLocal prLocal;
    
    private List<Departement> depart;
    private List<Arrondissement> arrondis;
    private List<Quartier> quartier;
    private List<Pointretrait> ptret;
    
    private Province provc;
    private Departement dep;
    private Arrondissement arron;
    private Quartier quart;
    private DataModel model;

    public Listeners() {
    }

    public ProvinceFacadeLocal getPvLocal() {
        return pvLocal;
    }

    public void setPvLocal(ProvinceFacadeLocal pvLocal) {
        this.pvLocal = pvLocal;
    }

    public DepartementFacadeLocal getDpLocal() {
        return dpLocal;
    }

    public void setDpLocal(DepartementFacadeLocal dpLocal) {
        this.dpLocal = dpLocal;
    }

    public ArrondissementFacadeLocal getArLocal() {
        return arLocal;
    }

    public void setArLocal(ArrondissementFacadeLocal arLocal) {
        this.arLocal = arLocal;
    }

    public List<Departement> getDepart() {
        return depart;
    }

    public void setDepart(List<Departement> depart) {
        this.depart = depart;
    }

    public List<Arrondissement> getArrondis() {
        return arrondis;
    }

    public void setArrondis(List<Arrondissement> arrondis) {
        this.arrondis = arrondis;
    }

    public List<Quartier> getQuartier() {
        return quartier;
    }

    public void setQuartier(List<Quartier> quartier) {
        this.quartier = quartier;
    }

    public Province getProvc() {
        return provc;
    }

    public void setProvc(Province provc) {
        this.provc = provc;
    }

    public Departement getDep() {
        return dep;
    }

    public void setDep(Departement dep) {
        this.dep = dep;
    }

    public Arrondissement getArron() {
        return arron;
    }

    public void setArron(Arrondissement arron) {
        this.arron = arron;
    }

    public Quartier getQuart() {
        return quart;
    }

    public void setQuart(Quartier quart) {
        this.quart = quart;
    }

    public QuartierFacadeLocal getQtLocal() {
        return qtLocal;
    }

    public void setQtLocal(QuartierFacadeLocal qtLocal) {
        this.qtLocal = qtLocal;
    }

    public PointretraitFacadeLocal getPrLocal() {
        return prLocal;
    }

    public void setPrLocal(PointretraitFacadeLocal prLocal) {
        this.prLocal = prLocal;
    }

    public List<Pointretrait> getPtret() {
        return ptret;
    }

    public void setPtret(List<Pointretrait> ptret) {
        this.ptret = ptret;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
    public void listProv(ValueChangeEvent p){
        System.out.println("Start 55 "+p.getNewValue().toString());
        depart = new ArrayList<Departement>();
        model = new DataModel(depart);
        provc = new Province(Integer.parseInt(p.getNewValue().toString()));
        System.out.println("New value "+p.getNewValue());
        List<Departement> dp = getDpLocal().listref(provc);
        for(Departement d : dp){
            getDepart().add(d);
        }
        System.out.println(provc.toString());
        
    }
    
    public void listDep(ValueChangeEvent d){
        System.out.println("Start 55 "+d.getNewValue().toString());
        arrondis = new ArrayList<Arrondissement>();
        dep = new Departement(Integer.parseInt(d.getNewValue().toString()));
        System.out.println(dep.toString());
        List<Arrondissement> ar = getArLocal().allbydepart(dep);
        for(Arrondissement ard : ar){
            getArrondis().add(ard);
        }
    }
    
    public void listArron(ValueChangeEvent a){
        System.out.println("Start 55 "+a.getNewValue().toString());
        quartier = new ArrayList<Quartier>();
        arron = new Arrondissement(Integer.parseInt(a.getNewValue().toString()));
        System.out.println(arron.toString());
        List<Quartier> qt = getQtLocal().findbyarron(arron);
        for(Quartier qtr : qt){
            getQuartier().add(qtr);
        }
    }
    
    public void listQuart(ValueChangeEvent q){
        System.out.println("Start 55 "+q.getNewValue().toString());
        ptret = new ArrayList<Pointretrait>();
        quart = new Quartier(Integer.parseInt(q.getNewValue().toString()));
        System.out.println(quart.toString());
        List<Pointretrait> prt = getPrLocal().findbyquart(quart);
        for(Pointretrait ptre : prt){
            getPtret().add(ptre);
        }
    }
    
}
