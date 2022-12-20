import threading
import socket

clients = []
def main():

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:
        server.bind(('localhost', 7777))
        server.listen(10)
    except:
        print ('Não foi possível iniciar o servidor...\n')
    
    while True:
        client, addr = server.accept()
        clients.append(client)

        thread = threading.Thread(target=messagesTreatment, args=[client])
        thread.start()

def messagesTreatment(client):
    while True: 
        try:
            msg = client.recv(2048).decode('utf-8')
            idade = float(msg)
            if idade<5:   
                msg = "Idade insuficiente para a competição"
            elif (idade >= 5 and idade <= 7):
                msg = "Categoria: infantil A"
            elif(idade >= 8 and idade <= 10):
                msg = "Categoria: infantil B"
            elif(idade >= 11 and idade <= 13):
                msg = "Categoria: juvenil A"
            elif(idade >= 14 and idade <= 17):
                msg = "Categoria: juvenil B"
            else:
                msg = "Categoria: Maiores de 18 anos"
            broadcast(msg, client)
        except:
            deleteClient(client)
            break

def broadcast(msg, client):
    for clientItem in clients:
        if clientItem == client:
            try:
                clientItem.send(msg.encode('utf-8'))
            except:
                deleteClient(clientItem)

def deleteClient(client):
    clients.remove(client)

def classificacao(self, idade):
        idade = float(idade)
        if idade<5:   
            return "Idade insuficiente para a competição"
        elif (idade >= 5 and idade <= 7):
            return "Categoria: infantil A"

        elif(idade >= 8 and idade <= 10):
            return "Categoria: infantil B"

        elif(idade >= 11 and idade <= 13):
            return "Categoria: juvenil A"
        elif(idade >= 14 and idade <= 17):
            return "Categoria: juvenil B"
        else:
            return "Categoria: Maiores de 18 anos"

main()