
import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import fatec.poo.model.Registro;
import fatec.poo.model.ServicoQuarto;
import java.time.LocalDate;
import java.time.Month;

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
        Hospede objHos1 = new Hospede("123.456.789-01", "Alípio");
        Hospede objHos2 = new Hospede("432.765.987-02", "Alice");
        
        Recepcionista objRec1 = new Recepcionista(1010, "Genius");
        Recepcionista objRec2= new Recepcionista(1011, "Laura");
        
        Quarto objQua1 = new Quarto(22, "S", true, 74.89);
        Quarto objQua2 = new Quarto(20, "S", false, 84.89);
        Quarto objQua3 = new Quarto(14, "D", false, 108.39);
        
        Registro objReg1 = new Registro(10203, LocalDate.of(2023, 10, 22), objRec1);
        Registro objReg2 = new Registro(10204, LocalDate.of(2023, 11, 05), objRec2);
        Registro objReg3 = new Registro(10205, LocalDate.of(2023, 11, 17), objRec1);
        
        ServicoQuarto objSeQ1 = new ServicoQuarto(102, "Limpar o banhero");
        ServicoQuarto objSeQ2 = new ServicoQuarto(103, "Café da manhã");
        ServicoQuarto objSeQ3 = new ServicoQuarto(104, "Arrumar as camas");
        
        
        objHos1.addRegistro(objReg1);
        objHos1.addRegistro(objReg2);
        objHos1.setEndereco("R. Rio Branco, 1241");
        objHos1.setTelefone("(11)94607-8932");
        objHos1.setTaxaDesconto(10);
        
        objHos2.addRegistro(objReg2);
        objHos2.addRegistro(objReg3);
        objHos2.setEndereco("R. Natal, 448");
        objHos2.setTelefone("(11)96184-3277");
        objHos2.setTaxaDesconto(50);
                
        objRec1.addRegistro(objReg1);
        objRec1.addRegistro(objReg3);
        objRec1.setEndereco("R. Arnaldo Pereira, 171");
        objRec1.setTelefone("(11)91928-3746");
        objRec1.setTurno("Diurno");
        
        objRec2.addRegistro(objReg2);
        objRec2.setEndereco("R. Luiz Gonsalves, 69");
        objRec2.setTelefone("(11)94637-2819");
        objRec2.setTurno("Noturno");
        
        objReg1.addServicoQuarto(objSeQ1);
        objReg1.setHospede(objHos1);
        objReg1.setQuarto(objQua1);
        objReg1.setDataSaida(LocalDate.of(2023, 10, 23));
        
        objReg2.addServicoQuarto(objSeQ2);
        objReg2.setHospede(objHos2);
        objReg2.setQuarto(objQua3);
        objReg2.setDataSaida(LocalDate.of(2023, 11, 10));
        
        objReg3.addServicoQuarto(objSeQ3);
        objReg3.setHospede(objHos1);
        objReg3.setQuarto(objQua2);
        objReg3.setDataSaida(LocalDate.of(2023, 11, 18));
        
        
        objSeQ1.setValor(17.98);
        objSeQ2.setValor(26.49);
        objSeQ3.setValor(9.99);
    }
    
}
