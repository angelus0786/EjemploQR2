package mx.edu.itsmt.ejemploqr.fragmentos;


import android.app.Fragment;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import mx.edu.itsmt.ejemploqr.R;
import mx.edu.itsmt.ejemploqr.bd.MyDatabase;

import mx.edu.itsmt.ejemploqr.modelo.Departamento;

/**
 * A simple {@link Fragment} subclass.
 */
public class JefaturaISCFragment extends Fragment {

    TextView nombrejefe,adscripcion, horario,telefono,correo,ubicacion;
     Departamento departamento;

     MyDatabase myDatabase;
     String codigo;
    public JefaturaISCFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_jefatura_isc, container, false);
        nombrejefe = vista.findViewById(R.id.tv_nombre_jefe);
        adscripcion=vista.findViewById(R.id.tv_nombre_adscripcion);
        horario=vista.findViewById(R.id.tv_horario);
        telefono =vista.findViewById(R.id.tv_telefono);
        correo=vista.findViewById(R.id.tv_correo);
        ubicacion=vista.findViewById(R.id.tv_ubicacion);
        departamento = new Departamento();
        myDatabase = new MyDatabase(getActivity());
        codigo = getArguments().getString("codigo");
        departamento = myDatabase.getDepartamento(codigo);

        getDatos();
        return vista;
    }

    public  void getDatos() {

        nombrejefe.setText(departamento.getGrado()+departamento.getNombre()+" "+departamento.getApellidos());
        adscripcion.setText(departamento.getAdscripcion());
        horario.setText(departamento.getHorario());
        telefono.setText(departamento.getTelefono());
        correo.setText(departamento.getCorreo());
        ubicacion.setText(departamento.getUbicacion());
    }
}
