package Controlador;
import DAO.Login;
import Principal.Main;
import Vista.FrmPrincipal;
import Vista.FrmCita;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class CFrmPrincipal implements ActionListener{

    FrmPrincipal fp;
    Login login;
    
    public CFrmPrincipal(FrmPrincipal fp,String nomUser){
        this.fp=fp;
        fp.lblNomUser.setText(nomUser);
        fp.btnSalir.addActionListener(this);
        fp.jmiCitas.addActionListener(this);

        fp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fp.setDefaultCloseOperation(fp.EXIT_ON_CLOSE);
        fp.setTitle("Sanna / Centro Clinico");
        fp.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fp.btnSalir){
            fp.dispose();
            Main.InicioSesion();
        }
        
        if(e.getSource()==fp.jmiCitas){
            FrmCita fc= new FrmCita();
            CCita cfc = new CCita(fc);
            fp.Container.add(fc);
        }
    }
    
}
