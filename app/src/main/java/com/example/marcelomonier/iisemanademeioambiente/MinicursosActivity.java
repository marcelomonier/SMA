package com.example.marcelomonier.iisemanademeioambiente;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class MinicursosActivity extends AppCompatActivity {


    CardView cardMinicurso_1, cardMinicurso_2, cardMinicurso_3, cardMinicurso_4;
    ImageView foto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minicursos);

        foto1 = (ImageView) findViewById(R.id.felipe_image);

        cardMinicurso_1 = (CardView) findViewById(R.id.card_minicursos_felipe);
        cardMinicurso_2 = (CardView) findViewById(R.id.card_minicursos_pedro);
        cardMinicurso_3 = (CardView) findViewById(R.id.card_minicursos_joyce);
        cardMinicurso_4 = (CardView) findViewById(R.id.card_minicursos_joao);


        cardMinicurso_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MinicursosActivity.this);
                builder.setTitle(getString(R.string.title_minicurso_felipe));
                builder.setMessage(getString(R.string.felipe_descricao));

                String positiveText = getString(android.R.string.ok);
                builder.setPositiveButton(positiveText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic
                            }
                        });


                AlertDialog dialog = builder.create();
                // display dialog
                dialog.show();

            }
        });

        cardMinicurso_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MinicursosActivity.this);
                builder.setTitle(getString(R.string.title_minicurso_pedro));
                builder.setMessage(getString(R.string.felipe_descricao));

                String positiveText = getString(android.R.string.ok);
                builder.setPositiveButton(positiveText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic
                            }
                        });


                AlertDialog dialog = builder.create();
                // display dialog
                dialog.show();

            }
        });


        cardMinicurso_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MinicursosActivity.this);
                builder.setTitle(getString(R.string.title_minicurso_joyce));
                builder.setMessage(getString(R.string.felipe_descricao));

                String positiveText = getString(android.R.string.ok);
                builder.setPositiveButton(positiveText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic
                            }
                        });


                AlertDialog dialog = builder.create();
                // display dialog
                dialog.show();

            }
        });

        cardMinicurso_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MinicursosActivity.this);
                builder.setTitle(getString(R.string.title_minicurso_joao));
                builder.setMessage(getString(R.string.joao_descricao));

                String positiveText = getString(android.R.string.ok);
                builder.setPositiveButton(positiveText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic
                            }
                        });


                AlertDialog dialog = builder.create();
                // display dialog
                dialog.show();

            }
        });




    }

}