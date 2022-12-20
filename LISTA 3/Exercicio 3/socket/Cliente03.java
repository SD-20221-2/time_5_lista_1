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
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					Socket socket;
					try {
						socket = new Socket("localhost", 7777);
						System.out.println("Conectado!");

						OutputStream outputStream = socket.getOutputStream();
						DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

						InputStream inputStream = socket.getInputStream();
						DataInputStream dataInputStream = new DataInputStream(inputStream);
						
						dataOutputStream.writeDouble(10.0 * Math.random());
						dataOutputStream.writeDouble(10.0 * Math.random());
						dataOutputStream.writeDouble(10.0 * Math.random());
						dataOutputStream.flush();
						
						String resultado;
						resultado = dataInputStream.readUTF();
						JOptionPane.showMessageDialog(null, resultado);
						dataOutputStream.close();
						System.out.println("Fechando Socket e Terminando a thread.");
						socket.close();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			});
			thread.start();
		}
	}

}
