package ar.edu.unju.fi.model;

public class Carrera {
	
    private String codigo;
    private String nombre;
    private int cantidadAnios;
    private String estado;
    
    public Carrera() {
	}
    
	public Carrera(String codigo, String nombre, int cantidadAnios, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidadAnios() {
		return cantidadAnios;
	}

	public String getEstado() {
		return estado;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidadAnios(int cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
