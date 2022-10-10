package com.example.aplicacion.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cita")
public class Cita implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcita")
    private Integer idcita;
    
    @JoinColumn(name = "paciente")
   	@ManyToOne
    private User paciente;
    
    @JoinColumn(name = "doctor")
   	@ManyToOne
    private User doctor;
    
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    
    @Basic(optional = false)
    @Column(name = "lugar")
    private String lugar;
    
    
    public Cita(){
 
    }


	public Integer getIdcita() {
		return idcita;
	}




	public void setIdcita(Integer idcita) {
		this.idcita = idcita;
	}




	public User getPaciente() {
		return paciente;
	}




	public void setPaciente(User paciente) {
		this.paciente = paciente;
	}




	public User getDoctor() {
		return doctor;
	}




	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}




	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public String getLugar() {
		return lugar;
	}




	public void setLugar(String lugar) {
		this.lugar = lugar;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}  

    
