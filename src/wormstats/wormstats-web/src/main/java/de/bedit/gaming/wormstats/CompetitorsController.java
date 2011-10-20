package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.model.Competitor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "competitors")
@RequestScoped
public class CompetitorsController {

    @EJB(name = "competitorDao")
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

    // -------------------getter & setter
    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }
}
