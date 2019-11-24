# Projeto FIAP ChatBot com Telegram
Projeto Java Platform - ChatBot 

Elaborado em Novembro de 2019

# Objetivo

O objetivo deste projeto é criar um bot com o Telegram que simule um assistente pessoal de um banco.
Serão implementados os comportamentos básicos de um banco, como depositar,sacar,abrir conta, dentre outras funcionalidades.

# 2. Componentes e Frameworks

# Maven
O Maven é uma ferramenta para gerenciamento das bibliotecas e plug-ins de
um ou mais repositórios de forma dinâmica utilizando um XML para descrever o projeto.

# Java API for Telegram
O Java API for Telegram possibilita o desenvolvimento de um bot personalizado conforme a necessidade do projeto.
Website da API:
[https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/2.1.2/](https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/2.1.2/)

# Prevlayer
Api de persistência usada para persistir os dados em arquivo conforme documento de requisitos.

[http://prevlayer.org/](http://prevlayer.org/)

[https://mvnrepository.com/artifact/org.prevayler](https://mvnrepository.com/artifact/org.prevayler)

# Java Logging
Ferramenta padrão de log do java em Console.

[https://docs.oracle.com/javase/7/docs/api/java/util/logging/package-summary.html](https://docs.oracle.com/javase/7/docs/api/java/util/logging/package-summary.html)


# 3. Estrutura de pacotes do Projeto

 fiap.chatbot
 - Pacote principal com os arquivos do projeto.

 fiap.chatbot.bot
 - Pacote com a inteligência do Bot para buscar as mensagens do telegram.

 fiap.chatbot.command
 - Pacote com todas as classes de comandos a serem executados.

 fiap.chatbot.comparator
 - Pacote com o comparator de cliente.

 fiap.chatbot.constants
 - Pacote de constantes

 fiap.chatbot.manager
 - Pacote com o gerenciador de envio de mensagens ao telegram e gerenciamento da sessão do cliente.

 fiap.chatbot.model
 - Pacote com a camada model

 fiap.chatbot.prevayler
 - Pacote prevlayer de persistência em arquivo.

 fiap.chatbot.utils
 - Pacote de Utilidades


# 4. Pré-requisitos
 - Tecnologias necessárias.
 
    1- Para executar o projeto é necessário ter o JRE 8 ou JDK 8 instalado.
 
    	2- Utilizar uma ide para execução. (Recomendo o Eclipse)
 
 
# 5. Utilização do Bot

- Funcionalidades

 - Para Utilização do bot, enviar o comando /start para o bot com o nome @WallaceBankBot.
 - Tela de boas-vindas do banco
 - Criação de conta
 - Modificação de conta
 - Exibição dos dados do titular 
 - Depósito
 - Saque (Desconta Taxa)
 - Solicitação de extrato (Desconta Taxa)
 - Solicitação de empréstimo
 - Exibição de saldo devedor do empréstimo e prazo de pagamento
 - Exibição dos lançamentos detalhada com total
 - Exibição das retiradas com total
 - Exibição das tarifas de serviços, com total dos serviços utilizados
 - Tela de ajuda
 

# Executando o projeto

Acessar o diretório **src** no pacote **br.fiap.chatbot** existe um arquivo chamado **Main.java** . Abra esse arquivo e execute **Run**

 
# Javadoc

[Acesse clicando aqui](doc/index.html)


# Referências

- Documentação do Telegram utilizada

  [https://core.telegram.org/bots](https://core.telegram.org/bots)
  	
  [https://core.telegram.org/bots/api](https://core.telegram.org/bots/api)

 
