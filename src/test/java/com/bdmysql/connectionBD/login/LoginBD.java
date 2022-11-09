package com.bdmysql.connectionBD.login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginBD {

    private Connection connection;
    final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public LoginBD() {
        this.connection = getConnection();
    }

    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/bancodeteste", "root", "12345");
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void adiciona(Login login){
        String sql = "INSERT INTO login (user, password, url) values (?,?,?)";

        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, login.getUser());
            stmt.setString(2, login.getPassword());
            stmt.setString(3, login.getUrl());

            stmt.execute();
            stmt.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Login> getLista() {

        String sql = "SELECT * FROM login";
        try {

            List<Login> logins = new ArrayList<Login>();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Login login = new Login();
                login.setCodigoLogin(rs.getString("codigo"));
                login.setUser(rs.getString("user"));
                login.setPassword(rs.getString("password"));
                login.setUrl(rs.getString("url"));

                logins.add(login);
            }
            rs.close();
            stmt.close();
            return logins;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getLista();    }



    public void altera(Login login) {
        try {
        String sql = "UPDATE login set user=?, password=?, url=? where codigo=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, login.getUser());
            stmt.setString(2, login.getPassword());
            stmt.setString(3, login.getUrl());
            stmt.setString(4, login.getCodigoLogin());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void remove(long id) {
        try {
            String sql = "DELETE FROM login WHERE codigo=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
