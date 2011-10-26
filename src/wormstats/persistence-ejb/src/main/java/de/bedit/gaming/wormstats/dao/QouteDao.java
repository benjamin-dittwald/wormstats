/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.Qoute;
import javax.ejb.Local;

/**
 *
 * @author benjamin
 */
@Local
public interface QouteDao {
	public Qoute getRandomQoute();
}
