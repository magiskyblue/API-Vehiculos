package com.api.alquilaya.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mantenimiento")
public class MantenimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private VehiculoModel vehiculo;

    @Column(name = "fecha_mantenimiento", nullable = false)
    private LocalDate fechaMantenimiento;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "costo", nullable = false)
    private Double costo;

    @Column(name = "kilometraje")
    private Integer kilometraje;

    public MantenimientoModel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public VehiculoModel getVehiculo() { return vehiculo; }
    public void setVehiculo(VehiculoModel vehiculo) { this.vehiculo = vehiculo; }

    public LocalDate getFechaMantenimiento() { return fechaMantenimiento; }
    public void setFechaMantenimiento(LocalDate fechaMantenimiento) { this.fechaMantenimiento = fechaMantenimiento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }

    public Integer getKilometraje() { return kilometraje; }
    public void setKilometraje(Integer kilometraje) { this.kilometraje = kilometraje; }
}