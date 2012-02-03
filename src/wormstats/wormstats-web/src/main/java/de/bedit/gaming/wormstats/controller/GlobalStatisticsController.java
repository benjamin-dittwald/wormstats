/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.chart.ChartCalculator;
import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.MatchGame;
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
	private MatchGameDao matchGameDao;
	@EJB
	private ChartCalculator chartCalculator;
	private CartesianChartModel pcKills;
	private CartesianChartModel pcSelfKills;
	private CartesianChartModel pcWins;
	private CartesianChartModel pcSkill;

	@PostConstruct
	public void init() {

		pcKills = chartCalculator.createKillsPerMatchPieChartEntry();
		pcSelfKills = chartCalculator.createSelfKillsPerMatchPieChartEntry();
		pcWins = chartCalculator.createWinsPerMatchPieChartEntry();
	}

	//TBD
	private CartesianChartModel createSkillfactor() {
		CartesianChartModel model = new CartesianChartModel();

		for (Competitor competitor : competitorDao.getAllCompetitors()) {
			List<MatchGame> matches = matchGameDao.getAllMatchGames();
			ChartSeries serie = new ChartSeries(competitor.getName());
			for (MatchGame match : matches) {
				for (CompetitorMatchStatistic stat : match
						.getCompetitorMatchStatistics()) {
					if (stat.getCompetitor().getName().equals(
							competitor.getName())) {
						//                        serie.set(match.getDate(), );
					}
				}
			}
		}

		return model;
	}

	public CartesianChartModel getPcSkill() {
		return pcSkill;
	}

	public void setPcSkill(CartesianChartModel pcSkill) {
		this.pcSkill = pcSkill;
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
