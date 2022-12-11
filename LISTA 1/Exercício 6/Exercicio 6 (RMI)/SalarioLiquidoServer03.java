package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SalarioLiquidoServer03 extends UnicastRemoteObject implements FuncionarioHome {

	public static void main(String args[]) {
		try {
			Registry registry = LocateRegistry.createRegistry(1010);
			FuncionarioHome obj = new SalarioLiquidoServer03();
			registry.bind("FuncionarioHome", obj);
			System.out.println("SalarioServer bound in registry");
		} catch (Exception e) {
			System.out.println("SalarioServer err: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public SalarioLiquidoServer03() throws RemoteException {
		super();
	}

	public String calculaSalarioLiquido(char nivel, double salarioBruto, int dependentes) {
		double salarioLiquido = salarioBruto;
		;
		if (nivel == 'A') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.03);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.08);
		} else if (nivel == 'B') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.05);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.1);
		} else if (nivel == 'C') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.08);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.15);
		} else if (nivel == 'D') {
			if (dependentes == 0)
				salarioLiquido = salarioBruto - (salarioBruto * 0.10);
			else
				salarioLiquido = salarioBruto - (salarioBruto * 0.17);
		}
		return String.valueOf(salarioLiquido);
	}

}
