package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_credenciales")
public class Credencial {

	@Id
	@Column(length = 40)
	private String usuario;
	
	@Column(name = "contrasena", length = 64, nullable = false)
	private String contraseña;
	
	@Column(length = 16, nullable = false, unique = true)
	private String salt;

	public Credencial() {
		
	}
	
	public Credencial(String usuario, String contraseña, String salt) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.salt = salt;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getSalt() {
		return this.salt;
	}
	
	
	
	
	

	
}
