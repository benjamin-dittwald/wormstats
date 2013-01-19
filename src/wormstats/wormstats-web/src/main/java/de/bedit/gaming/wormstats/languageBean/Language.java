/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.languageBean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * 
 * @author benjamin
 */
@ManagedBean(name = "language")
@SessionScoped
public class Language {

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot()
			.getLocale();

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		FacesContext.getCurrentInstance().getViewRoot()
				.setLocale(new Locale(language));
		locale = new Locale(language);
	}

}
