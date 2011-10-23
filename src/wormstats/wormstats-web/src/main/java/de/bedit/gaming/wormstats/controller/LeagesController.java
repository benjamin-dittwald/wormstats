/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.dao.LeageDao;
import de.bedit.gaming.wormstats.model.Leage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "leages")
@SessionScoped
public class LeagesController {

    @EJB
    private LeageDao leageDao;
    private List<Leage> leages = new ArrayList<Leage>();
    private Leage currentLeage;

    @PostConstruct
    public void init() {
        leages.addAll(leageDao.getAllLeages());
    }

    public String matchCreate(Leage leage) {
        currentLeage = leage;
        return "matchCreate";
    }
    
    public String simpleTable(Leage leage) {
        currentLeage = leage;
        return "simpleTable";
    }
    
    public String matchesSite(Leage leage) {
        currentLeage = leage;
        return "matchesSite";
    }

    public Leage getCurrentLeage() {
        return currentLeage;
    }

    public void setCurrentLeage(Leage currentLeage) {
        this.currentLeage = currentLeage;
    }

    public List<Leage> getLeages() {
        return leages;
    }

    public void setLeages(List<Leage> leages) {
        this.leages = leages;
    }
}
