import threading
import socket

clients = [] #array de clientes conectados
def main(): #inicia o main

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM) #inicia o servidor

    try: #tenta iniciar o servidor
        server.bind(('localhost', 7777)) #mantem a conexão aberta na porta 7777
        server.listen(10) #permite a conexão simultânea de 10
    except:
        print ('Não foi possível iniciar o servidor...\n')
    
    while True:
        client, addr = server.accept() #aceita a conexão do cliente 
        clients.append(client) #adiciona o cliente no array de clientes

        thread = threading.Thread(target=messagesTreatment, args=[client]) #inicia a thread que trata as mensagens recebidas
        thread.start()

def messagesTreatment(client):
    while True: 
        try: #tenta receber e tratar a mensagem recebida
            msg = client.recv(2048).decode('utf-8') #recebe a mensagem e decodifica de volta para utf-8
            sexo = float(msg) #força a transformação para float
            msg = client.recv(2048).decode('utf-8')
            altura = float(msg)
            peso_ideal = 0
            if sexo == 1:   
                peso_ideal = (72.7*float(altura))-58
                msg = f"O peso ideal para ele é {peso_ideal}"
            elif sexo == 2:
                print(sexo)
                peso_ideal = (62.1*float(altura))-44.7
                msg = f"O peso ideal para ela é {peso_ideal}"
            else:
                print(sexo)
                msg = "Informação errada, tente novamente"

            broadcast(msg, client) #chama a função que envia a mensagem de resposta e qual o cliente que fez a solicitação
        except:
            deleteClient(client) #se não funcionar a conexão, deleta o cliente do array de clientes, pois a conexão foi perdida
            break

def broadcast(msg, client): #função que envia a mensagem
    for clientItem in clients: #pega todos os clientes da lista (adaptado para enviar apenas para o cliente que solicitou mas pode ser para todos)
        if clientItem == client:
            try:
                clientItem.send(msg.encode('utf-8')) # envia a mensagem codificada
            except:
                deleteClient(clientItem) #se não funcionar a conexão, deleta o cliente do array de clientes, pois a conexão foi perdida

def deleteClient(client):
    clients.remove(client) #remove o cliente da lista

main()