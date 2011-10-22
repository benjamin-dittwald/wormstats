package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.MatchGame;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author benjamin
 */
public class MatchCreateController {
    @EJB
    MatchGameDao matchGameDao;
    MatchGame match = new MatchGame();
    List<CompetitorMatchStatistic> statistics = new ArrayList<CompetitorMatchStatistic>();
    
    @PostConstruct
    public void init() {
        
    }
}
