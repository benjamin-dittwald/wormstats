/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.dao.LeageDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.Leage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "leageCreate")
@ViewScoped
public class LeageCreateController {

    @EJB
    private LeageDao leageDao;
    @EJB
    private CompetitorDao competitorDao;
    private Leage leage = new Leage();
    private List<String> competitors = new ArrayList<String>();
    private List<SelectItem> competitorsAvailable = new ArrayList<SelectItem>();

    @PostConstruct
    public void init() {
        for (Competitor comp : competitorDao.getAllActiveCompetitors()) {
            competitorsAvailable.add(new SelectItem(String.valueOf(comp.getId()), comp.getName()));
        }
    }

    public String save() {
        for (String id : competitors) {
            leage.getCompetitors().add(competitorDao.getCompetitorById(Long.valueOf(id)));
        }
        leageDao.createLeage(leage);
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("leages");
        return "leages";
    }

    public Leage getLeage() {
        return leage;
    }

    public void setLeage(Leage leage) {
        this.leage = leage;
    }

    public List<String> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<String> competitors) {
        this.competitors = competitors;
    }

    public List<SelectItem> getCompetitorsAvailable() {
        return competitorsAvailable;
    }

    public void setCompetitorsAvailable(List<SelectItem> competitorsAvailable) {
        this.competitorsAvailable = competitorsAvailable;
    }
}
