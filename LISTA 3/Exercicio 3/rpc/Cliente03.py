#Client RPC
from xmlrpc.client import ServerProxy 
import threading

def inicializa():
    cliente = ServerProxy('http://localhost:20064', allow_none=True) 
    nota1 = input("Digite a nota 1 \n")
    nota2 = input("Digite a nota 2 \n")
    nota3 = input("Digite a nota 3 \n")

    print(cliente.calculaMedia(nota1, nota2, nota3))


if __name__ == "__main__":
    thread = threading.Thread(target=inicializa, args=[])
    thread.start()
