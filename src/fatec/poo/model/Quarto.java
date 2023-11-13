package fatec.poo.model;

/**
 *
 * @author super
 */
public class Quarto {
    private int numero;
    private String tipo; //S-Solteiro  D-Casado
    private boolean situacao; //True = Ocupado  False = Disponivel
    private double valorDiaria;
    private double totalFaturado;

    public Quarto(int numero, String tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }
    
    public void reservar(){
        situacao = true;
    }
    
    public double liberar(int qtdDias){
        situacao = false;
        double valorHospedagem = qtdDias * valorDiaria;
        totalFaturado += valorHospedagem;
        return valorHospedagem;
    }
}
