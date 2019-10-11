package mx.edu.itsmt.ejemploqr.modelo;

public class Persona {

    String nombre;
    String apellidos;
    String grado;
    String correo;
    String telefono;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String grado, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.grado = grado;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
