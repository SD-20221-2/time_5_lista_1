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
altura = input("Digite a altura \n")
msgsend=jpysocket.jpyencode(altura) #criptografia
s.send(msgsend)

sexo = input("Digite o sexo (1)masc (2)fem \n")
msgsend=jpysocket.jpyencode(sexo) #criptografia
s.send(msgsend)


#recepção da resposta
msgrecv=s.recv(1024)
msgrecv=jpysocket.jpydecode(msgrecv) #descriptografia
print(msgrecv)


s.close() 
print("Conexão finalizada!")