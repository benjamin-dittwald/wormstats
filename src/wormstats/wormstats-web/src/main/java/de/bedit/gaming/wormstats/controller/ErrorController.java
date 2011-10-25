/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

/**
 *
 * @author benjamin
 */
@ManagedBean(name = "error")
@RequestScoped
public class ErrorController {

	public String getStackTrace() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> request = context.getExternalContext()
				.getRequestMap();
		Throwable ex = (Throwable) request.get("javax.servlet.error.exception");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		fillStrackTrace(ex, pw);
		return sw.toString();
	}

	private void fillStrackTrace(Throwable t, PrintWriter w) {
		if (t == null) {
			return;
		}
		t.printStackTrace(w);
		if (t instanceof ServletException) {
			Throwable cause = ((ServletException) t).getRootCause();
			if (cause != null) {
				w.println("Root cause:");
				fillStrackTrace(cause, w);
			}
		} else if (t instanceof SQLException) {
			Throwable cause = ((SQLException) t).getNextException();
			if (cause != null) {
				w.println("Next exception:");
				fillStrackTrace(cause, w);
			}
		} else {
			Throwable cause = t.getCause();
			if (cause != null) {
				w.println("Cause:");
				fillStrackTrace(cause, w);
			}
		}
	}
}