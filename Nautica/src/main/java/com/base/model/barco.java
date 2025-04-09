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

@Entity
@Table(name="barco")
public class barco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_barco;
	@Column(name="matricula",length = 255)
	private String matricula;
	@Column(name="nombre",length = 255)
	private String nombre;
	@Column(name="amarre",length = 255)
	private String amarre;
	@Column(name="cuota")
	private double cuota;
	
	@OneToMany(mappedBy = "barco" , cascade= CascadeType.ALL)
    private List<salida> salidas;
    
	@ManyToOne
	@JoinColumn(name="id_socios")
	private socios socios;
    
   
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

