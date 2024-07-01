package ar.edu.unju.fi.model;

public class Materia {
	
    private String codigo;
    private String nombre;
    private String curso;
    private int cantidadHoras;
    private String modalidad; // virtual o presencial
    private Docente docente;
    private Carrera carrera;
    
    public Materia() {
		// TODO Auto-generated constructor stub
	}
    
	public Materia(String codigo, String nombre, String curso, int cantidadHoras, String modalidad, Docente docente,
			Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCurso() {
		return curso;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public String getNombreDocente() {
        return docente != null ? docente.getNombre() + " " + docente.getApellido() : "Sin asignar";
    }

    public String getNombreCarrera() {
        return carrera != null ? carrera.getNombre() : "Sin asignar";
    }
    
}