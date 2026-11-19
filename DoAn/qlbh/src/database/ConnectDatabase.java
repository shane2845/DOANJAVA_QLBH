package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    public static Connection getConnection() {

        try {

            String url =
                "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QLBanHang;"
                + "encrypt=true;"
                + "trustServerCertificate=true;";

            String user = "sa";
            String password = "1";

            Connection conn =
                DriverManager.getConnection(url, user, password);

            System.out.println("Ket noi thanh cong!");

            return conn;

        } catch (Exception e) {

            System.out.println("Ket noi that bai!");
            System.out.println("Loi: " + e.getMessage());

            e.printStackTrace();

            return null;
        }
    }
}