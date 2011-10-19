/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.Leage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author benjamin
 */
@Local
public interface LeageDao {

    public void createLeage(Leage leage);

    public List<Leage> getAllLeages();

    public Leage getById(long id);

    public void updateLeage(Leage leage);

    public void deleteLeage(Leage leage);
}
