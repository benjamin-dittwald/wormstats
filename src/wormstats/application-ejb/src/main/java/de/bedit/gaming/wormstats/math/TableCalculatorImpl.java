/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.math;

import de.bedit.gaming.wormstats.constants.Constants;
import de.bedit.gaming.wormstats.dao.ConfigurationDao;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.Leage;
import de.bedit.gaming.wormstats.model.MatchGame;
import de.bedit.gaming.wormstats.table.SimpleTableEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author benjamin
 */
@Stateless(name = "tableCalculator")
public class TableCalculatorImpl implements TableCalculator {

    @EJB
    ConfigurationDao configurationDao;

    @Override
    public List<SimpleTableEntry> createSimpleTableList(Leage leage) {
        List<SimpleTableEntry> list = new ArrayList<SimpleTableEntry>();
        Map<Long, SimpleTableEntry> entries = new HashMap<Long, SimpleTableEntry>();

        List<MatchGame> matches = leage.getMatches();

        for (MatchGame match : matches) {
            for (CompetitorMatchStatistic stat : match.getCompetitorMatchStatistics()) {
                if (entries.containsKey(stat.getId())) {
                    SimpleTableEntry entry = entries.get(stat.getCompetitor().getId());
                    entry.setKills(entry.getKills() + stat.getKills());
                    if (stat.getCompetitor().getId() == match.getWinner().getId()) {
                        entry.setWins(entry.getWins() + 1);
                    }
                    entry.setMatches(entry.getMatches() + 1);
                    entry.setSkill(calculateSimpleSkill(entry));
                    entries.put(stat.getCompetitor().getId(), entry);
                } else {
                    SimpleTableEntry entry = new SimpleTableEntry();
                    entry.setMatches(1);
                    entry.setCompetitor(stat.getCompetitor());
                    entry.setKills(stat.getKills());
                    if (stat.getCompetitor().getId() == match.getWinner().getId()) {
                        entry.setWins(1);
                    }
                    entry.setSkill(calculateSimpleSkill(entry));
                    entries.put(stat.getCompetitor().getId(), entry);
                }
            }

        }
        
        for (SimpleTableEntry entry : entries.values()) {
            list.add(entry);
        }

        return list;
    }

    private double calculateSimpleSkill(SimpleTableEntry entry) {

        Expression exp = new Expression(configurationDao.getConfiguration().getSkillFormula());
        exp.setVariable(Constants.KILLS, entry.getKills());
        exp.setVariable(Constants.MATCHES, entry.getMatches());
        exp.setVariable(Constants.WINS, entry.getWins());

        return exp.resolve();
    }
}
