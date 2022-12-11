package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class MediaServer04 extends UnicastRemoteObject implements MediaHome {

  public MediaServer04() throws RemoteException {
       super();
  }

   public String calculaPesoIdeal(double altura, double sexo) {
		String resposta;
		Double peso_ideal;
		if(sexo==1){
			peso_ideal = (72.7*altura)-58;
			resposta = "O peso ideal para ele é " + peso_ideal; 
		}
		else if(sexo==2){
			peso_ideal = (62.1*altura)-44.7;
			resposta = "O peso ideal para ela é " + peso_ideal;
		} 
		else 
			resposta = "Informação errada, tente novamente";
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
