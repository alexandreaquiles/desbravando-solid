insert into capitulos (ordem, nome, markdown, livro_id) values (1, 'Para que serve OO?', '## Modelagem e Dependências

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

Nosso foco nesse curso é aprofundar no estudo dos princípios SOLID, usando OO como uma maneira de gerenciar as dependências do nosso código.', 1);

insert into capitulos (ordem, nome, markdown, livro_id) values (2, 'SOLID', '## Os dez (ou onze) mandamentos de Orientação a Objetos

Robert Cecil Martin, o famoso Uncle Bob, listou os seus 10 (na verdade, 11) mandamentos da Programação Orientada a Objetos, no grupo Usenet _comp.object_ (MARTIN, 1995):

> _If I had to write commandments, these would be candidates._
>
> 1._Software entities (classes, modules, etc) should be open for extension, but closed for modification.  (The open/closed principle -- Bertrand Meyer)_
>
> 2._Derived classes must usable through the base class interface without the need for the user to know the difference.  (The Liskov Substitution Principle)_
>
> 3._Details should depend upon abstractions.  Abstractions should not depend upon details.  (Principle of Dependency Inversion)_
>
> 4._The granule of reuse is the same as the granule of release. Only components that are released through a tracking system can be effectively reused._
>
> _5.Classes within a released component should share common closure. That is, if one needs to be changed, they all are likely to need to be changed.  What affects one, affects all._
>
> 6._Classes within a released component should be reused together. That is, it is impossible to separate the components from each other in order to reuse less than the total._
>
> 7._The dependency structure for released components must be a DAG. There can be no cycles._
>
> 8._Dependencies between released components must run in the direction of stability. The dependee must be more stable than the depender._
>
> 9._The more stable a released component is, the more it must consist of abstract classes. A completely stable component should consist of nothing but abstract classes._
>
> 10._Where possible, use proven patterns to solve design problems._
>
> 11._When crossing between two different paradigms, build an interface layer that separates the two. Dont pollute one side with the paradigm of the other._

## Os Princípios de Orientação a Objetos

Em 1996, fez uma série de artigos na revista _C++ Report_ sobre o que chamou de **princípios**:

- _Open-Closed Principle_ (MARTIN, 1996a)
- _Liskov Substitution Principle_ (MARTIN, 1996b)
- _Dependency Inversion Principle_ (MARTIN, 1996c)
- _Interface Segregation Principle_ (MARTIN, 1996d)
- _Granularity_ (MARTIN, 1996e)
- _Stability_ (MARTIN, 1997)

O foco desses princípios é nas dependências entre objetos e componentes/módulos.

Em (Martin, 2002), Uncle Bob descreve o _Single Responsibility Principle_, reordenando os princípios e cunhando o acrônimo **S.O.L.I.D**.


Uma versão atualizada desses princípios foi lançada em C# (MARTIN, 2006).

Uncle Bob indica (MARTIN, 2009) que os princípios não são _check lists_, nem leis ou regras. São bons conselhos vindos do senso comum de gente experiente, coletados em projetos reais ao longo do tempo. Não significa que sempre funcionam ou que sempre devem ser seguidos.

## Princípios de classes

Os 5 princípios S.O.L.I.D. são focados em modelagem de classes:

- _**S**ingle Responsibility Principle_: **Uma classe deve ter um, e apenas um, motivo para ser mudada**.
- _**O**pen/Closed Principle_: **Deve ser possível extender o comportamento de uma classe sem modificá-la**.
- _**L**iskov Substitution Principle_: **Classes derivadas devem ser substituíveis pelas classes base**.
- _**I**nterface Segregation Principle_: **Uma classe deve ter um, e apenas um, motivo para ser mudada**.
- _**D**ependency Inversion Principle_: **Dependa de abstrações, não de classes concretas**.', 1);

insert into capitulos (ordem, nome, markdown, livro_id) values (3, 'Referências', 'MARTIN, Robert Cecil. _The Principles of OOD_. 2005. Em: <http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod>.

MARTIN, Robert Cecil. _The Ten Commandments of OO Programming_. 1995. Em: <https://groups.google.com/forum/?hl=en#!topic/comp.object/WICPDcXAMG8>.

MARTIN, Robert Cecil. _The Open-Closed Principle_. The C++ Report, Jan. 1996a. Em: <https://drive.google.com/file/d/0BwhCYaYDn8EgN2M5MTkwM2EtNWFkZC00ZTI3LWFjZTUtNTFhZGZiYmUzODc1/view>.

MARTIN, Robert Cecil. _The Liskov Substitution Principle_. The C++ Report, Mar. 1996b. Em: <https://drive.google.com/file/d/0BwhCYaYDn8EgNzAzZjA5ZmItNjU3NS00MzQ5LTkwYjMtMDJhNDU5ZTM0MTlh/view>.

MARTIN, Robert Cecil. _The Dependency Inversion Principle_. The C++ Report, Jun. 1996c. Em: <https://drive.google.com/file/d/0BwhCYaYDn8EgMjdlMWIzNGUtZTQ0NC00ZjQ5LTkwYzQtZjRhMDRlNTQ3ZGMz/view>.

MARTIN, Robert Cecil. _The Interface Segregation Principle_. The C++ Report, Aug. 1996d. Em: <https://drive.google.com/file/d/0BwhCYaYDn8EgOTViYjJhYzMtMzYxMC00MzFjLWJjMzYtOGJiMDc5N2JkYmJi/view>.

MARTIN, Robert Cecil. _Granularity_. The C++ Report, Nov. 1996e. Em: <https://drive.google.com/file/d/0BwhCYaYDn8EgOGM2ZGFhNmYtNmE4ZS00OGY5LWFkZTYtMjE0ZGNjODQ0MjEx/view>.

MARTIN, Robert Cecil. _Stability_. The C++ Report, Jan. 1997. Em: <https://drive.google.com/file/d/0BwhCYaYDn8EgZjI3OTU4ZTAtYmM4Mi00MWMyLTgxN2YtMzk5YTY1NTViNTBh/view>.

MARTIN, Robert Cecil. _Agile Software Development: Principles, Patterns, and Practices_. Prentice Hall, 2002. 529 p. Em: <https://www.amazon.com.br/Software-Development-Principles-Patterns-Practices/dp/0135974445>.

MARTIN, Robert Cecil. _Agile Principles, Patterns, and Practices in C#_. Prentice Hall, 2006. 732 p. Em: <https://www.amazon.com.br/Agile-Principles-Patterns-Practices-C/dp/0131857258>.

MARTIN, Robert Cecil. _Getting a SOLID start._. 2009. Em: <https://sites.google.com/site/unclebobconsultingllc/getting-a-solid-start>.', 1); 
