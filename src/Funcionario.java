import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setAumentaSalario() {
        this.salario = this.salario.multiply(BigDecimal.valueOf(1.1));
    }

    @Override
    public String toString() {
        DateTimeFormatter dataBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = getDataNascimento().format(dataBrasil);

        NumberFormat dinheiroBrasil = NumberFormat.getInstance(new Locale("pt", "BR"));
        dinheiroBrasil.setMinimumFractionDigits(2);
        dinheiroBrasil.setMaximumFractionDigits(2);
        String salarioFormatado = dinheiroBrasil.format(getSalario());

        return String.format("Nome: %s, Data de Nascimento: %s, Salário: R$%s, Função: %s", getNome(), dataFormatada, salarioFormatado, getFuncao());
    }

}
