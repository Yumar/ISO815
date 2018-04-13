/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.iso815.cheques.modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yumarx
 */
@Entity
@Table(name = "Proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByIdentificador", query = "SELECT p FROM Proveedores p WHERE p.identificador = :identificador")
    , @NamedQuery(name = "Proveedores.findByNombre", query = "SELECT p FROM Proveedores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedores.findByTipoPersona", query = "SELECT p FROM Proveedores p WHERE p.tipoPersona = :tipoPersona")
    , @NamedQuery(name = "Proveedores.findByN\u00fameroIdentificaci\u00f3n", query = "SELECT p FROM Proveedores p WHERE p.n\u00fameroIdentificaci\u00f3n = :n\u00fameroIdentificaci\u00f3n")
    , @NamedQuery(name = "Proveedores.findByCuentaProveedor", query = "SELECT p FROM Proveedores p WHERE p.cuentaProveedor = :cuentaProveedor")
    , @NamedQuery(name = "Proveedores.findByEstado", query = "SELECT p FROM Proveedores p WHERE p.estado = :estado")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Identificador")
    private Integer identificador;
    @Size(max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 10)
    @Column(name = "TipoPersona")
    private String tipoPersona;
    @Size(max = 50)
    @Column(name = "N\u00fameroIdentificaci\u00f3n")
    private String númeroIdentificación;
    @Size(max = 50)
    @Column(name = "CuentaProveedor")
    private String cuentaProveedor;
    @Size(max = 10)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(mappedBy = "identificador")
    private Collection<RegistroSolicitudCheques> registroSolicitudChequesCollection;

    public Proveedores() {
    }

    public Proveedores(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNúmeroIdentificación() {
        return númeroIdentificación;
    }

    public void setNúmeroIdentificación(String númeroIdentificación) {
        this.númeroIdentificación = númeroIdentificación;
    }

    public String getCuentaProveedor() {
        return cuentaProveedor;
    }

    public void setCuentaProveedor(String cuentaProveedor) {
        this.cuentaProveedor = cuentaProveedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<RegistroSolicitudCheques> getRegistroSolicitudChequesCollection() {
        return registroSolicitudChequesCollection;
    }

    public void setRegistroSolicitudChequesCollection(Collection<RegistroSolicitudCheques> registroSolicitudChequesCollection) {
        this.registroSolicitudChequesCollection = registroSolicitudChequesCollection;
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
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.unapec.iso815.cheques.modelos.Proveedores[ identificador=" + identificador + " ]";
    }
    
}
