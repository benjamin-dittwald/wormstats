package de.bedit.gaming.wormstats.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchGame.
 */
@Entity
@Table(name = "matchGame")
@NamedQueries({
		@NamedQuery(name = "getAllMatchGames", query = "SELECT m FROM MatchGame m"),
		@NamedQuery(name = "getMatchGameById", query = "SELECT m FROM MatchGame m WHERE m.id = :id"),
		@NamedQuery(name = "getMatchGameByTimestamp", query = "SELECT m FROM MatchGame m WHERE m.matchDate = :date"),
		@NamedQuery(name = "getAllMatchGamesByWinnerId", query = "SELECT m FROM MatchGame m WHERE m.winner.id = :id") })
public class MatchGame implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5104699627834511483L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** The match date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "matchDate", nullable = false)
	private Date matchDate;

	/** The competitor match statistics. */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<CompetitorMatchStatistic> competitorMatchStatistics = new ArrayList<CompetitorMatchStatistic>();

	/** The winner. */
	@OneToOne
	private Competitor winner;

	/**
	 * Gets the match date.
	 * 
	 * @return the match date
	 */
	public Date getMatchDate() {
		return matchDate;
	}

	/**
	 * Sets the match date.
	 * 
	 * @param matchDate
	 *            the new match date
	 */
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	/**
	 * Gets the winner.
	 * 
	 * @return the winner
	 */
	public Competitor getWinner() {
		return winner;
	}

	/**
	 * Sets the winner.
	 * 
	 * @param winner
	 *            the new winner
	 */
	public void setWinner(Competitor winner) {
		this.winner = winner;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return matchDate;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.matchDate = date;
	}

	/**
	 * Gets the competitor match statistics.
	 * 
	 * @return the competitor match statistics
	 */
	public List<CompetitorMatchStatistic> getCompetitorMatchStatistics() {
		return competitorMatchStatistics;
	}

	/**
	 * Sets the competitor match statistics.
	 * 
	 * @param competitorMatchStatistics
	 *            the new competitor match statistics
	 */
	public void setCompetitorMatchStatistics(
			List<CompetitorMatchStatistic> competitorMatchStatistics) {
		this.competitorMatchStatistics = competitorMatchStatistics;
	}
}
