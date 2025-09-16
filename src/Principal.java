import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;


public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();


        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 15), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Fazendo print dos funcionários do array
        funcionarios.forEach(f -> System.out.println(f));

//        System.out.println("\nAumentando salário dos Funcionários\n");

        // Aumentando em 10% o salário dos funcionários
        funcionarios.forEach(Funcionario::setAumentaSalario);

//        funcionarios.forEach(f -> System.out.println(f));

        // Retirando João da lista de funcionários
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        System.out.println();
//        funcionarios.forEach(f -> System.out.println(f));

        // Criando agrupamento de funcionários pela função. É um dicionário onde a chave é o valor é uma lista de objetos do tipo funcionário
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Imprimindo funcionários por função.
        for (Map.Entry<String, List<Funcionario>> entrada : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entrada.getKey());
            entrada.getValue().forEach(System.out::println);
            System.out.println();
        }

        // Imprimindo funcionários conforme o mês de aniversário
        System.out.println("Funcionários que fazem aniversário em outubro ou dezembro");
        funcionarios.stream().filter(f -> {
            int mes = f.getDataNascimento().getMonthValue();
            return mes == 10 || mes == 12;
        }).forEach(System.out::println);

        // Imprimindo o funcionário mais velho
        funcionarios.stream()
                // Comparadndo datas da lista para encontrar a menor
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                // Se tiver algum resultado vai executar essa função
                .ifPresent(f -> {
                    int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
                    System.out.printf("%nO funcionário mais velho é: %s com %d anos.%n", f.getNome(), idade);
                });


        // Imprimindo funcionários em ordem alfabetica
        System.out.println();
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        // Imprimindo soma do valor dos salários - A soma não está com o João e foi aplicado os 10% de aumento.
        System.out.println();
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("O total em salários é R$%.2f%n", totalSalarios.doubleValue());

        // Imprimindo o nome do funcionário e quanto cada um ganha em saláriosMinimos
        System.out.println();
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(f -> {
            BigDecimal quantosSalariosMinimos = f.getSalario().divide(salarioMinimo, 2);
            System.out.printf("%s recebe %.2f salários minimos.%n", f.getNome(), quantosSalariosMinimos.doubleValue());
        });
    }
}