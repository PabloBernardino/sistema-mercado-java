# 🛒 Sistema de Mercado em Java

Projeto desenvolvido em Java com foco em praticar lógica de programação, estruturas de repetição, métodos, vetores, condicionais e manipulação de dados em memória.

## 📋 Sobre o Projeto

O Sistema de Mercado é uma aplicação de console que simula o funcionamento básico de um caixa de supermercado.

O usuário pode:

* Cadastrar produtos
* Consultar estoque
* Iniciar uma venda
* Adicionar produtos ao carrinho
* Visualizar o carrinho
* Finalizar a compra
* Gerar um cupom fiscal
* Atualizar automaticamente o estoque após a venda

Todos os dados são armazenados em memória utilizando arrays.

---

## 🚀 Funcionalidades

### 📦 Cadastro de Produtos

Permite cadastrar:

* Código do produto
* Nome
* Preço
* Quantidade em estoque

Valida códigos duplicados para evitar produtos repetidos.

---

### 🛒 Iniciar Venda

Cria uma nova venda e prepara o carrinho para receber itens.

---

### ➕ Adicionar Itens ao Carrinho

Permite:

* Buscar produto pelo código
* Consultar estoque disponível
* Informar quantidade desejada
* Validar estoque
* Adicionar produto ao carrinho

---

### 👀 Visualizar Carrinho

Exibe:

* Nome do produto
* Quantidade
* Subtotal de cada item
* Total parcial da compra

---

### 💰 Finalizar Compra

Realiza:

* Cálculo do valor total
* Recebimento do pagamento
* Cálculo do troco
* Emissão do cupom fiscal
* Atualização automática do estoque

---

### 📊 Consultar Estoque

Lista todos os produtos cadastrados mostrando:

* Código
* Nome
* Preço
* Quantidade em estoque

---

## 🧠 Conceitos de Java Utilizados

### Métodos

```java
public static void titulo(String titulo)
```

Utilizados para organizar e reutilizar código.

---

### Arrays

```java
int[] codigo = new int[100];
String[] nome = new String[100];
double[] preco = new double[100];
int[] estoque = new int[100];
```

Utilizados para armazenar os dados dos produtos.

---

### Estruturas de Repetição

#### for

```java
for(int i = 0; i < codigo.length; i++)
```

#### do-while

```java
do {
   // código
} while(opcao != 0);
```

---

### Estruturas Condicionais

```java
if(codigoExiste)
```

```java
switch(opcao)
```

Utilizadas para controlar o fluxo do sistema.

---

### Variáveis Booleanas

```java
boolean vendaAtiva = false;
```

Utilizadas para controlar estados do sistema.

---

## 📂 Estrutura do Projeto

```text
SistemaMercado/
│
├── SistemaMercado.java
└── README.md
```

---

## ▶️ Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/sistema-mercado.git
```

### 2. Entrar na pasta

```bash
cd sistema-mercado
```

### 3. Compilar

```bash
javac SistemaMercado.java
```

### 4. Executar

```bash
java SistemaMercado
```

---

## 📌 Exemplo do Menu

```text
1 - Cadastrar Produto
2 - Iniciar venda
3 - Adicionar item
4 - Finalizar compra
5 - Ver estoque
6 - Ver carrinho
0 - Sair
```

---

## 🎯 Objetivos de Aprendizagem

Este projeto foi desenvolvido para praticar:

* Lógica de programação
* Programação estruturada
* Métodos
* Arrays
* Estruturas de repetição
* Estruturas condicionais
* Organização de código
* Simulação de sistemas reais

---

## 🔮 Melhorias Futuras

* Persistência em arquivos
* Banco de dados
* Exclusão de produtos
* Alteração de produtos
* Relatórios de vendas
* Login de usuários
* Interface gráfica com JavaFX
* API com Spring Boot

---

## 👨‍💻 Autor

**Pablo Bernardino**

Desenvolvedor Full Stack em formação, estudando:

* Java
* Spring Boot
* Angular
* JavaScript
* TypeScript
* Node.js
* Banco de Dados

Projeto criado para prática e evolução na área de desenvolvimento de software.
