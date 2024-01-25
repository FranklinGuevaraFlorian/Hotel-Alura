package DAO;

import javax.persistence.EntityManager;

import models.Credencial;
import utils.PasswordHasher;

public class CredencialesDao {

	private EntityManager em;

	public CredencialesDao(EntityManager em) {
		this.em = em; 
	}
	
	public void guardar(Credencial credencial) {
	
		//Genera y guarda el salt en la entidad
		String salt = PasswordHasher.generarSalt();
		credencial.setSalt(salt);
		
		//Genera el Hash en base al salt y la contraseña
		String contraseñaConSaltYHash = PasswordHasher.generarHash(salt.concat(credencial.getContraseña()));
		credencial.setContraseña(contraseñaConSaltYHash);
		
		this.em.persist(credencial);
	}
	
	public Credencial buscarPorUsuario(String usuario) {
		return this.em.find(Credencial.class, usuario);
	}
	
	public boolean validarUsuarioYcontrasena(Credencial credenciales) {
		
		Credencial credencialObtendida = buscarPorUsuario(credenciales.getUsuario());
		if(!credencialObtendida.equals(null)) {
			
			String coincidencia = PasswordHasher.generarHash(credencialObtendida.getSalt()
					.concat(credenciales.getContraseña()));
			
			if(coincidencia.equals(credencialObtendida.getContraseña())) {
				return true;
			}	
		}
		return false;
	}
	
}
