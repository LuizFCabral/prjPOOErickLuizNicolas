
import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import fatec.poo.model.Registro;
import fatec.poo.model.ServicoQuarto;
import java.text.DecimalFormat;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
public class Aplic {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        /*
            CRIAÇÃO DOS OBJETOS
        */
        Hospede objHos1 = new Hospede("123.456.789-01", "Alípio");
        Hospede objHos2 = new Hospede("432.765.987-02", "Alice");
        
        Recepcionista objRec1 = new Recepcionista(1010, "Genius");
        Recepcionista objRec2= new Recepcionista(1011, "Laura");
        
        Quarto objQua1 = new Quarto(22, "S", false, 74.89);
        Quarto objQua2 = new Quarto(20, "S", false, 84.89);
        Quarto objQua3 = new Quarto(14, "D", false, 108.39);
        
        Registro objReg1 = new Registro(10203, LocalDate.of(2023, 5, 25), objRec1);
        Registro objReg2 = new Registro(10204, LocalDate.of(2023, 11, 05), objRec2);
        Registro objReg3 = new Registro(10205, LocalDate.of(2023, 9, 17), objRec1);
        
        ServicoQuarto objSeQ1 = new ServicoQuarto(102, "Limpar o banhero");
        ServicoQuarto objSeQ2 = new ServicoQuarto(103, "Café da manhã");
        ServicoQuarto objSeQ3 = new ServicoQuarto(104, "Arrumar as camas");
        
        /*
            ULTILIZANDO OS ADDs E SETs
        */
        objHos1.setEndereco("R. Rio Branco, 1241");
        objHos1.setTelefone("(11)94607-8932");
        objHos1.setTaxaDesconto(10);
        
        objHos2.setEndereco("R. Natal, 448");
        objHos2.setTelefone("(11)96184-3277");
        objHos2.setTaxaDesconto(50);
                
        
        objRec1.setEndereco("R. Arnaldo Pereira, 171");
        objRec1.setTelefone("(11)91928-3746");
        objRec1.setTurno("Diurno");
        
        objRec2.setEndereco("R. Luiz Gonsalves, 69");
        objRec2.setTelefone("(11)94637-2819");
        objRec2.setTurno("Noturno");
        
        objSeQ1.setValor(10);
        objSeQ2.setValor(20);
        objSeQ3.setValor(30);
        
        objReg1.addServicoQuarto(objSeQ1);
        objReg1.addServicoQuarto(objSeQ2);
        objReg1.setDataSaida(LocalDate.of(2023, 6, 2));
        
        objReg2.addServicoQuarto(objSeQ2);
        objReg2.addServicoQuarto(objSeQ3);
        objReg2.setDataSaida(LocalDate.of(2023, 11, 10));
        
        objReg3.addServicoQuarto(objSeQ3);
        objReg3.addServicoQuarto(objSeQ1);
        objReg3.setDataSaida(LocalDate.of(2023, 9, 27));
        
        
        
        
        
        /*
            ULTILIZANDO AS FUNÇÕES ESPECÍFICAS - FAZENDO A RESERVA E LIBERANDO OS QUARTOS
        */
        /*
        System.out.println("A Situação do quarto " + objQua1.getNumero() + " é: " + objQua1.isSituacao());
        System.out.println("A Situação do quarto " + objQua2.getNumero() + " é: " + objQua2.isSituacao());
        System.out.println("A Situação do quarto " + objQua3.getNumero() + " é: " + objQua3.isSituacao());
        System.out.println("\n");
        */
        
        objReg1.reservarQuarto(objHos1, objQua1);
        objReg2.reservarQuarto(objHos2, objQua2);
        objReg3.reservarQuarto(objHos1, objQua3);
        
        /*
        System.out.println("A Situação do quarto " + objQua1.getNumero() + " é: " + objQua1.isSituacao());
        System.out.println("A Situação do quarto " + objQua2.getNumero() + " é: " + objQua2.isSituacao());
        System.out.println("A Situação do quarto " + objQua3.getNumero() + " é: " + objQua3.isSituacao());
        System.out.println("\n");
        */
        
        System.out.println("O valor da hospedagem do qurto " + objReg1.getQuarto().getNumero() + " ficou em: R$ " + df.format(objReg1.liberarQuarto()));
        System.out.println("O valor da hospedagem do qurto " + objReg2.getQuarto().getNumero() + " ficou em: R$ " + df.format(objReg2.liberarQuarto()));
        System.out.println("O valor da hospedagem do qurto " + objReg3.getQuarto().getNumero() + " ficou em: R$ " + df.format(objReg3.liberarQuarto()));
        System.out.println("\n");
        
        /*
        System.out.println("A Situação do quarto " + objQua1.getNumero() + " é: " + objQua1.isSituacao());
        System.out.println("A Situação do quarto " + objQua2.getNumero() + " é: " + objQua2.isSituacao());
        System.out.println("A Situação do quarto " + objQua3.getNumero() + " é: " + objQua3.isSituacao());
        System.out.println("\n");
        */
        
        /*
            GETs RERISTRO
        */
        System.out.println("--------------------------------------------------------------");
        System.out.println("\t\t REGISTRO(S)");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Código: " + objReg1.getCodigo());
        System.out.println("Data de entrada: " + objReg1.getDataEntrada());
        System.out.println("Data de sída: " + objReg1.getDataSaida());
        System.out.println("Nome do hóspede: " + objReg1.getHospede().getNome());
        System.out.println("Número do quarto: " + objReg1.getQuarto().getNumero());
        objReg1.listarServicoQuarto();
        System.out.println("Nome do recepcionista: " + objReg1.getRecepcionista().getNome());
        System.out.println("Valor da hospedagem: R$ " + df.format(objReg1.getValorHospedagem()) + "\n");
        
        
        System.out.println("Código: " + objReg2.getCodigo());
        System.out.println("Data de entrada: " + objReg2.getDataEntrada());
        System.out.println("Data de sída: " + objReg2.getDataSaida());
        System.out.println("Nome do hóspede: " + objReg2.getHospede().getNome());
        System.out.println("Número do quarto: " + objReg2.getQuarto().getNumero());
        objReg2.listarServicoQuarto();
        System.out.println("Nome do recepcionista: " + objReg2.getRecepcionista().getNome());
        System.out.println("Valor da hospedagem: R$ " + df.format(objReg2.getValorHospedagem()) + "\n");
        
        System.out.println("Código: " + objReg3.getCodigo());
        System.out.println("Data de entrada: " + objReg3.getDataEntrada());
        System.out.println("Data de sída: " + objReg3.getDataSaida());
        System.out.println("Nome do hóspede: " + objReg3.getHospede().getNome());
        System.out.println("Número do quarto: " + objReg3.getQuarto().getNumero());
        objReg3.listarServicoQuarto();
        System.out.println("Nome do recepcionista: " + objReg3.getRecepcionista().getNome());
        System.out.println("Valor da hospedagem: R$ " + df.format(objReg3.getValorHospedagem()) + "\n");
        
        /*
            GETs SERVICOQUARTO
        */
        System.out.println("--------------------------------------------------------------");
        System.out.println("\t\t SERVIÇO DE QUARTO(S)");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Código: " + objSeQ1.getCodigo());
        System.out.println("Descrição: " + objSeQ1.getDescricao());
        System.out.println("Valor: R$ " + df.format(objSeQ1.getValor()) + "\n");
        
        System.out.println("Código: " + objSeQ2.getCodigo());
        System.out.println("Descrição: " + objSeQ2.getDescricao());
        System.out.println("Valor: R$ " + df.format(objSeQ2.getValor()) + "\n");
        
        System.out.println("Código: " + objSeQ3.getCodigo());
        System.out.println("Descrição: " + objSeQ3.getDescricao());
        System.out.println("Valor: R$ " + df.format(objSeQ3.getValor()) + "\n");
        
        /*
            GETs QUARTO
        */
        System.out.println("--------------------------------------------------------------");
        System.out.println("\t\t QUARTO(S)");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Número: " + objQua1.getNumero());
        System.out.println("Tipo: " + objQua1.getTipo());
        System.out.println("Valor da diária: R$ " + df.format(objQua1.getValorDiaria()));
        System.out.println("Total faturado: R$ " + df.format(objQua1.getTotalFaturado()) + "\n");
        
        System.out.println("Número: " + objQua2.getNumero());
        System.out.println("Tipo: " + objQua2.getTipo());
        System.out.println("Valor da diária: R$ " + df.format(objQua2.getValorDiaria()));
        System.out.println("Total faturado: R$ " + df.format(objQua2.getTotalFaturado()) + "\n");
        
        System.out.println("Número: " + objQua3.getNumero());
        System.out.println("Tipo: " + objQua3.getTipo());
        System.out.println("Valor da diária: R$ " + df.format(objQua3.getValorDiaria()));
        System.out.println("Total faturado: R$ " + df.format(objQua3.getTotalFaturado()) + "\n");
        
        /*
            GETs RECEPCIONISTA
        */
        System.out.println("--------------------------------------------------------------");
        System.out.println("\t\t RECEPCIONISTA(S)");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Registro: " + objRec1.getRegFunc());
        System.out.println("Nome: " + objRec1.getNome());
        System.out.println("Telefone: " + objRec1.getTelefone());
        System.out.println("Endereço: " + objRec1.getEndereco());
        System.out.println("Turno: " + objRec1.getTurno() + "\n");
        
        System.out.println("Registro: " + objRec2.getRegFunc());
        System.out.println("Nome: " + objRec2.getNome());
        System.out.println("Telefone: " + objRec2.getTelefone());
        System.out.println("Endereço: " + objRec2.getEndereco());
        System.out.println("Turno: " + objRec2.getTurno() + "\n");
        
        /*
            GETs HOSPEDE
        */
        System.out.println("--------------------------------------------------------------");
        System.out.println("\t\t HOSPEDE(S)");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Nome: " + objHos1.getNome());
        System.out.println("CPF: " + objHos1.getCpf());
        System.out.println("Telefone: " + objHos1.getTelefone());
        System.out.println("Endereço: " + objHos1.getEndereco());
        System.out.println("Taxa de Desconto: " + objHos1.getTaxaDesconto()*100 + "%\n");
        
        System.out.println("Nome: " + objHos2.getNome());
        System.out.println("CPF: " + objHos2.getCpf());
        System.out.println("Telefone: " + objHos2.getTelefone());
        System.out.println("Endereço: " + objHos2.getEndereco());
        System.out.println("Taxa de Desconto: " + objHos2.getTaxaDesconto()*100 + "%\n");
        
    }
}
