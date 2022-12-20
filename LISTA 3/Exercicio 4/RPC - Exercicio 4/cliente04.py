#Client RPC
from xmlrpc.client import ServerProxy 
import threading

def inicializa():
    cliente = ServerProxy('http://localhost:20064', allow_none=True) 
    altura = input("Digite a altura \n")
    sexo = input("(1) Masculino (2) Feminino \n")
    print(cliente.classificacao(altura, sexo))


if __name__ == "__main__":
    thread = threading.Thread(target=inicializa, args=[])
    thread.start()