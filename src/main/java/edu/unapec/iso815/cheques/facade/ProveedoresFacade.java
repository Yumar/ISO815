/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.iso815.cheques.facade;

import edu.unapec.iso815.cheques.modelos.Proveedores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.unapec.iso815.cheques.modelos.Proveedores_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edu.unapec.iso815.cheques.modelos.RegistroSolicitudCheques;
import java.util.Collection;

/**
 *
 * @author yumarx
 */
@Stateless
public class ProveedoresFacade extends AbstractFacade<Proveedores> {

    @PersistenceContext(unitName = "edu.unapec.iso815_cheques_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresFacade() {
        super(Proveedores.class);
    }

    public boolean isRegistroSolicitudChequesCollectionEmpty(Proveedores entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Proveedores> proveedores = cq.from(Proveedores.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(proveedores, entity), cb.isNotEmpty(proveedores.get(Proveedores_.registroSolicitudChequesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistroSolicitudCheques> findRegistroSolicitudChequesCollection(Proveedores entity) {
        Proveedores mergedEntity = this.getMergedEntity(entity);
        Collection<RegistroSolicitudCheques> registroSolicitudChequesCollection = mergedEntity.getRegistroSolicitudChequesCollection();
        registroSolicitudChequesCollection.size();
        return registroSolicitudChequesCollection;
    }
    
}
