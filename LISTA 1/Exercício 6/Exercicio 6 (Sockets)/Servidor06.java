package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor06 {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Servidor esperando por conexoes...");
		Socket socket = ss.accept();
		System.out.println("Conexao de " + socket + "!");

		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);

		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

		String nome;
		char nivel;
		double salarioBruto;
		int dependentes;

		while (true) {
			nome = dataInputStream.readUTF();
			nivel = dataInputStream.readChar();
			salarioBruto = dataInputStream.readDouble();
			dependentes = dataInputStream.readInt();
			break;
		}

		dataOutputStream.writeUTF("O salário líquido do funcionário " + nome + " é R$ "
				+ calculaSalarioLiquido(nivel, salarioBruto, dependentes));
		dataOutputStream.flush();

		dataOutputStream.close();

		System.out.println("Fechando Sockets.");
		ss.close();
		socket.close();
	}

	public static String calculaSalarioLiquido(char nivel, double salarioBruto, int dependentes) {
		double salarioLiquido = salarioBruto;
		if (nivel == 'A') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.03);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.08);
		} else if (nivel == 'B') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.05);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.1);
		} else if (nivel == 'C') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.08);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.15);
		} else if (nivel == 'D') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.10);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.17);
		}
		return String.valueOf(salarioLiquido);
	}

}
