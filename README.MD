# Desbravando o SOLID

Este projeto é um _fork_ do [**Alexandre Aquiles**](https://github.com/alexandreaquiles), autor do livro **Desbravando SOLID**.

![Capa do Livro](https://cdn.shopify.com/s/files/1/0155/7645/products/p_408c6b07-0499-45a6-99fe-d06b67cf92ef_large.jpg?v=1659469600)

Durante sua leitura, uma série de refatorações são realizadas sobre o Cotuba, para o adequar aos princípios previstos pelo *SOLID*.

Caso tenha interesse no livro, ele pode ser comprado na [**Casa do Código**](https://www.casadocodigo.com.br/products/livro-desbravando-solid).

---

# Cotuba

O Cotuba é uma aplicação *CLI* que converte livros criados em arquivos *Markdown* (.md) para *PDF* ou *EPUB*.

## Requisitos
* *Java* 17+.
* *Maven* 3.8+

## Bibliotecas utilizadas
* *Apache Commons CLI*

Esta biblioteca foi empregada pelo autor para realizar a leitura dos parâmetros informados pelo usuário na linha de comando que executa a aplicação.

* *CommonMark*

Sua função dentro do projeto é realizar a leitura de arquivos *Markdown*.

* *iText*

Escolhida pelo autor para gerar os arquivos PDF.

* *Siegmann Epublib*

Realiza a geração dos arquivos EPUB.

## Instalação

Para realizar a instalação é necessário, primeiro, fazer um clone do projeto:

`git clone https://github.com/MarcosGOFavaretto/desbravando-solid`

Acesse a pasta do projeto que está dentro do repositório:

`cd desbravando-solid/cotuba`

Execute o *Maven* para executar um *build* no projeto:

`mvn clean package`

Descompacte o projeto gerado:

`unzip -o target/cotuba-*-distribution.zip -d ../`

Pronto! O projeto já foi instalado e pode ser executado estando dentro do repositório anteriormente clonado.

## Utilizando o Cotuba

Para gerar o arquivo em PDF, basta utilizar o comando:

`./cotuba.sh -d desbravando-solid/cotuba/livro-exemplo -f pdf`

Para gerar o arquivo em EPUB:

`./cotuba.sh -d desbravando-solid/cotuba/livro-exemplo -f epub`