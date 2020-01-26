# Projeto FIAP ChatBot com Telegram
Projeto Java Platform - ChatBot 

Elaborado em Dezembro de 2019

Este projeto foi criado para implementar um bot integrado com o Telegram que simule um assistente pessoal de um banco.
Foram disponibilizados os comportamentos b�sicos de um banco, como depositar,sacar,abrir conta e consultar o extrato.

# 2. Componentes e Frameworks

# Maven
O Maven � uma ferramenta para gerenciamento das bibliotecas e plug-ins de
um ou mais reposit�rios de forma din�mica utilizando XML para descrever o projeto.

# Java API for Telegram
O Java API for Telegram possibilita o desenvolvimento de um bot personalizado conforme a necessidade do projeto.
Link da API:
[https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/2.1.2/](https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/2.1.2/)

# Prevlayer
Api de persist�ncia usada para persistir os dados em arquivo.

[http://prevlayer.org/](http://prevlayer.org/)

[https://mvnrepository.com/artifact/org.prevayler](https://mvnrepository.com/artifact/org.prevayler)

# Java Logging
Ferramenta de log para Console.

[https://docs.oracle.com/javase/7/docs/api/java/util/logging/package-summary.html](https://docs.oracle.com/javase/7/docs/api/java/util/logging/package-summary.html)


# 3. Estrutura de pacotes do Projeto

 fiap.chatbot
 - Pacote principal com os arquivos do projeto.

 fiap.chatbot.bot
 - Pacote para buscar as mensagens do telegram.

 fiap.chatbot.options
 - Pacote com todas as classes de comandos a serem executados.

 fiap.chatbot.config
 - Pacote de constantes e configura��es da integra��o com o bot do telegram.

 fiap.chatbot.manager
 - Pacote com o gerenciador de envio de mensagens ao telegram e gerenciamento da sess�es online.

 fiap.chatbot.model
 - Pacote com a camada model

 fiap.chatbot.DAO
 - Pacote de persist�ncia em arquivo.

 fiap.chatbot.utils
 - Pacote de Utilidades


# 4. Pr�-requisitos
 - Tecnologias necess�rias.
 
    1- Para executar o projeto, ser� necessário ter o JRE 8 ou JDK 8 instalado.
 
    2- Utilizar uma ide para execu��o. (Recomendo o Eclipse)
 
 
# 5. Utiliza��o do Bot

- Funcionalidades

 - Para Utiliza��o do bot, enviar o comando /start para o bot com o nome configurado em BOT_NOME na classe BotConfig;
 - Ao executar a aplica��o, ser� exido uma tela inicial de boas-vindas;
 - Cria��o de conta
 - Modifica��o de conta
 - Exibi��o dos dados do titular 
 - Dep�sito
 - Saque (Desconta Tarifa)
 - Extrato (Desconta Tarifa)
 - Exibe os lan�amentos detalhada com total
 - Exibe as retiradas com total
 - Exibe as tarifas com total dos servi�os utilizados
 - Tela de ajuda
 

# Executando o projeto

Acessar o diret�rio **src** no pacote **br.fiap.telegram** existe um arquivo chamado **Main.java** . Abra esse arquivo e execute **Run**

 
# Javadoc

[Acesse clicando aqui](doc/index.html)


# Refer�ncias

- Documenta��o do Telegram utilizada

  [https://core.telegram.org/bots](https://core.telegram.org/bots)
  	
  [https://core.telegram.org/bots/api](https://core.telegram.org/bots/api)

 
