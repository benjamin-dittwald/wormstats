/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.languageBean;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "language")
@SessionScoped
public class Language {

    private static final long serialVersionUID = 1L;
    private String localeCode;
    private static Map<String, Object> countries;

    @PostConstruct
    public void init() {
        countries = new LinkedHashMap<String, Object>();
        countries.put("English", Locale.ENGLISH);
        countries.put("German", Locale.GERMAN);

        localeCode = FacesContext.getCurrentInstance().getViewRoot()
                .getLocale().toString();
    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        //loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {

                FacesContext.getCurrentInstance().getViewRoot().setLocale(
                        (Locale) entry.getValue());

            }
        }
    }
}
