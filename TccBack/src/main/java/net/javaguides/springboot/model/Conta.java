package net.javaguides.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import org.springframework.format.annotation.DateTimeFormat;
// import java.util.Date;

@Entity
@Table(name = "contas")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "categoria")
	private String categoria;
	
	// @NumberFormat(style = Style.CURRENCY)
	@Column(name = "valor")
	private Double valor;

	// @DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data")
	private Date data;
	
	@Column(name = "tipo")
	private Long tipo;

	public Conta() {
		
	}
	
	public Conta(String descricao, String categoria, Double valor, Date data, Long tipo) {
		super();
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
		this.data = data;
		this.tipo = tipo;
	}
	// id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	// descricao
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	// categoria
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	// valor
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	// data
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	// tipo
	public Long getTipo() {
		return tipo;
	}
	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}
}
