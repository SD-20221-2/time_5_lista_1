from xmlrpc.server import SimpleXMLRPCServer
class RPC:
    _metodos_rpc = ['calculaSalarioLiquido']
    def __init__(self, direcao):
        self._servidor = SimpleXMLRPCServer(direcao, allow_none=True)
        for metodo in self._metodos_rpc:
            self._servidor.register_function(getattr(self, metodo))

    def calculaSalarioLiquido(self, nome, nivel, salarioBruto, dependentes):
        salarioBruto = float(salarioBruto)
        dependentes = int(dependentes)
        salarioLiquido = salarioBruto
        if (nivel == 'A'):
            if (dependentes == 0):
                salarioLiquido = salarioBruto - (salarioBruto * 0.03)
            else:
                salarioLiquido = salarioBruto - (salarioBruto * 0.08)
        elif (nivel == 'B'): 
            if (dependentes == 0):
                salarioLiquido = salarioBruto - (salarioBruto * 0.05)
            else:
                salarioLiquido = salarioBruto - (salarioBruto * 0.1)
        elif(nivel == 'C'):
            if (dependentes == 0):
                salarioLiquido = salarioBruto - (salarioBruto * 0.08)
            else:
                salarioLiquido = salarioBruto - (salarioBruto * 0.15)
        elif(nivel == 'D'): 
            if (dependentes == 0):
                salarioLiquido = salarioBruto - (salarioBruto * 0.10)
            else:
                salarioLiquido = salarioBruto - (salarioBruto * 0.17)
        
        return 'O salário líquido do funcionário ' + nome + ' é R$ ' + str(salarioLiquido)

    def iniciar_servidor(self):
        self._servidor.serve_forever()
if __name__ == '__main__' :
    rpc = RPC(('', 20064))
    print("Servidor RPC iniciado ... ")
    rpc.iniciar_servidor()
