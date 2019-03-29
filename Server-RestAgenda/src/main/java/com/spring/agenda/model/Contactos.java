package com.spring.agenda.model;
import java.util.Date;

public class Contactos {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private Date fechanacimiento;
	private String direccion;
	private String codPostal;
	private String localidad;
	private String telefono;
	private String provincia;
	
	public Contactos() {
		super();
	}

	public Contactos(String nombre, String apellido1, String apellido2, String dni, Date fechanacimiento,
			String direccion, String codPostal, String localidad, String telefono, String provincia) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.telefono = telefono;
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Contactos [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", fechanacimiento=" + fechanacimiento + ", direccion=" + direccion + ", codPostal=" + codPostal
				+ ", localidad=" + localidad + ", telefono=" + telefono + ", provincia=" + provincia + "]";
	}	
}