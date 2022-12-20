#Client RPC
from xmlrpc.client import ServerProxy 
import threading

def inicializa():
    cliente = ServerProxy('http://localhost:20064', allow_none=True) 
    idade = input("Digite a idade do competidor \n")
    print(cliente.classificacao(idade))


if __name__ == "__main__":
    thread = threading.Thread(target=inicializa, args=[])
    thread.start()