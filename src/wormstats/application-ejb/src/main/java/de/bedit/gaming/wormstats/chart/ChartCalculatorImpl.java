/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.chart;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.dao.CompetitorMatchStatisticDao;
import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.math.TableCalculator;
import de.bedit.gaming.wormstats.model.ChartEntry;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.MatchGame;
import de.bedit.gaming.wormstats.model.SimpleTableEntry;

/**
 * 
 * @author benjamin
 */
@Stateless
public class ChartCalculatorImpl implements ChartCalculator {

	@EJB
	private CompetitorDao competitorDao;
	@EJB
	private CompetitorMatchStatisticDao competitorMatchStatisticDao;
	@EJB
	private MatchGameDao matchGameDao;
	@EJB
	private TableCalculator tableCalculator;

	@Override
	public CartesianChartModel createKillsPerMatchPieChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		List<Competitor> comps = competitorDao.getAllCompetitors();
		Collections.sort(comps);
		for (Competitor comp : comps) {
			ChartEntry pieChartEntry = new ChartEntry();
			ChartSeries serie = new ChartSeries();

			pieChartEntry.setLabel(comp.getName());
			pieChartEntry.setValue(0d);
			List<CompetitorMatchStatistic> matches = competitorMatchStatisticDao
					.getAllCompetitorMatchStatisticsByCompeitorId(comp.getId());

			for (CompetitorMatchStatistic cms : matches) {
				double killsCount = cms.getKills();
				pieChartEntry.setValue(pieChartEntry.getValue() + killsCount);
			}

			int matchCount = matches.size();

			try {
				pieChartEntry.setValue(pieChartEntry.getValue() / matchCount);
			} catch (ArithmeticException ex) {
				pieChartEntry.setValue(0d);
			}

			serie.setLabel(comp.getName());
			serie.set("", pieChartEntry.getValue());
			model.addSeries(serie);
		}
		return model;
	}

	@Override
	public CartesianChartModel createWinsPerMatchPieChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		List<Competitor> comps = competitorDao.getAllCompetitors();
		Collections.sort(comps);
		for (Competitor comp : comps) {
			ChartEntry pieChartEntry = new ChartEntry();
			ChartSeries serie = new ChartSeries();

			pieChartEntry.setLabel(comp.getName());
			pieChartEntry.setValue(0d);

			double wins = matchGameDao.getAllMatchGamesByWinnerId(comp.getId())
					.size();
			double matchCount = competitorMatchStatisticDao
					.getAllCompetitorMatchStatisticsByCompeitorId(comp.getId())
					.size();

			try {
				pieChartEntry.setValue(wins / matchCount);
			} catch (ArithmeticException ex) {
				pieChartEntry.setValue(0d);
			}

			serie.setLabel(comp.getName());
			serie.set("", pieChartEntry.getValue());
			model.addSeries(serie);
		}

		return model;
	}

	@Override
	public CartesianChartModel createSelfKillsPerMatchPieChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		List<Competitor> comps = competitorDao.getAllCompetitors();
		Collections.sort(comps);
		for (Competitor comp : comps) {
			ChartEntry pieChartEntry = new ChartEntry();
			ChartSeries serie = new ChartSeries();

			pieChartEntry.setLabel(comp.getName());
			pieChartEntry.setValue(0d);
			List<CompetitorMatchStatistic> matches = competitorMatchStatisticDao
					.getAllCompetitorMatchStatisticsByCompeitorId(comp.getId());

			for (CompetitorMatchStatistic cms : matches) {
				double selfKillsCount = cms.getSelfKills();
				pieChartEntry.setValue(pieChartEntry.getValue()
						+ selfKillsCount);
			}

			double matchCount = matches.size();
			try {
				pieChartEntry.setValue(pieChartEntry.getValue() / matchCount);
			} catch (ArithmeticException ex) {
				pieChartEntry.setValue(0d);
			}

			serie.setLabel(comp.getName());
			serie.set("", pieChartEntry.getValue());
			model.addSeries(serie);
		}
		return model;
	}

	@Override
	public CartesianChartModel createSkillFactorLineChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		List<Competitor> comps = competitorDao.getAllCompetitors();
		Collections.sort(comps);
		for (Competitor comp : comps) {
			SimpleTableEntry entry = new SimpleTableEntry();
			entry.setKills(0);
			entry.setMatches(0);
			entry.setSelfKills(0);
			entry.setSkill(0);
			entry.setWins(0);

			ChartSeries chart = new ChartSeries(comp.getName());
			for (MatchGame matchGame : matchGameDao.getAllMatchGames()) {
				for (CompetitorMatchStatistic stat : matchGame
						.getCompetitorMatchStatistics()) {
					if (!stat.getCompetitor().getName().equals(comp.getName())) {
						continue;
					}

					entry.setKills(entry.getKills() + stat.getKills());
					entry.setMatches(entry.getMatches() + 1);
					entry.setSelfKills(entry.getSelfKills()
							+ stat.getSelfKills());
					if (stat.getCompetitor().getId() == matchGame.getWinner()
							.getId()) {
						entry.setWins(entry.getWins() + 1);
					}
					chart.set(matchGame.getDate().getTime(),
							tableCalculator.calculateSimpleSkill(entry));
				}
			}
			model.addSeries(chart);
		}

		return model;
	}
}
