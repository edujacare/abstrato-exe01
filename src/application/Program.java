package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Enter the nuber of tax payers: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" +i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char op = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Anual income: ");
			double rendaAnual = sc.nextDouble();
			if (op == 'i') {
				System.out.println("Healt expenditures: ");
				double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
			}
			else {
				System.out.print("Number of employees: ");
				int numFunc = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numFunc));
			}
		}
				
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for (Contribuinte cont : list) {
			double imposto = cont.imposto();
			System.out.println(cont.getNome() + ": $ "+ String.format("%.2f", imposto));
		}
		
		double soma = 0.0;
		for (Contribuinte cont : list ) {
			soma += cont.imposto();			
		}
		
		System.out.println();
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", soma));
		
		sc.close();

	}

}
