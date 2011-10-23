/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

//import de.bedit.gaming.wormstats.constants.Constants;
import de.bedit.gaming.wormstats.model.MatchGame;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author benjamin
 */
@Stateless(name = "matchGameDao")
public class MatchGameDaoImpl implements MatchGameDao {

    @PersistenceContext
    private EntityManager em;
    private static final Logger logger = Logger.getLogger(MatchGameDaoImpl.class.getName());

    @Override
    public void createMatchGame(MatchGame matchGame) {
        logger.log(Level.INFO, "Create new matchGame with id {0}", new Object[]{matchGame.getId()});
        matchGame.setDate(new Date());
        em.persist(matchGame);
    }

    @Override
    public List<MatchGame> getAllMatchGames() {
        return em.createNamedQuery("getAllMatchGames").getResultList();
    }

    @Override
    public MatchGame getMatchGameById(long id) {
        return (MatchGame) em.createNamedQuery("getMatchGameById").setParameter("id", id).getSingleResult();
    }

    @Override
    public void updateMatchGame(MatchGame matchGame) {
        logger.log(Level.INFO, "Update matchGame with id {0}", new Object[]{matchGame.getId()});
        em.merge(matchGame);
    }

    @Override
    public void deleteMatchGame(MatchGame matchGame) {
        logger.log(Level.INFO, "Delete new matchGame with id {0}", new Object[]{matchGame.getId()});
        em.merge(matchGame);
        em.remove(matchGame);
    }

//    @Override
//    public List<MatchGame> getMatchGamesByDate(Date date, int config) {
//
//        List<MatchGame> matchGames = getAllMatchGames();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//
//        switch (config) {
//
//            case Constants.DATE_DAY:
//                break;
//
//            case Constants.DATE_WEEK:
//                break;
//
//            case Constants.DATE_MONTH:
//                break;
//
//            case Constants.DATE_YEAR:
//                break;
//
//            case Constants.DATE_STAMP:
//                break;
//
//            default:
//        }
//
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
}
