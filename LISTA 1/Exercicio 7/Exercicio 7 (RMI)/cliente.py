import Pyro5.api

server = Pyro5.api.Proxy("PYRONAME:aposentadoria")

idade = input('Idade do funcionário: ')
tempo = input('Tempo de serviço do funcionário: ')

print(server.podeAposentar(idade, tempo))