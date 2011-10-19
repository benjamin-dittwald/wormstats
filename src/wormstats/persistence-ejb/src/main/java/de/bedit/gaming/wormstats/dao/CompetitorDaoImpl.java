package de.bedit.gaming.wormstats.dao;

import java.util.List;
import javax.ejb.Stateless;

import de.bedit.gaming.wormstats.model.Competitor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "competitorDao")
public class CompetitorDaoImpl implements CompetitorDao {

    @PersistenceContext
    private EntityManager em;
    private static final Logger logger = Logger.getLogger(CompetitorDaoImpl.class.getName());

    @Override
    public void createCompetitor(Competitor competitor) {
        logger.log(Level.INFO, "Create new competitor with id {0} and name {1}", new Object[]{competitor.getId(), competitor.getName()});
        em.persist(competitor);
    }

    @Override
    public List<Competitor> getAllCompetitors() {
        return em.createNamedQuery("getAllCompetitors").getResultList();
    }

    @Override
    public Competitor getCompetitorById(long id) {
        return (Competitor) em.createNamedQuery("getById").setParameter("id", id).getSingleResult();
    }

    @Override
    public void updateCompetitor(Competitor competitor) {
        logger.log(Level.INFO, "Update competitor with id {0} and name {1}", new Object[]{competitor.getId(), competitor.getName()});
        em.merge(competitor);
    }

    @Override
    public void deactivateCompetitor(Competitor competitor) {
        logger.log(Level.INFO, "Deactivate competitor with id {0} and name {1}", new Object[]{competitor.getId(), competitor.getName()});
        competitor.setActive(false);
        em.merge(competitor);
    }

    @Override
    public void activateCompetitor(Competitor competitor) {
        logger.log(Level.INFO, "Activate competitor with id {0} and name {1}", new Object[]{competitor.getId(), competitor.getName()});
        competitor.setActive(true);
        em.merge(competitor);
    }
}
