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

@ManagedBean(name = "competitors")
@ViewScoped
public class CompetitorsController implements Serializable {

	@EJB
	private CompetitorDao competitorDao;
	private Competitor competitorToAdd = new Competitor();
	private List<Competitor> competitors = new ArrayList<Competitor>();

	/**
	 * default empty constructor
	 */
	public CompetitorsController() {
	}

	@PostConstruct
	public void init() {
		competitors.addAll(competitorDao.getAllActiveCompetitors());
		Collections.sort(competitors);
	}

	public void removeCompetitorFromList(Competitor competitor) {
		competitors.remove(competitor);
		competitor.setActive(false);
		competitorDao.updateCompetitor(competitor);
	}

	public String reinit() {
		competitorToAdd = new Competitor();
		return null;
	}

	public void save() {
		//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("leages");
		for (Competitor competitor : competitors) {
			if (competitorDao.competitorExist(competitor)) {
				competitorDao.updateCompetitor(competitor);
			} else {
				competitorDao.createCompetitor(competitor);
			}
		}
	}

	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}

	public Competitor getCompetitorToAdd() {
		return competitorToAdd;
	}

	public void setCompetitorToAdd(Competitor competitorToAdd) {
		this.competitorToAdd = competitorToAdd;
	}
}
