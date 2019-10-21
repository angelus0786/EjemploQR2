package mx.edu.itsmt.ejemploqr.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import mx.edu.itsmt.ejemploqr.bd.MyDatabase;
import mx.edu.itsmt.ejemploqr.modelo.Departamento;

public class DepartamentoDAO {

    Context context;
    Departamento departamento = new Departamento();

    MyDatabase myDatabase = new MyDatabase(context);

    public Departamento getDepartamento(String clave) {

        SQLiteDatabase db = myDatabase.getReadableDatabase();
        String sql="select DISTINCT A.grado,A.nombre,A.apellidos,A.correo,A.telefono,B.Adscripción,C.horario,C.ubicacion,D.logo from Persona A,trabajador B,Departamentos C,Carrera D " +
                " where C.nombre_depto like '"+clave+ "' and A.id=B.id_persona AND B.id_persona=C.id_jefe AND C.id_jefe=D.id_jefe ;";
        Cursor c = db.rawQuery(sql,null);

        while (c.moveToNext()){
            departamento.setNombre(c.getString(1));
            departamento.setApellidos(c.getString(2));
            departamento.setCorreo(c.getString(3));
            departamento.setTelefono(c.getString(4));
            departamento.setAdscripcion(c.getString(5));
            departamento.setUbicacion(c.getString(6));
            departamento.setLogo(c.getString(8));
        }
       myDatabase.close();
        return departamento;

    }



}
