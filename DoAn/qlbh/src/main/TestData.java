package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.ConnectDatabase;

public class TestData {

    public static void main(String[] args) {

        try {

            Connection conn =
                ConnectDatabase.getConnection();

            Statement st =
                conn.createStatement();

            ResultSet rs =
                st.executeQuery("SELECT * FROM SanPham");

            while(rs.next()){

                System.out.println(
                    rs.getInt("MaSP")
                    + " | "
                    + rs.getString("TenSP")
                    + " | "
                    + rs.getDouble("DonGia")
                );

            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}