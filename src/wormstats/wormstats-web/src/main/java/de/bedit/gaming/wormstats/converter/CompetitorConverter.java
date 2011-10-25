/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.converter;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.model.Competitor;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author benjamin
 */
@FacesConverter("competitorConverter")
public class CompetitorConverter implements Converter {

	@EJB
	CompetitorDao competitorDao;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String submittedValue) {
		return competitorDao.getCompetitorById(Long.valueOf(submittedValue));
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {
		Competitor comp = (Competitor) value;
		return String.valueOf(comp.getId());
	}
}
