package com.example;

public class Pais {

	private long id;
	private String nombre;
	private int poblacion;
	
	public Pais(long id, String nombre, int poblacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	
}
