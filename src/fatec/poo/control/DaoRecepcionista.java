/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Recepcionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Erick
 */
public class DaoRecepcionista {
    private Connection  conn;
    
    public DaoRecepcionista(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Recepcionista recepcionista){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbRecepcionista(RegFunc_Rec, Nome_Rec, Endereco_Rec, Telefone_Rec, Turno_Rec) VALUES(?,?,?,?,?)");
            ps.setInt(1, recepcionista.getRegFunc());
            ps.setString(2, recepcionista.getNome());
            ps.setString(3, recepcionista.getEndereco());
            ps.setString(4, recepcionista.getTelefone());
            ps.setString(5, recepcionista.getTurno());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Recepcionista recepcionista){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbRecepcionista set Nome_Rec = ?, Endereco_Rec = ?, Telefone_Rec = ?, Turno_Rec = ? where RegFunc_Rec = ?");
            ps.setString(1, recepcionista.getNome());
            ps.setString(2, recepcionista.getEndereco());
            ps.setString(3, recepcionista.getTelefone());
            ps.setString(4, recepcionista.getTurno());
            ps.setInt(5, recepcionista.getRegFunc());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());   
        }
    }
    
    public Recepcionista consultar(int regFunc){
        Recepcionista d = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * from tbRecepcionista where RegFunc_Rec = ?");
            ps.setInt(1, regFunc);
            ResultSet rs = ps.executeQuery();
            if(rs.next() == true) {
                d = new Recepcionista(regFunc, rs.getString("Nome_Rec"));
                d.setEndereco(rs.getString("Endereco_Rec"));
                d.setTelefone(rs.getString("Telefone_Rec"));
                d.setTurno(rs.getString("Turno_Rec"));
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());   
        }
        return(d);
    }
    
    public void excluir(Recepcionista recepcionista){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbRecepcionista where RegFunc_Rec = ?");
            ps.setInt(1, recepcionista.getRegFunc());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());   
        }
    }
}
