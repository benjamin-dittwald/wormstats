/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.math;

import de.bedit.gaming.wormstats.model.Leage;
import de.bedit.gaming.wormstats.table.SimpleTableEntry;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author benjamin
 */
@Local
public interface TableCalculator {
    public List<SimpleTableEntry> createSimpleTableList(Leage leage);
}
