/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.Leage;
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
@Stateless(name = "leageDao")
public class LeageDaoImpl implements LeageDao {

	@PersistenceContext
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(LeageDaoImpl.class
			.getName());

	@Override
	public void createLeage(Leage leage) {
		logger.log(Level.INFO, "Create new leage with id {0} and name {1}",
				new Object[]{leage.getId(), leage.getName()});
		em.persist(leage);
	}

	@Override
	public List<Leage> getAllLeages() {
		return em.createNamedQuery("getAllLeages").getResultList();
	}

	@Override
	public Leage getById(long id) {
		return (Leage) em.createNamedQuery("getLeageById").setParameter("id",
				id).getSingleResult();
	}

	@Override
	public void updateLeage(Leage leage) {
		logger.log(Level.INFO, "Update leage with id {0} and name {1}",
				new Object[]{leage.getId(), leage.getName()});
		em.merge(leage);
	}

	@Override
	public void deleteLeage(Leage leage) {
		logger.log(Level.INFO, "Delete leage with id {0} and name {1}",
				new Object[]{leage.getId(), leage.getName()});
		em.merge(leage);
		em.remove(leage);
	}
}
