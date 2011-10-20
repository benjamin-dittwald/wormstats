package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.model.Competitor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "competitors")
@SessionScoped
public class CompetitorsController implements Serializable {

    @EJB
    private CompetitorDao competitorDao;
    private List<Competitor> competitors = new ArrayList<Competitor>();

    /**
     * default empty constructor
     */
    public CompetitorsController() {
    }

    @PostConstruct
    public void init() {
        competitors.addAll(competitorDao.getAllCompetitors());
    }

    public void addCompetitorToList() {
        System.out.println("Add");
        competitors.add(new Competitor());
    }

    public void removeCompetitorFromList(Competitor competitor) {
        System.out.println("Remove");
        competitors.remove(competitor);
    }

    public void save() {
        System.out.println("Save");
        for (Competitor competitor : competitors) {
            if (competitorDao.competitorExist(competitor)) {
                competitorDao.updateCompetitor(competitor);
            } else {
                competitorDao.createCompetitor(competitor);
            }
        }
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }
}
