/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import de.bedit.gaming.wormstats.dao.QouteDao;
import de.bedit.gaming.wormstats.model.Qoute;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "qoute")
@RequestScoped
public class QouteController {

	@EJB
	QouteDao qouteDao;
	private Qoute qoute;

	@PostConstruct
	public void init() {
		qoute = qouteDao.getRandomQoute();
	}

	public Qoute getQoute() {
		return qoute;
	}

	public void setQoute(Qoute qoute) {
		this.qoute = qoute;
	}
}
