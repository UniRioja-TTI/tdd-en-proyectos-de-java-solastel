package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que gestiona tareas envía avisos
 * por correo electrónico cuando están fuera de fecha.
 */
public class Servicio {
	
	private InterfazRepositorio repositorio;
	private InterfazMailer mailer;
	
	/**
	 * Crea un servicio a partir de un repositorio y un sistema
	 * de envío de correos
	 * @param r repositorio de datos
	 * @param m sistema de envío de correos
	 */
	public Servicio(InterfazRepositorio r, InterfazMailer m) {
		this.repositorio=r;
		this.mailer=m;
	}
	
	/**
	 * Crea una nueva tarea
	 * @param nombre nombre de la tarea
	 * @param fechalimite fecha límite para completar la tarea
	 */
	public void createToDo(String nombre, LocalDate fechalimite) {
		if(nombre == null || nombre.isEmpty()) return;
		repositorio.guardarToDo(new ToDo(nombre, "", fechalimite, false));
		comprobarYAlertar();
	}
	
	/**
	 * Añade una dirección de correo a la agenda
	 * @param email dirección de correo
	 */
	public void addEmail(String email) {
		if(email!=null && email.contains("@")) {
			repositorio.guardarEmail(email);
			comprobarYAlertar();
		}
	}
	
	/**
	 * Marca una tarea como finalizada
	 * @param nombre nombre de la tarea
	 */
	public void marcarTareaFinalizada(String nombre) {
		repositorio.marcarCompletado(nombre);
		comprobarYAlertar();
	}
	
	/**
	 * Devuelve la lista de tareas pendientes
	 * @return lista de tareas no completadas
	 */
	public List<ToDo> listaPendientes(){
		comprobarYAlertar();
		return repositorio.obtenerPendientes();
	}
	
	/**
	 * Comprueba si existen tareas cuya fecha límite ya ha
	 * pasado y envía un aviso a las direcciones de correo
	 * almacenadas
	 */
	public void comprobarYAlertar() {
		List<ToDo> p = repositorio.obtenerPendientes();
		List<String> e = repositorio.obtenerEmails();
		for(ToDo t : p) {
			if(t.getFechaLimite().isBefore(LocalDate.now())) {
				for(String n: e) {
					mailer.enviarCorreo(n, "La tarea " + t.getNombre() + " está fuera de fecha");
				}
			}
		}
	}

}
