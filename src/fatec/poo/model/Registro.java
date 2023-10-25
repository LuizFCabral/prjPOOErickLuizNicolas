package fatec.poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

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
    private ArrayList<ServicoQuarto> servicosQuarto;

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
        servicosQuarto = new ArrayList<ServicoQuarto>();
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
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

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }
    
    public void addServicoQuarto(ServicoQuarto sq){
        servicosQuarto.add(sq);
    }
    
    public void reservarQuarto(Hospede hospede, Quarto quarto){
        this.quarto = quarto;
        this.hospede = hospede;
        
        this.quarto.reservar();
    }
    
    public double liberarQuarto(){
        Period periodo = dataEntrada.until(dataSaida);
        int qtdDias = periodo.getDays();
        
        valorHospedagem = quarto.liberar(qtdDias);
        valorHospedagem -= (hospede.getTaxaDesconto()*valorHospedagem);
        for(int i=0; i<servicosQuarto.size(); i++){
            valorHospedagem += servicosQuarto.get(i).getValor();
        }
        
        return valorHospedagem;
    }
}
