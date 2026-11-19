package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectDatabase;

public class TaiKhoanDAO {

    public boolean dangNhap(String username, String password) {

        try {

            Connection conn =
                    ConnectDatabase.getConnection();

            String sql =
                    "SELECT * FROM TaiKhoan "
                    + "WHERE TenDangNhap=? "
                    + "AND MatKhau=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}