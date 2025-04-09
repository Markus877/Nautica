package com.base.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="salida")
public class salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salida;

    @Column
    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha debe ser en el pasado o presente")
    private Date fecha;

    @Column(length = 30)
    @NotBlank(message = "El destino no puede estar vacío")
    @Size(max = 30, message = "El destino no puede tener más de 30 caracteres")
    private String destino;

    @Column(length = 50)
    @NotBlank(message = "Los datos del patrón no pueden estar vacíos")
    @Size(max = 50, message = "Los datos del patrón no pueden tener más de 50 caracteres")
    private String datos_patron;

    @ManyToOne
    @JoinColumn(name="id_barco")
    @NotNull(message = "El barco no puede ser nulo")
    private barco barco;

    // Getters y Setters
    public Long getId_salida() {
        return id_salida;
    }
    public void setId_salida(Long id_salida) {
        this.id_salida = id_salida;
    }
    public barco getBarco() {
        return barco;
    }
    public void setBarco(barco barco) {
        this.barco = barco;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getDatos_patron() {
        return datos_patron;
    }
    public void setDatos_patron(String datos_patron) {
        this.datos_patron = datos_patron;
    }
}
