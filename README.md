# AstroMonitor

## Descrição
O AstroMonitor é um aplicativo desenvolvido em Java que utiliza a API de Objetos Próximos à Terra da NASA (NEO - Near Earth Objects) para monitorar e analisar asteroides e cometas que passam perto da Terra. O sistema realiza chamadas à API para coletar dados sobre esses objetos, como tamanho, velocidade, distância da Terra e potencial perigo, e apresenta os resultados através de uma interface gráfica.

## Funcionalidades
- Monitoramento e análise de asteroides e cometas próximos à Terra.
- Coleta de dados como tamanho, velocidade, distância e potencial perigo.
- Apresentação dos resultados através de uma interface gráfica desenvolvida com Swing ou uma interface web separada que se comunica com o backend RESTFULL.
- Persistência dos dados coletados em um banco de dados MySQL.
- Menu de navegação com diversas opções para interação com o aplicativo.

## Equipe de Desenvolvimento

Projeto desenvolvido pelos integrantes:

- Larissa Helfer (Dev Front-end)
- Nicolas Lopes Redieske (Dev Back-end)
- Ryan dos Reis Marques (Design Front-end)
- Vitor Rafael Miorando (Dev Back-end)

## Menu de Navegação

- **Dashboard**
- **Dados**
  - Atualizar dados
- **Sobre**
- **Sair**

## Usuario
- **Login**
- **Cadastro de usuario**
  - Preferencias (Chave API)

## Requisitos
- **Linguagem**: Java
- **Biblioteca de Interface Gráfica**: Swing ou um framework utilizado o padrão RESTFUL
- **Banco de Dados**: MySQL
- **Web Service**: Tomcat

## Configuração do Banco de Dados
1. Baixe o MySQL e o [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) Caso preferir pode baixar o [XAMP](https://www.apachefriends.org/pt_br/index.html) para subir o MySQL
2. Crie um banco de dados MySQL:
    ```sql
    CREATE DATABASE astromonitor;
3. Utilize o script `docs/database_schema.sql` para criar as tabelas necessárias:

## Instalação Apache Tomcat

### Passos para Instalação no Windows

#### Baixar e Extrair o Tomcat:

1. Baixe o arquivo ZIP do Tomcat em [Apache Tomcat Downloads](https://tomcat.apache.org/download-90.cgi).
2. Extraia o arquivo ZIP no local de sua preferencia.

### Passos para Instalação no Linux

#### Baixar e Extrair o Tomcat:

1. Baixe o arquivo TAR.GZ do Tomcat em [Apache Tomcat Downloads](https://tomcat.apache.org/download-90.cgi).
2. Extraia o arquivo TAR.GZ no local de sua preferencia.

## Como Executar o Back-End
1. Clone o repositório:
   ```bash
   git clone https://github.com/nicolaslopess/AstroMonitor.git
2. Baixe o [JDK](https://www.oracle.com/br/java/technologies/downloads/#java17).
2. Importe o projeto para a sua IDE Java de preferência (NetBeans, IntelliJ, etc.) nesse projeto foi utilizado [NetBeans](https://netbeans.apache.org/front/main/index.html).
3. Configure a conexão com o banco de dados MySQL no arquivo `AstroMonitor/src/main/java/br/com/astromonitor/astromonitor/utils/ConnectionDB.java`.
4. Compile o projeto com as dependencias (assim o NetBeans vai baixar todas as dependencias do projeto).
- Faça os passos a seguir de configuração do Tomcat no NetBeans e execute o projeto.
- Vai abrir uma paginal Web `http://localhost:8080/` com a escrita `API java Iniciada`.

### Deploy de Aplicações no Tomcat com NetBeans

#### Adicionar o Tomcat ao NetBeans:

- Vá para `Services` > `Servers` > `Add Server`.
- Selecione `Apache Tomcat or TomEE` e configure o caminho do Tomcat e as credenciais de administrador.

#### Executar Projeto no NetBeans:

- Clique com o botão direito no projeto e selecione `Properties`.
- Configure o servidor Tomcat na aba `Run`.
- Selecione o Tomcat e clique em `ok`.

## Como executar Front-End

1. Baixe e instale o [Node.js](https://nodejs.org/en/) `v16.4.0`.
- Caso já tenha o Node.js instalado deve mudar a versão para `v16.4.0` pode ser usado o [nvm](https://github.com/coreybutler/nvm-windows/releases) para mudar a versão.
- Para mudar a versão utilize esse comando:
   ```bash
   nvm install 16.4.0
   nvm use 16.20.0
3. Baixe [npm](https://www.npmjs.com/) ou [Yarn](https://yarnpkg.com/).

### Adicionando dependencias do Node.js

1. Execute o comando abaixo no diretorio do `AstroMonitor-React/` para baixar as dependencias:
   ```bash
   npm install --force
2. Para iniciar o projeto:
   ```bash
   npm start
- Vai abrir uma paginal Web `http://localhost:3000/login`.

## Documentação da API da NASA

A API de Objetos Próximos à Terra da NASA (NEO) fornece informações sobre asteroides e cometas que passam perto da Terra. Você pode acessar a documentação completa e obter uma chave de API gratuita em: [NASA API Documentation](https://api.nasa.gov/).

## Documentação de processos

A documentação com o processos utilizados no desenvolvimento esta em `docs/` junto com os materias de Design