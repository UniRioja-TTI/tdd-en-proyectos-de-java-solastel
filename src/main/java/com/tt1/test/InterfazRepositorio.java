package com.tt1.test;

import java.util.List;

/**
 * Define las operaciones de acceso a datos para la gestión
 * de tareas y emails.
 */
public interface InterfazRepositorio {
	
	/**
	 * Guarda una nueva tarea
	 * @param todo tarea a almacenar
	 */
	public void guardarToDo(ToDo todo);
	
	/**
	 * Busca una tarea por su nombre
	 * @param nombre nombre de la tarea
	 * @return la tarea encontrada o null si no existe
	 */
	public ToDo buscarToDo(String nombre);
	
	/**
	 * Marca una tarea como completada
	 * @param n nombre de la tarea
	 */
	public void marcarCompletado(String n);
	
	/**
	 * Guarda un nuevo email en el sistema
	 * @param email dirección de correo
	 */
	public void guardarEmail(String email);
	
	/**
	 * Obtiene la lista de tareas pendientes
	 * @return lista de tareas sin completar
	 */
	public List<ToDo> obtenerPendientes();
	
	/**
	 * Obtiene la lista de emails almacenados
	 * @return lista de direcciones de correo
	 */
	public List<String> obtenerEmails();
}
