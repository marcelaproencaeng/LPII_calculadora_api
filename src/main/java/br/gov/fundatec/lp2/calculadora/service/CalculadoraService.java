package br.gov.fundatec.lp2.calculadora.service;

import br.gov.fundatec.lp2.calculadora.model.TipoOperacao;

public class CalculadoraService {
	
public double calcular(double primeiroTermo, double segundoTermo, TipoOperacao tipoOperacao) {
		
		if (TipoOperacao.SOMA == tipoOperacao) {
			return primeiroTermo + segundoTermo;
		}
		
		if (TipoOperacao.SUBTRACAO == tipoOperacao) {
			return primeiroTermo - segundoTermo;
		}
		
		if (TipoOperacao.MULTIPLICACAO == tipoOperacao) {
			return primeiroTermo * segundoTermo;
		}
		
		if (TipoOperacao.DIVISAO == tipoOperacao) {
			if (segundoTermo == 0) {
				throw new IllegalArgumentException("Não existe divisão por zero");
			}
			return primeiroTermo / segundoTermo;
		}
		
		throw new UnsupportedOperationException("Calculadora não suporta tipo operação: " 
				+ tipoOperacao);
	}

}
