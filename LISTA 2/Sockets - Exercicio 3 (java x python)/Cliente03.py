import jpysocket
import socket
import struct

# create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# get local machine name
host = socket.gethostname()

# connection to hostname on the port.
client_socket.connect((host, 7777))

# send 3 float numbers to the server
nota1 = 3.5
nota2 = 7.0
nota3 = 8.5
client_socket.send(struct.pack('!d', nota1))
client_socket.send(struct.pack('!d', nota2))
client_socket.send(struct.pack('!d', nota3))

# receive data from the server
result = client_socket.recv(1024)
result = jpysocket.jpydecode(result)
print(result)

# close the client socket
client_socket.close()
