import jpysocket
#biblioteca que permite decodificar e codificar strings recebidas e enviadas pelo java socket
import socket

#conexões no endereço correto
host='localhost' 
port=6666    

#criando e conectando o socket
s=socket.socket()
s.connect((host,port))
print("Socket conectado!")

#inserção de informação e envio para o servidor
idade = input("Digite a idade \n")
msgsend=jpysocket.jpyencode(idade) #criptografia
s.send(msgsend)

#recepção da resposta
msgrecv=s.recv(1024)
msgrecv=jpysocket.jpydecode(msgrecv) #descriptografia
print(msgrecv)


s.close() 
print("Conexão finalizada!")