package com.marcelomonier.iisemanademeioambiente;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB extends _Default implements Runnable{

    private Connection conn;
    private String host = "";
    private String db = "bdeventomeioambiente";
    private int port = 2345;
    private String user = "postgres";
    private String pass = "admin1234";
    private String url = "jdbc:postgresql://%s:%d/%s";



    public DB() {

        super();
        this.url = String.format(this.url, this.host, this.port, this.db);

        //Abrir conexao
        this.concta();


        //Fechar conexao
        this.desconecta();


    }

    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);


        }catch (Exception e){

            this._mensagem = e.getMessage();
            this._status = false;

        }
    }


    private void concta(){

        Thread thread = new Thread(this);
        thread.start();


        try {
            thread.join();

        }catch (Exception e){

            this._mensagem = e.getMessage();
            this._status = false;

        }

    }


    private void desconecta(){

        if (conn != null){
            try{
                this.conn.close();
            } catch (Exception e){

            } finally {
                this.conn = null;
            }

        }
    }
}
