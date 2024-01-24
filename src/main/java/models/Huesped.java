package models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_huespedes")
public class Huesped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_huesped")
	private Long idHuesped;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false, length = 255)
	private String apellido;
	
	@Column(name = "fechaNacimiento", nullable = false)
	private LocalDate fechaDeNacimiento;
	
	@Column(nullable = false, length = 100) 
	private String nacionalidad;
	
	@Column(nullable = false, length = 20, unique = true)
	private String telefono;
	
	@OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL)
	private List<Reserva> reservas;

	public Huesped() {}
	
	public Huesped(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	
	
	
	
}
