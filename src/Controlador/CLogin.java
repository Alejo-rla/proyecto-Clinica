package Controlador;

import Modelo.Usuario;
import DAO.Login;
import Metodos.MetodosLogin;
import Vista.FrmLogin;
import Vista.FrmPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CLogin  implements ActionListener{
    Usuario u;
    FrmLogin fl;
    Login login;

    public CLogin (FrmLogin fl){
        this.fl=fl;
        fl.btnIngresar.addActionListener(this);
        fl.btnSalir.addActionListener(this);
        fl.setTitle("LOGIN");
        fl.setVisible(true);
        fl.lblEstadoIngreso.setText("");
        MetodosLogin.CargarOpciones(fl);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fl.btnIngresar){
            u= MetodosLogin.LeerUsuario(fl);
            login = new Login();
            
            if(login.validarU(u)){
                int codUser= Integer.parseInt(fl.txtUsuario.getText());
                
                String nomUser= login.obtenerNomUser(codUser);
                fl.dispose();
                
                FrmPrincipal fp= new FrmPrincipal();
                CPrincipal cfp = new CPrincipal(fp, nomUser);
                
                System.out.println(nomUser);
            }else{
                fl.lblEstadoIngreso.setText("Datos incorrectos");
                MetodosLogin.LimpiarCampos(fl);
            }
        }
        
        if(e.getSource()==fl.btnSalir){
            fl.dispose();
        }
    
    }
    
}
