from xmlrpc.server import SimpleXMLRPCServer

def nomeCarta(valor, naipe):
    
    valor = int(valor)
    naipe = int(naipe)
    
    if naipe == 1:
        naipe = "Ouros"

    elif naipe == 2:
        naipe = "Paus"
    
    elif naipe == 3:
        naipe = "Copas"
    
    elif naipe == 4:
        naipe = "Espadas"
    
    if valor == 1:
        valor = "Ás"
    
    elif valor == 2:
        valor = "Dois"
    
    elif valor == 3:
        valor = "Três"
    
    elif valor == 4:
        valor = "Quatro"
    
    elif valor == 5:
        valor = "Cinco"
        
    elif valor == 6:
        valor = "Seis"
    
    elif valor == 7:
        valor = "Sete"
        
    elif valor == 8:
        valor = "Oito"
    
    elif valor == 9:
        valor = "Nove"
    
    elif valor == 10:
        valor = "Dez"
    
    elif valor == 11:
        valor = "Dama"
    
    elif valor == 12:
        valor = "Valete"
    
    elif valor == 13:
        valor = "Rei"
        
    return (f'{valor} de {naipe}')
    
server = SimpleXMLRPCServer(("localhost", 5050))
print("Conectado a porta 5050")
server.register_function(nomeCarta, "nomeCarta")
server.serve_forever()