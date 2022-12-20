import xmlrpc.client

server =  xmlrpc.client.ServerProxy("http://localhost:5050")

while(True):
    idade = input('Idade do funcionário: ')
    tempo = input('Tempo de serviço do funcionário: ')
    print(server.podeAposentar(idade, tempo))