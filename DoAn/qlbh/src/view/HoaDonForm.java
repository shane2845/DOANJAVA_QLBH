package view;

import dao.HoaDonDAO;

import javax.swing.*;
import java.awt.*;

public class HoaDonForm extends JFrame {

    JTextField txtMaKH;
    JTextField txtTongTien;

    JButton btnLuu;

    public HoaDonForm() {

        setTitle("Lap Hoa Don");

        setSize(400,250);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(3,2,10,10));

        add(new JLabel("Ma Khach Hang"));

        txtMaKH = new JTextField();

        add(txtMaKH);

        add(new JLabel("Tong Tien"));

        txtTongTien = new JTextField();

        add(txtTongTien);

        add(new JLabel());

        btnLuu = new JButton("Luu Hoa Don");

        add(btnLuu);

        btnLuu.addActionListener(e -> luuHoaDon());

        setVisible(true);

    }

    private void luuHoaDon() {

        try {

            int maKH =
                    Integer.parseInt(
                            txtMaKH.getText()
                    );

            double tongTien =
                    Double.parseDouble(
                            txtTongTien.getText()
                    );

            HoaDonDAO dao =
                    new HoaDonDAO();

            if(dao.taoHoaDon(maKH, tongTien)){

                JOptionPane.showMessageDialog(
                        this,
                        "Luu hoa don thanh cong!"
                );

            }else{

                JOptionPane.showMessageDialog(
                        this,
                        "Luu hoa don that bai!"
                );

            }

        } catch(Exception e){

            JOptionPane.showMessageDialog(
                    this,
                    "Du lieu khong hop le!"
            );

        }
    }
}