package mx.edu.itsmt.ejemploqr.modelo;

import java.io.Serializable;

public class Departamento extends Trabajador implements Serializable {

    String nombre_depto;
    String horario;
    String ubicacion;
    String logo;

    public Departamento() {

    }

    public Departamento(String nombre, String apellidos, String grado, String correo, String telefono, int id_persona, String puesto, String adscripcion, String nombre_depto, String horario, String ubicacion, String logo) {
        super(nombre, apellidos, grado, correo, telefono, id_persona, puesto, adscripcion);
        this.nombre_depto = nombre_depto;
        this.horario = horario;
        this.ubicacion = ubicacion;
        this.logo = logo;
    }

    public String getNombre_depto() {
        return nombre_depto;
    }

    public void setNombre_depto(String nombre_depto) {
        this.nombre_depto = nombre_depto;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
