import socket

HOST = 'localhost'
PORT = 5000

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST,PORT))
s.listen()

print('Aguardando conexão')

conn, ender = s.accept()

print('Conectando em', ender)

while True:
    data = conn.recv(1024)
    
    if not data:
        print('Fechando conexão')
        break

    data = data.decode()
    
    idade, tempo = data.split(',')

    idade = int(idade)
    tempo = int(tempo)

    if idade >= 65:
       data = 'O funcionário pode aposentar'
    
    elif tempo >= 30:
        data = 'O funcionário pode aposentar'

    elif idade >= 60 and tempo >= 20:
        data = 'O funcionário pode aposentar'
    
    else:
       data = 'O funcionário não pode aposentar'

    conn.sendall(data.encode())
conn.close()




