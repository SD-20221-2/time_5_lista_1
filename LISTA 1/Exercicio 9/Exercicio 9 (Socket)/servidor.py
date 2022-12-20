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
    
    valor, naipe = data.split(',')

    if naipe == "1":
        naipe = "Ouros"

    elif naipe == "2":
        naipe = "Paus"
    
    elif naipe == "3":
        naipe = "Copas"
    
    elif naipe == "4":
        naipe = "Espadas"
    
    if valor == "1":
        valor = "Ás"
    
    elif valor == "2":
        valor = "Dois"
    
    elif valor == "3":
        valor = "Três"
    
    elif valor == "4":
        valor = "Quatro"
    
    elif valor == "5":
        valor = "Cinco"
        
    elif valor == "6":
        valor = "Seis"
    
    elif valor == "7":
        valor = "Sete"
        
    elif valor == "8":
        valor = "Oito"
    
    elif valor == "9":
        valor = "Nove"
    
    elif valor == "10":
        valor = "Dez"
    
    elif valor == "11":
        valor = "Dama"
    
    elif valor == "12":
        valor = "Valete"
    
    elif valor == "13":
        valor = "Rei"

    data = (valor + " de " + naipe)
    
    conn.sendall(data.encode())
conn.close()