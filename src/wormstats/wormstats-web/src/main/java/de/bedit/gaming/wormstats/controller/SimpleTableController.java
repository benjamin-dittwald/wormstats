/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.math.TableCalculator;
import de.bedit.gaming.wormstats.model.SimpleTableEntry;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "simpleTable")
@RequestScoped
public class SimpleTableController {

    @EJB(name = "tableCalculator")
    TableCalculator tableCalculator;
    List<SimpleTableEntry> entries;

    @PostConstruct
    public void init() {
        LeagesController leageController = (LeagesController) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("leages");
        entries = tableCalculator.createSimpleTableList(leageController.getCurrentLeage());
        Collections.sort(entries);
    }

    public List<SimpleTableEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<SimpleTableEntry> entries) {
        this.entries = entries;
    }
}
