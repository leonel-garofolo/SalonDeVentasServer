package org.salondeventas.server.util;

public class ValidacionesGlobales {
	
	public static boolean validarUsuario(String usuario, String clave){
		if(usuario != null && !usuario.equals("null")  && clave != null && !clave.equals("null")){
			return true;
		}
		return false;
	}
}
