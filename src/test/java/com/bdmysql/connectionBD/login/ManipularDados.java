package com.bdmysql.connectionBD.login;

import java.sql.Connection;
import java.util.List;

public class ManipularDados {
    private static Connection connection;
    static LoginBD dao;
    public static void conectarBD() {
        dao = new LoginBD();
    }

    public static void inserirLogin(String user, String password, String url ) {
        Login login = new Login();
        login.setUser(user);
        login.setPassword(password);
        login.setUrl(url);
        dao.adiciona(login);
        System.out.println("Dados inclusos com sucesso!");
    }

    public static void alterarLogin(String codigoLogin, String user, String password, String url){

        Login login = new Login();
        login.setCodigoLogin(codigoLogin);
        login.setUser(user);
        login.setPassword(password);
        login.setUrl(url);


        dao.altera(login);
        System.out.println("Dados alterados com sucesso!");
    }

    public static void removerLogin(String entrada) {
        long id = Integer.parseInt(entrada);
        dao.remove(id);

        System.out.println("Objeto removido com sucesso!");
    }


    public static void listarLogins(){
        List<Login> login = dao.getLista();

        for (Login l : login) {
            System.out.println("------------\nID_Login: " + l.getCodigoLogin());
            System.out.println("User: " + l.getUser());
            System.out.println("Password: " + l.getPassword());
            System.out.println("Url: " + l.getUrl());
        }

        System.out.println("------------\nExibindo lista!");
    }

}
