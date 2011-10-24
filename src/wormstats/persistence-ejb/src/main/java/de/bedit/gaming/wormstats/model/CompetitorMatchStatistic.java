package de.bedit.gaming.wormstats.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "competitorMatchStatistic")
public class CompetitorMatchStatistic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "worms", nullable = false)
    private int worms;
    @Column(name = "kills", nullable = false)
    private int kills;
    @Column(name = "selfkills", nullable = false)
    private int selfKills;
    @OneToOne
    private Competitor competitor;

    public int getSelfKills() {
        return selfKills;
    }

    public void setSelfKills(int selfKills) {
        this.selfKills = selfKills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWorms() {
        return worms;
    }

    public void setWorms(int worms) {
        this.worms = worms;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }
}
