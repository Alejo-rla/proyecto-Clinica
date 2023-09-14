package Controlador;
import DAO.CrudCita;
import Vista.FrmCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCita implements ActionListener{

    CrudCita CrudCita;
    FrmCita fc;
    
    public CCita(FrmCita fc){
        this.fc=fc;
        fc.btnBuscar.addActionListener(this);
        fc.txtCodPaciente.setText("");
        fc.setTitle("Agendar Cita");
        fc.setVisible(true);
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fc.btnBuscar){
            CrudCita= new CrudCita();
            int codPaciente = Integer.parseInt(fc.txtCodPaciente.getText());
            
            CrudCita.BuscarCita(codPaciente, fc.jtCitas);
        }
    }
    
}
