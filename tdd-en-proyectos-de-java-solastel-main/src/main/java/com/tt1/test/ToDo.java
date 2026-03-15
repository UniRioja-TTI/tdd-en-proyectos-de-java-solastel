package com.tt1.test;

import java.time.LocalDate;

public class ToDo {
	private String nombre;
	private String descripcion;
	private LocalDate fechaLimite;
	private boolean completado;

	public ToDo() {
		
	}
	
	public ToDo(String n, String d, LocalDate f, boolean c) {
		this.nombre=n;
		this.descripcion=d;
		this.fechaLimite=f;
		this.completado=c;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String n) {
		this.nombre=n;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String d) {
		this.descripcion=d;
	}
	
	public LocalDate getFechaLimite() {
		return this.fechaLimite;
	}
	
	public void setFechaLimite(LocalDate f) {
		this.fechaLimite=f;
	}
	
	public boolean getCompletado() {
		return this.completado;
	}
	
	public void setCompletado(boolean c) {
		this.completado=c;
	}
}
