package com.api.alquilaya.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class VehiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_oficina", nullable = false)
    private OficinaModel oficina;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "matricula", unique = true, nullable = false)
    private String placa;

    @Column(name = "tarifa_diaria", nullable = false)
    private Double tarifaDiaria;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoVehiculo estado = EstadoVehiculo.Disponible;

    public VehiculoModel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public OficinaModel getOficina() { return oficina; }
    public void setOficina(OficinaModel oficina) { this.oficina = oficina; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public Double getTarifaDiaria() { return tarifaDiaria; }
    public void setTarifaDiaria(Double tarifaDiaria) { this.tarifaDiaria = tarifaDiaria; }

    public EstadoVehiculo getEstado() { return estado; }
    public void setEstado(EstadoVehiculo estado) { this.estado = estado; }
}