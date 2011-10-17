package de.bedit.gaming.wormstats.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "match")
public class Match implements Serializable {

	@Id
	@GeneratedValue
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "matchDate")
	private Date matchDate;

	@ElementCollection
	@CollectionTable(name = "competitorMatchStatistic", joinColumns = @JoinColumn(referencedColumnName = "matchId"))
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
