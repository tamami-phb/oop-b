package util;

import java.sql.*;

public class Koneksi {

    private Connection connection;
    private Statement statement;

    public Koneksi() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost/mahasiswa",
                "root",
                "rahasia"
        );
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from mahasiswa");
        while(result.next()) {
            System.out.println("NIM : " + result.getString(1));
            System.out.println("NAMA : " + result.getString(2));
            System.out.println("KELAS : " + result.getString(3));
        }
        connection.close();
    }

}