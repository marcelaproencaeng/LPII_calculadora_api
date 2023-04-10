package br.gov.fundatec.lp2.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.gov.fundatec.lp2.calculadora.model.TipoOperacao;
import br.gov.fundatec.lp2.calculadora.service.CalculadoraService;

public class CalculadoraServiceTest {
	private CalculadoraService calculadoraService;

	@BeforeEach
	public void init() {
		calculadoraService = new CalculadoraService();
	}

	@ParameterizedTest
	@CsvSource({ "2,4,6", "4,25,29" })
	void deveSomarDoisNumeros(double primeiroNumero, double segundoNumero, double resultadoEsperado) {
		// 1
		// when
		double resultado = calculadoraService.calcular(primeiroNumero, segundoNumero, TipoOperacao.SOMA);

		// Then
		assertEquals(resultadoEsperado, resultado);
	}

	// 5
	@Test
	void deveLancarExcecaoQuandoDivisaoPorZero() {
		// given
		double divisor = 10;
		double dividendo = 0;

		// when / then
		assertThrows(IllegalArgumentException.class,
				() -> calculadoraService.calcular(divisor, dividendo, TipoOperacao.DIVISAO));

	}

	// 4
	@Test
	void deveDivirDoisTermos() {
		double divisor = 20;
		double dividendo = 2;
		double resultado = calculadoraService.calcular(divisor, dividendo, TipoOperacao.DIVISAO);

		// when /then
		assertEquals(10, resultado);
	}

	// 2
	@ParameterizedTest
	@CsvSource({ "20,2,18", "20,10,10" })
	void deveSubtrair(double primeiroNumero, double segundoNumero, double resultadoEsperado) {

		// when /then
		double resultado = calculadoraService.calcular(primeiroNumero, segundoNumero, TipoOperacao.SUBTRACAO);

		// when /then
		assertEquals(resultadoEsperado, resultado);

	}

	// 3
	@ParameterizedTest
	@CsvSource({ "20,2,40", "20,3,60" })
	void deveMultiplicar(double primeiroNumero, double segundoNumero, double resultadoEsperado) {
		// when / then
		double resultado = calculadoraService.calcular(primeiroNumero, segundoNumero, TipoOperacao.MULTIPLICACAO);

		// when / then
		assertEquals(resultadoEsperado, resultado);

	}
}
