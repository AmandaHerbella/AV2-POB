package CRUD;

public class ValidarDados {
	public static boolean validarEmail(String email) {
		return email.contains("@");
	}
	public static boolean validarNome(String nome) {
		return nome.matches("[a-zA-Z]+"); //verificando se a string contem apenas caracteres alfabeticos
	}
	public static boolean validarCliente(Cliente cliente) {
		return validarEmail(cliente.getEmail()) && validarNome(cliente.getNome());
	}
}
