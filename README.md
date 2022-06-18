# Envio e recebimento de mensagens do AWS SQS usando JMS

Este projeto é um teste para envio e recebimento de mensagens do SQS utilizando JMS.

Para enviar uma mensagem, Acesse http://localhost:8080/envia?msg=SUA_MENSAGEM_AQUI

Também existem listeners para receber eventos de criação e exclusão de arquivos do S3 de forma.

Este projeto usa o LocaStack para simular o ambiente AWS.

### Executando 

Ambiente:
```sh
docker compose up
```

Basta rodar a aplicação

Comandos:

```sh
#Envia arquivo para o bucket
 awslocal s3api put-object --bucket bucket-teste --key <key> --body <file-name>

#Comando para receber uma mensagem da fila de eventos de upload
 awslocal sqs receive-message --queue-url=http://localhost:4566/000000000000/upload-file-event-sqs

#Comando para apagar um arquivo do bucket
 awslocal s3api delete-object --bucket tutorial-bucket --key <key>

#Comando para receber uma mensagem da fila de eventos de exclusao de arquivos do bucket
 awslocal sqs receive-message --queue-url=http://localhost:4566/000000000000/delete-file-event-sqs
```