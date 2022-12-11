import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor05 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Servidor esperando por conexoes...");
		Socket socket = ss.accept(); 
		System.out.println("Conexao de " + socket + "!");

		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

		double idade = dataInputStream.readDouble();
		
		dataOutputStream.writeUTF(classificacao(idade));
		dataOutputStream.flush();
		
		dataOutputStream.close();
		
		System.out.println("Fechando Sockets.");
		ss.close();
		socket.close();
	}
	
	public static String classificacao(double idade){
		String resposta;
		if(idade < 5)
			resposta = "Idade insuficiente para a competição";
		else if(idade >= 5 && idade <= 7)
			resposta = "Categoria: infantil A";
		else if(idade >= 8 && idade <= 10)
			resposta = "Categoria: infantil B";
		else if(idade >= 11 && idade <= 13)
			resposta = "Categoria: juvenil A";
		else if(idade >= 14 && idade <= 17)
			resposta = "Categoria: juvenil B";
		else 
			resposta = "Categoria: Maiores de 18 anos";
		return resposta;
	}
}