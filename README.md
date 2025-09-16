# Teste tecnico - Projedata

## Menu 
[Requisitos](#requisitos-)  
[Guia de implementação](#guia-de-implementação-)  


## Requisitos 
- Criar a classe **Pessoa** com os atributos:
    - nome (`String`)
    - data de nascimento (`LocalDate`)
- Criar a classe **Funcionário** que estende Pessoa, com os atributos:
    - salário (`BigDecimal`)
    - função (`String`)
- Criar a classe **Principal** para executar as ações:
    1. Inserir todos os funcionários conforme tabela fornecida.
    2. Remover o funcionário "João" da lista.
    3. Imprimir todos os funcionários, exibindo:
        - Data no formato `dd/MM/yyyy`
        - Salário com ponto para milhar e vírgula para decimal
    4. Aplicar 10% de aumento no salário de todos os funcionários.
    5. Agrupar funcionários por função em um mapa (`Map<String, List<Funcionario>`).
    6. Imprimir funcionários agrupados por função.
    7. Imprimir funcionários que fazem aniversário nos meses 10 e 12.
    8. Imprimir o funcionário com maior idade (nome e idade).
    9. Imprimir lista de funcionários em ordem alfabética.
    10. Imprimir o total dos salários.
    11. Imprimir quantos salários mínimos ganha cada funcionário (considerando salário mínimo de R$1212,00).

## Guia de Implementação 
### 1. Criar classe Pessoa
Implemente a classe `Pessoa` com os atributos privados:
- `nome` (String)
- `dataDeNascimento` (LocalDate)

### 2. Criar classe Funcionário
Implemente a classe `Funcionario`, que estende `Pessoa` e possui os atributos adicionais:
- `salario` (BigDecimal)
- `funcao` (String)

### 3. Criar classe Principal
A classe principal (com método `main`) será responsável por executar as ações do sistema.

#### 3.1 Inserir todos os funcionários conforme a tabela fornecida
- Crie uma lista para armazenar os funcionários e facilitar as demais operações.
- Utilize construtores nas classes para facilitar a criação dos objetos.
- Em `Funcionario`, utilize o `super` no construtor para herdar os dados de `Pessoa`.
- Para datas, utilize `LocalDate.of(ano, mes, dia)`.
- Para valores monetários, utilize `new BigDecimal("valor")` (sempre como string para evitar problemas de precisão).

#### 3.2 - Remover o funcionário João
- Criar um getter para o nome na classe Pessoa.
- Utilizar o método `removeIf` em uma lista de funcionários, passando uma função anônima (lambda) como parâmetro para pesquisar pelo nome "João" e removê-lo da lista.

#### 3.3 - Imprimir todos os funcionários, exibindo:
- Data no formato `dd/MM/yyyy`
- Salário com ponto para milhar e vírgula para decimal

Eu devo:
- Para a data, utilizar a classe **DateTimeFormatter**
- Para o salário, utilizar a classe **NumberFormat**
- Usar o método **format** das respetivas classes para formatar os valores da maneira desejada.
- Customizar o método **toString()** na sua classe para que, ao imprimir os funcionários (por exemplo, ao imprimir a lista), as informações já apareçam no formato desejado.
- Usar o método forEach no array para imprimir todos os funcionários da lista.

#### 3.4 - Aplicar 10% de aumento no salário de todos os funcionários.
- Criar um setter (método) na classe `Funcionario` que aumente o salário em 10%.
- Usar o método `forEach` para aplicar esse aumento a todos os funcionários da lista.

#### 3.5 - Agrupar funcionários por função em um mapa

- Tipifique um dicionário usando `Map<String, List<Funcionario>>`, onde:
  - a **chave** é uma `String` representando a função/cargo do funcionário,
  - o **valor** é uma `List` de objetos do tipo `Funcionario` que possuem essa função.
- Utilize o método `stream()` para processar os dados da lista `funcionarios`.
- Use o método `collect(Collectors.groupingBy(Funcionario::getFuncao))` para criar o dicionário (mapa), agrupando os funcionários por função — ou seja, a chave será a função e o valor será a lista de funcionários daquela função.

#### 3.6 - Imprimir funcionários agrupados por função

- Utilize um laço `for` no formato: `for (Variável : Coleção)` para percorrer todas as entradas do mapa.
- Utilize `Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()` para acessar cada par chave-valor do mapa, onde a chave é a função e o valor é a lista de funcionários daquela função.
- Estruture o `print` de forma que a função (cargo) fique em destaque, seguida dos funcionários que exercem essa função.
- Use um `forEach` para percorrer e imprimir todos os funcionários armazenados na lista (valor) da chave correspondente.


#### 3.7 - Imprimir funcionários que fazem aniversário nos meses 10 e 12
- Usar `System.out.println` para sinalizar no terminal que está listando os aniversariantes de outubro e dezembro.
- Utilizar o `stream` para processar os dados dos funcionários.
- Aplicar `filter` para selecionar apenas os funcionários cujo mês de nascimento seja 10 ou 12.
- Criar uma variável para armazenar o mês extraído da data de nascimento de cada funcionário.
- Retornar apenas os funcionários que possuem esse valor de mês.
- Imprimir os funcionários filtrados com o `forEach`.

#### 3.8 - Imprimir o funcionário com maior idade (nome e idade)
- Em vez de usar o `reduce`, pesquisei e descobri que o Java já oferece métodos práticos para isso.
- É possível usar um comparador para encontrar o funcionário mais velho, procurando aquele cuja data de nascimento tem o menor valor.
- Para calcular a idade, o Java possui métodos nativos que calculam a diferença entre datas e retornam o período transcorrido (ou seja, a idade).
- Ao utilizar os métodos `min` ou `max` em streams, o retorno é um `Optional`, garantindo que o código não quebre caso a lista esteja vazia.
- Por isso, é importante tratar esse caso com `ifPresent`, assegurando que só será impresso se houver algum funcionário.


#### 3.9 - Imprimir lista de funcionários em ordem alfabética.
- Stream para trabalhar com o array de funcionáros
- Sorted usando o nome dos funcionários como referência
- ForEach para impressão de cada um dos funcionários no terminal


#### 3.10 - Imprimir o total dos salários.
- Criar uma variável `totalSalarios` para facilitar a leitura do código e dividir o processo em etapas.
- Utilizar um Stream com o método `map` para obter apenas os salários dos funcionários.
- Usar o método `reduce`, começando de `BigDecimal.ZERO` e utilizando `BigDecimal::add` para somar todos os salários.
- Utilizar `printf` para exibir o total, formatando o valor com duas casas decimais.

#### 3.11 - Imprimir quantos salários mínimos ganha cada funcionário (considerando salário mínimo de R$1212,00).
- Criar uma variável `salarioMinimo` do tipo `BigDecimal`.
- Utilizar o método `forEach` na lista de funcionários para calcular quantos salários mínimos cada um recebe, dividindo o salário do funcionário pelo valor do salário mínimo.
- Fazer a impressão do resultado, utilizando a formatação correta para exibir o valor com duas casas decimais.


