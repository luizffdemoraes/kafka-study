# Estudos sobre Kafka: Produtores, Consumidores e streams

<h1 align="center">
<a href="https://kafka.apache.org/"> Como funciona o Apache Kafka?</a>
</h1>

### O Apache Kafka é composto por alguns componentes principais:

<b>Mensagens:</b> Um dado (ou evento) no Kafka é chamado de mensagem e um conjunto de mensagens é chamado de lote (ou batch);<br>
<b>Tópicos:</b> Local onde as mensagens são armazenadas;<br>
<b>Partições:</b> Os tópicos são divididos em partições;<br>
Segmentos de log:</b> As mensagens do Kafka são escritas em arquivos de logs dentro das partições;<br>
<b>Broker:</b> É o servidor do Kafka, responsável por receber as mensagens dos producers, escrever as mensagens no disco e disponibilizar para os consumers;<br>
<b>Producer:</b> Serviço(s) responsável(eis) por enviar enviar as mensagens para o Kafka;<br>
<b>Consumer:</b> Serviço(s) responsável(eis) por ler as mensagens do Kafka.<br>
No Kafka, um dado (ou evento) é imutável e é chamado de mensagem. Vindo de um contexto de banco de dados, cada tópico seria uma tabela, e cada mensagem seria uma linha dela. Para ter mais eficiência, as mensagens no Kafka são escritas em batches (ou mini batches).

<h1 align="center">
    Kafka Cluster
</h1>

Um cluster de Kafka é basicamente um conjunto de brokers. Esses brokers, de uma forma mais simples, podem ser chamados de intermediários ou facilitadores. Cada broker é responsável por armazenar os dados de uma partição. Ou seja, cada broker é um server.

<h1 align="center">
    Replication Factor
</h1>

E o que aconteceria se, em algum momento em que estivéssemos consumindo alguma informação, um de nossos brokers saísse do ar? Perderíamos todas as informações?

O Kafka, justamente por trabalhar de forma distribuída, possui um recurso excelente chamado de Replication Factor. Ou seja, ele consegue replicar a informação de uma partição em brokers diferentes.

<h1 align="center">
    Consumer Groups
</h1>

Basicamente, as informações de uma partição podem ser lidas por somente um consumer este alocado em um consumer group. Ao mesmo tempo, você pode ter diversos consumers dentro de um mesmo grupo, organizando-se entre si para definir qual consumir lerá determinada partição.


## Comandos importantes utilizandos durante as aulas utilizando windows

### Iniciar zookeeper

```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

### Iniciar kafka

```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```


### Criar topic

```
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic LOJA_NOVO_PEDIDO
```


### Verificar criação do topic

```
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092 
```

### Enviar mensagens para o topic

```
.\bin\windows\kafka-console-producer.bat  --broker-list localhost:9092 --topic LOJA_NOVO_PEDIDO
```

### Consumir as mensagens do topic do inicio

```
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO --from-beginning
```

### Verificar descrição do topic

```
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe 
```

### Reparticionando novos tópicos
Alterar o arquivo server.properties dentro da pasta kafka_2.13-3.6.0\config.:

```
num.partitions=3
```
### Alterar pasta de armazenamento de log Kafka
Alterar o arquivo server.properties dentro da pasta kafka_2.13-3.6.0\config.:

```
log.dirs=CAMINHO_DESEJADO
```

### Alterar pasta de armazenamento de log Zookeeper
Alterar o arquivo zookeeper.properties dentro da pasta kafka_2.13-3.6.0\config.:

```
dataDir=CAMINHO_DESEJADO
```

### Reparticionando um tópico existente
```
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --alter --topic ECOMMERCE_NEW_ORDER --partitions 3
```

<b>Observação.:</b> A partir do Apache Kafka versão 2.8.0 e posterior, o suporte direto ao ZooKeeper para a gestão de tópicos foi removido. Em vez disso, você deve usar o Kafka Admin API diretamente ou a ferramenta kafka-topics.sh com as opções apropriadas.

### Verificar grupos de consumo
```
.\bin\windows\kafka-consumer-groups.bat --all-groups --bootstrap-server localhost:9092 --describe
```

<h1 align="center">
    Dúvidas
</h1>

Em um sistema bancário, um usuário inicia o processo de uma transação bancária, qual abordagem é baseada em produtores e consumidores de mensagens?

A requisição é feita por um site ou app cujo servidor envia uma mensagem de pedido de transação bancária.

```
Essa abordagem mistura o processo síncrono e a mensagem.
```

Qual a importância das chaves na paralelização de tarefas?

Ela é peça fundamental para paralelizar o processamento de mensagens em um tópico dentro do mesmo consumer group.

```
A chave é usada para distribuir a mensagem entre as partições existentes e consequentemente entre as instâncias de um serviço dentro de um consumer group.
```

Qual a vantagem de criar nossa própria camada?

Adotar boas práticas como evitar código duplicado.

```
Definir padrões, boas práticas e evitar más práticas, permitindo novos/as devs começar a desenvolver rapidamente código pronto para produção.
```

<h1 align="center">
    Referências
</h1>

https://kafka.apache.org/documentation/

https://www.alura.com.br/formacao-kafka

https://fullcycle.com.br/apache-kafka-trabalhando-com-mensageria-e-real-time/