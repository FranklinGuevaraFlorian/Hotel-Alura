package models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private Long idReserva;
	
	@Column(name = "fechaEntrada", nullable = false)
	private LocalDate fechaDeEntrada;
	
	@Column(name = "fechaSalida", nullable = false)
	private LocalDate fechaDeSalida;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(name = "formaPago", nullable = false, length = 20)
	private String formaDePago;

	@ManyToOne
	@JoinColumn(name = "id_huesped")
	private Huesped huesped;
	

	public Reserva() {
		
	}
	
	public Reserva(LocalDate fechaDeEntrada, LocalDate fechaDeSalida, BigDecimal valor, String formaDePago) {
		this.fechaDeEntrada = fechaDeEntrada;
		this.fechaDeSalida = fechaDeSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public LocalDate getFechaDeEntrada() {
		return fechaDeEntrada;
	}

	public void setFechaDeEntrada(LocalDate fechaDeEntrada) {
		this.fechaDeEntrada = fechaDeEntrada;
	}

	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}

	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	
	
	
	
	
	
	
}
