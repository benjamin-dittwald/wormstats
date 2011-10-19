package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.MatchGame;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MatchGameDao {

    public void createMatchGame(MatchGame matchGame);
    
    public List<MatchGame> getAllMatchGames();
    
    public MatchGame getMatchGameById(long id);
    
    public void updateMatchGame(MatchGame matchGame);
    
    public void deleteMatchGame(MatchGame matchGame);
    
    public List<MatchGame> getMatchGamesByDate(Date date, int config);

}
