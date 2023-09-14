
package DAO;
import Modelo.Usuario;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
    
}
