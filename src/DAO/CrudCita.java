
package DAO;
import Modelo.Cita;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudCita extends ConexionBD{
    
    public void BuscarCita(int codPaciente){
        String query="Select c.Paciente_idPaciente, c.Fecha, c.Hora,"
                + " concat(p.Nombre,' ',p.Apellido),"
                + " a.Nombre as 'Especialidad'  from Cita c"
                + " inner join Paciente p on (c.Paciente_idPaciente=p.idPaciente)"
                + " inner join area_medica a on (c.Area_Medica_codArea=a.codArea)"
                + " where Paciente_idPaciente=(?)";
        
        try {
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            if(rs.next()){
                Object[] Resultado=new Object[5];
                Resultado[0]=rs.getInt(1);
                Resultado[1]=rs.getDate(2);
                Resultado[2]=rs.getTime(3);
                Resultado[3]=rs.getString(4);
                Resultado[4]=rs.getString(5);
                
            }
            
        } catch (SQLException ex) {
        }
        
        
    }
    
}
