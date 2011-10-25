/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.model;

import de.bedit.gaming.wormstats.model.Competitor;

/**
 *
 * @author benjamin
 */
public class SimpleTableEntry implements Comparable<SimpleTableEntry> {

	private Competitor competitor;
	private int matches;
	private int wins;
	private int kills;
	private int selfKills;
	private double skill;

	public int getSelfKills() {
		return selfKills;
	}

	public void setSelfKills(int selfKills) {
		this.selfKills = selfKills;
	}

	public Competitor getCompetitor() {
		return competitor;
	}

	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public double getSkill() {
		return skill;
	}

	public void setSkill(double skill) {
		this.skill = skill;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	@Override
	public int compareTo(SimpleTableEntry t) {
		int result;

		if (t.getSkill() < skill) {
			result = -1;
		} else if (t.getSkill() > skill) {
			result = 1;
		} else {
			result = 0;
		}

		return result;
	}
}
