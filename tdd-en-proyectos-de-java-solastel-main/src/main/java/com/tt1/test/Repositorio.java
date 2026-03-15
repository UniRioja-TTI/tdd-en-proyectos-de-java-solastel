package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class Repositorio implements InterfazRepositorio{

	private DBStub db;
	
	public Repositorio(DBStub d) {
		this.db=d;
	}
	
	@Override
	public void guardarToDo(ToDo todo) {
		db.createToDo(todo);
	}

	@Override
	public ToDo buscarToDo(String nombre) {
		return db.readToDo(nombre);
	}

	@Override
	public void marcarCompletado(String n) {
		ToDo t = db.readToDo(n);
		if(t!=null) t.setCompletado(true);
	}

	@Override
	public void guardarEmail(String email) {
		db.insertarEmail(email);
	}

	@Override
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

	@Override
	public List<String> obtenerEmails() {
		return db.listarEmails();
	}

}
