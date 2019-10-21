package mx.edu.itsmt.ejemploqr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import mx.edu.itsmt.ejemploqr.controlador.DepartamentoDAO;
import mx.edu.itsmt.ejemploqr.modelo.Departamento;

public class ActivityEscanear extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView escanerZXing;
    Departamento departamento;

    Intent intentRegreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escanear);
        escanerZXing = new ZXingScannerView(this);
        // Hacer que el contenido de la actividad sea el escaner
        setContentView(escanerZXing);

    }
    @Override
    public void onResume() {
        super.onResume();
        // El "manejador" del resultado es esta misma clase, por eso implementamos ZXingScannerView.ResultHandler
        escanerZXing.setResultHandler(this);
        escanerZXing.startCamera(); // Comenzar la cámara en onResume
    }
    @Override
    public void onPause() {
        super.onPause();
        escanerZXing.stopCamera(); // Pausar en onPause
    }

    @Override
    public void handleResult(Result resultado) {
        // Si quieres que se siga escaneando después de haber leído el código, descomenta lo siguiente:
        // Si la descomentas no recomiendo que llames a finish
       //        escanerZXing.resumeCameraPreview(this);
        // Obener código/texto leído
        String codigo = resultado.getText();
        // Preparar un Intent para regresar datos a la actividad que nos llamó
      //////////////
      //  switch (codigo){
       //     case "Jefatura ISC":
                intentRegreso = new Intent(ActivityEscanear.this,ContenidoActivity.class);
                intentRegreso.putExtra("codigo", codigo);
             //   intentRegreso.putExtra("depto", departamento);
                startActivity(intentRegreso);
             //   break;
          ////  case "Jefatura IMT":
         ////       intentRegreso = new Intent(ActivityEscanear.this,ContenidoActivity.class);
            //    intentRegreso.putExtra("codigo", codigo);
                //   intentRegreso.putExtra("depto", departamento);
              //  startActivity(intentRegreso);
          ////      break;
       ////     case "Jefatura IIA":
        ////        intentRegreso = new Intent(ActivityEscanear.this,ContenidoActivity.class);

                //   intentRegreso.putExtra("depto", departamento);
              //  startActivity(intentRegreso);
       ///         break;
     ///   }
     //   intentRegreso.putExtra("codigo", codigo);
       // startActivity(intentRegreso);
        //////////
      ///  Intent intentRegreso = new Intent();
     //   intentRegreso.putExtra("codigo", codigo);
    //    setResult(Activity.RESULT_OK, intentRegreso);
        // Cerrar la actividad. Ahora mira onActivityResult de MainActivity
        finish();
    }
}
