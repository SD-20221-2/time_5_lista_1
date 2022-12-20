package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor03 {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Servidor esperando por conexoes...");
		double nota1, nota2, nota3;
		
		while(true) {
			Socket socket = ss.accept(); 
			System.out.println("Conexao de " + socket + "!");
			ThreadExecutor thread = new ThreadExecutor(socket);
			thread.start();
		}
		
	
	}
	

}
