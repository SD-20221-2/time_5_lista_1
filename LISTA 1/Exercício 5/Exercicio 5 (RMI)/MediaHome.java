package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MediaHome extends Remote {
	public String classificacao(double idade) throws RemoteException;
}
