
package DAO;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends ConexionBD{
    
    public boolean validarU(Usuario u){
        boolean uValido=false;
        try{
            String query="Select codUsuario, clave, tipoUsuario from Acesso"
                    + " where codUsuario=(?) and clave=(?) and tipoUsuario=(?);";
            ps=conexion.prepareStatement(query);
            ps.setString(1,u.getNombre());
            ps.setString(2, u.getClave());
            ps.setString(3, u.getTipoUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                uValido=true;
            }
            
        }catch(SQLException e){}
        
        return uValido;
    }
    
    public String obtenerNomUser(int codUser){
        String nomUser="";
        
        String query="Select concat(nombre,' ',apellido) from recepcionista"
                + " where codRecepcionista=(?);";
        
        try {
            ps = conexion.prepareStatement(query);
            ps.setInt(1, codUser);
            rs=ps.executeQuery();
            if(rs.next()){
                nomUser=rs.getString(1);
                System.out.println("nomUser");
            }
        } catch (SQLException ex) {}
        return nomUser;

    }
}
