/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bedit.gaming.wormstats.model.MatchGame;

/**
 * 
 * @author benjamin
 */
@Stateless(name = "matchGameDao")
public class MatchGameDaoImpl implements MatchGameDao {

	@PersistenceContext
	private EntityManager em;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void createMatchGame(MatchGame matchGame) {
		log.debug("Create new matchGame with id {0}",
				new Object[] { matchGame.getId() });
		matchGame.setDate(new Date());
		em.persist(matchGame);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatchGame> getAllMatchGames() {
		return em.createNamedQuery("getAllMatchGames").getResultList();
	}

	@Override
	public MatchGame getMatchGameById(long id) {
		return (MatchGame) em.createNamedQuery("getMatchGameById")
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public void updateMatchGame(MatchGame matchGame) {
		log.debug("Update matchGame with id {0}",
				new Object[] { matchGame.getId() });
		em.merge(matchGame);
	}

	@Override
	public void deleteMatchGame(MatchGame matchGame) {
		log.debug("Delete new matchGame with id {0}",
				new Object[] { matchGame.getId() });
		em.merge(matchGame);
		em.remove(matchGame);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatchGame> getAllMatchGamesByWinnerId(long id) {
		return em.createNamedQuery("getAllMatchGamesByWinnerId")
				.setParameter("id", id).getResultList();
	}
}
