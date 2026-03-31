package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de interactuar con la base de
 * datos simulada para almacenar y recuperar tareas
 * y correos electrónicos.
 */
public class Repositorio implements InterfazRepositorio{

	private DBStub db;
	
	/**
	 * Crea un repositorio asociado a una base de datos
	 * simulada
	 * @param d instancia de la base de datos simulada
	 */
	public Repositorio(DBStub d) {
		this.db=d;
	}
	
	/**
	 * Guarda una nueva tarea en la base de datos
	 * @param todo tarea a guardar
	 */
	public void guardarToDo(ToDo todo) {
		db.createToDo(todo);
	}

	/**
	 * Busca una tarea por su nombre
	 * @param nombre de la tarea
	 * @return tarea encontrada o null si no existe
	 */
	public ToDo buscarToDo(String nombre) {
		return db.readToDo(nombre);
	}

	/**
	 * Marca una tarea como completada
	 * @param n nombre de la tarea
	 */
	public void marcarCompletado(String n) {
		ToDo t = db.readToDo(n);
		if(t!=null) t.setCompletado(true);
	}

	/**
	 * Guarda una dirección de correo en la agenda
	 * @param email dirección de correo
	 */
	public void guardarEmail(String email) {
		db.insertarEmail(email);
	}

	/**
	 * Devuelve la lista de tareas pendientes
	 * @return lista de tareas que no han sido completadas
	 */
	public List<ToDo> obtenerPendientes() {
		List<ToDo> pendientes = new ArrayList<>();
		List<ToDo> t = db.listarToDos();
		for(ToDo td : t){
			if(!td.getCompletado()) {
				pendientes.add(td);
			}
		}
		return pendientes;
	}

	/**
	 * Devuelve todas las direcciones de correo almacenadas
	 * @return lista de correos electrónicos
	 */
	public List<String> obtenerEmails() {
		return db.listarEmails();
	}

}
