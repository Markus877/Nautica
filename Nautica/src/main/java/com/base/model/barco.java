package com.base.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="barco")
public class barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_barco;

    @Column(name="matricula", length = 30)
    @NotBlank(message = "La matrícula no puede estar vacía")
    @Size(max = 30, message = "La matrícula no puede tener más de 30 caracteres")
    private String matricula;

    @Column(name="nombre", length = 30)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    private String nombre;

    @Column(name="amarre", length = 30)
    @NotBlank(message = "El amarre no puede estar vacío")
    @Size(max = 30, message = "El amarre no puede tener más de 30 caracteres")
    private String amarre;

    @Column(name="cuota")
    @Positive(message = "La cuota debe ser un valor positivo")
    private double cuota;

    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL)
    private List<salida> salidas;

    @ManyToOne
    @JoinColumn(name="id_socios")
    @NotNull(message = "El socio no puede ser nulo")
    private socios socios;

    // Getters y Setters
    public List<salida> getSalidas() {
        return salidas;
    }
    public void setSalidas(List<salida> salidas) {
        this.salidas = salidas;
    }
    public String getAmarre() {
        return amarre;
    }
    public void setAmarre(String amarre) {
        this.amarre = amarre;
    }
    public Long getId_barco() {
        return id_barco;
    }
    public void setId_barco(Long id_barco) {
        this.id_barco = id_barco;
    }
    public socios getSocios() {
        return socios;
    }
    public void setSocios(socios socios) {
        this.socios = socios;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCuota() {
        return cuota;
    }
    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
}
