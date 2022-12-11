package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class ClienteAplicativo05 {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		try {
			double idade;
				idade = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a idade do competidor","Idade",JOptionPane.QUESTION_MESSAGE));
			MediaHome obj = null;
			Registry registry = LocateRegistry.getRegistry(1010);
			obj = (MediaHome) registry.lookup("MediaHome");
			String result = obj.classificacao(idade);
			JOptionPane.showMessageDialog(null,result);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato Errado! Tente Novamente\n(Ex: 200)", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
