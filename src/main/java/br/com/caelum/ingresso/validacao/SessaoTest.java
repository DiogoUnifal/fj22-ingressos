package br.com.caelum.ingresso.validacao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		Sala sala = new Sala("Sala A", new BigDecimal("22.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "Ficção", new BigDecimal("12.0"));
		
		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
		
	}
}
