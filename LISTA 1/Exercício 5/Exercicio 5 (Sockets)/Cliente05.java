import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente08 {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Conectado!");

		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		
		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);	
        
		while(true){
			try{
				double idade;
				idade = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a idade do competidor","Idade",JOptionPane.QUESTION_MESSAGE));
				dataOutputStream.writeDouble(idade);
				dataOutputStream.flush();
				break;
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato Errado! Tente Novamente\n(Ex: 200)", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		String classificacao;
		classificacao = dataInputStream.readUTF();
		JOptionPane.showMessageDialog(null,classificacao);

		dataOutputStream.close();

		System.out.println("Fechando Socket e Terminando o Programa.");
		socket.close();
	}
}