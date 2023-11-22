/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author nplay
 */
public class Hospede extends Pessoa {
    
    private String cpf;
    private double taxaDesconto;
    private ArrayList<Registro> registros;  

    public Hospede(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
        registros = new ArrayList<Registro>();
    }

    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public String getCpf() {
        return cpf;
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }
    
    
    public static boolean validarCPF(String cpf){
        cpf = cpf.replaceAll("\\.", "");
        int valida = 0, dv1, dv2;
        //calculo do primeiro digito verificador
        for(int i = 0; i<9; i++){
            valida += (Integer.parseInt(String.valueOf(cpf.charAt(i))) * (i+1));
        }
        
        dv1 = valida%11;
        if(dv1==10)
            dv1=0;
        
        //calculo do segundo digito verificador
        cpf = cpf.replaceAll("\\-", "");
        valida = 0;
        for(int i = 11; i>1; i--){
            valida += (Integer.parseInt(String.valueOf(cpf.charAt(11-i))) * i);
        }
        
        dv2 = (valida*10)%11;
        if(dv2==10)
            dv2=0;
        
        if(dv1== Integer.parseInt(String.valueOf(cpf.charAt(9))) && dv2==Integer.parseInt(String.valueOf(cpf.charAt(10)))){
            return true;
        }
        else
            return false;
    }
    
    public void addRegistro(Registro r){
        registros.add(r);
    }
    
}
