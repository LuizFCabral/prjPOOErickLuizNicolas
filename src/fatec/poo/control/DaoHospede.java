/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author super
 */
public class DaoHospede {
    private Connection conn;
    
    public DaoHospede(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbHospede(CPF_Hosp, Nome_Hosp, Endereco_Hosp, Telefone_Hosp, TaxaDesc_Hosp) VALUES(?,?,?,?,?)");
            ps.setString(1, hospede.getCpf());
            ps.setString(2, hospede.getNome());
            ps.setString(3, hospede.getEndereco());
            ps.setString(4, hospede.getTelefone());
            ps.setDouble(5, hospede.getTaxaDesconto());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbHospede set Nome_Hosp = ?, Endereco_Hosp = ?, Telefone_Hosp = ?,  TaxaDesc_Hosp = ?" +
                                                 "where CPF_Hosp = ?");
            ps.setString(1, hospede.getNome());
            ps.setString(2, hospede.getEndereco());
            ps.setString(3, hospede.getTelefone());
            ps.setDouble(4, hospede.getTaxaDesconto());
            ps.setString(5, hospede.getCpf());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Hospede consultar (String cpf) {
        Hospede hospede = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbHospede where " +
                                                 "CPF_Hosp = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                hospede = new Hospede(cpf, rs.getString("Nome_Hosp"));
                hospede.setEndereco(rs.getString("Endereco_Hosp"));
                hospede.setTelefone(rs.getString("Telefone_Hosp"));
                hospede.setTaxaDesconto(rs.getDouble("TaxaDesc_Hosp"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (hospede);
    }    
     
     public void excluir(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbHospede where CPF_Hosp = ?");
            
            ps.setString(1, hospede.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
