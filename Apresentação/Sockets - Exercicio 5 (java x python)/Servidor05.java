import java.io.*;  
import java.net.*; 
public class Servidor05 {
    public static void main(String[] args) {
        try{ 
          ServerSocket serverSocket = new ServerSocket(6666);
          Socket soc = serverSocket.accept();

          System.out.println("Nova conexão de cliente: " + soc.getInetAddress());
          DataOutputStream dout=new DataOutputStream(soc.getOutputStream());  
          DataInputStream in = new DataInputStream(soc.getInputStream());
          
          Double idade = Double.parseDouble((String)in.readUTF());

          dout.writeUTF(classificacao(idade));
          dout.flush();
          dout.close();
          soc.close();
        }
        catch(Exception e){
          e.printStackTrace(); 
      }
    }
    public static String classificacao(double idade){
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
  }