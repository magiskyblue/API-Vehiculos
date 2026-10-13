package com.api.alquilaya.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alquiler")
public class AlquilerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private VehiculoModel vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteModel cliente;

    @Column(name = "fecha_alquiler", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "precio_total")
    private Double precioTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoAlquiler estado = EstadoAlquiler.Pendiente;

    public AlquilerModel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public VehiculoModel getVehiculo() { return vehiculo; }
    public void setVehiculo(VehiculoModel vehiculo) { this.vehiculo = vehiculo; }

    public ClienteModel getCliente() { return cliente; }
    public void setCliente(ClienteModel cliente) { this.cliente = cliente; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public Double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(Double precioTotal) { this.precioTotal = precioTotal; }

    public EstadoAlquiler getEstado() { return estado; }
    public void setEstado(EstadoAlquiler estado) { this.estado = estado; }
}