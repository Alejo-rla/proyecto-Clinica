package Modelo;

import java.time.LocalTime;
import java.util.Date;


public class Cita {
    private int codDoctor;
    private int codArea;
    private int codPaciente;
    private Date fecha;
    private LocalTime hora;

    public Cita() {
    }

    public int getCodDoctor() {
        return codDoctor;
    }

    public void setCodDoctor(int codDoctor) {
        this.codDoctor = codDoctor;
    }

    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int codArea) {
        this.codArea = codArea;
    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
      
    //para mostrar en la tabla de citas
    public Object[] RegistroCita() {
        String nomApell = "";
        String Especialidad = "";
        Object[] registro= {codPaciente,fecha,hora,nomApell,Especialidad};
        return registro;
    }
    
}
