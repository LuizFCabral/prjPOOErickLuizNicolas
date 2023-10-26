
import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import fatec.poo.model.Registro;
import fatec.poo.model.ServicoQuarto;
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
        Hospede objHos = new Hospede("123.456.789-01", "Alípio");
        Recepcionista objRec = new Recepcionista(1010, "Genius");
        
        Quarto objQua1 = new Quarto(22, "S", true, 74.89);
        Quarto objQua2 = new Quarto(20, "S", false, 84.89);
        Quarto objQua3 = new Quarto(14, "D", false, 108.39);
        
        Registro objReg1 = new Registro(10203, LocalDate.of(2023, 10, 22), objRec);
        Registro objReg2 = new Registro(10204, LocalDate.of(2023, 11, 05), objRec);
        Registro objReg3 = new Registro(10205, LocalDate.of(2023, 11, 17), objRec);
        
        ServicoQuarto objSeQ1 = new ServicoQuarto(102, "Limpar o banhero do quarto 22");
        ServicoQuarto objSeQ2 = new ServicoQuarto(103, "Concertar a TV do quarto 20");
        ServicoQuarto objSeQ3 = new ServicoQuarto(104, "Arrumar as camas do quarto 14");
    }
    
}
