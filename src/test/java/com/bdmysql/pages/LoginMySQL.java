package com.bdmysql.pages;


import java.sql.*;

public class LoginMySQL {

    public static String status = "Não conectou...";

    public static String getLogin() throws Exception {

        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        Connection connection = null;

        String serverName = "localhost:3306";    //caminho do servidor do BD
        String mydatabase = "bancodeteste";        //nome do seu banco de dados
        String username = "root";        //nome de um usuário de seu BD
        String pw = "12345";      //sua senha de acesso
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

        connection = DriverManager.getConnection(url, username, pw);

        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }
        System.out.println(status);

        PreparedStatement statement = connection.prepareStatement(driverName);

        String query = "SELECT * FROM login";
        ResultSet resultSet = statement.executeQuery(query);

        String user = "";


        if (resultSet.next()) {

            user = resultSet.getString("user");

            connection.close();
        }

        return user;
    }

    public static String getPassword() throws Exception {

        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        Connection connection = null;

        String serverName = "localhost:3306";    //caminho do servidor do BD
        String mydatabase = "bancodeteste";        //nome do seu banco de dados
        String username = "root";        //nome de um usuário de seu BD
        String pw = "12345";      //sua senha de acesso
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

        connection = DriverManager.getConnection(url, username, pw);

        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }
        System.out.println(status);

        PreparedStatement statement = connection.prepareStatement(driverName);

        String query = "SELECT * FROM login";
        ResultSet resultSet = statement.executeQuery(query);

        String password = "";


        if (resultSet.next()) {

            password = resultSet.getString("password");

            connection.close();
        }

        return password;
    }

}

