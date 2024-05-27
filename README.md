# AstroMonitor

## Descrição
O AstroMonitor é um aplicativo desenvolvido em Java que utiliza a API de Objetos Próximos à Terra da NASA (NEO - Near Earth Objects) para monitorar e analisar asteroides e cometas que passam perto da Terra. O sistema realiza chamadas à API para coletar dados sobre esses objetos, como tamanho, velocidade, distância da Terra e potencial perigo, e apresenta os resultados através de uma interface gráfica.

## Funcionalidades
- Monitoramento e análise de asteroides e cometas próximos à Terra.
- Coleta de dados como tamanho, velocidade, distância e potencial perigo.
- Apresentação dos resultados através de uma interface gráfica desenvolvida com Swing.
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
    CREATE DATABASE neotracker;
2. Importe o script schema.sql localizado na pasta db para criar as tabelas necessárias:
      ```bash
    mysql -u seu-usuario -p neotracker < db/schema.sql
3. Configure as credenciais de acesso ao banco de dados no arquivo `config.properties`.

## Documentação da API da NASA

Escrever doc da api
