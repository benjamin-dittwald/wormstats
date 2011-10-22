/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.math;

import de.bedit.gaming.wormstats.model.CompetitorMatchStatistic;
import de.bedit.gaming.wormstats.model.Leage;
import de.bedit.gaming.wormstats.model.MatchGame;
import de.bedit.gaming.wormstats.table.SimpleTableEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benjamin
 */
public class TableCalculator {

    public static List<SimpleTableEntry> simpleTableList(Leage leage) {
        List<SimpleTableEntry> list = new ArrayList<SimpleTableEntry>();
        Map<Long, CompetitorMatchStatistic> stats = new HashMap<Long, CompetitorMatchStatistic>();

        List<MatchGame> matches = leage.getMatches();

//        for (MatchGame ) {
//            
//        }
        
        for (MatchGame matchGame : matches) {
            SimpleTableEntry entry = new SimpleTableEntry();
        }

        return list;
    }
}
