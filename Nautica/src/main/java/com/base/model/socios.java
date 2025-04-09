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

@Entity
@Table(name="socios")
public class socios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_socios;
	@Column(length = 255)
	private String nombre;
	@Column(length = 255)
	private String apellido;
	@Column(length = 255)
	private String email;
	
	@OneToMany(mappedBy = "socios" , cascade= CascadeType.ALL)
    private List<barco> barcos;

	
	
	public List<barco> getBarcos() {
		return barcos;
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

