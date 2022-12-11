package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FuncionarioHome extends Remote {
	public String calculaSalarioLiquido(char nivel, double salarioBruto, int dependentes) throws RemoteException;
}
