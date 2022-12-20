import socket

HOST = 'localhost'
PORT = 5000

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))

valor = input('Digite o valor da carta: ')
naipe = input('Digite o naipe da carta: 1= ouros, 2= paus, 3= copas, 4= espadas ')

data = (valor + ',' + naipe)

s.sendall(str.encode(data))

data = s.recv(1024)

print(data.decode())