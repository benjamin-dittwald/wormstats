/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.chart;

import org.primefaces.model.chart.CartesianChartModel;

/**
 *
 * @author benjamin
 */
public interface ChartCalculator {

	public CartesianChartModel createKillsPerMatchPieChartEntry();

	public CartesianChartModel createWinsPerMatchPieChartEntry();

	public CartesianChartModel createSelfKillsPerMatchPieChartEntry();

	public CartesianChartModel createSkillFactorLineChartEntry();
}
