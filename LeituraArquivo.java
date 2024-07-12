package CRUD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class LeituraArquivo {
	public static List<Cliente> lerClientesArquivo(String pathArch) throws IOException{
		List<Cliente> clientes = new ArrayList<>();
		pathArch = "clientesAv2.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(pathArch))) {
			String linha;
			br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				Cliente cliente = new Cliente(
					campos[0],
					campos[1],
					campos[2],
					campos[3],
					campos[4]
				);
				clientes.add(cliente);
			}
		}
		return clientes;
	}
}
