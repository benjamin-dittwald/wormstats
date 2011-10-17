package de.bedit.gaming.wormstats.dao;

import java.util.List;
import javax.ejb.Stateless;

import de.bedit.gaming.wormstats.model.Competitor;

@Stateless(name = "competitorDao")
public class CompetitorDaoImpl implements CompetitorDao {

    @Override
    public void createCompetitor(Competitor competitor) {
        System.out.println("Create");

    }

    @Override
    public List<Competitor> getAllCompetitors() {
        System.out.println("GetAll");
        return null;
    }
}
