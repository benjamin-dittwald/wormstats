/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author benjamin
 */
@Stateless
public class CompetitorMatchStatisticDaoImpl implements CompetitorMatchStatisticDao {
    
    @PersistenceContext
    private EntityManager em;
    private static final Logger logger = Logger.getLogger(CompetitorMatchStatisticDaoImpl.class.getName());
    
    @Override
    public List<CompetitorMatchStatistic> getAllCompetitorMatchStatisticsByCompeitorId(long id) {
        return em.createNamedQuery("getAllCompetitorMatchStatisticsByCompetitorId").setParameter("id", id).getResultList();
    }
}
