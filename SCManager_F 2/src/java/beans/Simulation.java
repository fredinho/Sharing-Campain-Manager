/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.MenageFacadeLocal;
import JPA.Menage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FREDINHO
 */

@ManagedBean
@SessionScoped
public class Simulation implements Serializable {
    @EJB
    private MenageFacadeLocal menLocal;
    private MenageBean men;
    private int nbreart=0;
    private int total;

    public int getSomme() {
        int somme=0;
        List<Menage> listmen = getMenLocal().findAll();
        for(Menage m :listmen ){
          somme=somme+m.getNombreResidant(); 
        }
        System.out.println(somme);
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }
    private int somme;

    public int getTotal() {
        
        if(nbreart!=0){
            total=0;
            somme=0;
          System.out.println("yep");
        List<Menage> listmen = getMenLocal().findAll();
        menlist = new ArrayList<Menage>();
        for(Menage m :listmen ){
          somme=somme+m.getNombreResidant(); 
        }
        
        total = somme/nbreart;  
        
        }
           
             return total;
    }
   
    public void setTotal(int total) {
        this.total = total;
    }
    private List<Menage> menlist; 

    public List<Menage> getMenlist() {
        return menlist;
    }

    public void setMenlist(List<Menage> menlist) {
        this.menlist = menlist;
    }
           
    
    public Simulation(){
        
    }

    public MenageFacadeLocal getMenLocal() {
        return menLocal;
    }

    public void setMenLocal(MenageFacadeLocal menLocal) {
        this.menLocal = menLocal;
    }

    public MenageBean getMen() {
        return men;
    }

    public void setMen(MenageBean men) {
        this.men = men;
    }

    public int getNbreart() {
        return nbreart;
    }

    public void setNbreart(int nbreart) {
        this.nbreart = nbreart;
    }
    
      
    
}
