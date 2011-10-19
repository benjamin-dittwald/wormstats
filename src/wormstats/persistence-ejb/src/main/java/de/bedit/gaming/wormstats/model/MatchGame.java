package de.bedit.gaming.wormstats.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "matchGame")
@NamedQueries({
    @NamedQuery(name = "getAllMatchGames", query = "SELECT m FROM MatchGame m"),
    @NamedQuery(name = "getMatchGameById", query = "SELECT m FROM MatchGame m WHERE m.id = :id"),
    @NamedQuery(name = "getMatchGameByTimestamp", query = "SELECT m FROM MatchGame m WHERE m.matchDate = :date")})
public class MatchGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "matchDate", nullable=false)
    private Date matchDate;
    @OneToMany
    private List<CompetitorMatchStatistic> competitorMatchStatistics;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return matchDate;
    }

    public void setDate(Date date) {
        this.matchDate = date;
    }

    public List<CompetitorMatchStatistic> getCompetitorMatchStatistics() {
        return competitorMatchStatistics;
    }

    public void setCompetitorMatchStatistics(
            List<CompetitorMatchStatistic> competitorMatchStatistics) {
        this.competitorMatchStatistics = competitorMatchStatistics;
    }
}
