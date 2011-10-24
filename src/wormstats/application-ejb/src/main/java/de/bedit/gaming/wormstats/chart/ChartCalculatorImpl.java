/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.chart;

import de.bedit.gaming.wormstats.dao.CompetitorMatchStatisticDao;
import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.MatchGame;
import de.bedit.gaming.wormstats.model.PieChartEntry;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author benjamin
 */
@Stateless
public class ChartCalculatorImpl implements ChartCalculator {

    @EJB
    private CompetitorMatchStatisticDao competitorMatchStatisticDao;
    @EJB
    private MatchGameDao matchGameDao;

    @Override
    public PieChartEntry createKillsPerMatchPieChartEntry(Competitor comp) {
        PieChartEntry pieChartEntry = new PieChartEntry();

        pieChartEntry.setLabel(comp.getName());
        pieChartEntry.setValue(0);

        for (CompetitorMatchStatistic cms : competitorMatchStatisticDao.getAllCompetitorMatchStatisticsByCompeitorId(comp.getId())) {
            pieChartEntry.setValue(pieChartEntry.getValue() + cms.getKills());
        }


        return pieChartEntry;
    }

    @Override
    public PieChartEntry createWinsPerMatchPieChartEntry(Competitor comp) {
        PieChartEntry pieChartEntry = new PieChartEntry();

        pieChartEntry.setLabel(comp.getName());
        pieChartEntry.setValue(0);

        for (MatchGame match : matchGameDao.getAllMatchGamesByCompetitorId(comp.getId())) {
            if (comp.getId() == match.getWinner().getId()) {
                pieChartEntry.setValue(pieChartEntry.getValue() + 1);
            }
        }

        return pieChartEntry;
    }

    @Override
    public PieChartEntry createSelfKillsPerMatchPieChartEntry(Competitor comp) {
        PieChartEntry pieChartEntry = new PieChartEntry();

        pieChartEntry.setLabel(comp.getName());
        pieChartEntry.setValue(0);

        for (CompetitorMatchStatistic cms : competitorMatchStatisticDao.getAllCompetitorMatchStatisticsByCompeitorId(comp.getId())) {
            pieChartEntry.setValue(pieChartEntry.getValue() + cms.getSelfKills());
        }

        return pieChartEntry;
    }
}
