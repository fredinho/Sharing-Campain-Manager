/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import EJB.CampagneFacadeLocal;
import JPA.Article;
import JPA.Campagne;
import JPA.Etat;
import JPA.Organisme;
import config.DataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author FREDINHO
 */
@ManagedBean
@ViewScoped
public class CampagneBean implements Serializable {
    @EJB
    private CampagneFacadeLocal campLocal;
    private Campagne camp;
    private List<Campagne> listcamp;
    private Date datdeb;
    private Date datfin;
    private Article idart;
    private Organisme idorg;
    private Etat idetat;
    private String description;
    private Campagne select;
    private DataModel model;
    private Campagne[] selection;
    private Campagne events;

    public CampagneBean() {
    }

    public CampagneFacadeLocal getCampLocal() {
        return campLocal;
    }

    public void setCampLocal(CampagneFacadeLocal campLocal) {
        this.campLocal = campLocal;
    }

    public Campagne getCamp() {
        return camp;
    }

    public void setCamp(Campagne camp) {
        this.camp = camp;
    }

    public List<Campagne> getListcamp() {
        return listcamp;
    }

    public void setListcamp(List<Campagne> listcamp) {
        this.listcamp = listcamp;
    }

    public Date getDatdeb() {
        return datdeb;
    }

    public void setDatdeb(Date datdeb) {
        this.datdeb = datdeb;
    }

    public Date getDatfin() {
        return datfin;
    }

    public void setDatfin(Date datfin) {
        this.datfin = datfin;
    }

    public Article getIdart() {
        return idart;
    }

    public void setIdart(Article idart) {
        this.idart = idart;
    }

    public Organisme getIdorg() {
        return idorg;
    }

    public void setIdorg(Organisme idorg) {
        this.idorg = idorg;
    }

    public Etat getIdetat() {
        return idetat;
    }

    public void setIdetat(Etat idetat) {
        this.idetat = idetat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Campagne getSelect() {
        return select;
    }

    public void setSelect(Campagne select) {
        this.select = select;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public Campagne[] getSelection() {
        return selection;
    }

    public void setSelection(Campagne[] selection) {
        this.selection = selection;
    }

    public Campagne getEvents() {
        return events;
    }

    public void setEvents(Campagne events) {
        this.events = events;
    }
    
    public void allcampagne(){
        listcamp = new ArrayList<Campagne>();
        model = new DataModel(listcamp);
        List<Campagne> lc = getCampLocal().findAll();
        for(Campagne c : lc){
            getListcamp().add(c);
        }
    }
    
    public void creercampagne(){
        try{
            System.out.println("Start");
            getCamp().setDateDebut(getDatdeb());
            getCamp().setDateFin(getDatfin());
            getCamp().setIDArticle(getIdart());
            getCamp().setIDEtat(new Etat(1));
            getCamp().setIDOrganisme(getIdorg());
            getCamp().setDescription(getDescription());
            getCampLocal().create(camp);
        }catch(Exception ex){
            System.err.println("error "+ ex);
        }
    }
    public void suppEvents(){
        System.out.println("onStart");
        try{
            System.out.println(selection.length);
        for(int i=0; i<selection.length; i++){
            selection[i].setIDCampagne(selection[i].getIDCampagne());
            camp = getCampLocal().find(selection[i].getIDCampagne());
            getCampLocal().remove(camp);
            
            System.out.println("Ligne avec id = "+selection[i].getDescription()+" a ete supprimer.");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Supprimer", "Suppression reussi"));
            
        }
        }catch(Exception e){
            System.out.println("Hi "+e);
        }
    }
    
    public void editRow() {
        System.out.println("Mod inline");
        events = new Campagne();
        System.out.println(select.getIDCampagne().toString());
        try{
        events = getCampLocal().find(select.getIDCampagne());

        events.setDateDebut(getDatdeb());
        events.setDateFin(getDatfin());
        events.setDescription(getDescription());
        events.setIDArticle(getIdart());
        events.setIDOrganisme(getIdorg());
        campLocal.edit(events);
        System.out.println("Ligne avec id = "+select.getDescription()+" a ete modifier.");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Valeur Modifier"));
        }catch(Exception ex){
            System.err.println(ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Modification Echec"));
        }
    }
}
