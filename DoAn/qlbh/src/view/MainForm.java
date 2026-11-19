package view;

import java.awt.*;
import javax.swing.*;

public class MainForm extends JFrame {

    JButton btnSanPham;
    JButton btnKhachHang;
    JButton btnHoaDon;
    JButton btnThongKe;
    JButton btnDangXuat;

    public MainForm() {

        setTitle("PHAN MEM QUAN LY BAN HANG");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(5,1,10,10));

        btnSanPham = new JButton("QUAN LY SAN PHAM");
        btnKhachHang = new JButton("QUAN LY KHACH HANG");
        btnHoaDon = new JButton("LAP HOA DON");
        btnThongKe = new JButton("THONG KE");
        btnDangXuat = new JButton("DANG XUAT");

        add(btnSanPham);
        add(btnKhachHang);
        add(btnHoaDon);
        add(btnThongKe);
        add(btnDangXuat);

        btnSanPham.addActionListener(e -> {

            new SanPhamForm();

        });

        btnKhachHang.addActionListener(e -> {

            new KhachHangForm();

        });

        btnThongKe.addActionListener(e -> {

            new ThongKeForm();

        });

        btnHoaDon.addActionListener(e -> {

    new HoaDonForm();

});


        btnDangXuat.addActionListener(e -> {

            dispose();

            new LoginForm();

        });

        setVisible(true);
    }
}