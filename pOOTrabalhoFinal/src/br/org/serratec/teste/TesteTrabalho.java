package br.org.serratec.teste;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.org.serratec.model.Dependente;
import br.org.serratec.model.Funcionario;

public class TesteTrabalho {
	public static void main(String[] args) {

		List <Funcionario> funcionarios = new ArrayList <>();
		List<Dependente> dependentes = new ArrayList<>(); 
		  
		try {
		File arquivo = new File("C:/Users/ASUS/Serratec/pOOTrabalhoFinal/pOOFuncionarios.csv");
		String pastLine = "";
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("yyyy,MM,dd");

		// Read all lines in from CSV file and add to studentList
		/*FileReader fr = new FileReader(fileIn);
		BufferedReader br = new BufferedReader(fr);*/
			
		Scanner sc = new Scanner(arquivo);
		String linha = sc.nextLine();
		
	    while (sc.hasNextLine()) {
		    String[] FuncTemp = linha.split(";");
			String nomeFunc = FuncTemp[0];
			String cpfFunc = FuncTemp[1];
			LocalDate dataFunc = LocalDate.parse(FuncTemp[2], formatadorData);
			double salario = Double.parseDouble(FuncTemp[3]);
			
			if (!sc.nextLine().isEmpty()){
				String[] DepTemp = linha.split(";");
				String nomeDep = DepTemp[0];
				String cpfDep = DepTemp[1];
				LocalDate dataDep = LocalDate.parse(DepTemp[2], formatadorData);
				String parentesco = DepTemp[3];
				dependentes.add(new Dependente(nomeDep, cpfDep, dataDep, parentesco));
			}

			
			funcionarios.add(new Funcionario(nomeFunc, cpfFunc, dataFunc, salario, dependentes));
	     }
	     sc.close();
	     for (Funcionario funcionario : funcionarios) {
			funcionario.calcularSalarioLiquido();
		}
	     System.out.println(funcionarios);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 * List<Funcionario> funcionarios = new ArrayList<>(); List<Dependente> deps =
 * new ArrayList<>(); Dependente dep = new Dependente("Dep", "222",
 * LocalDate.of(2022,2,2), "FILHO"); Dependente dep2 = new Dependente("Dep",
 * "222", LocalDate.of(2022,2,2), "FILHO"); deps.add(dep); deps.add(dep2);
 * Funcionario fun1 = new Funcionario("Nome", "1111", LocalDate.of(2022,2,2),
 * 7000., deps); funcionarios.add(fun1);
 * 
 * fun1.calcularSalarioLiquido(); System.out.println(funcionarios);
 * System.out.println(fun1.getDependentes().size());
 */

// LEITURA DO ARQUIVO

// CALCULOS
// 1> INSS
// 2> DEP
// 3> IR

// COMPARACAO EXCEPTIONS

// GRAVACAO DO ARQUIVO
