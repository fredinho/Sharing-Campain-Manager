/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.PointretraitFacadeLocal;
import JPA.Disponibilite;
import JPA.Pointretrait;
import JPA.Quartier;
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
public class PointdeRetraitBean implements Serializable{
    @EJB
    private PointretraitFacadeLocal ptrLocal;
    
    private Pointretrait ptr;
    private List<Pointretrait> lptr;
    private int idquart;
    private String ptret;
    private int stat;

    public PointdeRetraitBean() {
    }

    public PointretraitFacadeLocal getPtrLocal() {
        return ptrLocal;
    }

    public void setPtrLocal(PointretraitFacadeLocal ptrLocal) {
        this.ptrLocal = ptrLocal;
    }

    public Pointretrait getPtr() {
        return ptr;
    }

    public void setPtr(Pointretrait ptr) {
        this.ptr = ptr;
    }

    public List<Pointretrait> getLptr() {
        return lptr;
    }

    public void setLptr(List<Pointretrait> lptr) {
        this.lptr = lptr;
    }

    public int getIdquart() {
        return idquart;
    }

    public void setIdquart(int idquart) {
        this.idquart = idquart;
    }

    public String getPtret() {
        return ptret;
    }

    public void setPtret(String ptret) {
        this.ptret = ptret;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
    
    public void allpointretrait(){
        lptr = new ArrayList<Pointretrait>();
        List<Pointretrait> lp = getPtrLocal().findAll();
        for(Pointretrait ptrs : lp){
            getLptr().add(ptrs);
        }
    }
    
    public void somepointretrait(){
        lptr = new ArrayList<Pointretrait>();
        Disponibilite dis = new Disponibilite(2);
        List<Pointretrait> lp = getPtrLocal().findAll();
        for(Pointretrait ptrs : lp){
            if(ptrs.getIDDisponibilite()==dis) {
                getLptr().add(ptrs);
            }
        }
    }
    
//    public void creerptr(){
//        getPtr().setIDQuartier(new Quartier(getIdquart()));
//        getPtr().setIDDisponibilite(getStat());
//        getPtr().setNomPointRetrait(getPtret());
//        getPtrLocal().create(ptr);
//    }
}
