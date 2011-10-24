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
import de.bedit.gaming.wormstats.model.SimpleTableEntry;
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
        Map<String, String[]> offsetMap = new HashMap<String, String[]>();

        List<MatchGame> matches = leage.getMatches();

        for (MatchGame match : matches) {
            for (CompetitorMatchStatistic stat : match.getCompetitorMatchStatistics()) {
                if (entries.containsKey(stat.getCompetitor().getId())) {
                    SimpleTableEntry entry = entries.get(stat.getCompetitor().getId());
                    entry.setKills(entry.getKills() + stat.getKills());
                    if (stat.getCompetitor().getId() == match.getWinner().getId()) {
                        entry.setWins(entry.getWins() + 1);
                    }
                    entry.setMatches(entry.getMatches() + 1);
                    entry.setSkill(calculateSimpleSkill(entry));
                    entry.setSelfKills(entry.getSelfKills() + stat.getSelfKills());
                    entries.put(stat.getCompetitor().getId(), entry);
                } else {
                    SimpleTableEntry entry = new SimpleTableEntry();
                    String[] offset = offsetMap.get(stat.getCompetitor().getName());
                    entry.setMatches(1);
                    entry.setCompetitor(stat.getCompetitor());
                    entry.setKills(stat.getKills());
                    entry.setSelfKills(stat.getSelfKills());
                    if (stat.getCompetitor().getId() == match.getWinner().getId()) {
                        entry.setWins(1);
                    }

                    // Hack zur Übernahme der Altdaten
                    if (leage.getName().equals("5014 #1")) {
                        String cName = stat.getCompetitor().getName();

                        if (cName.equals("Benjamin")) {
                            entry.setKills(entry.getKills() + 163);
                            entry.setMatches(entry.getMatches() + 31);
                            entry.setWins(entry.getWins() + 15);

                        } else if (cName.equals("Thomas")) {
                            entry.setKills(entry.getKills() + 129);
                            entry.setMatches(entry.getMatches() + 25);
                            entry.setWins(entry.getWins() + 10);

                        } else if (cName.equals("Tom")) {
                            entry.setKills(entry.getKills() + 139);
                            entry.setMatches(entry.getMatches() + 26);
                            entry.setWins(entry.getWins() + 10);

                        } else if (cName.equals("Frank")) {
                            entry.setKills(entry.getKills() + 142);
                            entry.setMatches(entry.getMatches() + 29);
                            entry.setWins(entry.getWins() + 7);

                        } else if (cName.equals("Tilo")) {
                            entry.setKills(entry.getKills() + 14);
                            entry.setMatches(entry.getMatches() + 5);
                            entry.setWins(entry.getWins() + 0);

                        }
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
