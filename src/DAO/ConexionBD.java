package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionBD implements ParametrosBD{
    public Connection conexion;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement ps;
    public ResultSetMetaData mdata;

    public ConexionBD() {
        try{
           Class.forName(DRIVER);
           conexion = DriverManager.getConnection(RUTA,USUARIO,CLAVE);
           st=conexion.createStatement();
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
    
    
    
}
