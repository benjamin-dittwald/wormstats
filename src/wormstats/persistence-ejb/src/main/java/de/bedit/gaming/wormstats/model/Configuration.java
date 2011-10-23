/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.PrivateOwned;

/**
 *
 * @author benjamin
 */
@Entity
@Table(name = "configuration")
@NamedQueries({
    @NamedQuery(name = "getConfiguration", query = "SELECT c FROM Configuration c")})
public class Configuration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "skillFormula")
    private String skillFormula;
    @ElementCollection
    private List<String> historicalOffset = new ArrayList<String>();

    public List<String> getHistoricalOffset() {
        return historicalOffset;
    }

    public void setHistoricalOffset(List<String> historicalOffset) {
        this.historicalOffset = historicalOffset;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillFormula() {
        return skillFormula;
    }

    public void setSkillFormula(String skillFormula) {
        this.skillFormula = skillFormula;
    }
}
