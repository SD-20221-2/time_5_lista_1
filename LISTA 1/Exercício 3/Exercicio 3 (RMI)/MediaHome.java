package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MediaHome extends Remote {
	public String calculaMedia(double nota1, double nota2, double nota3) throws RemoteException;
}
