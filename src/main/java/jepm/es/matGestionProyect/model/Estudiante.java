package jepm.es.matGestionProyect.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@Table(name="estudiante")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	@Override
	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2;
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido1;

	private String apellido2;

	private String direccion;

	private String dni;

	private String email;

	private byte[] imagen;

	private String nombre;

	private int sexo;

	private String telefono;

	public Estudiante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSexo() {
		return this.sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}