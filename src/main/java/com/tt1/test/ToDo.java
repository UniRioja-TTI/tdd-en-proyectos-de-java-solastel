package com.tt1.test;

import java.time.LocalDate;

/**
 * Clase que representa una tarea con nombre, descripción,
 * fecha límite y estado.
 */
public class ToDo {
	private String nombre;
	private String descripcion;
	private LocalDate fechaLimite;
	private boolean completado;

	public ToDo() {
		
	}
	
	/**
	 * Crea una tarea con todos sus atributos
	 * @param n nombre de la tarea
	 * @param d descripción de la tarea
	 * @param f fecha límite de la tarea
	 * @param c estado de completado
	 */
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
