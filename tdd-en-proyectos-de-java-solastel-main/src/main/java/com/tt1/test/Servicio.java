package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public class Servicio {
	
	private InterfazRepositorio repositorio;
	private InterfazMailer mailer;
	
	public Servicio(InterfazRepositorio r, InterfazMailer m) {
		this.repositorio=r;
		this.mailer=m;
	}
	
	public void createToDo(String nombre, LocalDate fechalimite) {
		if(nombre == null || nombre.isEmpty()) return;
		repositorio.guardarToDo(new ToDo(nombre, "", fechalimite, false));
		comprobarYAlertar();
	}
	
	public void addEmail(String email) {
		if(email!=null && email.contains("@")) {
			repositorio.guardarEmail(email);
			comprobarYAlertar();
		}
	}
	
	public void marcarTareaFinalizada(String nombre) {
		repositorio.marcarCompletado(nombre);
		comprobarYAlertar();
	}
	
	public List<ToDo> listaPendientes(){
		comprobarYAlertar();
		return repositorio.obtenerPendientes();
	}
	
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
