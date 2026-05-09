# 📘 tcs-jsf-treinamento

Projeto Java Web desenvolvido com **JSF (JavaServer Faces)** e **PrimeFaces**, criado para fins de treinamento. Utiliza **Hibernate** como ORM, banco de dados **H2** em memória e é empacotado como uma aplicação **WAR** gerenciada pelo **Maven**.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java EE | 7.0 |
| JSF (GlassFish) | 2.3.7 |
| PrimeFaces | 10.0.0 |
| Hibernate Core | 5.6.14.Final |
| H2 Database | 2.1.214 |
| Apache POI | 5.2.3 |
| iText (PDF) | 2.1.7 |
| Maven | — |
| Tomcat | 9.x |

---

## 📁 Estrutura do Projeto

```
tcs-jsf-treinamento/
├── src/
│   └── main/
│       ├── java/          # Classes Java (Managed Beans, Entidades, DAOs)
│       └── webapp/        # Páginas XHTML, CSS e recursos web
│           └── META-INF/
│               └── context.xml
├── pom.xml                # Configuração Maven
└── README.md
```

---

## ✅ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java JDK 8+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.6+](https://maven.apache.org/download.cgi)
- [Apache Tomcat 9.x](https://tomcat.apache.org/download-90.cgi) *(opcional se usar o plugin Maven)*
- Uma IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [Eclipse](https://www.eclipse.org/)

---

## 🚀 Como Rodar o Projeto

### Opção 1 — Via Plugin Maven (Tomcat embutido)

Esta é a forma mais simples. O projeto já possui o plugin `tomcat7-maven-plugin` configurado na porta **8081**.

```bash
# 1. Clone o repositório
git clone https://github.com/caiogalassi/tcs-jsf-treinamento.git
cd tcs-jsf-treinamento

# 2. Compile e rode com Maven
mvn tomcat7:run
```

Acesse no navegador:
```
http://localhost:8081/tcs-jsf-treinamento
```

---

### Opção 2 — Deploy no Tomcat 9 (manual)

```bash
# 1. Clone o repositório
git clone https://github.com/caiogalassi/tcs-jsf-treinamento.git
cd tcs-jsf-treinamento

# 2. Gere o arquivo WAR
mvn clean package

# 3. Copie o WAR para a pasta webapps do Tomcat
cp target/tcs-jsf-treinamento.war /caminho/para/tomcat9/webapps/

# 4. Inicie o Tomcat
/caminho/para/tomcat9/bin/startup.sh   # Linux/Mac
/caminho/para/tomcat9/bin/startup.bat  # Windows
```

Acesse no navegador:
```
http://localhost:8080/tcs-jsf-treinamento
```

---

### Opção 3 — Via IntelliJ IDEA

1. Abra o IntelliJ e clique em **File > Open** e selecione a pasta do projeto.
2. Aguarde o Maven baixar as dependências automaticamente.
3. Configure um servidor **Tomcat 9** em **Run > Edit Configurations**.
4. Adicione o artefato `tcs-jsf-treinamento:war` ao deployment.
5. Clique em **Run** ▶️.

---

## 📦 Dependências Principais

- **JSF + PrimeFaces** — Framework web e componentes de interface
- **Hibernate** — Mapeamento objeto-relacional (ORM)
- **H2 Database** — Banco de dados em memória (ideal para desenvolvimento/testes)
- **Apache POI** — Exportação para arquivos Excel (`.xlsx`)
- **iText** — Geração de relatórios em PDF
- **CDI (jakarta.inject)** — Injeção de dependências

---

## 🧪 Testes

```bash
mvn test
```

> Os testes utilizam **JUnit 3.8.1**.

---

## 📄 Licença

Projeto para fins educacionais e de treinamento interno.

---

## 👤 Autor

**Caio Galassi**
[github.com/caiogalassi](https://github.com/caiogalassi)