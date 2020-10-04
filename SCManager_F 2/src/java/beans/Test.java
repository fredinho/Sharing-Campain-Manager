/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.ArrondissementFacadeLocal;
import EJB.DepartementFacadeLocal;
import EJB.ProvinceFacadeLocal;
import EJB.QuartierFacadeLocal;
import EJB.PointretraitFacadeLocal;
import JPA.Pointretrait;
import JPA.Arrondissement;
import JPA.Departement;
import JPA.Province;
import JPA.Quartier;
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
public class Test implements Serializable {
    @EJB
    private ProvinceFacadeLocal plocal;
    @EJB
    private QuartierFacadeLocal qlocal;
    @EJB
    private DepartementFacadeLocal dlocal;
    @EJB
    private ArrondissementFacadeLocal alocal;
    @EJB
    private PointretraitFacadeLocal prlocal;
    
    private Quartier quart;
    private Province provc;
    private Departement dep;
    private Arrondissement arron;
    
    private List<Province> provList;
    private List<Departement> depList;
    private List<Quartier> quartList;
    private List<Arrondissement> arronList;
    private List<Pointretrait> prlist;
    private List<Province> selected;
    
    private String provfilt;
    private String depfilt;
    private String arronfilt;
    private String quartfilt;

    public Test() {
    }

    public ProvinceFacadeLocal getPlocal() {
        return plocal;
    }

    public void setPlocal(ProvinceFacadeLocal plocal) {
        this.plocal = plocal;
    }

    public QuartierFacadeLocal getQlocal() {
        return qlocal;
    }

    public void setQlocal(QuartierFacadeLocal qlocal) {
        this.qlocal = qlocal;
    }

    public DepartementFacadeLocal getDlocal() {
        return dlocal;
    }

    public void setDlocal(DepartementFacadeLocal dlocal) {
        this.dlocal = dlocal;
    }

    public ArrondissementFacadeLocal getAlocal() {
        return alocal;
    }

    public void setAlocal(ArrondissementFacadeLocal alocal) {
        this.alocal = alocal;
    }

    public PointretraitFacadeLocal getPrlocal() {
        return prlocal;
    }

    public void setPrlocal(PointretraitFacadeLocal prlocal) {
        this.prlocal = prlocal;
    }

    public Quartier getQuart() {
        return quart;
    }

    public void setQuart(Quartier quart) {
        this.quart = quart;
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

    public List<Province> getSelected() {
        return selected;
    }

    public void setSelected(List<Province> selected) {
        this.selected = selected;
    }

    public Arrondissement getArron() {
        return arron;
    }

    public void setArron(Arrondissement arron) {
        this.arron = arron;
    }

    public List<Province> getProvList() {
        return provList;
    }

    public void setProvList(List<Province> provList) {
        this.provList = provList;
    }

    public List<Departement> getDepList() {
        return depList;
    }

    public void setDepList(List<Departement> depList) {
        this.depList = depList;
    }

    public List<Quartier> getQuartList() {
        return quartList;
    }

    public void setQuartList(List<Quartier> quartList) {
        this.quartList = quartList;
    }

    public List<Arrondissement> getArronList() {
        return arronList;
    }

    public void setArronList(List<Arrondissement> arronList) {
        this.arronList = arronList;
    }

    public List<Pointretrait> getPrlist() {
        return prlist;
    }

    public void setPrlist(List<Pointretrait> prlist) {
        this.prlist = prlist;
    }

    public String getProvfilt() {
        return provfilt;
    }

    public void setProvfilt(String provfilt) {
        this.provfilt = provfilt;
    }

    public String getDepfilt() {
        return depfilt;
    }

    public void setDepfilt(String depfilt) {
        this.depfilt = depfilt;
    }

    public String getArronfilt() {
        return arronfilt;
    }

    public void setArronfilt(String arronfilt) {
        this.arronfilt = arronfilt;
    }

    public String getQuartfilt() {
        return quartfilt;
    }

    public void setQuartfilt(String quartfilt) {
        this.quartfilt = quartfilt;
    }
    
    public void getall(){
        List<Pointretrait> listpr = getPrlocal().findAll();
        prlist = new ArrayList<Pointretrait>();
        for(Pointretrait pr : listpr){
            getPrlist().add(pr);
            System.out.println(getPrlist().iterator().next().getIDPointRetrait());
            
        }
    }
    
    public void allprovince(){
        List<Province> listprov = getPlocal().findAll();
        provList = new ArrayList<Province>();
        for(Province p : listprov){
            getProvList().add(p);
            System.out.println(getProvList().iterator().next().getNomProvince().toString());
            
        }
    }
    
    public void alldep(){
        depList = new ArrayList<Departement>();
        List<Departement> listdep = getDlocal().findAll();
        for(Departement d : listdep){
            getDepList().add(d);
        }
    }
    
    public void allarron(){
        List<Arrondissement> listarron = getAlocal().findAll();
        arronList = new ArrayList<Arrondissement>();
        for(Arrondissement a : listarron){
            getArronList().add(a);
        }
    }
    
    public void allquart(){
        quartList = new ArrayList<Quartier>();
        List<Quartier> listquart = getQlocal().findAll();
        for(Quartier q : listquart){
            getQuartList().add(q);
        }
    }
}
