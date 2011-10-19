package de.bedit.gaming.wormstats.dao;

import java.util.List;
import javax.ejb.Stateless;

import de.bedit.gaming.wormstats.model.Competitor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "competitorDao")
public class CompetitorDaoImpl implements CompetitorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createCompetitor(Competitor competitor) {
        System.out.println("Create");
        em.persist(competitor);
    }

    @Override
    public List<Competitor> getAllCompetitors() {
        System.out.println("GetAll");
        return em.createNamedQuery("competitor").getResultList();
    }
}
