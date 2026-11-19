package dao;

import database.ConnectDatabase;
import model.SanPham;

import java.sql.*;
import java.util.ArrayList;

public class SanPhamDAO {

    public ArrayList<SanPham> getAllSanPham() {

        ArrayList<SanPham> ds = new ArrayList<>();

        try {

            Connection conn = ConnectDatabase.getConnection();

            String sql = "SELECT * FROM SanPham";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                SanPham sp = new SanPham(
                        rs.getInt("MaSP"),
                        rs.getString("TenSP"),
                        rs.getDouble("DonGia"),
                        rs.getInt("SoLuongTon")
                );

                ds.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public boolean themSanPham(SanPham sp) {

        try {

            Connection conn = ConnectDatabase.getConnection();

            String sql =
                    "INSERT INTO SanPham(TenSP, DonGia, SoLuongTon) VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getTenSP());
            ps.setDouble(2, sp.getDonGia());
            ps.setInt(3, sp.getSoLuongTon());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean suaSanPham(SanPham sp) {

        try {

            Connection conn = ConnectDatabase.getConnection();

            String sql =
                    "UPDATE SanPham SET TenSP=?, DonGia=?, SoLuongTon=? WHERE MaSP=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getTenSP());
            ps.setDouble(2, sp.getDonGia());
            ps.setInt(3, sp.getSoLuongTon());
            ps.setInt(4, sp.getMaSP());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean xoaSanPham(int maSP) {

        try {

            Connection conn = ConnectDatabase.getConnection();

            String sql =
                    "DELETE FROM SanPham WHERE MaSP=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maSP);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<SanPham> timKiem(String keyword) {

        ArrayList<SanPham> ds = new ArrayList<>();

        try {

            Connection conn = ConnectDatabase.getConnection();

            String sql =
                    "SELECT * FROM SanPham WHERE TenSP LIKE ?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                SanPham sp = new SanPham(
                        rs.getInt("MaSP"),
                        rs.getString("TenSP"),
                        rs.getDouble("DonGia"),
                        rs.getInt("SoLuongTon")
                );

                ds.add(sp);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return ds;
    }
}