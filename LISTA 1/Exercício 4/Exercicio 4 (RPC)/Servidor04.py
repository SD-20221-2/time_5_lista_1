from xmlrpc.server import SimpleXMLRPCServer
class RPC:
    _metodos_rpc = ['classificacao']
    def __init__(self, direcao):
        self._servidor = SimpleXMLRPCServer(direcao, allow_none=True)
        for metodo in self._metodos_rpc:
            self._servidor.register_function(getattr(self, metodo))

    def classificacao(self, altura, sexo):
        print(sexo)
        peso_ideal = 0
        if sexo == 'masculino':   
            peso_ideal = (72.7*float(altura))-58
            return "O peso ideal para ele é ", peso_ideal
        elif sexo == 'feminino':
            peso_ideal = (62.1*float(altura))-44.7
            return "O peso ideal para ela é ", peso_ideal
        else:
            return "Informação errada, tente novamente"
    def iniciar_servidor(self):
        self._servidor.serve_forever()
if __name__ == '__main__' :
    rpc = RPC(('', 20064))
    print("Servidor RPC iniciado ... ")
    rpc.iniciar_servidor()