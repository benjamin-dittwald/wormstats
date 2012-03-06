/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.Configuration;
import javax.ejb.Local;

/**
 *
 * @author benjamin
 */
@Local
public interface ConfigurationDao {

    public Configuration getConfiguration();

    public void updateConfiguration(Configuration configuration);
}
