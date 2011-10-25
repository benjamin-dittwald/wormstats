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
import javax.faces.bean.SessionScoped;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "configuration")
@SessionScoped
public class ConfigurationController {

	@EJB
	private ConfigurationDao configurationDao;
	private Configuration configuration;
	//    private List<String> offsets;

	@PostConstruct
	public void init() {
		configuration = configurationDao.getConfiguration();
		//        offsets = configuration.getHistoricalOffset();
	}

	public void save() {
		//        configuration.setHistoricalOffset(offsets);
		configurationDao.updateConfiguration(configuration);
	}

	//    public List<String> getOffsets() {
	//        return offsets;
	//    }
	//
	//    public void setOffsets(List<String> offsets) {
	//        this.offsets = offsets;
	//    }

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
}
