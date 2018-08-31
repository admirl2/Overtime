package com.supp.work.soft.shared;

import java.security.MessageDigest;
import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client-side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to
	 * ensure that usernames, passwords, email addresses, URLs, and other fields
	 * have the proper syntax.
	 * 
	 * @param name
	 *            the name to validate
	 * @return true if valid, false if invalid
	 */

	// static byte[] cipherText;
	// private static final String DES_TRANSFORMATION_STRING = "DES";
	// // private static Key clef;
	// private String cle;
	// private byte[] passwordInBytes;
	// public FieldVerifier(String cle)
	// {
	// try
	// {
	// //passwordInBytes = cle.getBytes("ISO-8859-2");
	// //passwordInBytes = cle.getBytes("UTF8");
	// passwordInBytes = cle.getBytes("ISO-8859-2");
	// clef=new SecretKeySpec(passwordInBytes,"DES");
	//
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}

	public static boolean isNumberCar(String name) {
		try {
			if (!name.isEmpty()) {
				int val = Integer.valueOf(name);
				return false;
			}
		} catch (Exception ex) {
		}
		return true;
	}

	public static int isVide(String valeur) {
		try {
			if (!valeur.isEmpty()) {
				int val = Integer.valueOf(valeur);
				return val;
			}
		} catch (Exception ex) {
		}
		return 0;
	}

	public static String formateDate(Date date) {
		final DateTimeFormat dateFormat = DateTimeFormat
				.getFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	public static String annee(Date date) {
		String annee = null;
		String dateEnCaractere = null;
		try {
			DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
			dateEnCaractere = dateFormat.format(date);
			annee = dateEnCaractere.substring(6, 10);
		} catch (Exception ex) {

		}
		return annee;
	}

	public static String nombreChiffreApresVirgule(String nombre) {
		String nombreFinal = null;
		String buf = "";
		char caractere;
		for (int i = 0; i < nombre.length(); i++) {
			caractere = nombre.charAt(i);
			if (caractere == '.') {
				if (nombre.length() >= i + 3) {
					nombreFinal = nombre.substring(0, i + 3);
				} else {
					nombreFinal = nombre.substring(0, i + 2);
				}
				buf = nombre.substring(i, i + 1);
			}
			if (buf.equals("")) {
				nombreFinal = nombre;
			}
		}
		return nombreFinal;
	}
	
}
