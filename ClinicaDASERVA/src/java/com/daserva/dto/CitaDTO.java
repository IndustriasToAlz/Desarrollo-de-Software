package com.daserva.dto;

import java.io.Serializable;
import java.util.Date;

public class CitaDTO implements Serializable {

    private Long id;
    private String fecha;
    private String hora;
    private int codigoCliente;
    private int codigoDoctor;
    private Date fechaCreacion;

    public CitaDTO() {
    }

    public CitaDTO(Long id) {
        this.id = id;
    }

    public CitaDTO(Long id, String fecha, String hora, int codigoCliente, int codigoDoctor, Date fechaCreacion) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.codigoCliente = codigoCliente;
        this.codigoDoctor = codigoDoctor;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoDoctor() {
        return codigoDoctor;
    }

    public void setCodigoDoctor(int codigoDoctor) {
        this.codigoDoctor = codigoDoctor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaDTO)) {
            return false;
        }
        CitaDTO other = (CitaDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daserva.modelos.Cita[ id=" + id + " ]";
    }
    
}
