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

@Entity
@Table(name="salida")
public class salida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_salida;
	@Column
	private Date fecha;
	@Column(length = 255)
	private String destino;
	@Column(length = 255)
	private String datos_patron;
	
	@ManyToOne
	@JoinColumn(name="id_barco")
	private barco barco;
	

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

