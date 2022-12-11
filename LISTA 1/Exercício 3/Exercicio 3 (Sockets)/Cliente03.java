package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente03 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Conectado!");

		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		
		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);	
        
		while(true){
			try{
				double n1, n2, n3;
				n1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a nota 1:","Nota 1",JOptionPane.QUESTION_MESSAGE));
				dataOutputStream.writeDouble(n1);
				n2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a nota 2:","Nota 2",JOptionPane.QUESTION_MESSAGE));
				dataOutputStream.writeDouble(n2);
				n3 = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a nota 3:","Nota 3",JOptionPane.QUESTION_MESSAGE));
				dataOutputStream.writeDouble(n3);
				dataOutputStream.flush();
				break;
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato Errado! Tente Novamente\n(Ex: 200)", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		String resultado;
		resultado = dataInputStream.readUTF();
		JOptionPane.showMessageDialog(null,resultado);

		dataOutputStream.close();

		System.out.println("Fechando Socket e Terminando o Programa.");
		socket.close();

	}

}
