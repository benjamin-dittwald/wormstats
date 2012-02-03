/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.model;

import java.util.Comparator;

/**
 *
 * @author benjamin
 */
public class MatchGameComparatorDateDesc implements Comparator<MatchGame> {

	@Override
	public int compare(MatchGame t, MatchGame t1) {
		MatchGame match1 = (MatchGame) t;
		MatchGame match2 = (MatchGame) t1;

		// * -1 DESC
		return match1.getMatchDate().compareTo(match2.getMatchDate()) * -1;
	}

}
