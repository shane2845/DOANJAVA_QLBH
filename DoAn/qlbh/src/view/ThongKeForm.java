package view;

import database.ConnectDatabase;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ThongKeForm extends JFrame {

    JLabel lblSP;
    JLabel lblKH;

    public ThongKeForm() {

        setTitle("Thong Ke");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(2,1));

        lblSP = new JLabel();
        lblKH = new JLabel();

        add(lblSP);
        add(lblKH);

        loadThongKe();

        setVisible(true);
    }

    private void loadThongKe() {

        try {

            Connection conn =
                    ConnectDatabase.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs1 =
                    st.executeQuery(
                    "SELECT COUNT(*) Tong FROM SanPham");

            if(rs1.next()){

                lblSP.setText(
                        "Tong san pham: "
                        + rs1.getInt("Tong"));
            }

            ResultSet rs2 =
                    st.executeQuery(
                    "SELECT COUNT(*) Tong FROM KhachHang");

            if(rs2.next()){

                lblKH.setText(
                        "Tong khach hang: "
                        + rs2.getInt("Tong"));
            }

        } catch(Exception e){

            e.printStackTrace();

        }
    }
}