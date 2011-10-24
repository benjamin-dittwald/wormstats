/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author benjamin
 */
@Local
public interface CompetitorMatchStatisticDao {
    public List<CompetitorMatchStatistic> getAllCompetitorMatchStatisticsByCompeitorId(long id);
}
