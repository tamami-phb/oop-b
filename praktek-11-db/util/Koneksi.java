package util;

import java.sql.*;

public class Koneksi {

    private Connection connection;
    private Statement statement;

    public Koneksi() { }

    public void openConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost/mahasiswa",
                "root",
                "rahasia"
        );
        statement = connection.createStatement();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public ResultSet select(String query) throws SQLException {
        openConnection();
        ResultSet result = statement.executeQuery(query);
        closeConnection();
        return result;
    }

    public int update(String query) throws SQLException {
        openConnection();
        int result = statement.executeUpdate(query);
        closeConnection();
        return result;
    }

}