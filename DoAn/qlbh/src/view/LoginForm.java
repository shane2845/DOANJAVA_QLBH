package view;

import dao.TaiKhoanDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;

    public LoginForm() {

        setTitle("Dang Nhap");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Ten dang nhap:"));

        txtUser = new JTextField();
        add(txtUser);

        add(new JLabel("Mat khau:"));

        txtPass = new JPasswordField();
        add(txtPass);

        add(new JLabel(""));

        btnLogin = new JButton("Dang nhap");
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String user = txtUser.getText();
                String pass = new String(txtPass.getPassword());

                TaiKhoanDAO dao = new TaiKhoanDAO();

                if (dao.dangNhap(user, pass)) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Dang nhap thanh cong!");

                    dispose();

                    new MainForm();

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Sai tai khoan hoac mat khau!");

                }
            }
        });

        setVisible(true);
    }
}