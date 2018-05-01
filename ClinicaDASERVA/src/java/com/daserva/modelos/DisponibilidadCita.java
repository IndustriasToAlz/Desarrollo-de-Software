package com.daserva.modelos;

import java.io.Serializable;

public class DisponibilidadCita implements Serializable {

    private String hora;
    private int codigoCliente;
    private int codigoDoctor;
    private int asignada;

    public DisponibilidadCita() {
    }

    public DisponibilidadCita(Long id, String hora, int codigoCliente, int codigoDoctor, int asignada) {
        this.hora = hora;
        this.codigoCliente = codigoCliente;
        this.codigoDoctor = codigoDoctor;
        this.asignada = asignada;
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

    public int getAsignada() {
        return asignada;
    }

    public void setAsignada(int asignada) {
        this.asignada = asignada;
    }
}
