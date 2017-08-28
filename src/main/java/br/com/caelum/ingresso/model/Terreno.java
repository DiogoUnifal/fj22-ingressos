package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Terreno {
	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	private float frente;
	private float largura;
	private char quadra;
	private boolean empresa;
	
	public boolean isEmpresa() {
		return empresa;
	}
	public void setEmpresa(boolean empresa) {
		this.empresa = empresa;
	}
	public float getFrente() {
		return frente;
	}
	public void setFrente(float frente) {
		this.frente = frente;
	}
	public float getLargura() {
		return largura;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	public char getQuadra() {
		return quadra;
	}
	public void setQuadra(char quadra) {
		this.quadra = quadra;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
