package com.spring.agenda.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 *
 */
@Entity
@NamedQuery(name="Telefono.findAll", query="SELECT t FROM Telefono t")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtelefono;

	private String telefono;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	@JsonIgnore
	private Persona persona;

	public Telefono() {
	}

	public int getIdtelefono() {
		return this.idtelefono;
	}

	public void setIdtelefono(int idtelefono) {
		this.idtelefono = idtelefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Telefono [idtelefono=" + idtelefono + ", telefono=" + telefono + ", persona=" + persona + "]";
	}

	
}