/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.converter;

import java.text.DecimalFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author benjamin
 */
@FacesConverter("doubleConverter")
public class DoubleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component,
            String submittedValue) {
        return Double.parseDouble(submittedValue);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component,
            Object value) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format((Double) value);
    }
}
