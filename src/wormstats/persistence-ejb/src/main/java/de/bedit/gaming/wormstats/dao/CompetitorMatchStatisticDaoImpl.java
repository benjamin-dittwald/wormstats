/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;

/**
 * 
 * @author benjamin
 */
@Stateless
public class CompetitorMatchStatisticDaoImpl implements
		CompetitorMatchStatisticDao {

	@PersistenceContext
	private EntityManager em;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	@Override
	public List<CompetitorMatchStatistic> getAllCompetitorMatchStatisticsByCompeitorId(
			long id) {
		log.debug("Getting all competitors");
		return em
				.createNamedQuery(
						"getAllCompetitorMatchStatisticsByCompetitorId")
				.setParameter("id", id).getResultList();
	}
}
