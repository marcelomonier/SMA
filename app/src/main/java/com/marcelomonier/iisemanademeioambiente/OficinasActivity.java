package com.marcelomonier.iisemanademeioambiente;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class OficinasActivity extends AppCompatActivity {

    CardView card_oficina_1, card_oficina_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficinas);



        card_oficina_1 = (CardView) findViewById(R.id.card_alana);
        card_oficina_2 = (CardView) findViewById(R.id.card_regia);


        card_oficina_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OficinasActivity.this);
                builder.setTitle(getString(R.string.title_oficina_alana));
                builder.setMessage(getString(R.string.alana_descricao));

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


        card_oficina_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OficinasActivity.this);
                builder.setTitle(getString(R.string.title_oficina_regia));
                builder.setMessage(getString(R.string.regia_descricao));

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
