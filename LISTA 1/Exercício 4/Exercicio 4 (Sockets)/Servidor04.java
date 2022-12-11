import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor04 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Servidor esperando por conexoes...");
		Socket socket = ss.accept(); 
		System.out.println("Conexao de " + socket + "!");

		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

		double altura = dataInputStream.readDouble();
		double sexo = dataInputStream.readDouble();

		dataOutputStream.writeUTF(classificacao(altura, sexo));
		dataOutputStream.flush();
		
		dataOutputStream.close();
		
		System.out.println("Fechando Sockets.");
		ss.close();
		socket.close();
	}
	
	public static String classificacao(double altura, double sexo){
		String resposta;
		Double peso_ideal;
		if(sexo==1){
			peso_ideal = (72.7*altura)-58;
			resposta = "O peso ideal para ele é " + peso_ideal; 
		}
		else if(sexo==2){
			peso_ideal = (62.1*altura)-44.7;
			resposta = "O peso ideal para ela é " + peso_ideal;
		} 
		else 
			resposta = "Informação errada, tente novamente";
		return resposta;
	}
}