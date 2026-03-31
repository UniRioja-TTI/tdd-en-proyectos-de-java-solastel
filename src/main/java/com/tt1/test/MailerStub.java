package com.tt1.test;

/**
 * Clase que simula el envío de correos electrónicos. No
 * envía el correo real, sino que muestra por pantalla
 * el destinatario y el mensaje a enviar.
 */
public class MailerStub implements InterfazMailer {

	/**
	 * Simula el envío de un correo electrónico.
	 * @param e dirección del destinatario
	 * @param m mensaje a enviar
	 * @return true si el envío se realiza correctamente
	 */
	public boolean enviarCorreo(String e, String m) {
		System.out.println("Enviando a: " + e);
		System.out.println("Mensaje: " + m);
		return true;
	}
	
}
