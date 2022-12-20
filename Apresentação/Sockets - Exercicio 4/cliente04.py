import threading 
import socket

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # registrando o cliente

    try: #tenta fazer a conexão na porta 7777 e caso não dê certo, avisa
        client.connect(('localhost', 7777)) 
    except:
        return print('Não foi possível conectar ao servidor\n')
    
    username = input('Usuário> ') #cria um nome para o cliente que está se conectando
    print('\nConectado')

    thread1 = threading.Thread(target=receiveMessages, args=[client, username]) #declara as threads de recepção e envio de mensagem
    thread2 = threading.Thread(target=sendMessages, args=[client])

    thread1.start() #inicia as threads
    thread2.start()


def receiveMessages(client, username): #função que recebe mensagem do servidor
    while True:
        try: #tenta receber a mensagem, caso não dê certo, avisa
            msg = client.recv(2048).decode('utf-8') #decodificaão de bytes para string
            print('Usuário '+ username + ': ' + msg+'\n') 

        except:
            print('Não foi possível permanecer conectado no servidor\n')
            print('Pressione <enter> para prosseguir...')
            client.close() #encerra a conexão caso tenha algum erro
            break

def sendMessages(client): #função que envia mensagem ao servidor
    while True:
        try: #tenta receber a mensagem, caso não dê certo, avisa
            sexo = input('\n') 
            client.send(sexo.encode('utf-8')) #envia, codificando de string para bytes
            altura = input('\n')
            client.send(altura.encode('utf-8'))
        except:
            return
    pass 

main()