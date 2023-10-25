package fatec.poo.model;

import java.time.LocalDate;

/**
 *
 * @author super
 */
public class Registro {
    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem; 
    private Recepcionista recepcionista;
    private Hospede hospede;
    private Quarto quarto;

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public double getValorHospedagem() {
        return valorHospedagem;
    }
    
    public void reservarQuarto(Hospede hospede, Quarto quarto){
        this.quarto = quarto;
        this.hospede = hospede;
        
        this.quarto.reservar();
    }
    
    public double liberarQuarto(){
        return valorHospedagem;
    }
}
