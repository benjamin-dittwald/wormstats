/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.LeageDao;
import de.bedit.gaming.wormstats.model.Leage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "leages")
@RequestScoped
public class LeagesController {

    @EJB
    private LeageDao leageDao;
    private List<Leage> leages = new ArrayList<Leage>();

    @PostConstruct
    public void init() {
        leages.addAll(leageDao.getAllLeages());
    }

    public List<Leage> getLeages() {
        return leages;
    }

    public void setLeages(List<Leage> leages) {
        this.leages = leages;
    }
}
