/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.dao.MatchGameDao;
import de.bedit.gaming.wormstats.model.MatchGame;
import de.bedit.gaming.wormstats.model.MatchGameComparatorDateDesc;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "matches")
@ViewScoped
public class MatchesController {

    @EJB
    MatchGameDao matchGameDao;
    List<MatchGame> matches;

    @PostConstruct
    public void init() {
        LeagesController leageController = (LeagesController) FacesContext
                .getCurrentInstance().getExternalContext().getSessionMap().get(
                        "leages");
        matches = leageController.getCurrentLeage().getMatches();
        Collections.sort(matches, new MatchGameComparatorDateDesc());
    }

    public void removeMatch(MatchGame match) {
        matches.remove(match);
        matchGameDao.deleteMatchGame(match);
    }

    public List<MatchGame> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchGame> matches) {
        this.matches = matches;
    }

}
