package com.base.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="socios")
public class socios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_socios;

    @Column(length = 30)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    private String nombre;

    @Column(length = 30)
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 30, message = "El apellido no puede tener más de 30 caracteres")
    private String apellido;

    @Column(length = 50)
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Debe ser un email válido")
    @Size(max = 50, message = "El email no puede tener más de 50 caracteres")
    private String email;

    @OneToMany(mappedBy = "socios", cascade = CascadeType.ALL)
    private List<barco> barcos;

    // Getters y Setters
    public List<barco> getBarcos() {
        return barcos;
    }
    public socios(
			@NotBlank(message = "El nombre no puede estar vacío") @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres") String nombre,
			@NotBlank(message = "El apellido no puede estar vacío") @Size(max = 30, message = "El apellido no puede tener más de 30 caracteres") String apellido,
			@NotBlank(message = "El email no puede estar vacío") @Email(message = "Debe ser un email válido") @Size(max = 50, message = "El email no puede tener más de 50 caracteres") String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	public void setBarcos(List<barco> barcos) {
        this.barcos = barcos;
    }
    public Long getId_socios() {
        return id_socios;
    }
    public void setId_socios(Long id_socios) {
        this.id_socios = id_socios;
    }
    public socios() {
	}
	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}	
