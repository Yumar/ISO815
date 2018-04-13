/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.iso815.cheques.facade;

import edu.unapec.iso815.cheques.modelos.ConceptosPago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yumarx
 */
@Stateless
public class ConceptosPagoFacade extends AbstractFacade<ConceptosPago> {

    @PersistenceContext(unitName = "edu.unapec.iso815_cheques_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConceptosPagoFacade() {
        super(ConceptosPago.class);
    }
    
}
