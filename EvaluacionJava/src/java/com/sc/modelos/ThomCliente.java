
package com.sc.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author user
 */
@Entity
@Table(name = "thom_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThomCliente.findAll", query = "SELECT t FROM ThomCliente t")
    , @NamedQuery(name = "ThomCliente.findByNmcliente", query = "SELECT t FROM ThomCliente t WHERE t.nmcliente = :nmcliente")
    , @NamedQuery(name = "ThomCliente.findByCdcliente", query = "SELECT t FROM ThomCliente t WHERE t.cdcliente = :cdcliente")
    , @NamedQuery(name = "ThomCliente.findByDsnombre", query = "SELECT t FROM ThomCliente t WHERE t.dsnombre = :dsnombre")
    , @NamedQuery(name = "ThomCliente.findByDsdireccion", query = "SELECT t FROM ThomCliente t WHERE t.dsdireccion = :dsdireccion")
    , @NamedQuery(name = "ThomCliente.findByDsmail", query = "SELECT t FROM ThomCliente t WHERE t.dsmail = :dsmail")
    , @NamedQuery(name = "ThomCliente.findByFeregistro", query = "SELECT t FROM ThomCliente t WHERE t.feregistro = :feregistro")
    , @NamedQuery(name = "ThomCliente.findByCdusuario", query = "SELECT t FROM ThomCliente t WHERE t.cdusuario = :cdusuario")
    , @NamedQuery(name = "ThomCliente.findBySnactivo", query = "SELECT t FROM ThomCliente t WHERE t.snactivo = :snactivo")
    , @NamedQuery(name = "ThomCliente.findByCdtelefono", query = "SELECT t FROM ThomCliente t WHERE t.cdtelefono = :cdtelefono")
    , @NamedQuery(name = "ThomCliente.findByDscontacto", query = "SELECT t FROM ThomCliente t WHERE t.dscontacto = :dscontacto")
    , @NamedQuery(name = "ThomCliente.findByDslogo", query = "SELECT t FROM ThomCliente t WHERE t.dslogo = :dslogo")})
public class ThomCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nmcliente")
    private Integer nmcliente;
    @Size(max = 15)
    @Column(name = "cdcliente")
    private String cdcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "dsnombre")
    private String dsnombre;
    @Size(max = 120)
    @Column(name = "dsdireccion")
    private String dsdireccion;
    @Size(max = 120)
    @Column(name = "dsmail")
    private String dsmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feregistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feregistro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "febaja")
    private byte[] febaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "cdusuario")
    private String cdusuario;
    @Size(max = 1)
    @Column(name = "snactivo")
    private String snactivo;
    @Size(max = 60)
    @Column(name = "cdtelefono")
    private String cdtelefono;
    @Size(max = 120)
    @Column(name = "dscontacto")
    private String dscontacto;
    @Size(max = 50)
    @Column(name = "dslogo")
    private String dslogo;

    public ThomCliente() {
    }

    public ThomCliente(Integer nmcliente) {
        this.nmcliente = nmcliente;
    }

    public ThomCliente(Integer nmcliente, String dsnombre, Date feregistro, byte[] febaja, String cdusuario) {
        this.nmcliente = nmcliente;
        this.dsnombre = dsnombre;
        this.feregistro = feregistro;
        this.febaja = febaja;
        this.cdusuario = cdusuario;
    }

    public Integer getNmcliente() {
        return nmcliente;
    }

    public void setNmcliente(Integer nmcliente) {
        this.nmcliente = nmcliente;
    }

    public String getCdcliente() {
        return cdcliente;
    }

    public void setCdcliente(String cdcliente) {
        this.cdcliente = cdcliente;
    }

    public String getDsnombre() {
        return dsnombre;
    }

    public void setDsnombre(String dsnombre) {
        this.dsnombre = dsnombre;
    }

    public String getDsdireccion() {
        return dsdireccion;
    }

    public void setDsdireccion(String dsdireccion) {
        this.dsdireccion = dsdireccion;
    }

    public String getDsmail() {
        return dsmail;
    }

    public void setDsmail(String dsmail) {
        this.dsmail = dsmail;
    }

    public Date getFeregistro() {
        return feregistro;
    }

    public void setFeregistro(Date feregistro) {
        this.feregistro = feregistro;
    }

    public byte[] getFebaja() {
        return febaja;
    }

    public void setFebaja(byte[] febaja) {
        this.febaja = febaja;
    }

    public String getCdusuario() {
        return cdusuario;
    }

    public void setCdusuario(String cdusuario) {
        this.cdusuario = cdusuario;
    }

    public String getSnactivo() {
        return snactivo;
    }

    public void setSnactivo(String snactivo) {
        this.snactivo = snactivo;
    }

    public String getCdtelefono() {
        return cdtelefono;
    }

    public void setCdtelefono(String cdtelefono) {
        this.cdtelefono = cdtelefono;
    }

    public String getDscontacto() {
        return dscontacto;
    }

    public void setDscontacto(String dscontacto) {
        this.dscontacto = dscontacto;
    }

    public String getDslogo() {
        return dslogo;
    }

    public void setDslogo(String dslogo) {
        this.dslogo = dslogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nmcliente != null ? nmcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThomCliente)) {
            return false;
        }
        ThomCliente other = (ThomCliente) object;
        if ((this.nmcliente == null && other.nmcliente != null) || (this.nmcliente != null && !this.nmcliente.equals(other.nmcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sc.modelos.ThomCliente[ nmcliente=" + nmcliente + " ]";
    }
    
}
