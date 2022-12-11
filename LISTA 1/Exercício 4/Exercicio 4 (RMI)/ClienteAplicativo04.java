package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class ClienteAplicativo04 {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		try {
			double altura, sexo;
			altura = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Digite a altura:", "Altura", JOptionPane.QUESTION_MESSAGE));
			sexo = Double.parseDouble(
					JOptionPane.showInputDialog(null, "(1)Masculino (2)Feminino", "Sexo", JOptionPane.QUESTION_MESSAGE));
			MediaHome obj = null;
			Registry registry = LocateRegistry.getRegistry(1010);
			obj = (MediaHome) registry.lookup("MediaHome");
			String result = obj.calculaPesoIdeal(altura, sexo);
			JOptionPane.showMessageDialog(null,result);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato Errado! Tente Novamente\n(Ex: 200)", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
