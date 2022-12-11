package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente06 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Conectado!");

		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		
		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);	
        
		while(true){
			try{
				String nome;
				char nivel;
				double salarioBruto;
				int dependentes;
				nome = JOptionPane.showInputDialog(null,"Digite o nome do funcionário:","Nome do Funcionário",JOptionPane.QUESTION_MESSAGE);
				dataOutputStream.writeUTF(nome);
				nivel = JOptionPane.showInputDialog(null,"Digite o nível:","Nível", JOptionPane.QUESTION_MESSAGE).charAt(0);
				dataOutputStream.writeChar(nivel);
				salarioBruto = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o salário bruto:","Salário Bruto",JOptionPane.QUESTION_MESSAGE));
				dataOutputStream.writeDouble(salarioBruto);
				dependentes = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número de dependentes:","Dependentes",JOptionPane.QUESTION_MESSAGE));
				dataOutputStream.writeInt(dependentes);
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
