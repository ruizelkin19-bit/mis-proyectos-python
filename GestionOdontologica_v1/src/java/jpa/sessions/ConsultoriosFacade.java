/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Consultorios;

/**
 *
 * @author Hp
 */
@Stateless
public class ConsultoriosFacade extends AbstractFacade<Consultorios> {

    @PersistenceContext(unitName = "GestionOdontologica_v1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultoriosFacade() {
        super(Consultorios.class);
    }
    
}
