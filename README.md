# Api em Java SpringBoot 

**Passo a passo para fazer deploy de uma aplicação Spring Boot no Azure, como um web app, com o código fonte da aplicação no GitHub:**

**Pré-requisitos:**

* Conta da Microsoft Azure
* Grupo de recursos no Azure
* Plano de serviço do Azure
* Servidor SQL Server no Azure
* Banco de dados SQL Server no Azure
* Código-fonte da aplicação Spring Boot no GitHub

**Passo 1: Criar a infraestrutura do banco de dados no Azure**

1. Abra o terminal e execute o seguinte comando para criar um grupo de recursos:

```
az group create --name gruporecursos --location brazilsouth
```

2. Execute os seguintes comandos para criar um servidor SQL Server, um banco de dados SQL Server e uma regra de firewall:

```
az sql server create --location brazilsouth --resource-group gruporecursos --name sqlserver-app --admin-username admsql --admin-password dbacesspasswd@123 --enable-public-network true
```

```
az sql db create --resource-group gruporecursos --server sqlserver-app --name dbapp --service-objective basic --backup-storage-redundancy local --zone-redundant false
```
- apenas para testes! esse regra permite acesso indefinido 

```
az sql server firewall-rule create --resource-group gruporecursos --server sqlserver-app --name allowall --start-ip-address 0.0.0.0 --end-ip-address 255.255.255.255 
```


**Passo 2: Importar o projeto Spring Boot do GitHub**

1. Abra o Eclipse.
2. No menu **Window** > **Show View** > **Other**, selecione **Git Repositories**.
3. No menu **File** > **Import**, selecione **Projects from Git**.
4. Na janela **Import Projects from Git**, selecione **Clone URI**.
5. Na janela **Clone Git Repository**, informe a URL do repositório do GitHub do seu projeto Spring Boot.
6. Clique em **Next**.
7. Na janela **Select Repository Location**, selecione o local onde você deseja salvar o projeto.
8. Clique em **Next**.
9. Na janela **Select Branches**, selecione a branch que você deseja importar.
10. Clique em **Finish**.

**Passo 3: Configurar a conexão com o banco de dados**

1. Abra o arquivo `application.properties` do seu projeto Spring Boot.
2. Altere as propriedades `spring.datasource.url` e `spring.datasource.username` para o endereço do seu servidor SQL Server, o nome de usuário e a senha do banco de dados.

**Passo 4: Criar um serviço de aplicativo no Azure**

1. Acesse o portal da Azure.
2. No menu **Web Apps**, clique em **Create**.
3. Na página **Create Web App**, insira as seguintes informações:
    * **Nome do aplicativo:** O nome do seu aplicativo Web no Azure.
    * **Região:** A região do Azure onde você deseja implantar o aplicativo Web.
    * **Plano de serviço:** O plano de serviço do Azure que você deseja usar para o aplicativo Web.
    * **Tipo de aplicativo:** **Java**.
    * **Tipo de implantação:** **Automático**.
4. Clique em **Create**.

**Passo 5: Implantar o aplicativo no Azure**

1. No Eclipse, clique com o botão direito do mouse no projeto Spring Boot e selecione **Azure** > **Publish as Azure Web App
