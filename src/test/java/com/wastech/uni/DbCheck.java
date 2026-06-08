package com.wastech.uni;
import java.sql.*;

public class DbCheck {
    public static void main(String[] args) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/wastech_db?user=root&password=");
        ResultSet rs = c.createStatement().executeQuery("SELECT usuario, contrasena FROM usuario WHERE usuario='admin'");
        if(rs.next()) {
            System.out.println("ADMIN_ENCONTRADO: " + rs.getString(1) + " | HASH: " + rs.getString(2));
        } else {
            System.out.println("ADMIN_NO_EXISTE");
        }
    }
}
