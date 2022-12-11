#Client RPC
from xmlrpc.client import ServerProxy 
cliente = ServerProxy('http://localhost:20064', allow_none=True) 
while True:
    altura = input("Digite a altura \n")
    sexo = input("(1) Masculino (2) Feminino \n")
    print(cliente.classificacao(altura, sexo))