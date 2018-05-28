package com.example.marcelomonier.iisemanademeioambiente;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;


public class MenuAlunoActivity extends AppCompatActivity {

    private ImageView logo, nome_logo, programacao_imagem_alnuo, qrcode_imagem_aluno, local_imagem_aluno, inscricao_imagem;

    private TextView nome_programacao, nome_qrcode, nome_local, nome_inscricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_aluno);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        programacao_imagem_alnuo = (ImageView) findViewById(R.id.programacao_aluno);
        qrcode_imagem_aluno = (ImageView) findViewById(R.id.qrcode_aluno);
        local_imagem_aluno  = (ImageView) findViewById(R.id.local_aluno);



        programacao_imagem_alnuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuAlunoActivity.this, Programacao2Activity.class);
                startActivity(i);
            }
        });



        local_imagem_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:-6.3398207, -47.4027648?z=17");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                //Intent it = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapIntent);
            }
        });

        final Activity activity = this;
        qrcode_imagem_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "Gerar qrcode aluno", Toast.LENGTH_SHORT).show();


            }
        });

    }
}
