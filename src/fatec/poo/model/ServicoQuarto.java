package fatec.poo.model;


/**
 *
 * @author super
 */
public class ServicoQuarto {
    private int codigo;
    private String descricao;
    private double valor;
    private Registro registro;

    public ServicoQuarto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
    
    
}
