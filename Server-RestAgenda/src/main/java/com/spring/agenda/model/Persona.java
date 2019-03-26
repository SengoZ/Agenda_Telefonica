package com.spring.agenda.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 *
 */

/**
 * Se le da una identidad a la clase y se define el nombre de la tabla en la que
 * se encuentran los objetos de este tipo.
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Se le da una identidad a la ID de la persona que será autoincremental.
	 * También se hace referencia a las columnas de la tabla que guardará cada
	 * atributo del objeto.
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpersona;

	private String apellido1;

	private String apellido2;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private String nombre;
	
	/**
	 * Se utiliza OneToOne para relacionar una persona (mapeado por el ID de la
	 * persona) con una dirección.
	 */
	
	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
	private List<Direccion> direccions;

	/**
	 * Se utiliza OneToMany para relacionar una persona (mapeado por el ID de la
	 * persona) con varios números de teléfono.
	 */
	
	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
	private List<Telefono> telefonos;
	
	/**
	 * Se realizan tanto el constructor vacío como el constructor con los atributos
	 * que definen al objeto.
	 */
	
	public Persona() {
	}
	
	/**
	 * Se realizan Getter/Setter de todos los parámetros.
	 */
	
	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}


	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	/**
	 * Se realiza el ToString
	 */

}