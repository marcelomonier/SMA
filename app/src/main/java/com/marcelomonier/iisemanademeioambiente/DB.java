package com.marcelomonier.iisemanademeioambiente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DB extends _Default implements Runnable{

    private Connection conn;
    private String host = "bdeventomeioambiente.cw9rjqh2pvcl.us-east-2.rds.amazonaws.com";
    private String db = "bdeventomeioambiente";
    private int port = 2345;
    private String user = "postgres";
    private String pass = "admin1234";
    private String url = "jdbc:postgresql://%s:%d/%s";



    public DB() {

        super();
        this.host = String.format(this.url, this.host, this.port, this.db);

        //Abrir conexao
        this.conecta();


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


    private void conecta(){

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


    public ResultSet select(String query){

        this.conecta();
        ResultSet resultSet = null;

        try{

            resultSet = new ExecuteDB(this.conn, query).execute().get();

        } catch (Exception e){

            this._status = false;
            this._mensagem = e.getMessage();

        }

        return resultSet;
    }

    public ResultSet execute(String query){

        this.conecta();
        ResultSet resultSet = null;

        try{

            resultSet = new ExecuteDB(this.conn, query).execute().get();

        } catch (Exception e){

            this._status = false;
            this._mensagem = e.getMessage();

        }

        return resultSet;
    }


}
