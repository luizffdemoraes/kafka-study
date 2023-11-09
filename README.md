# Estudos sobre Kafka: Produtores, Consumidores e streams

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



