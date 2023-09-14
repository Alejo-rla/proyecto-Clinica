
package Metodos;
import Vista.FrmLogin;
import Modelo.Usuario;

public class MetodosLogin {
    
    //lee usuario del frmLogin y crea el objeto
    public static Usuario LeerUsuario(FrmLogin fl){
        Usuario u = new Usuario();
        u.setNombre(fl.txtUsuario.getText());
        u.setClave(String.valueOf(fl.txtClave.getPassword()));
        u.setTipoUsuario(fl.cbxTipoU.getSelectedItem().toString());
        return u;
        
    }
    
    public static void LimpiarCampos(FrmLogin fl){
        fl.txtUsuario.setText("");
        fl.txtClave.setText("");
    }
    
    public static void CargarOpciones(FrmLogin fl){
        String[] empleados = {"Admision","Enfermero","Medico"};
        for(String empleado: empleados){
            fl.cbxTipoU.addItem(empleado);
        }
    }

    
}
