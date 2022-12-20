from xmlrpc.server import SimpleXMLRPCServer

def podeAposentar(idade, tempo):
    
    idade = int(idade)
    tempo = int(tempo)
    
    aposentar = 0
    
    if idade >= 65:
       aposentar = 1
    
    elif tempo >= 30:
        aposentar = 1

    elif idade >= 60 and tempo >= 20:
        aposentar = 1
    
    else:
       aposentar = 0
       
    if aposentar == 1:
        return "Pode aposentar"

    else:
        return "Não pode aposentar"
    
server = SimpleXMLRPCServer(("localhost", 5050))
print("Conectado a porta 5050")
server.register_function(podeAposentar, "podeAposentar")
server.serve_forever()