# S.O.L.I.D.

## Os dez (ou onze) mandamentos de Orientação a Objetos

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
> 11._When crossing between two different paradigms, build an interface layer that separates the two. Don't pollute one side with the paradigm of the other._

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
- _**D**ependency Inversion Principle_: **Dependa de abstrações, não de classes concretas**.
