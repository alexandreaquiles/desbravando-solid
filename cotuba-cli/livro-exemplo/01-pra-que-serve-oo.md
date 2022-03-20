# Para que serve OO?

## Modelagem e Dependências

Você aprendeu Orientação a Objetos.

Entendeu classes, objetos, atributos, métodos, herança, polimorfismo, interfaces.

Aprendeu algumas soluções comuns para problemas recorrentes estudando alguns _Design Patterns_.

Mas como e quando usar OO?

Sem dúvida, a resposta tem a ver com organizar e facilitar a mudança do código no médio/longo prazo.

Mas, para Martin (2005), há duas abordagens complementares no uso de OO:

- criar um **modelo** do mundo real
- gerenciar as **dependências** do seu código

> _These principles expose the dependency management aspects of OOD as opposed to the conceptualization and modeling aspects. This is not to say that OO is a poor tool for conceptualization of the problem space, or that it is not a good venue for creating models. Certainly many people get value out of these aspects of OO. The principles, however, focus very tightly on dependency management._
>
>(MARTIN, 2005)

OO é uma ótima ferramenta para representar, em código, os conceitos do problema que estamos resolvendo. É importante selecionar entidades de negócio e criar um modelo de domínio que as "traduza" para uma linguagem de programação.

Um bom _domain model_ é o foco de metodologias e técnicas como:

- Feature-Driven Development
- Card-Responsibility-Collaboration (CRC)
- **Domain-Driven Design**

Mas OO também é uma ótima maneira de evitar código "amarrado" demais, controlando as dependências e minimizando o acoplamento. Um código OO bem modelado, com as dependências administradas com cuidado, leva a mais flexibilidade, robustez e possibilidade de reuso.

Dependências bem gerenciadas são o foco de técnicas como:

- General Responsibility Assignment So ware Principles (GRASP)
- Design Patterns
- Dependency Injection
- **Princípios SOLID**.

Nosso foco nesse curso é aprofundar no estudo dos princípios SOLID, usando OO como uma maneira de gerenciar as dependências do nosso código.
