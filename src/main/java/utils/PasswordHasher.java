package utils;

import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordHasher {

	
	//Crea el salt
	public static String generarSalt() {
		String caracteres = "ABCDEFGHYJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz0123456789 "; 
		StringBuilder salt = new StringBuilder("");
		
		Random numeroAletorio = new Random();
		int numero = 0;
		
		for(int i = 0; i < 16; i++) {	
			
			numero = numeroAletorio.nextInt(58 + 1);
			salt.append(caracteres.charAt(numero));
		}
		
		return salt.toString();
	}
	
	//Crea el Hashed en base a la contraseña más el salt
	public static String generarHash(String input) {
		try {
			
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			
			byte[] bytes = sha256.digest(input.getBytes());
			
		    StringBuilder stringBuilder = new StringBuilder();
	        for (byte b : bytes) {
	             stringBuilder.append(String.format("%02x", b));
	         }
	        
	        return stringBuilder.toString();
	        
		}catch(NoSuchAlgorithmException e) {
			
			e.printStackTrace();
            
			return null;
		}
	
	}
}
