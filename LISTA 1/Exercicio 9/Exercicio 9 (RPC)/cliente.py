import xmlrpc.client

server =  xmlrpc.client.ServerProxy("http://localhost:5050")

while(True):
    valor = input('Digite o valor da carta: ')
    naipe = input('Digite o naipe da carta: 1= ouros, 2= paus, 3= copas, 4= espadas: ')
    print(server.nomeCarta(valor, naipe))