
package DAO;
import Modelo.Cita;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CrudCita extends ConexionBD{
    
    public void BuscarCita(int codPaciente,JTable tabla){
        String[] headers={"DNI","Fecha","Hora","Nombre y Apellido","Especialidad"};
        DefaultTableModel tModelo =  new DefaultTableModel(null,headers);
        tabla.setModel(tModelo);
        
        String query="Select c.Paciente_idPaciente, c.Fecha, c.Hora,"
                + " concat(p.Nombre,' ',p.Apellido),"
                + " a.Nombre as 'Especialidad'  from Cita c"
                + " inner join Paciente p on (c.Paciente_idPaciente=p.idPaciente)"
                + " inner join area_medica a on (c.Area_Medica_codArea=a.codArea)"
                + " where Paciente_idPaciente=(?)";
        
        try {
            ps=conexion.prepareStatement(query);
            ps.setInt(1,codPaciente);
            rs=ps.executeQuery();
            Object[] Resultado=new Object[5];
            if(rs.next()){
                Resultado[0]=rs.getInt(1);
                Resultado[1]=rs.getDate(2);
                Resultado[2]=rs.getTime(3);
                Resultado[3]=rs.getString(4);
                Resultado[4]=rs.getString(5);
                
            }
            tModelo.addRow(Resultado);
            
        } catch (SQLException ex) {
        }
        
        
    }
    
}
