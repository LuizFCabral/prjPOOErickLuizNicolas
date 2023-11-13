package fatec.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        recepcionista.addRegistro(this);
        servicosQuarto = new ArrayList<ServicoQuarto>();
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
        hospede.addRegistro(this);
        
        this.quarto.reservar();
    }
    
    public double liberarQuarto(){
        long qtdDias = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        
        valorHospedagem = quarto.liberar(Integer.parseInt(String.valueOf(qtdDias)));
        valorHospedagem -= ((hospede.getTaxaDesconto()/100)*valorHospedagem);
        for(int i=0; i<servicosQuarto.size(); i++){
            valorHospedagem += servicosQuarto.get(i).getValor();
        }
        
        return valorHospedagem;
    }
}
