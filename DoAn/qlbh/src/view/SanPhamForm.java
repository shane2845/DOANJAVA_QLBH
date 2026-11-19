package view;

import dao.SanPhamDAO;
import model.SanPham;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SanPhamForm extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    private JTextField txtTenSP;
    private JTextField txtDonGia;
    private JTextField txtSoLuong;

    private JButton btnThem;

    public SanPhamForm() {

        setTitle("Quan Ly San Pham");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel pnTop = new JPanel(new GridLayout(4, 2, 5, 5));

        pnTop.add(new JLabel("Ten san pham"));
        txtTenSP = new JTextField();
        pnTop.add(txtTenSP);

        pnTop.add(new JLabel("Don gia"));
        txtDonGia = new JTextField();
        pnTop.add(txtDonGia);

        pnTop.add(new JLabel("So luong"));
        txtSoLuong = new JTextField();
        pnTop.add(txtSoLuong);

        btnThem = new JButton("Them");
        pnTop.add(btnThem);

        add(pnTop, BorderLayout.NORTH);

        model = new DefaultTableModel();

        model.addColumn("Ma SP");
        model.addColumn("Ten SP");
        model.addColumn("Don Gia");
        model.addColumn("So Luong");

        table = new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadData();

        btnThem.addActionListener(e -> themSanPham());

        setVisible(true);
    }

    private void themSanPham() {

        try {

            String tenSP =
                    txtTenSP.getText();

            double donGia =
                    Double.parseDouble(txtDonGia.getText());

            int soLuong =
                    Integer.parseInt(txtSoLuong.getText());

            SanPham sp =
                    new SanPham(
                            0,
                            tenSP,
                            donGia,
                            soLuong
                    );

            SanPhamDAO dao =
                    new SanPhamDAO();

            if (dao.themSanPham(sp)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Them thanh cong!"
                );

                loadData();

                txtTenSP.setText("");
                txtDonGia.setText("");
                txtSoLuong.setText("");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Them that bai!"
                );

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Du lieu khong hop le!"
            );

        }

    }

    private void loadData() {

        model.setRowCount(0);

        SanPhamDAO dao =
                new SanPhamDAO();

        ArrayList<SanPham> ds =
                dao.getAllSanPham();

        for (SanPham sp : ds) {

            model.addRow(new Object[]{
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getDonGia(),
                    sp.getSoLuongTon()
            });

        }

    }
}