package com.api.alquilaya.models;

import jakarta.persistence.*;

@Entity
@Table(name = "oficina_alquiler")
public class OficinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oficina")
    private Long id;

    @Column(name = "nombre_oficina", nullable = false)
    private String nombreOficina;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "region", nullable = false)
    private String region;

    public OficinaModel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreOficina() { return nombreOficina; }
    public void setNombreOficina(String nombreOficina) { this.nombreOficina = nombreOficina; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
}