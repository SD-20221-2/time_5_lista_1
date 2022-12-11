package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class ClienteAplicativo03 {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		try {
			double n1, n2, n3;
			n1 = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Digite a nota 1:", "Nota 1", JOptionPane.QUESTION_MESSAGE));
			n2 = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Digite a nota 2:", "Nota 2", JOptionPane.QUESTION_MESSAGE));
			n3 = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Digite a nota 3:", "Nota 3", JOptionPane.QUESTION_MESSAGE));
			MediaHome obj = null;
			Registry registry = LocateRegistry.getRegistry(1010);
			obj = (MediaHome) registry.lookup("MediaHome");
			String result = obj.calculaMedia(n1, n2, n3);
			JOptionPane.showMessageDialog(null,result);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato Errado! Tente Novamente\n(Ex: 200)", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
