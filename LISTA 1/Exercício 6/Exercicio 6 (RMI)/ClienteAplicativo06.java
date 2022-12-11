package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class ClienteAplicativo06 {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		try {
			String nome;
			char nivel;
			double salarioBruto;
			int dependentes;
			nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário:", "Nome do Funcionário",
					JOptionPane.QUESTION_MESSAGE);
			nivel = JOptionPane.showInputDialog(null, "Digite o nível:", "Nível", JOptionPane.QUESTION_MESSAGE)
					.charAt(0);
			salarioBruto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o salário bruto:",
					"Salário Bruto", JOptionPane.QUESTION_MESSAGE));
			dependentes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número de dependentes:",
					"Dependentes", JOptionPane.QUESTION_MESSAGE));
			FuncionarioHome obj = null;
			Registry registry = LocateRegistry.getRegistry(1010);
			obj = (FuncionarioHome) registry.lookup("FuncionarioHome");
			String result = obj.calculaSalarioLiquido(nivel, salarioBruto, dependentes);
			JOptionPane.showMessageDialog(null, "O salário líquido do funcionário " + nome + " é R$ "
					+ result);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato Errado! Tente Novamente\n(Ex: 200)", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
