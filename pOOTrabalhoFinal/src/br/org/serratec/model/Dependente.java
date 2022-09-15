package br.org.serratec.model;

import java.time.LocalDate;

public class Dependente extends Pessoa {
	
	private String parentesco;
	private static Double VALOR_DEPENDENTE = 189.59;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, String parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	@Override
	public String toString() {
		return super.toString() + "Parentesco: " + parentesco;
	}

	public String getParentesco() {
		return parentesco;
	}

	public static Double getVALOR_DEPENDENTE() {
		return VALOR_DEPENDENTE;
	}

	@Override
	public void calcularSalarioLiquido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String criarTextoCsv() {
		return super.criarTextoCsv() +  parentesco + "\n";
	}
	

}
