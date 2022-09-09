package br.org.serratec.model;

import java.time.LocalDate;
import java.util.List;

import br.org.serratec.enums.EnumDependente;
import br.org.serratec.enums.EnumINSS;
import br.org.serratec.interfaces.Aliquota;

public class Funcionario extends Pessoa implements Aliquota {

	private Double salarioBruto, descontoINSS, descontoIR;
	private List<Dependente> dependentes;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto, Double descontoINSS,
			Double descontoIR, List<Dependente> dependentes) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoINSS = descontoINSS;
		this.descontoIR = descontoIR;
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Funcionario [salarioBruto=" + salarioBruto + ", descontoINSS=" + descontoINSS + ", descontoIR="
				+ descontoIR + ", dependentes=" + dependentes + "]";
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public Double getDescontoINSS() {
		return descontoINSS;
	}

	public Double getDescontoIR() {
		return descontoIR;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	@Override
	public Double calcularINSS() {
		if (salarioBruto >= EnumINSS.RENDAA.getSalario()) {
			descontoINSS = salarioBruto * EnumINSS.RENDAA.getAliquota()
					- (dependentes.size() * EnumDependente.VALORDEPENDENTE.getDescontoDependente());
			return descontoINSS;

		} else if (salarioBruto >= EnumINSS.RENDAB.getSalario()) {
			descontoINSS = salarioBruto * EnumINSS.RENDAB.getAliquota() 
					- (dependentes.size() * EnumDependente.VALORDEPENDENTE.getDescontoDependente());
			return descontoINSS;

		} else if (salarioBruto >= EnumINSS.RENDAC.getSalario()) {
			descontoINSS = salarioBruto * EnumINSS.RENDAC.getAliquota()
					- (dependentes.size() * EnumDependente.VALORDEPENDENTE.getDescontoDependente());
			return descontoINSS;

		} else if (salarioBruto >= EnumINSS.RENDAD.getSalario()) {
			descontoINSS = salarioBruto * EnumINSS.RENDAD.getAliquota()
					- (dependentes.size() * EnumDependente.VALORDEPENDENTE.getDescontoDependente());
			return descontoINSS;
		} else {
			return 7087.22 * EnumINSS.RENDAD.getAliquota();
		}

	}
// Criar o calculo IR ****************************************************************************************
	@Override
	public Double calcularIR() {
		return null;
	}
}
