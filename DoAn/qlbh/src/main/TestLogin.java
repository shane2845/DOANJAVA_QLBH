package main;

import dao.TaiKhoanDAO;

public class TestLogin {

    public static void main(String[] args) {

        TaiKhoanDAO tkDAO =
                new TaiKhoanDAO();

        boolean result =
                tkDAO.dangNhap("admin", "123");

        if(result){

            System.out.println("Dang nhap thanh cong!");

        }else{

            System.out.println("Sai tai khoan hoac mat khau!");

        }

    }

}