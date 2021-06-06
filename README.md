# Discord Bot 

Este projeto tem como objetivo auxiliar a criação de um Bot no [Discord](https://discord.com/) integrado com o [IBM Watson](https://www.ibm.com/br-pt/watson).

### Como criar meu Bot

Primeiramente devemos criar um Bot no site de desenvolvedor do Discord para depois referenciarmos ele em nosso sistema. Você pode fazer isso utilizando este [tutorial](https://canaltech.com.br/apps/como-criar-bots-para-responder-discord/).

Feito isso, anote o Token gerado, utilizaremos ele mais tarde.

### Criando um assitente no Watson 

Para criar um assistente, você pode seguir este [tutorial](https://cloud.ibm.com/docs/assistant?topic=assistant-getting-started&locale=pt-BR). Nesta etapa, você deve anotar os seguintes itens:

- API Key
- Assistant ID
- Watson URL

### Pré-requisitos

Para executar nosso Bot, vamos utilizar o [Docker](https://www.docker.com/), então para isso, você deve instala-lo em sua máquina.

### Rodando o programa

Para rodar nossa programa, você pode executar o comando abaixo em um terminal:

```shell
	docker run -it -e WATSON_API_KEY='your watson api key' \
			   -e WATSON_ASSISTANT_ID='your watson assistant ID' \
			   -e WATSON_URL='your watson URL' \
			   -e BOT_TOKEN='your discord bot token' \
			   -e BOT_PREFIX='bot prefix, ex: !felix' \
			   felixgilioli/discordbot
```
