import socket

HOST = 'localhost'
PORT = 5000

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))

idade = input('Idade do funcionário: ')
tempo = input('Tempo de serviço do funcionário: ')

data = (idade + ',' + tempo)

s.sendall(str.encode(data))

data = s.recv(1024)

print(data.decode())