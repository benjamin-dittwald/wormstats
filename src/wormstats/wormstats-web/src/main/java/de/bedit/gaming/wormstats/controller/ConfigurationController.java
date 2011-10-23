/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.dao.ConfigurationDao;
import de.bedit.gaming.wormstats.model.Configuration;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "configuration")
@ViewScoped
public class ConfigurationController {

    @EJB
    private ConfigurationDao configurationDao;
    private Configuration configuration;

    @PostConstruct
    public void init() {
        configuration = configurationDao.getConfiguration();
    }

    public void save() {
        configurationDao.updateConfiguration(configuration);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
