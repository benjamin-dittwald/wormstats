package de.bedit.gaming.wormstats.dao;

import java.util.List;

import de.bedit.gaming.wormstats.model.Competitor;
import javax.ejb.Local;

@Local
public interface CompetitorDao {

	public void createCompetitor(Competitor competitor);

	public List<Competitor> getAllCompetitors();

}
