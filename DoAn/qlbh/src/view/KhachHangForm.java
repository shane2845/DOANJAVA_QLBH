package view;

import dao.KhachHangDAO;
import model.KhachHang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class KhachHangForm extends JFrame {

    JTable table;
    DefaultTableModel model;

    JTextField txtTenKH;
    JTextField txtSDT;
    JTextField txtDiaChi;

    JButton btnThem;

    public KhachHangForm() {

        setTitle("Quan Ly Khach Hang");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelTop = new JPanel(new GridLayout(4,2));

        panelTop.add(new JLabel("Ten KH"));
        txtTenKH = new JTextField();
        panelTop.add(txtTenKH);

        panelTop.add(new JLabel("SDT"));
        txtSDT = new JTextField();
        panelTop.add(txtSDT);

        panelTop.add(new JLabel("Dia Chi"));
        txtDiaChi = new JTextField();
        panelTop.add(txtDiaChi);

        btnThem = new JButton("Them");
        panelTop.add(btnThem);

        add(panelTop, BorderLayout.NORTH);

        model = new DefaultTableModel();

        model.addColumn("Ma KH");
        model.addColumn("Ten KH");
        model.addColumn("SDT");
        model.addColumn("Dia Chi");

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        loadData();

        btnThem.addActionListener(e -> themKhachHang());

        setVisible(true);
    }

    private void loadData() {

        model.setRowCount(0);

        ArrayList<KhachHang> ds =
                new KhachHangDAO().getAllKhachHang();

        for(KhachHang kh : ds){

            model.addRow(new Object[]{
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getSdt(),
                    kh.getDiaChi()
            });
        }
    }

    private void themKhachHang() {

        KhachHang kh =
                new KhachHang(
                        0,
                        txtTenKH.getText(),
                        txtSDT.getText(),
                        txtDiaChi.getText()
                );

        if(new KhachHangDAO().themKhachHang(kh)){

            JOptionPane.showMessageDialog(
                    this,
                    "Them thanh cong"
            );

            loadData();

        }
    }
}