package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que simula una base de datos, y permite almacenar
 * y gestionar tareas y emails.
 */
public class DBStub {
	
	private List<ToDo> tareas;
	private List<String> emails;

	/**
	 * Crea una base de datos simulada vacía
	 */
	public DBStub() {
		tareas=new ArrayList<>();
		emails=new ArrayList<>();
	}
	
	/**
	 * Crea una nueva tarea en la base de datos.
	 * @param t tarea a añadir
	 */
	public void createToDo(ToDo t) {
		tareas.add(t);
	}
	
	
	/**
	 * Busca una tarea por su nombre
	 * @param n nombre de la tarea
	 * @return la tarea encontrada o null si la tarea no existe
	 */
	public ToDo readToDo(String n) {
		for(ToDo t:tareas) {
			if(t.getNombre().equals(n)) {
				return t;
			}
		}
		return null;
	}
	
	
	/**
	 * Actualiza una tarea existente en la base de datos
	 * @param t tarea con la nueva información
	 */
	public void updateToDo(ToDo t) {
		for(int i=0;i<tareas.size(); i++) {
			if(tareas.get(i).getNombre().equals(t.getNombre())) {
				tareas.set(i,t);
			}
		}
	}
	
	/**
	 * Elimina una tarea de la base de datos
	 * @param n nombre de la tarea a eliminar
	 */
	public void deleteToDo(String n) {
		for(ToDo t: tareas) {
			if(t.getNombre().equals(n)) {
				tareas.remove(t);
			}
		}
	}
	
	/**
	 * Devuelve la lista de todas las tareas almacenadas
	 * @return lista de tareas
	 */
	public List<ToDo> listarToDos(){
		return tareas;
	}
	
	/**
	 * Inserta una dirección de correo en la agenda
	 * @param email dirección de correo electrónico
	 */
	public void insertarEmail(String email) {
		emails.add(email);
	}
	
	/**
	 * Devuelve la lista de todos los correos almacenados
	 * @return lista de direcciones de correo
	 */
	public List<String> listarEmails(){
		return emails;
	}
}
