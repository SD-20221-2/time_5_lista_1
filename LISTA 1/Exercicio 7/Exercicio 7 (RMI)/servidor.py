import Pyro5.api

@Pyro5.api.expose
class aposentadoria(object):
    def podeAposentar(self, idade, tempo):
        
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

daemon = Pyro5.server.Daemon(host='localhost')
ns = Pyro5.api.locate_ns()
uri = daemon.register(aposentadoria)
ns.register("aposentadoria", uri)

print("Pronto para iniciar")

daemon.requestLoop()