package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.Leage;
import de.bedit.gaming.wormstats.model.MatchGame;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "matchCreate")
@ViewScoped
public class MatchCreateController {

    @EJB
    MatchGameDao matchGameDao;
    MatchGame match = new MatchGame();
    Leage leage;
    List<CompetitorMatchStatistic> statistics = new ArrayList<CompetitorMatchStatistic>();

    @PostConstruct
    public void init() {
        LeagesController leageController = (LeagesController) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("leage");
        leage = leageController.getCurrentLeage();
    }

    public void addStats() {
        CompetitorMatchStatistic competitorMatchStatistic = new CompetitorMatchStatistic();
        competitorMatchStatistic.setKills(0);
        competitorMatchStatistic.setWorms(0);
        statistics.add(competitorMatchStatistic);
    }

    public void removeStats(CompetitorMatchStatistic competitorMatchStatistic) {
        statistics.remove(competitorMatchStatistic);
    }

    public Leage getLeage() {
        return leage;
    }

    public void setLeage(Leage leage) {
        this.leage = leage;
    }

    public MatchGame getMatch() {
        return match;
    }

    public void setMatch(MatchGame match) {
        this.match = match;
    }

    public List<CompetitorMatchStatistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<CompetitorMatchStatistic> statistics) {
        this.statistics = statistics;
    }
    
}
