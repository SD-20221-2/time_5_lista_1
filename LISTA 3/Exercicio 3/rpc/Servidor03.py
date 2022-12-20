from xmlrpc.server import SimpleXMLRPCServer
import threading
class RPC:
    _metodos_rpc = ['calculaMedia']
    def __init__(self, direcao):
        self._servidor = SimpleXMLRPCServer(direcao, allow_none=True)
        for metodo in self._metodos_rpc:
            self._servidor.register_function(getattr(self, metodo))
        

    def calculaMedia(self, nota1, nota2, nota3):
        nota1 = float(nota1)
        nota2 = float(nota2)
        nota3 = float(nota3)
        media = float((nota1 + nota2)/2.0)
        if (media>= 7.0):   
            return "Aprovado"
        elif (media < 3.0):
            return "Reprovado"
        elif((media + nota3)/2.0 >= 5.0):
            return "Aprovado"
        else:
            return "Reprovado"

            
    def iniciar_servidor(self):
        self._servidor.serve_forever()
if __name__ == '__main__' :
    rpc = RPC(('', 20064))
    print("Servidor RPC iniciado ... ")
    thread = threading.Thread(target=rpc.iniciar_servidor, args=[])
    thread.start()
