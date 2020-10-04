/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.StatutFacadeLocal;
import JPA.Statut;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author FREDINHO
 */
public class StatutBean {
    @EJB
    private StatutFacadeLocal sLocal;
    private Statut stat;
    private String nstat;
    private List<Statut> liststat;

    public StatutBean() {
    }

    public StatutFacadeLocal getsLocal() {
        return sLocal;
    }

    public void setsLocal(StatutFacadeLocal sLocal) {
        this.sLocal = sLocal;
    }

    public Statut getStat() {
        return stat;
    }

    public void setStat(Statut stat) {
        this.stat = stat;
    }

    public String getNstat() {
        return nstat;
    }

    public void setNstat(String nstat) {
        this.nstat = nstat;
    }

    public List<Statut> getListstat() {
        return liststat;
    }

    public void setListstat(List<Statut> liststat) {
        this.liststat = liststat;
    }
    
    public void allstats(){
        liststat = new ArrayList<Statut>();
        List<Statut> stats = getsLocal().findAll();
        for(Statut s : stats){
            getListstat().add(s);
        }
    }
}
