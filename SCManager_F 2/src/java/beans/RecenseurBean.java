/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.RecenseurFacadeLocal;
import JPA.Quartier;
import JPA.Recenseur;
import config.DataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class RecenseurBean implements Serializable {
    @EJB
    private RecenseurFacadeLocal recLocal;
    private Recenseur rec;
    private String nomrec;
    private int idquart;
    private int num;
    private String pnomrec;
    private Date datnais;
    private List<Recenseur> listrec;
    private List<Recenseur> listnum;
    private DataModel model;

    public RecenseurBean() {
    }

    public RecenseurFacadeLocal getRecLocal() {
        return recLocal;
    }

    public void setRecLocal(RecenseurFacadeLocal recLocal) {
        this.recLocal = recLocal;
    }

    public Recenseur getRec() {
        return rec;
    }

    public void setRec(Recenseur rec) {
        this.rec = rec;
    }

    public String getNomrec() {
        return nomrec;
    }

    public void setNomrec(String nomrec) {
        this.nomrec = nomrec;
    }

    public int getQuart() {
        return idquart;
    }

    public List<Recenseur> getListrec() {
        return listrec;
    }

    public void setListrec(List<Recenseur> listrec) {
        this.listrec = listrec;
    }

    public void setQuart(int idarron) {
        this.idquart = idarron;
    }

    public int getIdquart() {
        return idquart;
    }

    public void setIdquart(int idquart) {
        this.idquart = idquart;
    }

    public String getPnomrec() {
        return pnomrec;
    }

    public void setPnomrec(String pnomrec) {
        this.pnomrec = pnomrec;
    }

    public Date getDatnais() {
        return datnais;
    }

    public void setDatnais(Date datnais) {
        this.datnais = datnais;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Recenseur> getListnum() {
        return listnum;
    }

    public void setListnum(List<Recenseur> listnum) {
        this.listnum = listnum;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
    public void allrecenseur(){
        listrec = new ArrayList<Recenseur>();
        model = new DataModel(listrec);
        List<Recenseur> recl = getRecLocal().findAll();
        for(Recenseur rece : recl){
            getListrec().add(rece);
        }
    }
    
    public void allbyquart(){
        int ar = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idarron").toString());
         
    }
    
    public void creatrecenseur(){
        getRec().setNomRecenseur(getNomrec());
        getRec().setIDQuartier(new Quartier(getQuart()));
        getRecLocal().create(rec);
    }
}
