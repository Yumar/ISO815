/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.iso815.cheques.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yumarx
 */
@Entity
@Table(name = "ConceptosPago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptosPago.findAll", query = "SELECT c FROM ConceptosPago c")
    , @NamedQuery(name = "ConceptosPago.findByIdentificador", query = "SELECT c FROM ConceptosPago c WHERE c.identificador = :identificador")
    , @NamedQuery(name = "ConceptosPago.findByDescripci\u00f3n", query = "SELECT c FROM ConceptosPago c WHERE c.descripci\u00f3n = :descripci\u00f3n")
    , @NamedQuery(name = "ConceptosPago.findByEstado", query = "SELECT c FROM ConceptosPago c WHERE c.estado = :estado")})
public class ConceptosPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Identificador")
    private Integer identificador;
    @Size(max = 50)
    @Column(name = "Descripci\u00f3n")
    private String descripción;
    @Size(max = 10)
    @Column(name = "Estado")
    private String estado;

    public ConceptosPago() {
    }

    public ConceptosPago(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptosPago)) {
            return false;
        }
        ConceptosPago other = (ConceptosPago) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.unapec.iso815.cheques.modelos.ConceptosPago[ identificador=" + identificador + " ]";
    }
    
}
