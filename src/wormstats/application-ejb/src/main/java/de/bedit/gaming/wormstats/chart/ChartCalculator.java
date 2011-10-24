/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.chart;

import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.PieChartEntry;

/**
 *
 * @author benjamin
 */
public interface ChartCalculator {

    public PieChartEntry createKillsPerMatchPieChartEntry(Competitor comp);
    
    public PieChartEntry createWinsPerMatchPieChartEntry(Competitor comp);
    
    public PieChartEntry createSelfKillsPerMatchPieChartEntry(Competitor comp);
}
