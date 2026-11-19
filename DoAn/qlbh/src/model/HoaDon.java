package model;

public class HoaDon {

    private int maHD;
    private int maKH;
    private String ngayLap;
    private double tongTien;

    public HoaDon() {
    }

    public HoaDon(int maHD, int maKH,
                  String ngayLap,
                  double tongTien) {

        this.maHD = maHD;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}