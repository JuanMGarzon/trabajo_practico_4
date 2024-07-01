package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Alumno {
	
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String domicilio;
    private String lu; // libreta Universitaria
    
    public Alumno() {
		// TODO Auto-generated constructor stub
	}
    
	public Alumno(String dni, String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento,
			String domicilio, String lu) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.lu = lu;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getLu() {
		return lu;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setLu(String lu) {
		this.lu = lu;
	}
    
}