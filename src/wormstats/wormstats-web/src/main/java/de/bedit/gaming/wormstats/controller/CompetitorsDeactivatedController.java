package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.model.Competitor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "competitorsDeactivated")
@ViewScoped
public class CompetitorsDeactivatedController implements Serializable {

	@EJB
	private CompetitorDao competitorDao;
	private List<Competitor> competitors = new ArrayList<Competitor>();

	/**
	 * default empty constructor
	 */
	public CompetitorsDeactivatedController() {
	}

	@PostConstruct
	public void init() {
		competitors.addAll(competitorDao.getAllInactiveCompetitors());
		Collections.sort(competitors);
	}

	public String save() {
		for (Competitor competitor : competitors) {
			competitorDao.updateCompetitor(competitor);
		}

		return "competitorsDeactivated";
	}

	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}
}
