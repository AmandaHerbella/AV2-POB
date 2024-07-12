package CRUD;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu();
		
		while(true) {
			System.out.println("ESCOLHA UMA OPÇÃO:");
			System.out.println("(1) INCLUIR CLIENTE");
			System.out.println("(2) ALTERAR CLIENTE");
			System.out.println("(3) EXCLUIR CLIENTE");
			System.out.println("(4) LISTAR CLIENTES");
			System.out.println("(5) SAIR");
			
			int op = scanner.nextInt();
			scanner.nextLine();
			
			try {
				switch (op) {
				case 1:
					System.out.println("Digite os dados do cliente:");
					Cliente novo = new Cliente(
						scanner.nextLine(),
						scanner.nextLine(),
						scanner.nextLine(),
						scanner.nextLine(),
						scanner.nextLine()
					);
					if (ValidarDados.validarCliente(novo)) {
						menu.incluirCliente(novo);
						System.out.println("Cliente inserido.");
					}else {
						System.out.println("Erro ao inserir cliente.");
					}
					break;
				case 2:
					System.out.println("Para alterar o cliente, digite o CPF do mesmo:");
					String cpf = scanner.nextLine();
					Cliente clienteAtual = new Cliente(
						scanner.nextLine(),
						cpf,
						scanner.nextLine(),
						scanner.nextLine(),
						scanner.nextLine()
						);
					
					if(ValidarDados.validarCliente(clienteAtual)) {
						menu.alterarCliente(clienteAtual);
						System.out.println("Cliente alterado com sucesso.");	
					}else {
						System.out.println("Erro ao alterar cliente.");
					}
					break;
				case 3: 
					System.out.println("Para excluir o cliente, digite o CPF do mesmo:");
					String cpfExcluir = scanner.nextLine();
					menu.excluirCliente(cpfExcluir);
					System.out.println("Cliente excluido com sucesso.");
					break;
				case 4:
					List<Cliente> clientes = menu.listarClientes();
					for(Cliente cliente : clientes) {
						System.out.println(cliente);
					}
					break;
				case 5:
					System.out.println("Encerrando...");
					return;
				default:
					System.out.println("Erro.");
					break;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Erro ao acessar banco de dados.");
			}
		}
	}
}
