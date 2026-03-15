package com.tt1.test;

import java.util.List;

public interface InterfazRepositorio {
	public void guardarToDo(ToDo todo);
	public ToDo buscarToDo(String nombre);
	public void marcarCompletado(String n);
	public void guardarEmail(String email);
	public List<ToDo> obtenerPendientes();
	public List<String> obtenerEmails();
}
