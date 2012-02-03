/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.chart.ChartCalculator;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "globalStatistics")
@RequestScoped
public class GlobalStatisticsController {

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
