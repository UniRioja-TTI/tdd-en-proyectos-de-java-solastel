package com.tt1.test;

public class MailerStub implements InterfazMailer {

	@Override
	public boolean enviarCorreo(String e, String m) {
		System.out.println("Enviando a: " + e);
		System.out.println("Mensaje: " + m);
		return true;
	}
	
}
