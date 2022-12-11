from xmlrpc.server import SimpleXMLRPCServer
class RPC:
    _metodos_rpc = ['classificacao']
    def __init__(self, direcao):
        self._servidor = SimpleXMLRPCServer(direcao, allow_none=True)
        for metodo in self._metodos_rpc:
            self._servidor.register_function(getattr(self, metodo))

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
    def iniciar_servidor(self):
        self._servidor.serve_forever()
if __name__ == '__main__' :
    rpc = RPC(('', 20064))
    print("Servidor RPC iniciado ... ")
    rpc.iniciar_servidor()