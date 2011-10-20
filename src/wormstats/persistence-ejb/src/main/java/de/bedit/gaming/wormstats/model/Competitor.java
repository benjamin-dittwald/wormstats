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

@Entity
@Table(name = "competitor")
@NamedQueries({
    @NamedQuery(name = "getAllCompetitors", query = "SELECT c FROM Competitor c"),
    @NamedQuery(name = "getCompetitorById", query = "SELECT c FROM Competitor c WHERE c.id = :id")})
public class Competitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false, length = 70)
    private String name;
    @Column(name = "active", nullable = false)
    private boolean active;
    @Column(name = "color", nullable = false)
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
