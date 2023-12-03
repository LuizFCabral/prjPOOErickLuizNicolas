/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Registro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author super
 */
public class DaoRegistro {
    private Connection conn;
    
    public DaoRegistro(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Registro registro) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbRegistro(Codigo_Reg, RegFunc_Rec, CPF_Hosp, Numero_Qrt,"
                    + " DataEntrada_Reg, ValorHosp_Reg) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, registro.getCodigo());
            ps.setInt(2, registro.getRecepcionista().getRegFunc());
            ps.setString(3, registro.getHospede().getCpf());
            ps.setInt(4, registro.getQuarto().getNumero());
            ps.setDate(5, Date.valueOf(registro.getDataEntrada()));
            ps.setDouble(6, registro.getValorHospedagem());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Registro registro) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbRegistro set Codigo_Reg = ?, RegFunc_Rec = ?, CPF_Hosp = ?, Numero_Qrt = ?,"
                    + " DataEntrada_Reg = ?, DataSaida_Reg = ?, ValorHosp_Reg = ? WHERE Codigo_Reg = ?");
            ps.setInt(1, registro.getRecepcionista().getRegFunc());
            ps.setString(2, registro.getHospede().getCpf());
            ps.setInt(3, registro.getQuarto().getNumero());
            ps.setDate(4, Date.valueOf(registro.getDataEntrada()));
            ps.setDate(5, Date.valueOf(registro.getDataSaida()));
            ps.setDouble(6, registro.getValorHospedagem());
            ps.setInt(7, registro.getCodigo());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Registro consultar (int codigo) {
        Registro registro = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbRegistro where " +
                                                 "Codigo_Reg = ?");
            
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            DaoRecepcionista daoRecepcionista = new DaoRecepcionista(conn);
            DaoHospede daoHosp = new DaoHospede(conn);
            DaoQuarto daoQuarto = new DaoQuarto(conn);
            
           
            if (rs.next() == true) {
                registro = new Registro(codigo, rs.getDate("DataEntrada_Reg").toLocalDate(), daoRecepcionista.consultar(rs.getInt("RegFunc_Rec")));
                if(rs.getDate("DataSaida_Reg")!=null)
                    registro.setDataSaida(rs.getDate("DataSaida_Reg").toLocalDate());
                registro.setHospede(daoHosp.consultar(rs.getString("CPF_Hosp")));
                registro.setQuarto(daoQuarto.consultar(rs.getInt("Numero_Qrt")));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (registro);
    }    
     
     public void excluir(Registro registro) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbRegistro where Codigo_Reg = ?");
            
            ps.setInt(1, registro.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
}
