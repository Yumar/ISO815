/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.iso815.cheques.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yumarx
 */
@Entity
@Table(name = "RegistroSolicitudCheques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroSolicitudCheques.findAll", query = "SELECT r FROM RegistroSolicitudCheques r")
    , @NamedQuery(name = "RegistroSolicitudCheques.findByN\u00fameroSolicitud", query = "SELECT r FROM RegistroSolicitudCheques r WHERE r.n\u00fameroSolicitud = :n\u00fameroSolicitud")
    , @NamedQuery(name = "RegistroSolicitudCheques.findByMonto", query = "SELECT r FROM RegistroSolicitudCheques r WHERE r.monto = :monto")
    , @NamedQuery(name = "RegistroSolicitudCheques.findByFechaRegistro", query = "SELECT r FROM RegistroSolicitudCheques r WHERE r.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "RegistroSolicitudCheques.findByEstado", query = "SELECT r FROM RegistroSolicitudCheques r WHERE r.estado = :estado")
    , @NamedQuery(name = "RegistroSolicitudCheques.findByCuentaCorriente", query = "SELECT r FROM RegistroSolicitudCheques r WHERE r.cuentaCorriente = :cuentaCorriente")})
public class RegistroSolicitudCheques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "N\u00fameroSolicitud")
    private Long númeroSolicitud;
    @Size(max = 30)
    @Column(name = "Monto")
    private String monto;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Size(max = 10)
    @Column(name = "Estado")
    private String estado;
    @Size(max = 50)
    @Column(name = "CuentaCorriente")
    private String cuentaCorriente;
    @JoinColumn(name = "Identificador", referencedColumnName = "Identificador")
    @ManyToOne
    private Proveedores identificador;

    public RegistroSolicitudCheques() {
    }

    public RegistroSolicitudCheques(Long númeroSolicitud) {
        this.númeroSolicitud = númeroSolicitud;
    }

    public Long getNúmeroSolicitud() {
        return númeroSolicitud;
    }

    public void setNúmeroSolicitud(Long númeroSolicitud) {
        this.númeroSolicitud = númeroSolicitud;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public Proveedores getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Proveedores identificador) {
        this.identificador = identificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (númeroSolicitud != null ? númeroSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroSolicitudCheques)) {
            return false;
        }
        RegistroSolicitudCheques other = (RegistroSolicitudCheques) object;
        if ((this.númeroSolicitud == null && other.númeroSolicitud != null) || (this.númeroSolicitud != null && !this.númeroSolicitud.equals(other.númeroSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.unapec.iso815.cheques.modelos.RegistroSolicitudCheques[ n\u00fameroSolicitud=" + númeroSolicitud + " ]";
    }
    
}
