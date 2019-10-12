package mx.edu.itsmt.ejemploqr.bd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import mx.edu.itsmt.ejemploqr.controlador.DepartamentoDAO;
import mx.edu.itsmt.ejemploqr.modelo.Departamento;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "RecorridosITSMT1.sql";
    private static final int DATABASE_VERSION = 1;
    Departamento departamento=new Departamento();

    public MyDatabase(Context context) {
       super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    public Departamento getDepartamento(String clave) {

        SQLiteDatabase db = getReadableDatabase();
        String sql="select DISTINCT A.grado,A.nombre,A.apellidos,A.correo,A.telefono,B.Adscripción,C.horario,C.ubicacion from Persona A,trabajador B,Departamentos C " +
                " where C.nombre_depto like '"+clave+ "' and A.id=B.id_persona AND B.id_persona=C.id_jefe ;";
        Cursor c = db.rawQuery(sql,null);

        while (c.moveToNext()){
            departamento.setGrado(c.getString(0));
            departamento.setNombre(c.getString(1));
            departamento.setApellidos(c.getString(2));
            departamento.setCorreo(c.getString(3));
            departamento.setTelefono(c.getString(4));
            departamento.setAdscripcion(c.getString(5));
            departamento.setHorario(c.getString(6));
            departamento.setUbicacion(c.getString(7));
        }
        db.close();
        return departamento;

    }
}
