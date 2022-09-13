package br.org.serratec.teste;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import br.org.serratec.model.Dependente;
import br.org.serratec.model.Funcionario;

public class TesteTrabalho {
	public static void main(String[] args) {

		List <Funcionario> funcionarios = new ArrayList <>();
		  
		try {
		File arquivo = new File("C:/Users/ASUS/Serratec/pOOTrabalhoFinal/pOOFuncionarios.csv");
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("yyyy,MM,dd");

		Scanner sc = new Scanner(arquivo);
		String linha;
		
	    while (sc.hasNextLine()) {
	    	List<Dependente> dependentes = new ArrayList<>(); 
	    	linha = sc.nextLine();
	    	
	    	String[] FuncTemp = linha.split(";");
			String nomeFunc = FuncTemp[0];
			String cpfFunc = FuncTemp[1];
			LocalDate dataFunc = LocalDate.parse(FuncTemp[2], formatadorData);
			double salario = Double.parseDouble(FuncTemp[3]);
		
			linha = sc.nextLine();
			
			while (!linha.isBlank()){
				String[] DepTemp = linha.split(";");
				String nomeDep = DepTemp[0];
				String cpfDep = DepTemp[1];
				LocalDate dataDep = LocalDate.parse(DepTemp[2], formatadorData);
				String parentesco = DepTemp[3];
				
				dependentes.add(new Dependente(nomeDep, cpfDep, dataDep, parentesco));
				
				linha = sc.nextLine();
			}
	
			funcionarios.add(new Funcionario(nomeFunc, cpfFunc, dataFunc, salario, dependentes));
	     }
	    
	     sc.close();
	     for (Funcionario funcionario : funcionarios) {
			funcionario.calcularSalarioLiquido();
		}
	     System.out.println(funcionarios);
		} catch (Exception e) {
			if (!e.getClass().equals(NoSuchElementException.class)) {
				e.printStackTrace();
			}
		}
		for (Funcionario funcionario : funcionarios) {
			funcionario.calcularSalarioLiquido();
		}
		System.out.println(funcionarios);
	}

}

// LEITURA DO ARQUIVO

// CALCULOS
// 1> INSS
// 2> DEP
// 3> IR

// COMPARACAO EXCEPTIONS

// GRAVACAO DO ARQUIVO