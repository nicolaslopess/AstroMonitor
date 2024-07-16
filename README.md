# AstroMonitor

## Descrição
O AstroMonitor é um aplicativo desenvolvido em Java que utiliza a API de Objetos Próximos à Terra da NASA (NEO - Near Earth Objects) para monitorar e analisar asteroides e cometas que passam perto da Terra. O sistema realiza chamadas à API para coletar dados sobre esses objetos, como tamanho, velocidade, distância da Terra e potencial perigo, e apresenta os resultados através de uma interface gráfica.

## Funcionalidades
- Monitoramento e análise de asteroides e cometas próximos à Terra.
- Coleta de dados como tamanho, velocidade, distância e potencial perigo.
- Apresentação dos resultados através de uma interface gráfica desenvolvida com Swing ou uma interface web separada que se comunica com o backend Full REST.
- Persistência dos dados coletados em um banco de dados MySQL.
- Menu de navegação com diversas opções para interação com o aplicativo.

## Menu de Navegação
- **Arquivo**
  - Dashboard
  - Sair
- **Dados**
  - Atualizar dados
  - Resultados
- **Configurações**
  - Preferências
  - [Outras subopções conforme necessário]
- **Ajuda**
  - Sobre

## Requisitos
- **Linguagem**: Java
- **Biblioteca de Interface Gráfica**: Swing
- **Banco de Dados**: MySQL

## Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/nicolaslopess/AstroMonitor.git
2. Importe o projeto para a sua IDE Java de preferência (NetBeans, IntelliJ, etc.).
3. Configure a conexão com o banco de dados MySQL no arquivo `config.properties`.
4. Compile e execute o projeto.

## Configuração do Banco de Dados
1. Crie um banco de dados MySQL:
    ```sql
    CREATE DATABASE astromonitor;
2. Utilize o script database_schema.sql para criar as tabelas necessárias:

3. Configure as credenciais de acesso ao banco de dados no arquivo `config.properties`.

## Instalação e Configuração do Apache Tomcat

### Passos para Instalação no Windows

#### Baixar e Extrair o Tomcat:

- Baixe o arquivo ZIP do Tomcat em [Apache Tomcat Downloads](https://tomcat.apache.org/download-90.cgi).
- Extraia o arquivo ZIP para `C:\Tomcat\apache-tomcat-9.0.xx`.

#### Configurar Variáveis de Ambiente:

- Adicione `JAVA_HOME` apontando para o diretório do JDK.
- Adicione o binário do Tomcat ao `PATH`.

#### Configurar Usuário Administrador:

Edite `conf/tomcat-users.xml` e adicione:

```xml
<tomcat-users>
    <role rolename="manager-gui"/>
    <role rolename="admin-gui"/>
    <user username="admin" password="admin_password" roles="manager-gui,admin-gui"/>
</tomcat-users>
```

#### Iniciar o Tomcat:

- Execute `bin/startup.bat`.

#### Verificar a Instalação:

- Acesse `http://localhost:8080` no navegador.

### Passos para Instalação no Linux

#### Baixar e Extrair o Tomcat:

- Baixe o arquivo TAR.GZ do Tomcat em [Apache Tomcat Downloads](https://tomcat.apache.org/download-90.cgi).
- Extraia o arquivo TAR.GZ para `/opt/tomcat`.

```sh
sudo tar xzvf apache-tomcat-9.0.xx.tar.gz -C /opt/tomcat
```

#### Configurar Variáveis de Ambiente:

Adicione `JAVA_HOME` ao `~/.bashrc` ou `~/.profile`:

```sh
export JAVA_HOME=/path/to/jdk
export PATH=$PATH=/opt/tomcat/apache-tomcat-9.0.xx/bin
```

Recarregue o arquivo de perfil:

```sh
source ~/.bashrc
```

#### Configurar Usuário Administrador:

Edite `/opt/tomcat/apache-tomcat-9.0.xx/conf/tomcat-users.xml` e adicione:

```xml
<tomcat-users>
    <role rolename="manager-gui"/>
    <role rolename="admin-gui"/>
    <user username="admin" password="admin_password" roles="manager-gui,admin-gui"/>
</tomcat-users>
```

#### Iniciar o Tomcat:

Execute `bin/startup.sh`:

```sh
cd /opt/tomcat/apache-tomcat-9.0.xx/bin
./startup.sh
```

#### Verificar a Instalação:

- Acesse `http://localhost:8080` no navegador.

### Deploy de Aplicações no Tomcat com NetBeans

#### Adicionar o Tomcat ao NetBeans:

- Vá para `Services` > `Servers` > `Add Server`.
- Selecione `Apache Tomcat or TomEE` e configure o caminho do Tomcat e as credenciais de administrador.

#### Executar Projeto no NetBeans:

- Clique com o botão direito no projeto e selecione `Properties`.
- Configure o servidor Tomcat na aba `Run`.
- Clique em `Run` para implantar e executar a aplicação.

## Documentação da API da NASA

A API de Objetos Próximos à Terra da NASA (NEO) fornece informações sobre asteroides e cometas que passam perto da Terra. Você pode acessar a documentação completa e obter uma chave de API gratuita em: [NASA API Documentation](https://api.nasa.gov/).

### Exemplos de Endpoints

- **Buscar Objetos Próximos à Terra**:

    ```bash
    GET https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=YOUR_API_KEY
    ```

- **Buscar Objetos Próximos à Terra por Data**:

    ```bash
    GET https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=YOUR_API_KEY
    ```

- **Buscar Detalhes de um Objeto**:

    ```bash
    GET https://api.nasa.gov/neo/rest/v1/neo/OBJECT_ID?api_key=YOUR_API_KEY
    ```

Substitua `YOUR_API_KEY` pela sua chave de API da NASA e ajuste os parâmetros conforme necessário.
