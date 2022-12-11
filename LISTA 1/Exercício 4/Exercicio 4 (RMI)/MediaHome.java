package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MediaHome extends Remote {
	public String calculaPesoIdeal(double altura, double sexo) throws RemoteException;
}
