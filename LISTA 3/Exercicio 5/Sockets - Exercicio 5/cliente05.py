import threading 
import socket

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:
        client.connect(('localhost', 7777))
    except:
        return print('Não foi possível conectar ao servidor\n')
    
    username = input('Usuário> ')
    print('\nConectado')

    thread1 = threading.Thread(target=receiveMessages, args=[client, username])
    thread2 = threading.Thread(target=sendMessages, args=[client])

    thread1.start()
    thread2.start()


def receiveMessages(client, username):
    while True:
        try:
            msg = client.recv(2048).decode('utf-8') #bytes para string
            print('Usuário '+ username + ': ' + msg+'\n')

        except:
            print('Não foi possível permanecer conectado no servidor\n')
            print('Pressione <enter> para prosseguir...')
            client.close()
            break

def sendMessages(client):
    while True:
        try:
            msg = input('\n')
            client.send(msg.encode('utf-8')) #string para bytes
        except:
            return
    pass 

main()