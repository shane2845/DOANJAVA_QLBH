package dao;

import database.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class HoaDonDAO {

    public boolean taoHoaDon(int maKH, double tongTien) {

        try {

            Connection conn =
                    ConnectDatabase.getConnection();

            String sql =
                    "INSERT INTO HoaDon(MaKH,NgayLap,TongTien) VALUES(?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, maKH);

            ps.setDate(
                    2,
                    new Date(System.currentTimeMillis())
            );

            ps.setDouble(3, tongTien);

            return ps.executeUpdate() > 0;

        } catch(Exception e){

            e.printStackTrace();
            return false;

        }
    }
}