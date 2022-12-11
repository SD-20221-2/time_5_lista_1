#Client RPC
from xmlrpc.client import ServerProxy 
cliente = ServerProxy('http://localhost:20064', allow_none=True) 
while True:
    idade = input("Digite a idade do competidor \n")
    print(cliente.classificacao(idade))