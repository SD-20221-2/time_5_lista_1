#Client RPC
from xmlrpc.client import ServerProxy 
cliente = ServerProxy('http://localhost:20064', allow_none=True) 
while True:
    nome = input("Digite o nome do funcionário: \n")
    nivel = input("Digite o nível: \n")
    salarioBruto = input("Digite o salário bruto: \n")
    dependentes = input("Digite o número de dependentes: \n")
    print(cliente.calculaSalarioLiquido(nome, nivel, salarioBruto, dependentes))
