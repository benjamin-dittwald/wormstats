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

import de.bedit.gaming.wormstats.model.Leage;

/**
 * 
 * @author benjamin
 */
@Stateless(name = "leageDao")
public class LeageDaoImpl implements LeageDao {

	@PersistenceContext
	private EntityManager em;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void createLeage(Leage leage) {
		log.debug("Create new leage with id {0} and name {1}", new Object[] {
				leage.getId(), leage.getName() });
		em.persist(leage);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Leage> getAllLeages() {
		return em.createNamedQuery("getAllLeages").getResultList();
	}

	@Override
	public Leage getById(long id) {
		return (Leage) em.createNamedQuery("getLeageById")
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public void updateLeage(Leage leage) {
		log.debug("Update leage with id {0} and name {1}",
				new Object[] { leage.getId(), leage.getName() });
		em.merge(leage);
	}

	@Override
	public void deleteLeage(Leage leage) {
		log.debug("Delete leage with id {0} and name {1}",
				new Object[] { leage.getId(), leage.getName() });
		em.merge(leage);
		em.remove(leage);
	}
}
