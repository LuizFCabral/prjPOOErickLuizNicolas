/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Erick
 */
public class DaoQuarto {
    
    private Connection  conn;
    
    public DaoQuarto(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Quarto quarto){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbQuarto(Numero_Qrt, Tipo_Qrt, ValorDiaria_Qrt) VALUES(?,?,?)");
            ps.setInt(1, quarto.getNumero());
            ps.setString(2, quarto.getTipo());
            ps.setDouble(3, quarto.getValorDiaria());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Quarto quarto){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbQuarto set Tipo_Qrt = ?, ValorDiaria_Qrt = ? where Numero_Qrt = ?");
            ps.setString(1, quarto.getTipo());
            ps.setDouble(2, quarto.getValorDiaria());
            ps.setInt(3, quarto.getNumero());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());   
        }
    }
    
    public Quarto consultar(int numero){
        Quarto d = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * from tbQuarto where Numero_Qrt = ?");
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if(rs.next() == true) {
                d = new Quarto(numero, rs.getString("Tipo_Qrt"), rs.getDouble("ValorDiaria_Qrt"));
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());   
        }
        return(d);
    }
    
    public void excluir(Quarto quarto){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbQuarto where Numero_Qrt = ?");
            ps.setInt(1, quarto.getNumero());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());   
        }
    }
}
