package com.marcelomonier.iisemanademeioambiente;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;


public class Menu2Activity extends AppCompatActivity {

    ImageView logo, nome_logo, programacao2_imagem, qrcode2_imagem, local2_imagem, inscricao_imagem;

    TextView nome_programacao, nome_qrcode, nome_local, nome_inscricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        programacao2_imagem = (ImageView) findViewById(R.id.imageView6);
        qrcode2_imagem = (ImageView) findViewById(R.id.imageView5);
        local2_imagem  = (ImageView) findViewById(R.id.imageView9);



        programacao2_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu2Activity.this, Programacao2Activity.class);
                startActivity(i);
            }
        });



        local2_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:-6.3398207, -47.4027648?z=17");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                //Intent it = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapIntent);
            }
        });

        final Activity activity = this;
        qrcode2_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();


            }
        });

    }
}
