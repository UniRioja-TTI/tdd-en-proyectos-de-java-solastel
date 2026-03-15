package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub {
	
	private List<ToDo> tareas;
	private List<String> emails;

	public DBStub() {
		tareas=new ArrayList<>();
		emails=new ArrayList<>();
	}
	
	public void createToDo(ToDo t) {
		tareas.add(t);
	}
	
	public ToDo readToDo(String n) {
		for(ToDo t:tareas) {
			if(t.getNombre().equals(n)) {
				return t;
			}
		}
		return null;
	}
	
	public void updateToDo(ToDo t) {
		for(int i=0;i<tareas.size(); i++) {
			if(tareas.get(i).getNombre().equals(t.getNombre())) {
				tareas.set(i,t);
			}
		}
	}
	
	public void deleteToDo(String n) {
		for(ToDo t: tareas) {
			if(t.getNombre().equals(n)) {
				tareas.remove(t);
			}
		}
	}
	
	public List<ToDo> listarToDos(){
		return tareas;
	}
	
	public void insertarEmail(String email) {
		emails.add(email);
	}
	
	public List<String> listarEmails(){
		return emails;
	}
}
