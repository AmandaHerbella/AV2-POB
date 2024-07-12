package CRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
	public void incluirCliente(Cliente cliente) throws SQLException{
		String sql = "INSERT INTO clientes (nome, cpf, email, endereco, cep) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = JDBC.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getCep());
			stmt.setString(5, cliente.getCpf());
			stmt.executeUpdate();
		}
				
	}
	public void alterarCliente(Cliente cliente) throws SQLException{
		String sql = "UPDATE clientes SET nome = ?, email = ?, endereco = ?, cep = ? WHERE cpf = ?";
		try(Connection conn = JDBC.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getCep());
			stmt.setString(5, cliente.getCpf());
			stmt.executeUpdate();
		}
	}
	public void excluirCliente(String cpf) throws SQLException {
		String sql = "DELETE FROM clientes WHERE cpf = ?";
		try (Connection conn = JDBC.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, cpf);
			stmt.executeUpdate();
		}
	}
	public List<Cliente> listarClientes() throws SQLException {
		String sql = "SELECT * FROM clientes";
		List<Cliente> clientes = new ArrayList<>();
		try(Connection conn = JDBC.getConexao();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while (rs.next()) {
				Cliente cliente = new Cliente(
					rs.getString("nome"),
					rs.getString("cpf"),
					rs.getString("email"),
					rs.getString("endereco"),
					rs.getString("cep")
				);
				clientes.add(cliente);
			}
		}
		
		return clientes;
	}
}
