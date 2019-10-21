package mx.edu.itsmt.ejemploqr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import mx.edu.itsmt.ejemploqr.fragmentos.JefaturaISCFragment;
import mx.edu.itsmt.ejemploqr.modelo.Departamento;

public class ContenidoActivity extends AppCompatActivity {

    Fragment fragment;
    Departamento departamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
      departamento = new Departamento();
      fragment = new JefaturaISCFragment();

        Bundle intent = getIntent().getExtras();
        String codigo  = intent.getString("codigo");
        fragment.setArguments(intent);
        FragmentManager miManejador = getFragmentManager();
        FragmentTransaction miTransaction = miManejador.beginTransaction();

        miTransaction.replace(R.id.contenedor,fragment);
        miTransaction.commit();

        getSupportActionBar().setTitle("ITSMT - "+codigo);

    }
}
