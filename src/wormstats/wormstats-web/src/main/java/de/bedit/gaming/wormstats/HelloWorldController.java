package de.bedit.gaming.wormstats;

import de.bedit.gaming.wormstats.dao.CompetitorDao;
import de.bedit.gaming.wormstats.model.Competitor;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@ManagedBean(name = "helloWorld")
@RequestScoped
public class HelloWorldController {

    // properties
    private String name;
    @EJB(name = "competitorDao")
    private CompetitorDao competitorDao;

    /**
     * default empty constructor
     */
    public HelloWorldController() {
    }

    @PostConstruct
    public void init() {
        Competitor comp = new Competitor();
        comp.setName("hans");
        competitorDao.createCompetitor(comp);
        for (Competitor competitor: competitorDao.getAllCompetitors()) {
            System.out.println(competitor.getName());
        }
    }

    /**
     * Method that is backed to a submit button of a form.
     */
    public String send() {
        // do real logic, return a string which will be used for the navigation
        // system of JSF
        return "page2.xhtml";
    }

    // -------------------getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
