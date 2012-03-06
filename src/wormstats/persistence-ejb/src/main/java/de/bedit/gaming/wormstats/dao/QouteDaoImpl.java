/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bedit.gaming.wormstats.dao;

import de.bedit.gaming.wormstats.model.Qoute;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author benjamin
 */
@Stateless
public class QouteDaoImpl implements QouteDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Qoute getRandomQoute() {
        List<Qoute> qoutes = em.createNamedQuery("getAllQoutes")
                .getResultList();
        int max = qoutes.size();

        Random rnd = new Random();
        if (max > 0) {

            return qoutes.get(rnd.nextInt(max));
        } else {
            Qoute qoute = new Qoute();
            qoute.setGameName("Null");
            qoute.setQoute("Null");
            return qoute;

        }
    }
}
