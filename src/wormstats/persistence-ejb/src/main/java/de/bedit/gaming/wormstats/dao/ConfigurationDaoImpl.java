/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.Configuration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author benjamin
 */
@Stateless
public class ConfigurationDaoImpl implements ConfigurationDao {

    @PersistenceContext
    private EntityManager em;
    private static final Logger logger = Logger.getLogger(ConfigurationDaoImpl.class.getName());

    @Override
    public Configuration getConfiguration() {
        Configuration configuration;
        try {
            configuration = (Configuration) em.createNamedQuery("getConfiguration").getSingleResult();
        } catch (NoResultException ex) {
            configuration = new Configuration();
            logger.log(Level.INFO, "Create new configuration with id {0}", new Object[]{configuration.getId()});
            em.persist(configuration);
        }

        return configuration;
    }

    @Override
    public void updateConfiguration(Configuration configuration) {
        logger.log(Level.INFO, "Update configuration with id {0}, formula is now {1}", new Object[]{configuration.getId(), configuration.getSkillFormula()});
        em.merge(configuration);
    }
}
