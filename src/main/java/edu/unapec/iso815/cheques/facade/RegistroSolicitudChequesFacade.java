/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.iso815.cheques.facade;

import edu.unapec.iso815.cheques.modelos.RegistroSolicitudCheques;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.unapec.iso815.cheques.modelos.RegistroSolicitudCheques_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edu.unapec.iso815.cheques.modelos.Proveedores;

/**
 *
 * @author yumarx
 */
@Stateless
public class RegistroSolicitudChequesFacade extends AbstractFacade<RegistroSolicitudCheques> {

    @PersistenceContext(unitName = "edu.unapec.iso815_cheques_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroSolicitudChequesFacade() {
        super(RegistroSolicitudCheques.class);
    }

    public boolean isIdentificadorEmpty(RegistroSolicitudCheques entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistroSolicitudCheques> registroSolicitudCheques = cq.from(RegistroSolicitudCheques.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registroSolicitudCheques, entity), cb.isNotNull(registroSolicitudCheques.get(RegistroSolicitudCheques_.identificador)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Proveedores findIdentificador(RegistroSolicitudCheques entity) {
        return this.getMergedEntity(entity).getIdentificador();
    }
    
}
