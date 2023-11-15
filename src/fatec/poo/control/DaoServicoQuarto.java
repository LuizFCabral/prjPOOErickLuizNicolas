package fatec.poo.control;

import fatec.poo.model.ServicoQuarto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author nplay
 */
public class DaoServicoQuarto {
   
    private Connection conn;
    
    public DaoServicoQuarto(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(ServicoQuarto servicoQuarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbServicoQuarto(Codigo_SerQrt, Descr_SerQrt, Valor_SerQrt) VALUES(?,?,?)");
            ps.setInt(1, servicoQuarto.getCodigo());
            ps.setString(2, servicoQuarto.getDescricao());
            ps.setDouble(3, servicoQuarto.getValor());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(ServicoQuarto servicoQuarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbServicoQuarto set Descr_SerQrt = ?, Valor_SerQrt = ? " +
                                                 "where Codigo_SerQrt = ?");
            
            ps.setString(1, servicoQuarto.getDescricao());
            ps.setDouble(2, servicoQuarto.getValor());
            ps.setInt(3, servicoQuarto.getCodigo());
            
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  ServicoQuarto consultar (int codigo) {
        ServicoQuarto d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbServicoQuarto where " +
                                                 "Codigo_SerQrt = ?");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new ServicoQuarto (codigo, rs.getString("Descr_SerQrt"));
                d.setValor(rs.getDouble("Valor_SerQrt"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(ServicoQuarto servicoQuarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbServicoQuarto where Codigo_SerQrt = ?");
            
            ps.setInt(1, servicoQuarto.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
