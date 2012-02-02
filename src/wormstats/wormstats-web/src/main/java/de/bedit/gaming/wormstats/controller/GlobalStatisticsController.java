/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.dao.CompetitorMatchStatisticDao;
import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.PieChartEntry;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "globalStatistics")
@RequestScoped
public class GlobalStatisticsController {

	@EJB
	private CompetitorDao competitorDao;
	@EJB
	private CompetitorMatchStatisticDao competitorMatchStatisticDao;
	@EJB
	private MatchGameDao matchGameDao;
	private CartesianChartModel pcKills;
	private CartesianChartModel pcSelfKills;
	private CartesianChartModel pcWins;

	@PostConstruct
	public void init() {

		pcKills = createKillsPerMatchPieChartEntry();
		pcSelfKills = createSelfKillsPerMatchPieChartEntry();
		pcWins = createWinsPerMatchPieChartEntry();
	}

	public CartesianChartModel createKillsPerMatchPieChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		for (Competitor competitor : competitorDao.getAllCompetitors()) {
			PieChartEntry pieChartEntry = new PieChartEntry();
			ChartSeries serie = new ChartSeries();

			pieChartEntry.setLabel(competitor.getName());
			pieChartEntry.setValue(0d);
			List<CompetitorMatchStatistic> matches = competitorMatchStatisticDao
					.getAllCompetitorMatchStatisticsByCompeitorId(competitor
							.getId());

			for (CompetitorMatchStatistic cms : matches) {
				double killsCount = cms.getKills();
				pieChartEntry.setValue(pieChartEntry.getValue() + killsCount);
			}

			int matchCount = matches.size();
			String name = competitor.getName();
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

			serie.setLabel(competitor.getName());
			serie.set("", pieChartEntry.getValue());
			model.addSeries(serie);
		}

		return model;
	}

	public CartesianChartModel createWinsPerMatchPieChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		for (Competitor competitor : competitorDao.getAllCompetitors()) {
			PieChartEntry pieChartEntry = new PieChartEntry();
			ChartSeries serie = new ChartSeries();
			pieChartEntry.setLabel(competitor.getName());
			pieChartEntry.setValue(0d);

			double wins = matchGameDao.getAllMatchGamesByWinnerId(
					competitor.getId()).size();
			double matchCount = competitorMatchStatisticDao
					.getAllCompetitorMatchStatisticsByCompeitorId(
							competitor.getId()).size();

			String name = competitor.getName();
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

			serie.setLabel(competitor.getName());
			serie.set("", pieChartEntry.getValue());
			model.addSeries(serie);
		}

		return model;
	}

	public CartesianChartModel createSelfKillsPerMatchPieChartEntry() {
		CartesianChartModel model = new CartesianChartModel();
		for (Competitor competitor : competitorDao.getAllCompetitors()) {
			PieChartEntry pieChartEntry = new PieChartEntry();
			ChartSeries serie = new ChartSeries();

			pieChartEntry.setLabel(competitor.getName());
			pieChartEntry.setValue(0d);
			List<CompetitorMatchStatistic> matches = competitorMatchStatisticDao
					.getAllCompetitorMatchStatisticsByCompeitorId(competitor
							.getId());

			for (CompetitorMatchStatistic cms : matches) {
				double selfKillsCount = cms.getSelfKills();
				pieChartEntry.setValue(pieChartEntry.getValue()
						+ selfKillsCount);
			}

			double matchCount = matches.size();
			String name = competitor.getName();
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

			serie.setLabel(competitor.getName());
			serie.set("", pieChartEntry.getValue());
			model.addSeries(serie);
		}

		return model;
	}

	public CartesianChartModel getPcKills() {
		return pcKills;
	}

	public void setPcKills(CartesianChartModel pcKills) {
		this.pcKills = pcKills;
	}

	public CartesianChartModel getPcSelfKills() {
		return pcSelfKills;
	}

	public void setPcSelfKills(CartesianChartModel pcSelfKills) {
		this.pcSelfKills = pcSelfKills;
	}

	public CartesianChartModel getPcWins() {
		return pcWins;
	}

	public void setPcWins(CartesianChartModel pcWins) {
		this.pcWins = pcWins;
	}
}
