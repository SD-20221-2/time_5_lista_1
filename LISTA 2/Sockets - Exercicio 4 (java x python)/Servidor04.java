import java.io.*;  
import java.net.*; 
public class Servidor04 {
    public static void main(String[] args) {
        try{ 
          ServerSocket serverSocket = new ServerSocket(6666);
          Socket soc = serverSocket.accept();

          System.out.println("Nova conexão de cliente: " + soc.getInetAddress());
          DataOutputStream dout=new DataOutputStream(soc.getOutputStream());  
          DataInputStream in = new DataInputStream(soc.getInputStream());
          
          Double altura = Double.parseDouble((String)in.readUTF());
          Double sexo = Double.parseDouble((String)in.readUTF());

          dout.writeUTF(classificacao(altura,sexo));
          dout.flush();
          dout.close();
          soc.close();
        }
        catch(Exception e){
          e.printStackTrace(); 
      }
    }
    public static String classificacao(double altura, double sexo){
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
  }