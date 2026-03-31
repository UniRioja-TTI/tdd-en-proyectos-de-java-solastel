package com.tt1.test;

/**
 * Define el comportamiento de un servicio de envío de
 * correos electrónicos.
 */
public interface InterfazMailer {
	
	/**
	 * Envía un correo electrónico a un destinatario
	 * @param e dirección de correo del destinatario
	 * @param m mensaje que se envía
	 * @return true si el envío se realiza correctamente,
	 * falso en caso contrario
	 */
	public boolean enviarCorreo(String e, String m);
}
