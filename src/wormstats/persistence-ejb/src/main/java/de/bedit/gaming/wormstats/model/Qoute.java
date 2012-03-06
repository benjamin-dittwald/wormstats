/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author benjamin
 */
@Entity
@Table(name = "qoute")
@NamedQueries( { @NamedQuery(name = "getAllQoutes", query = "SELECT q FROM Qoute q") })
public class Qoute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "gameName")
    private String gameName;
    @Column(name = "qoute")
    private String qoute;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQoute() {
        return qoute;
    }

    public void setQoute(String qoute) {
        this.qoute = qoute;
    }
}
