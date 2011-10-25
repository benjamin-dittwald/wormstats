package de.bedit.gaming.wormstats.dao;

import java.util.List;

import de.bedit.gaming.wormstats.model.Competitor;
import javax.ejb.Local;

@Local
public interface CompetitorDao {

	public void createCompetitor(Competitor competitor);

	public List<Competitor> getAllCompetitors();

	public Competitor getCompetitorById(long id);

	public void updateCompetitor(Competitor competitor);

	public void deactivateCompetitor(Competitor competitor);

	public void activateCompetitor(Competitor competitor);

	public boolean competitorExist(Competitor competitor);

	public List<Competitor> getAllActiveCompetitors();

	public List<Competitor> getAllInactiveCompetitors();
}
