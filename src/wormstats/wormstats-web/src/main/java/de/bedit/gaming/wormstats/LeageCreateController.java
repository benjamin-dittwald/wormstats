/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.LeageDao;
import de.bedit.gaming.wormstats.model.Competitor;
import de.bedit.gaming.wormstats.model.Leage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "leageCreate")
@RequestScoped
public class LeageCreateController {

    @EJB
    private LeageDao leageDao;

    public Leage getLeage() {
        return leage;
    }

    public void setLeage(Leage leage) {
        this.leage = leage;
    }

    public LeageDao getLeageDao() {
        return leageDao;
    }

    public void setLeageDao(LeageDao leageDao) {
        this.leageDao = leageDao;
    }
    private List<Competitor> competitors = new ArrayList<Competitor>();
    private Leage leage = new Leage();
}
