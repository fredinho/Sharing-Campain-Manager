/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.MenageFacadeLocal;
import EJB.ProvinceFacadeLocal;
import JPA.Menage;
import JPA.Province;
import config.DataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author FREDINHO
 */
@ManagedBean
@ViewScoped
public class MenageBean implements Serializable {
    @EJB
    private MenageFacadeLocal menLocal;
    @EJB
    private ProvinceFacadeLocal provinceLocal;
    private Menage men;
    private List<Menage> listmen;
    private Menage[] selection;
    private Menage modified;
    private Menage events;
    private Menage selEvent;
    private DataModel model;
    private CartesianChartModel modelChart;

    public CartesianChartModel getModelChart() {
        modelChart = new CartesianChartModel();
        List<Province> listProvince;
        listProvince=provinceLocal.findAll();
            ChartSeries serieDistribue = new ChartSeries();
            ChartSeries serieNonDistribue = new ChartSeries();
            serieDistribue.setLabel("Menages Livrés");
            serieNonDistribue.setLabel("Menages Non Livrés");
        for(Province p: listProvince){


                 List<Menage> listByProvince= menLocal.findByProvince(p);
                 List<Menage> listLivre= new ArrayList<Menage>();

                 for(Menage m: listByProvince){
                     if(m.getIDStatut().getIDStatut()==1){
                         listLivre.add(m);
                     }
                 }
                 
                 serieDistribue.set(p.getNomProvince(), listLivre.size());
                 serieNonDistribue.set(p.getNomProvince(), (listByProvince.size()-listLivre.size())); 

            }

        
            modelChart.addSeries(serieDistribue);
            modelChart.addSeries(serieNonDistribue);
        return modelChart;
    }

    public void setModelChart(CartesianChartModel modelChart) {
        this.modelChart = modelChart;
    }

    public MenageBean() {
    }

    public MenageFacadeLocal getMenLocal() {
        return menLocal;
    }

    public void setMenLocal(MenageFacadeLocal menLocal) {
        this.menLocal = menLocal;
    }

    public Menage getMen() {
        return men;
    }

    public void setMen(Menage men) {
        this.men = men;
    }

    public List<Menage> getListmen() {
        return listmen;
    }

    public void setListmen(List<Menage> listmen) {
        this.listmen = listmen;
    }

    public Menage[] getSelection() {
        return selection;
    }

    public void setSelection(Menage[] selection) {
        this.selection = selection;
    }

    public Menage getModified() {
        return modified;
    }

    public void setModified(Menage modified) {
        this.modified = modified;
    }

    public Menage getEvents() {
        return events;
    }

    public void setEvents(Menage events) {
        this.events = events;
    }

    public Menage getSelEvent() {
        return selEvent;
    }

    public void setSelEvent(Menage selEvent) {
        this.selEvent = selEvent;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
    public void allmenage(){
        listmen = new ArrayList<Menage>();
        model = new DataModel(listmen);
        List<Menage> menlist = getMenLocal().findAll();
        for(Menage m : menlist){
            getListmen().add(m);
        }
    }
    
    public void creermenage(){
        
    }
    
    public void suppEvents(){
        System.out.println("onStart");
        try{
            System.out.println(selection.length);
        for(int i=0; i<selection.length; i++){
            selection[i].setIDMenage(selection[i].getIDMenage());
            events = getMenLocal().find(selection[i].getIDMenage());
            getMenLocal().remove(events);
            
            System.out.println("Ligne avec id = "+selection[i].getNumeroCNI()+" a ete supprimer.");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Supprimer", "Suppression reussi"));
            
        }
        }catch(Exception e){
            System.out.println("Hi "+e);
        }
    }
    
    public void onEditRow(RowEditEvent event) {
        System.out.println("Mod inline");
        modified = (Menage) event.getObject();

        try{
        events = getMenLocal().find(modified.getIDMenage());

        events.setIDPointRetrait(modified.getIDPointRetrait());
        events.setIDRecenseur(modified.getIDRecenseur());
        events.setNombreResidant(modified.getNombreResidant());

        menLocal.edit(events);
        System.out.println("Ligne avec id = "+modified.getNumeroCNI()+" a ete modifier.");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Valeur Modifier"));
        }catch(Exception ex){
            System.err.println(ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Modification Echec"));
        }
    }
    
    public void suppEvenmt(){
        try{
        System.out.println("Start : "+selEvent.getIDMenage());
        events = getMenLocal().find(selEvent.getIDMenage());
        System.out.println(events.getIDMenage());
        menLocal.remove(events);
        }catch(Exception e){
            System.err.println("Exception : "+e);
        }
    }
}
