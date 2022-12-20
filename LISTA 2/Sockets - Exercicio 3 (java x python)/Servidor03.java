package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor03 {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Servidor esperando por conexoes...");
		Socket socket = ss.accept(); 
		System.out.println("Conexao de " + socket + "!");

		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

		double nota1, nota2, nota3;
		
		while(true) {
			nota1 = dataInputStream.readDouble();
			nota2 = dataInputStream.readDouble();
			nota3 = dataInputStream.readDouble();
			break;
		}
		
		dataOutputStream.writeUTF(calculaMedia(nota1, nota2, nota3));
		dataOutputStream.flush();
		
		dataOutputStream.close();
		
		System.out.println("Fechando Sockets.");
		ss.close();
		socket.close();
	}
	
	public static String calculaMedia(double nota1, double nota2, double nota3){
		double media = (nota1 + nota2)/2.0;
		if(media >= 7.0 ) {
			return "Aprovado";
		}else if(media < 3.0 ) {
			return "Reprovado";
		}else if((media + nota3)/2.0 >= 5.0)
			return "Aprovado";
		else {
			return "Reprovado";
		}
	}

}
