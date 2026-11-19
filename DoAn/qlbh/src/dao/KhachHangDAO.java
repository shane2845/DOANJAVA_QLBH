package dao;

import database.ConnectDatabase;
import model.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangDAO {

    public ArrayList<KhachHang> getAllKhachHang() {

        ArrayList<KhachHang> ds = new ArrayList<>();

        try {

            Connection conn =
                    ConnectDatabase.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM KhachHang");

            while (rs.next()) {

                ds.add(new KhachHang(
                        rs.getInt("MaKH"),
                        rs.getString("TenKH"),
                        rs.getString("SDT"),
                        rs.getString("DiaChi")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public boolean themKhachHang(KhachHang kh) {

        try {

            Connection conn =
                    ConnectDatabase.getConnection();

            String sql =
                    "INSERT INTO KhachHang(TenKH,SDT,DiaChi) VALUES(?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getSdt());
            ps.setString(3, kh.getDiaChi());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}