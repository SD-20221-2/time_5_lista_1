package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class MediaServer03 extends UnicastRemoteObject implements MediaHome {

  public MediaServer03() throws RemoteException {
       super();
  }

   public String calculaMedia(double nota1, double nota2, double nota3) {
	   double media = (nota1 + nota2)/2.0;
		if(media >= 7.0 ) {
			return "Aprovado";
		}else if(media < 3.0 ) {
			return "Reprovado";
		}else if((media + nota3)/2.0 >= 5.0)
			return "Aprovado";
		else {
			return "Reprovado";
		}
   }

    public static void main(String args[]) {

        try {
        Registry registry = LocateRegistry.createRegistry(1010);
        MediaHome obj = new MediaServer03();
	    // Bind this object instance to the name "Cliente"
         registry.bind("MediaHome", obj);
	    System.out.println("CreditoServer bound in registry");
        } catch (Exception e) {
	    System.out.println("CreditoServer err: " + e.getMessage());
	    e.printStackTrace();
        }
    }
}
