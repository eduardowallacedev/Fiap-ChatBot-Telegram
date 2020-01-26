# Projeto FIAP ChatBot com Telegram
Projeto Java Platform - ChatBot 

Elaborado em Dezembro de 2019

Este projeto foi criado para implementar um bot integrado com o Telegram que simule um assistente pessoal de um banco.
Foram disponibilizados os comportamentos básicos de um banco, como depositar,sacar,abrir conta e consultar o extrato.

# 2. Componentes e Frameworks

# Maven
O Maven é uma ferramenta para gerenciamento das bibliotecas e plug-ins de
um ou mais repositórios de forma dinâmica utilizando XML para descrever o projeto.

# Java API for Telegram
O Java API for Telegram possibilita o desenvolvimento de um bot personalizado conforme a necessidade do projeto.
Link da API:
[https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/2.1.2/](https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/2.1.2/)

# Prevlayer
Api de persistência usada para persistir os dados em arquivo.

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
 - Pacote de constantes e configurações da integração com o bot do telegram.

 fiap.chatbot.manager
 - Pacote com o gerenciador de envio de mensagens ao telegram e gerenciamento da sessões online.

 fiap.chatbot.model
 - Pacote com a camada model

 fiap.chatbot.DAO
 - Pacote de persistência em arquivo.

 fiap.chatbot.utils
 - Pacote de Utilidades


# 4. Pré-requisitos
 - Tecnologias necessárias.
 
    1- Para executar o projeto, será necessÃ¡rio ter o JRE 8 ou JDK 8 instalado.
 
    2- Utilizar uma ide para execução. (Recomendo o Eclipse)
 
 
# 5. Utilização do Bot

- Funcionalidades

 - Para Utilização do bot, enviar o comando /start para o bot com o nome configurado em BOT_NOME na classe BotConfig;
 - Ao executar a aplicação, será exido uma tela inicial de boas-vindas;
 - Criação de conta
 - Modificação de conta
 - Exibição dos dados do titular 
 - Depósito
 - Saque (Desconta Tarifa)
 - Extrato (Desconta Tarifa)
 - Exibe os lançamentos detalhada com total
 - Exibe as retiradas com total
 - Exibe as tarifas com total dos serviços utilizados
 - Tela de ajuda
 

# Executando o projeto

Acessar o diretório **src** no pacote **br.fiap.telegram** existe um arquivo chamado **Main.java** . Abra esse arquivo e execute **Run**

 
# Javadoc

[Acesse clicando aqui](doc/index.html)


# Referências

- Documentação do Telegram utilizada

  [https://core.telegram.org/bots](https://core.telegram.org/bots)
  	
  [https://core.telegram.org/bots/api](https://core.telegram.org/bots/api)

 
