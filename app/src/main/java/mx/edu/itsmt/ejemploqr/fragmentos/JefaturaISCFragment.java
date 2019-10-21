package mx.edu.itsmt.ejemploqr.fragmentos;


import android.app.Fragment;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import mx.edu.itsmt.ejemploqr.R;
import mx.edu.itsmt.ejemploqr.bd.MyDatabase;

import mx.edu.itsmt.ejemploqr.modelo.Departamento;

/**
 * A simple {@link Fragment} subclass.
 */
public class JefaturaISCFragment extends Fragment {

     TextView nombrejefe,adscripcion, horario,telefono,correo,ubicacion;
     ImageView logotipo;
     Departamento departamento;
     MyDatabase myDatabase;
     String codigo;
     String carrera="isc";
    public JefaturaISCFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_jefatura_isc, container, false);
        logotipo = vista.findViewById(R.id.logo);
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

        getDatos(vista);
        return vista;

    }

    public  void getDatos(View view) {
            if (departamento.getLogo()!=null){
                carrera = departamento.getLogo().toString();
            }else{
                carrera="tec";
            }
            switch (carrera) {
                case "isc":
                    logotipo.setImageResource(R.drawable.isc);
                    break;
                case "imt":
                    logotipo.setImageResource(R.drawable.imt);
                    break;
                case "iia":
                    logotipo.setImageResource(R.drawable.iia);
                    break;
                case "ia":
                    logotipo.setImageResource(R.drawable.ia);
                    break;
                case "ige":
                    logotipo.setImageResource(R.drawable.ige);
                    break;
                case "tec":
                    logotipo.setImageResource(R.drawable.tec);
                    break;
            }

        nombrejefe.setText(departamento.getGrado()+departamento.getNombre()+" "+departamento.getApellidos());
        adscripcion.setText(departamento.getAdscripcion());
        horario.setText(departamento.getHorario());
        telefono.setText(departamento.getTelefono());
        correo.setText(departamento.getCorreo());
        ubicacion.setText(departamento.getUbicacion());
    }
}
