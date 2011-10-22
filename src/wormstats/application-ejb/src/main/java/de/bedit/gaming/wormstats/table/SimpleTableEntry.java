/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.table;

import de.bedit.gaming.wormstats.model.Competitor;

/**
 *
 * @author benjamin
 */
public class SimpleTableEntry {

    private Competitor competitor;
    private int matches;
    private int wins;
    private int kills;
    private int skill;

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

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
