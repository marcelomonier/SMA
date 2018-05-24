package com.example.marcelomonier.iisemanademeioambiente;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    ImageView logo, nome_logo, programacao_imagem, qrcode_imagem, local_imagem, inscricao_imagem;

    TextView nome_programacao, nome_qrcode, nome_local, nome_inscricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        programacao_imagem = (ImageView) findViewById(R.id.imageView6);
        qrcode_imagem = (ImageView) findViewById(R.id.imageView5);
        local_imagem  = (ImageView) findViewById(R.id.imageView9);



        programacao_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, Programacao2Activity.class);
                startActivity(i);
            }
        });



        local_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:-6.3398207, -47.4027648?z=17");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                //Intent it = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapIntent);
            }
        });




    }
}
