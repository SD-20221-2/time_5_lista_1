import Pyro5.api

server = Pyro5.api.Proxy("PYRONAME:nomear")

valor = input('Digite o valor da carta: ')
naipe = input('Digite o naipe da carta: 1= ouros, 2= paus, 3= copas, 4= espadas: ')

print(server.nomeCarta(valor, naipe))