/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.chart.ChartCalculator;
import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.model.Competitor;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.commons.lang3.time.DateUtils;
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
	private ChartCalculator chartCalculator;
	@EJB
	private CompetitorDao competitorDao;
	private String competitorsColors;
	private CartesianChartModel pcKills;
	private CartesianChartModel pcSelfKills;
	private CartesianChartModel pcWins;
	private CartesianChartModel pcSkill;
	private CartesianChartModel pcSkillFactor;
	private CartesianChartModel pcSkillFactorAll;
	private int skillMonitoringMonths;

	@PostConstruct
	public void init() {
		List<Competitor> competitors = competitorDao.getAllCompetitors();
		Collections.sort(competitors);
		StringBuilder sb = new StringBuilder();
		for (Competitor competitor : competitors) {
			sb.append(competitor.getColor()).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length() - 1);
		competitorsColors = sb.toString();
		pcKills = chartCalculator.createKillsPerMatchPieChartEntry();
		pcSelfKills = chartCalculator.createSelfKillsPerMatchPieChartEntry();
		pcWins = chartCalculator.createWinsPerMatchPieChartEntry();
		pcSkillFactorAll = chartCalculator.createSkillFactorLineChartEntry();
		pcSkillFactor = pcSkillFactorAll;
	}

	// TODO: Fertig machen
	public void updateSkillLineChart() {
		Date lastShowingMonth = DateUtils.addMonths(new Date(),
				-skillMonitoringMonths);
		for (ChartSeries serie : pcSkillFactorAll.getSeries()) {

		}
	}
	public int getSkillMonitoringMonths() {
		return skillMonitoringMonths;
	}

	public void setSkillMonitoringMonths(int skillMonitoringMonths) {
		this.skillMonitoringMonths = skillMonitoringMonths;
	}

	public String getCompetitorsColors() {
		return competitorsColors;
	}

	public void setCompetitorsColors(String competitorsColors) {
		this.competitorsColors = competitorsColors;
	}

	public CartesianChartModel getPcSkillFactor() {
		return pcSkillFactor;
	}

	public void setPcSkillFactor(CartesianChartModel pcSkillFactor) {
		this.pcSkillFactor = pcSkillFactor;
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
