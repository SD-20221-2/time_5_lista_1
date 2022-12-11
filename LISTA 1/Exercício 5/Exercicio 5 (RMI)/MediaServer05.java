package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class MediaServer05 extends UnicastRemoteObject implements MediaHome {

  public MediaServer05() throws RemoteException {
       super();
  }

   public String classificacao(double idade) {
		String resposta;
		if(idade < 5)
			resposta = "Idade insuficiente para a competição";
		else if(idade >= 5 && idade <= 7)
			resposta = "Categoria: infantil A";
		else if(idade >= 8 && idade <= 10)
			resposta = "Categoria: infantil B";
		else if(idade >= 11 && idade <= 13)
			resposta = "Categoria: juvenil A";
		else if(idade >= 14 && idade <= 17)
			resposta = "Categoria: juvenil B";
		else 
			resposta = "Categoria: Maiores de 18 anos";
		return resposta;
   }

    public static void main(String args[]) {

        try {
        Registry registry = LocateRegistry.createRegistry(1010);
        MediaHome obj = new MediaServer04();
	    // Bind this object instance to the name "Cliente"
         registry.bind("MediaHome", obj);
	    System.out.println("Server bound in registry");
        } catch (Exception e) {
	    System.out.println("Server err: " + e.getMessage());
	    e.printStackTrace();
        }
    }
}
