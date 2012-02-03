/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.chart;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.dao.CompetitorMatchStatisticDao;
import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.PieChartEntry;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

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

	@Override
	public CartesianChartModel createKillsPerMatchPieChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		for (Competitor comp : competitorDao.getAllCompetitors()) {
			PieChartEntry pieChartEntry = new PieChartEntry();
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
			String name = comp.getName();
			if (name.equals("Benjamin")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 163);
				matchCount += 31;
			} else if (name.equals("Thomas")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 129);
				matchCount += 25;
			} else if (name.equals("Tom")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 139);
				matchCount += 26;
			} else if (name.equals("Frank")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 142);
				matchCount += 29;
			} else if (name.equals("Tilo")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 14);
				matchCount += 5;
			}

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
		for (Competitor comp : competitorDao.getAllCompetitors()) {
			PieChartEntry pieChartEntry = new PieChartEntry();
			ChartSeries serie = new ChartSeries();

			pieChartEntry.setLabel(comp.getName());
			pieChartEntry.setValue(0d);

			double wins = matchGameDao.getAllMatchGamesByWinnerId(comp.getId())
					.size();
			double matchCount = competitorMatchStatisticDao
					.getAllCompetitorMatchStatisticsByCompeitorId(comp.getId())
					.size();

			String name = comp.getName();
			if (name.equals("Benjamin")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 15);
				matchCount += 31;
			} else if (name.equals("Thomas")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 10);
				matchCount += 25;
			} else if (name.equals("Tom")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 10);
				matchCount += 26;
			} else if (name.equals("Frank")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 7);
				matchCount += 29;
			} else if (name.equals("Tilo")) {
				pieChartEntry.setValue(pieChartEntry.getValue() + 0);
				matchCount += 5;
			}

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
		for (Competitor comp : competitorDao.getAllCompetitors()) {
			PieChartEntry pieChartEntry = new PieChartEntry();
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
			String name = comp.getName();
			if (name.equals("Benjamin")) {
				matchCount += 31;
			} else if (name.equals("Thomas")) {
				matchCount += 25;
			} else if (name.equals("Tom")) {
				matchCount += 26;
			} else if (name.equals("Frank")) {
				matchCount += 29;
			} else if (name.equals("Tilo")) {
				matchCount += 5;
			}

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
}
