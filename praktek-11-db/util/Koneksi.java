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
    }

}