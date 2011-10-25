/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.chart.ChartCalculator;
import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.PieChartEntry;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "globalStatistics")
@RequestScoped
public class GlobalStatisticsController {

	@EJB
	private ChartCalculator chartCalculator;
	@EJB
	private CompetitorDao competitorDao;
	private List<PieChartEntry> pcKills = new ArrayList<PieChartEntry>();
	private List<PieChartEntry> pcWins = new ArrayList<PieChartEntry>();
	private List<PieChartEntry> pcSelfKills = new ArrayList<PieChartEntry>();

	@PostConstruct
	public void init() {

		for (Competitor competitor : competitorDao.getAllActiveCompetitors()) {
			pcKills.add(chartCalculator
					.createKillsPerMatchPieChartEntry(competitor));
			pcSelfKills.add(chartCalculator
					.createSelfKillsPerMatchPieChartEntry(competitor));
			pcWins.add(chartCalculator
					.createWinsPerMatchPieChartEntry(competitor));
		}
	}

	public List<PieChartEntry> getPcKills() {
		return pcKills;
	}

	public void setPcKills(List<PieChartEntry> pcKills) {
		this.pcKills = pcKills;
	}

	public List<PieChartEntry> getPcSelfKills() {
		return pcSelfKills;
	}

	public void setPcSelfKills(List<PieChartEntry> pcSelfKills) {
		this.pcSelfKills = pcSelfKills;
	}

	public List<PieChartEntry> getPcWins() {
		return pcWins;
	}

	public void setPcWins(List<PieChartEntry> pcWins) {
		this.pcWins = pcWins;
	}
}
