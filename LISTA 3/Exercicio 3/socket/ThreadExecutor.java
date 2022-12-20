package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadExecutor extends Thread  {
	
	private Socket socket;
	double nota1, nota2, nota3;

	public ThreadExecutor(Socket socket) {
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);

			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			
			nota1 = dataInputStream.readDouble();
			nota2 = dataInputStream.readDouble();
			nota3 = dataInputStream.readDouble();
			dataOutputStream.writeUTF(calculaMedia(nota1, nota2, nota3));
			dataOutputStream.flush();
			dataOutputStream.close();
			
			System.out.println("Fechando Socket.");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
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
