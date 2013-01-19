package de.bedit.gaming.wormstats.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "leage")
@NamedQueries({
		@NamedQuery(name = "getAllLeages", query = "SELECT l FROM Leage l"),
		@NamedQuery(name = "getLeageById", query = "SELECT l FROM Leage l WHERE l.id = :id") })
public class Leage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8117680793573755306L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	private List<MatchGame> matches = new ArrayList<MatchGame>();
	@OneToMany(fetch = FetchType.EAGER)
	private List<Competitor> competitors = new ArrayList<Competitor>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MatchGame> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchGame> matches) {
		this.matches = matches;
	}

	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}
}
