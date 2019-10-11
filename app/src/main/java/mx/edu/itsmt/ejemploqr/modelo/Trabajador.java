package mx.edu.itsmt.ejemploqr.modelo;

public class Trabajador extends Persona {
    int id_persona;
    String puesto;
    String adscripcion;

    public Trabajador() {
    }

    public Trabajador(String nombre, String apellidos, String grado, String correo, String telefono, int id_persona, String puesto, String adscripcion) {
        super(nombre, apellidos, grado, correo, telefono);
        this.id_persona = id_persona;
        this.puesto = puesto;
        this.adscripcion = adscripcion;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getAdscripcion() {
        return adscripcion;
    }

    public void setAdscripcion(String adscripcion) {
        this.adscripcion = adscripcion;
    }
}
