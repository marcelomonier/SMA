package com.marcelomonier.iisemanademeioambiente;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    ImageView logo, nome_logo;
    EditText cpf, senha;
    Button btn_enviar;
    ProgressBar progressBar;



    Connection conn;
    String user, pass, db, ip, port, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        cpf = (EditText) findViewById(R.id.edit_matricula);
        senha = (EditText) findViewById(R.id.edit_senha);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btn_enviar = (Button) findViewById(R.id.button_enviar);

        progressBar.setVisibility(View.GONE);

        ip = "bdeventomeioambiente.cw9rjqh2pvcl.us-east-2.rds.amazonaws.com";
        db = "bdeventomeioambiente";
        user = "postgres";
        port = ":5432";
        pass = "admin1234";
        url = "jdbc:postgresql://";


        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            Login login = new Login();
            login.execute("");










            }
        });



    }


    public class Login extends AsyncTask<String, String, String>{


        String z = "";
        Boolean isSucess = false;

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            String text_cpf = cpf.getText().toString();
            String text_senha = senha.getText().toString();

            if (text_cpf.trim().equals("") || text_senha.trim().equals("")){

                z = "Entre com o seu CPF e sua senha.";

            } else {
                try {
                    conn = connectionclass(user, pass, db, ip, port, url);
                    if (conn == null){

                        z = "Verifique sua conexão";

                    } else{
                        String query = "SELECT *  FROM aluno WHERE cpf ='"+ text_cpf +"' and senha = '" + text_senha + "'";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        if (rs.next()){

                            Intent i = new Intent(MainActivity.this, MenuAlunoActivity.class);
                            startActivity(i);
                            isSucess = true;
                            conn.close();


                        }else {

                            z = "CPF ou senha inexistentes.";
                            isSucess = false;

                        }



                    }
                } catch (SQLException e) {
                    isSucess = false;
                    z = e.getMessage();
                }
            }
            return z;


        }

        @Override
        protected void onPostExecute(String r) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_LONG).show();
            if (isSucess){

                Toast.makeText(MainActivity.this, "Login efetuado com sucesso.", Toast.LENGTH_LONG).show();

            }
        }
    }




    @SuppressLint("NewApi")
    public Connection connectionclass(String user, String password, String database, String server, String porta, String url_cabecalho){


        StrictMode.ThreadPolicy polyce = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(polyce);
        Connection connection = null;
        String ConnectionURL = null;

        try{

            Class.forName("org.postgresql.Driver");
            //jdbc:postgresql://bdeventomeioambiente.cw9rjqh2pvcl.us-east-2.rds.amazonaws.com:5432/bdeventomeioambiente"
            ConnectionURL = url_cabecalho + server + porta + "/" + database + " ;user=" + user + " ;password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);


        } catch (SQLException se) {
            Log.e("error here 1 : ", se.getMessage());
        }

        catch (ClassNotFoundException e){

            Log.e("error here 2 : ", e.getMessage());

        }

        catch (Exception e){

            Log.e("error here 3 : ", e.getMessage());

        }
        return connection;
    }
}
